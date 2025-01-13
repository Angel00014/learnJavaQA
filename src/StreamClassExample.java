import java.util.*;
import java.util.stream.Collectors;

public class StreamClassExample {

    public static void main(String[] args){

//        List<account.CreditAccount> creditAccounts = new ArrayList<account.CreditAccount>(){{
//            add(new account.CreditAccount("5135687", "Alex", 12500.00, account.StatusAccount.ACTIVE));
//            add(new account.CreditAccount("2342324", "Bob", 1250.00, account.StatusAccount.NO_ACTIVE));
//            add(new account.CreditAccount("7547564", "Dan", 542.05, account.StatusAccount.ACTIVE));
//            add(new account.CreditAccount("1243241", "Mila", 9501.10, account.StatusAccount.ACTIVE));
//            add(new account.CreditAccount("5456645", "Anna", 126.00, account.StatusAccount.BLOCKED));
//        }};

//        List<account.CreditAccount> blockedAccounts = new ArrayList<>();
//
//        for (account.CreditAccount creditAccount : creditAccounts) {
//            if (creditAccount.getStatusAccountWithEnum().equals(account.StatusAccount.BLOCKED)){
//                blockedAccounts.add(creditAccount);
//            }
//        }
//
//        System.out.println(blockedAccounts);

//        List<account.CreditAccount> noActiveAccounts = creditAccounts.stream()
//                .filter(temp -> temp.getStatusAccountWithEnum().equals(account.StatusAccount.NO_ACTIVE))
//                .collect(Collectors.toList());
//
//        System.out.println(noActiveAccounts);
//
//        List<String> onlyHighSum = creditAccounts.stream()
//                .filter(x->x.getSumma() > 2000.00)
//                .map(account.Account::getOwner)
//                .collect(Collectors.toList());
//        System.out.println(onlyHighSum);
//
//        account.CreditAccount lastAccounts = creditAccounts.get(creditAccounts.size() - 1);
//        account.CreditAccount lastAccountsStream = creditAccounts.stream().reduce((temp, next) -> next).get();
//
//        System.out.println(lastAccounts);
//        System.out.println(lastAccountsStream);
//
//        creditAccounts.stream()
//                .filter(x->x.getOwner().equals("Bob"))
//                .findFirst()
//                .orElseThrow(()-> new IllegalStateException("Владелец не найден"));

        List<String> email = Arrays.asList(
                "a@gmail.com",
                "bob@mail.ru",
                "anna@gmail.com",
                "mary@yandex.ru",
                "bob@gmail.com",
                "alice@gmail.com",
                "dan@gmail.com",
                "ted@gmail.com",
                "nick@gmail.com",
                "ronald@gmail.com");

        List<String> uniq = email.stream()
                .distinct()
                .collect(Collectors.toList());

//        System.out.println(uniq);

        List<String> gmails = email.stream().filter(x->x.endsWith("@gmail.com")).collect(Collectors.toList());

//        System.out.println(gmails);

        String firstGmail = email.stream().filter(x->x.endsWith("@gmail.com")).findFirst().get();

        String randomGmail = email.stream().filter(x->x.endsWith("@gmail.com")).findAny().get();

        String randomGmailParallel = email.stream().parallel().filter(x->x.endsWith("@gmail.com")).findAny().get();

        Random random = new Random();
        int randomNumber = random.nextInt(email.size());
//        System.out.println(email.get(randomNumber));
//
//        System.out.println(firstGmail);
//        System.out.println(randomGmail);
//        System.out.println(randomGmailParallel);

        boolean isAllEmailsEndsWithGmail = email.stream().allMatch(x->x.endsWith("@gmail.com"));
        boolean isAllEmailsNotStartsWithYandex = email.stream().noneMatch(x->x.startsWith("yandex"));

//        System.out.println(isAllEmailsEndsWithGmail);
//        System.out.println(isAllEmailsNotStartsWithYandex);


        Map<String, Integer> coins = new HashMap<String, Integer>(){{
            put("USD",12);
            put("EUR",40);
            put("RUB",15000);
            put("AED",100);
            put("GBR",955);
        }};

        System.out.println(coins);

        Map<String, Integer> reverse = coins.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (first, second)-> first, LinkedHashMap::new));

        System.out.println(reverse);


    }

}

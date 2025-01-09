import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamClassExample {

    public static void main(String[] args){

        List<CreditAccount> creditAccounts = new ArrayList<CreditAccount>(){{
            add(new CreditAccount("5135687", "Alex", 12500.00, StatusAccount.ACTIVE));
            add(new CreditAccount("2342324", "Bob", 1250.00, StatusAccount.NO_ACTIVE));
            add(new CreditAccount("7547564", "Dan", 542.05, StatusAccount.ACTIVE));
            add(new CreditAccount("1243241", "Mila", 9501.10, StatusAccount.ACTIVE));
            add(new CreditAccount("5456645", "Anna", 126.00, StatusAccount.BLOCKED));
        }};

        List<CreditAccount> blockedAccounts = new ArrayList<>();

        for (CreditAccount creditAccount : creditAccounts) {
            if (creditAccount.getStatusAccountWithEnum().equals(StatusAccount.BLOCKED)){
                blockedAccounts.add(creditAccount);
            }
        }

        System.out.println(blockedAccounts);

        List<CreditAccount> noActiveAccounts = creditAccounts.stream()
                .filter(temp -> temp.getStatusAccountWithEnum().equals(StatusAccount.NO_ACTIVE))
                .collect(Collectors.toList());

        System.out.println(noActiveAccounts);



    }

}

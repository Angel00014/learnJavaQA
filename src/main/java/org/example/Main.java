package org.example;

import org.example.account.AccountWithParam;
import org.example.account.StatusAccount;

public class Main {

    //    public static List<CreditAccount> getCreditAccounts(){
    //            List<CreditAccount> creditAccounts = new ArrayList<CreditAccount>() {{
    //                    add(new CreditAccount("5135687", "Alex", 12500.00, StatusAccount.ACTIVE));
    //                    add(new CreditAccount("2342324", "Bob", 1250.00, StatusAccount.ACTIVE));
    //                    add(new CreditAccount("7547564", "Dan", 542.05, StatusAccount.ACTIVE));
    //                    add(new CreditAccount("1243241", "Mila", 9501.10, StatusAccount.ACTIVE));
    //                    add(new CreditAccount("5456645", "Anna", 126.00, StatusAccount.ACTIVE));
    //            }};
    //
    //            return creditAccounts;
    //    }


    public static void main(String[] args) {


        //  Данные по предыдущим урокам
        //            int numberClient = 10;
        //            double checkSum = 145.1;
        //            boolean required = true;
        //            String nameClient = "Alex";
        //            String sonameClient = "Smith";
        //            boolean nameClientsStartWithN;
        //            String formatMessage = String.format("Моё имя %s , сумма на моём счету = %.2f", (nameClient + " " + sonameClient), checkSum);
        //
        //            System.out.println(nameClient);
        //
        //            nameClientsStartWithN = nameClient.startsWith("N");
        //
        //            System.out.println(nameClientsStartWithN);
        //
        //            String nameClientsUpper = nameClient.toUpperCase();
        //
        //            System.out.println(nameClientsUpper);
        //
        //            System.out.println( nameClient + " " + sonameClient + ". checkSum: " + (checkSum + 102.4));
        //
        //            System.out.println(formatMessage);
        //
        //            System.out.println(formatMessage.replaceAll(nameClient, "Pit"));
        //            Double withdrawSub = 500.00;
        //
        //            account.Account account = new account.Account();
        //            account.checkStatus();
        //            account.setNumber("12343534523");
        //            account.setSumma(1200.42);
        //
        //            System.out.println(account.withdrawMoney(withdrawSub));
        //
        //            account.Account account2 = new account.Account();
        //            account2.setNumber("5431123131");
        //            System.out.println(account2.getNumber());
        //
        //            account.Account account3 = new account.Account("999999", "Alex", 150000.00);
        //            System.out.println(account3.getNumber());
        //            System.out.println(account3.getOwner());
        //            System.out.println(account3.getSumma());
        //            account3.withdrawMoney(withdrawSub);
        //            System.out.println(account3.getSumma());

        //            account.Account account3 = new account.Account("999999", "Alex", 150000.00);
        //            account.Account account4 = new account.Account("999999", "Alex", 150000.00);
        //
        //            boolean isSame = account3.equals(account4);
        //
        //            boolean isNumberSame = account3.getNumber().equals(account4.getNumber());
        //            boolean isOwnerSame = account3.getOwner().equals(account4.getOwner());
        //
        //            System.out.println(isNumberSame);
        //            System.out.println(isOwnerSame);
        //
        //            System.out.println(account3);
        //            System.out.println(account4);
        //            System.out.println(isSame);

        //            Double cashbackLevel = 2.0;
        //
        //            account.CreditAccount account5 = new account.CreditAccount("999999", "Alex", 150000.00);
        //            account.DebitAccount account6 = new account.DebitAccount("999999", "Alex", 150000.00);
        //
        //
        //            System.out.println(account5.getCreditLimit());
        //            account6.setCashbackLevel(cashbackLevel);
        //            System.out.println(account6.getCashbackLevel());
        //
        //
        //            account5.checkStatus();
        //            account6.checkStatus();
        //
        //            account5.checkFunctionality();

        //            account.CreditAccount[] accounts = new account.CreditAccount[5];
        //
        //            accounts[0] = new account.CreditAccount("5135687", "Alex", 12500.00, account.StatusAccount.ACTIVE);
        //            accounts[1] = new account.CreditAccount("2342324", "Bob", 1250.00, account.StatusAccount.ACTIVE);
        //            accounts[2] = new account.CreditAccount("7547564", "Dan", 542.05, account.StatusAccount.ACTIVE);
        //            accounts[3] = new account.CreditAccount("1243241", "Mila", 9501.10, account.StatusAccount.ACTIVE);
        //            accounts[4] = new account.CreditAccount("5456645", "Anna", 126.00, account.StatusAccount.ACTIVE);
        //
        //            System.out.println(accounts[0].getStatusAccountWithEnum());
        //
        //            System.out.println(Arrays.asList(accounts));
        //
        //            for (int i = 0; i < accounts.length; i++) {
        //                    if (accounts[i].getOwner().equals("Dan")){
        //                            account.CreditAccount tempSumma = accounts[i];
        //                            tempSumma.setSumma(999999.00);
        //                            break;
        //                    }
        //
        //            }
        //
        //            System.out.println(Arrays.asList(accounts));
        //
        //            for (int i = accounts.length - 1; i >= 0; i--) {
        //                    if (accounts[i].getOwner().equals("Anna")){
        //                            account.CreditAccount tempSumma = accounts[i];
        //                            tempSumma.setSumma(999999.00);
        //                            break;
        //                    }
        //            }
        //
        //            System.out.println(Arrays.asList(accounts));

        //            List<account.CreditAccount> creditAccounts = getCreditAccounts();
        //            List<account.CreditAccount> creditAccountsHighSum = new ArrayList<>();
        //
        //            for (account.CreditAccount creditAccount : creditAccounts) {
        //                    if (creditAccount.getSumma() > 2000.00) {
        //                            creditAccountsHighSum.add(creditAccount);
        //                    }
        //            }
        //
        //            System.out.println(creditAccountsHighSum);

        //        List<String> originalNames = new ArrayList<String>() {{
        //                add("John");
        //                add("Kira");
        //                add("John");
        //                add("Alex");
        //                add("Bob");
        //                add("Mary");
        //            }};
        //
        //        Set<String> names = new HashSet<>(originalNames);
        //
        //        System.out.println(names);
        //
        //        Map<String , Integer> people = new HashMap<>();
        //        people.put(null, 90);
        //        people.put("Alex", 27);
        //        people.put("Bob", 15);
        //        people.put("Alex", 50);
        //        people.put(null, 27);
        //
        //        people.replace(null, 99);
        //
        //        System.out.println(people.get("Bob"));
        //
        //        for (Map.Entry<String, Integer> stringIntegerEntry : people.entrySet()) {
        //                if (stringIntegerEntry.getKey().equals("Bob")) {
        //                    System.out.println("Найден ключ " + stringIntegerEntry.getKey());
        //                    break;
        //                }
        //        }
        //
        //        System.out.println(people);

        AccountWithParam<String> accountWithParam = new AccountWithParam<>(
                "5135687",
                "Alex",
                12500.00,
                StatusAccount.ACTIVE,
                "Абракадабра"
        );

        AccountWithParam<String> accountWithParam2 = new AccountWithParam<>(
                "5135687",
                "Alex",
                12500.00,
                StatusAccount.ACTIVE,
                "Абракадабра"
        );

        AccountWithParam<String> accountWithParam3 = new AccountWithParam<>(
                "5135687",
                "Alex",
                12500.00,
                StatusAccount.ACTIVE,
                "Абракадабра"
        );

        AccountWithParam<String> accountWithParam4 = new AccountWithParam<>(
                "5135687",
                "Alex",
                12500.00,
                StatusAccount.ACTIVE,
                "Абракадабра"
        );



        accountWithParam.checkStatus();

        System.out.println(AccountWithParam.getCounter());

    }
}
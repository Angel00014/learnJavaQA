//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
            Double withdrawSub = 500.00;

            Account account = new Account();
            account.checkStatus();
            account.setNumber("12343534523");
            account.setSumma(1200.42);

//            System.out.println(account.withdrawMoney(withdrawSub));

            Account account2 = new Account();
            account2.setNumber("5431123131");
//            System.out.println(account2.getNumber());

            Account account3 = new Account("999999", "Alex", 150000.00);
            System.out.println(account3.getNumber());
            System.out.println(account3.getOwner());
            System.out.println(account3.getSumma());
            account3.withdrawMoney(withdrawSub);
            System.out.println(account3.getSumma());
    }
}
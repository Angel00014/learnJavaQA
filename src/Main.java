//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            int numberClient = 10;
            double checkSum = 145.1;
            boolean required = true;
            String nameClient = "Alex";
            String sonameClient = "Smith";
            boolean nameClientsStartWithN;
            String formatMessage = String.format("Моё имя %s , сумма на моём счету = %.2f", (nameClient + " " + sonameClient), checkSum);

            System.out.println(nameClient);

            nameClientsStartWithN = nameClient.startsWith("N");

            System.out.println(nameClientsStartWithN);

            String nameClientsUpper = nameClient.toUpperCase();

            System.out.println(nameClientsUpper);

            System.out.println( nameClient + " " + sonameClient + ". checkSum: " + (checkSum + 102.4));

            System.out.println(formatMessage);

            System.out.println(formatMessage.replaceAll(nameClient, "Pit"));

    }
}
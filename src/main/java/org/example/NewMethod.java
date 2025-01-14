package org.example;

public class NewMethod {
    public static void main(String[] args){
        String myName = "Alex";
        String mySoname = "Smith";
        Double myCheckSum = 12442.21;
        Double myCheckNumberOne = 122.1;
        Double myCheckNumberTwo = 512.6;


        System.out.println(createFinalMessageAboutClientCheck(myName, mySoname, sumMyCheck(myCheckNumberOne, myCheckNumberTwo)));

        System.out.println(sumMyCheck(myCheckNumberOne, myCheckNumberTwo));

    }

    public static String createFinalMessageAboutClientCheck(String nameClient, String sonameClient, Double checkSum){

        return String.format("Уважаемый клиент %s %s , на вашем счету, на текущий момент, находится сумма %.2f", nameClient, sonameClient, checkSum);
    }

    private static Double sumMyCheck(Double checkOne , Double checkTwo){
        return checkOne + checkTwo;
    }

}


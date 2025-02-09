package org.example;

public class Conditions {
    public static void main(String[] args){
        int myAge = 18;
        boolean haveAutoRight = true;
        boolean canDrive = false;
        String carManufacturer;


        if (myAge < 18) {
            canDrive = false;
        }else if (myAge >= 18 && haveAutoRight == false){
            canDrive = false;
        }else if (myAge >= 18 && haveAutoRight == true){
            canDrive = true;
        }
        System.out.println("Можно ли вам водить машину: " + canDrive);

        boolean coolCanDrive = myAge >= 18 && haveAutoRight == true ? true : false;
        String textCanDrive = myAge >= 18 && haveAutoRight == true ? "Вам можно водить машину" : "Вам нельзя водить машину";

        System.out.println(coolCanDrive);
        System.out.println(textCanDrive);

        switch (myAge){
            case 17:
                carManufacturer = "Nothing";
                break;
            case 18:
                carManufacturer = "BMW";
                break;
            default:
                carManufacturer = "Lada";
                break;
        }

        System.out.println(carManufacturer);

    }


}

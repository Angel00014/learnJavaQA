package dog;

import java.util.Random;

public class Foxec extends DogFamily{

    public Foxec(String dogName, String dogHabitat, DogStatus dogStatus) {
        super(dogName, dogHabitat, dogStatus);
    }

    @Override
    public void bark() {
        System.out.println( getDogName() +  " тявкает");
    }

    @Override
    public void abilityTame() {
        Random random = new Random();
        Double doubleRandom = random.nextDouble();

        if ((doubleRandom * getIq()) > 0.8){
            System.out.println(getDogName() + " может быть приручен");
        }else {
            System.out.println(getDogName() +  " не может быть приручен");
        }
    }


}

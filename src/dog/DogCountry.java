package dog;

import java.util.Random;

public enum DogCountry {
    AUSTRALIA, ASIA, NORTH_AMERICA, SOUTH_AMERICA, EUROPE;

    public static DogCountry getRandomCountry(){

        DogCountry[] country = DogCountry.values();

        int lenght = country.length;
        int randomCountry = new Random().nextInt(lenght);

        return country[randomCountry];
    }
}


package dog;

import java.util.Random;

public abstract class DogFamily {

    private String dogName;
    private String dogHabitat;
    private DogStatus dogStatus;
    private final Double Iq = generationIqAbility();


    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogHabitat() {
        return dogHabitat;
    }

    public void setDogHabitat(String dogHabitat) {
        this.dogHabitat = dogHabitat;
    }

    public DogStatus getDogStatus() {
        return dogStatus;
    }

    public void setDogStatus(DogStatus dogStatus) {
        this.dogStatus = dogStatus;
    }

    public Double getIq() {
        return Iq;
    }

    public DogFamily(String dogName, String dogHabitat, DogStatus dogStatus) {
        this.dogName = dogName;
        this.dogHabitat = dogHabitat;
        this.dogStatus = dogStatus;
    }

    @Override
    public String toString() {
        return "DogFamily{" +
                "dogName='" + dogName + '\'' +
                ", dogHabitat='" + dogHabitat + '\'' +
                ", dogStatus=" + dogStatus +
                ", Iq=" + Iq +
                '}';
    }

    public abstract void bark();

    public abstract void abilityTame();

    private Double generationIqAbility(){
        Random random = new Random();
        return random.nextDouble();
    }

    private void movesLimbs(){
        System.out.println( getDogName() + " задействует нейроны для бега");
    }

    public void run(){
        movesLimbs();
        System.out.println(getDogName() + " бегает");
    }



}

package org.example.dog;

public class Dogs extends DogFamily{

    public Dogs(String dogName, String dogHabitat, DogStatus dogStatus) {
        super(dogName, dogHabitat, dogStatus);
    }

    @Override
    public void bark() {
        System.out.println(getDogName() + " лает");
    }

    @Override
    public void abilityTame() {
        System.out.println(getDogName() + " имеет возможность к приручению с рождения");
    }
}

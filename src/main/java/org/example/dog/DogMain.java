package org.example.dog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DogMain {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {


        int countItemList = 30;
        int countYear = 5;
        int j = 1;

        List<Wolves> wolves = new ArrayList<Wolves>(){{
            add(new Wolves("Cумчатый волк №1", "Австралия", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №2", "Европа", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №3", "Северная Америка", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №4", "Южная Америка", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №5", "Азия", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №6", "Австралия", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №7", "Европа", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №8", "Австралия", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №9", "Азия", DogStatus.OLD));
            add(new Wolves("Cумчатый волк №10", "Южная Америка", DogStatus.OLD));
        }};

        List<Method> wolvesMethodList = new ArrayList<Method>();
        wolvesMethodList = Arrays.stream(Wolves.class.getMethods())
                .filter(x->x.toString().startsWith("public void") && !x.toString().contains("set"))
                .collect(Collectors.toList());

        List<Foxec> foxecs = new ArrayList<Foxec>(){{
            add(new Foxec("Обыкновенная лисица №1", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №2", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №3", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №4", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №5", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №6", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №7", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №8", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №9", "Австралия", DogStatus.OLD));
            add(new Foxec("Обыкновенная лисица №10", "Австралия", DogStatus.OLD));
        }};
        List<Method> foxecsMethodList = new ArrayList<Method>();
        foxecsMethodList = Arrays.stream(Foxec.class.getMethods())
                .filter(x->x.toString().startsWith("public void") && !x.toString().contains("set"))
                .collect(Collectors.toList());

        List<Dogs> dogs = new ArrayList<Dogs>(){{
            add(new Dogs("Среднеазиатская овчарка", "Азия", DogStatus.OLD));
            add(new Dogs("Кавказская овчарка", "Азия", DogStatus.OLD));
            add(new Dogs("Шарпланинская овчарка", "Европа", DogStatus.OLD));
            add(new Dogs("Бельгийская овчарка", "Европа", DogStatus.OLD));
            add(new Dogs("Шотландская овчарка колли", "Европа", DogStatus.OLD));
            add(new Dogs("Пиренейский мастиф", "Азия", DogStatus.OLD));
            add(new Dogs("Сибирский хаски", "Азия", DogStatus.OLD));
            add(new Dogs("Аляскинский маламут", "Северная Америка", DogStatus.OLD));
            add(new Dogs("Самоедская собака", "Азия", DogStatus.OLD));
            add(new Dogs("Сибирская ездовая собака Сеппала", "Азия", DogStatus.OLD));
        }};
        List<Method> dogsMethodList = new ArrayList<Method>();
        dogsMethodList = Arrays.stream(Dogs.class.getMethods())
                .filter(x->x.toString().startsWith("public void") && !x.toString().contains("set"))
                .collect(Collectors.toList());




        for (int i = 0; i < countYear; i++) {

            int allCountDay = 0;
            if (j == 4){
                allCountDay = allCountDay + 365;
                j++;
            }else{
                allCountDay = allCountDay + 366;
                j = 1;
            }

            int countNewDogs = 10;

            Random randomFamily = new Random();
            Method method;

            Random randomFamilyToAdd = new Random();

            Random randomItem = new Random();
            Random randomMethod = new Random();

            switch (randomFamily.nextInt(3)){
                case 0:
                    method = wolvesMethodList.get(randomMethod.nextInt(wolvesMethodList.size()));
                    method.invoke(wolves.get(randomItem.nextInt(wolves.size())));
                    break;
                case 1:
                    method = foxecsMethodList.get(randomMethod.nextInt(foxecsMethodList.size()));
                    method.invoke(foxecs.get(randomItem.nextInt(foxecs.size())));
                    break;
                case 2:
                    method = dogsMethodList.get(randomMethod.nextInt(dogsMethodList.size()));
                    method.invoke(dogs.get(randomItem.nextInt(dogs.size())));
                    break;
            }

            do {
                switch (randomFamilyToAdd.nextInt(3)){
                    case 0:
                        wolves.add(new Wolves("Cумчатый волк №" + countNewDogs++, "Австралия", DogStatus.NEW));
                        allCountDay = allCountDay - 30;
                        break;
                    case 1:
                        foxecs.add(new Foxec("Обыкновенная лисица №" + countNewDogs++, "Австралия", DogStatus.NEW));
                        allCountDay = allCountDay - 30;
                        break;
                    case 2:
                        dogs.add(new Dogs("Новая собака №" + countNewDogs++, "Австралия", DogStatus.NEW));
                        allCountDay = allCountDay - 30;
                        break;
                };
            } while (allCountDay > 30);
        }

        System.out.println(
                "Количество волков до = " + wolves.stream().filter(x->x.getDogStatus() == DogStatus.OLD).count() + '\'' +
                "Количество волком после = '" + wolves.size() + '\'' +
                "Количество лис до = " + foxecs.stream().filter(x->x.getDogStatus() == DogStatus.OLD).count() + '\'' +
                "Количество лис после = " + foxecs.size() + '\'' +
                "Количество собак  = " + dogs.stream().filter(x->x.getDogStatus() == DogStatus.OLD).count() + '\'' +
                "Количество собак после = " + dogs.size()
        );

    System.out.println(createRandomList(countItemList));


    }

    public static List<DogFamily> createRandomList(int listSize){
        List<DogFamily> dogFamilyList = new ArrayList<>();
        Random random = new Random();
        int countDogs = 0;

        for (int i = 0; i < listSize; i++) {
            switch (random.nextInt(3)){
                case 0:
                    dogFamilyList.add(new Wolves("Cумчатый волк №" + countDogs++, DogCountry.getRandomCountry().toString(), DogStatus.OLD));
                    break;
                case 1:
                    dogFamilyList.add(new Foxec("Обыкновенная лисица №" + countDogs++, DogCountry.getRandomCountry().toString(), DogStatus.OLD));
                    break;
                case 2:
                    dogFamilyList.add(new Dogs("Среднеазиатская овчарка №" + countDogs++, DogCountry.getRandomCountry().toString(), DogStatus.OLD));
                    break;
            }

        }

        return dogFamilyList;
    }

}

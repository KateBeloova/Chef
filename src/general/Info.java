package general;

import components.Vegetable;

import java.util.ArrayList;
import java.util.Random;

public class Info {
    public static final String NEW_SALAD_NAME = "New salad";
    public static final int NUMBER_ALL_VEGETABLES = Veggies.values().length;
    public static final String FORMAT_STRING = "%-17s%-15s%-15s%-15s%n";

    public static ArrayList<Integer> getRandomValues(int valuesQuantity) {
        ArrayList<Integer> randValues = new ArrayList<>();
        if (valuesQuantity > NUMBER_ALL_VEGETABLES) {
            valuesQuantity = NUMBER_ALL_VEGETABLES;
        }

        Random random = new Random();
        for (int i = 0; i < valuesQuantity; i++) {
            int num = random.nextInt(NUMBER_ALL_VEGETABLES);
            if (randValues.contains(num)) {
                i--;
                continue;
            } else {
                randValues.add(num);
            }
        }
        return randValues;
    }

    public enum Veggies {
        TOMATO, CUCUMBER, DILL, PUNCH
    }

    public static void printVegetablesInfo(ArrayList<Vegetable> vegetables) {
        System.out.format(Info.FORMAT_STRING, "Vegetable", "Calories", "Fat", "Proteins", "Weight");
        for (Vegetable veg : vegetables) {
            System.out.format(FORMAT_STRING, veg.getName(), veg.getCalories(), veg.getFat(), veg.getProteins(), veg.getWeight());
        }
    }
}
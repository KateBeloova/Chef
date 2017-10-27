package chiefexceptions;

import salad.Salad;
import chiefexceptions.exceptions.IngredientNotExistsException;
import chiefexceptions.exceptions.NoIngredientsException;
import chiefexceptions.exceptions.SaladHasIngredientException;
import components.Vegetable;
import components.types.Roots;

public class RunnerExceptions {
    public static void main(String[] args) {
        checkNoIngredients();
        checkIngredientNotExists();
        checkSaladHasIngredient();
        checkArrayIndexOutOfBoundsException();
        checkNullPointerException();
    }

    private static void checkNoIngredients() {
        Salad salad = new Salad();
        try {
            salad.printAllInfo();
        } catch (NoIngredientsException e) {
            System.out.println(e.getClass() + "salad has no ingredients.");
        }
    }

    private static void checkIngredientNotExists() {
        Salad salad = new Salad();
        try {
            salad.getCalories();
        } catch (IngredientNotExistsException e) {
            System.out.println(e.getClass() + "  java.salad has no ingredients.");
        }
    }

    private static void checkSaladHasIngredient() {
        Salad salad = new Salad();
        try {
            salad.addVegetable(new Roots("Tomato", 3.2, 0.2, 2.0, 20.5));
            salad.addVegetable(new Roots("Tomato", 3.2, 0.2, 2.0, 20.5));
        } catch (SaladHasIngredientException e) {
            System.out.println(e.getClass() + "salad already contains this vegetable");
        }
    }

    private static void checkArrayIndexOutOfBoundsException() {
        Salad salad = new Salad(new Roots("Tomato", 3.2, 0.2, 2.0, 20.5));
        try {
            Vegetable veg = salad.getIngredient(2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass() + ": index out of range");
        }
    }

    private static void checkNullPointerException() {
        Vegetable veg = new Vegetable(null, 1, 1, 1, 1);
        try {
            String name = veg.getName();
        } catch (NullPointerException e) {
            System.out.println(e.getClass() + ": name is empty");
        }
    }

}

package salad;

import general.Info;
import chiefexceptions.exceptions.IngredientNotExistsException;
import chiefexceptions.exceptions.NoIngredientsException;
import chiefexceptions.exceptions.SaladHasIngredientException;
import comparators.VegetableCaloriesComparator;
import components.Vegetable;
import components.types.Greenery;
import components.types.Roots;


import java.util.ArrayList;
import java.util.Collections;

public class Salad {
    private ArrayList<Vegetable> ingredients;
    private String name;

    public Salad() {
        this.name = Info.NEW_SALAD_NAME;
        ingredients = new ArrayList<>();
    }

    public Salad(Vegetable vegetable) {
        this.name = Info.NEW_SALAD_NAME;
        ingredients = new ArrayList<>();
        ingredients.add(vegetable);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addVegetable(Vegetable veg) throws SaladHasIngredientException {
        for (Vegetable ing : ingredients) {
            if (veg.getName() == ing.getName()) {
                throw new SaladHasIngredientException();
            }
        }
        this.ingredients.add(veg);
    }

      public void makeRandomSalad(int numberIngredients) {
        ingredients.clear();
        ArrayList<Integer> ingrNumbers = Info.getRandomValues(numberIngredients);
        for (int i = 0; i < ingrNumbers.size(); i++) {
            int num = ingrNumbers.get(i);
            switch (Info.Veggies.values()[num]) {
                case TOMATO:
                    ingredients.add(new Roots("Tomato", 3.2, 0.2, 2.0, 20.5 ));
                    break;
                case CUCUMBER:
                    ingredients.add(new Roots("Cucumber", 5.3, 1.2, 2.8, 15.5));
                    break;
                case DILL:
                    ingredients.add(new Greenery("Dill",3.5,6.7,8.3,6.4));
                    break;
                case PUNCH:
                    ingredients.add(new Greenery("Dill",3.2,6.4,6.3,1.6));
                    break;
                default:
                    break;
            }

        }
    }

    public ArrayList<Vegetable> getIngredients() {
        return ingredients;
    }

    public Vegetable getIngredient(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= ingredients.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return ingredients.get(index);
    }

    public ArrayList<Vegetable> findByCalories(double min, double max) {
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }

        ArrayList<Vegetable> ingred = new ArrayList<Vegetable>();

        for (int i = 0; i < ingredients.size(); i++) {
            double cal = ingredients.get(i).getCalories();
            if (cal > min && cal < max) {
                ingred.add(ingredients.get(i));
            }
        }
        return ingred;
    }

    public void sortByCalories() {
        Collections.sort(ingredients, new VegetableCaloriesComparator());
    }

    public double getCalories() throws IngredientNotExistsException {
        if (ingredients.size() == 0) {
            throw new IngredientNotExistsException();
        }
        double calories = 0;
        for (int i = 0; i < ingredients.size(); i++) {
            calories += ingredients.get(i).getCalories();
        }
        return calories;
    }

    @Override
    public String toString() {
        String ing = "";
        for (int i = 0; i < ingredients.size(); i++) {
            ing += ingredients.get(i).getName() + " ";
        }
        return "Salad '" + name + "' has following ingredients: " + ing;
    }

    public void printAllInfo() throws NoIngredientsException {
        if (ingredients.size() == 0) {
            throw new NoIngredientsException("No ingredient");
        }
        System.out.println("Salad '" + this.name + "' info:");
        Info.printVegetablesInfo(this.getIngredients());
    }

}


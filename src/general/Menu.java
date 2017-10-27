package general;

import salad.Salad;
import chiefexceptions.exceptions.IngredientNotExistsException;
import chiefexceptions.exceptions.NoIngredientsException;
import chiefexceptions.exceptions.SaladHasIngredientException;
import components.types.Greenery;
import components.types.Roots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private static Salad salad;

    private static final String OPTIONS_MENU_MAIN = "Choose what kind of salad you want to make: \n1. Random salad \n2. Create your own salad  \n0. Exit";
    private static final String OPTIONS_SALAD_NAME = "Please,write name of your salad:";
    private static final String OPTIONS_CUSTOM_SALAD = "Choose vegetable to add to your salad:\n 1. Tomato\n 2. Cucumber\n 3. Dill\n 4. Punch\nOr choose other options:\n 5. Main menu\n 6. Finish with salad\n 0. Exit";
    private static final String OPTIONS_RANDOM_SALAD = "There are " + Info.NUMBER_ALL_VEGETABLES + " vegetables available. Please, enter number of ingredients you want in your salad or press 0 to exit program";
    private static final String OPTIONS_SALAD = "What you want to do with this salad?\n 1. Show all info\n 2. Count calories\n 3. Sort\n 4. Find ingredient\n 5. Make new salad\n 0 - exit";
    private static final String OPTIONS_FIND = "Find ingredients by\n 1. Calories\n 2. Go back \n 0. Exit";
    private static final String OPTIONS_SORT = "Sort ingredients by\n 1. Calories\n 2. Go back \n 0. Exit";
    private static final String SEPARATOR_LINE = "-------------------------------------------";

    private static final String ERROR_READING_CONSOLE_MESSAGE = "Error reading from console.";
    private static final String ERROR_PARSING_INTEGER_MESSAGE = "Symbol you entered is not an integer.";
    private static final String ERROR_INCORRECT_OPTION = "Symbol you entered isn't correct. Please read instruction and try again.";
    private static final int ERROR_CODE = -111;

    private static int readIntFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = "";
        try {
            key = reader.readLine();
        } catch (Exception e) {
            System.out.println(ERROR_READING_CONSOLE_MESSAGE);
        }

        int option;
        try {
            option = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_PARSING_INTEGER_MESSAGE);
            return ERROR_CODE;
        }

        return option;
    }

    private static String readStringFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = "";
        try {
            key = reader.readLine();
        } catch (IOException e) {
            System.out.println(ERROR_READING_CONSOLE_MESSAGE);
        }

        return key;
    }

    private static void readSaladName() {
        System.out.println(OPTIONS_SALAD_NAME);
        salad.setName(readStringFromConsole());
    }


    public static void runMenu() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_MENU_MAIN);
        int option = readIntFromConsole();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                salad = new Salad();
                readSaladName();
                runRandomSaladOptions();
                break;
            case 2:
                salad = new Salad();
                readSaladName();
                runCustomSaladOptions();
                break;
            default:
                System.out.println(ERROR_INCORRECT_OPTION);
                runMenu();
        }
    }

    private static void runRandomSaladOptions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_RANDOM_SALAD);
        int number = readIntFromConsole();
        salad.makeRandomSalad(number);
        runSaladOptions();
    }

    private static void runCustomSaladOptions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_CUSTOM_SALAD);
        int option = readIntFromConsole();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                try {
                    salad.addVegetable(new Roots("Tomato", 3.2, 0.2, 2.0, 20.5));
                } catch (SaladHasIngredientException e) {
                    System.out.println("Salad already contains this vegetable");
                }
                runCustomSaladOptions();
                break;
            case 2:
                try {
                    salad.addVegetable(new Roots("Cucumber", 5.2, 7.2, 6.3, 12.7));
                } catch (SaladHasIngredientException e) {
                    System.out.println("Salad already contains this vegetable");
                }
                runCustomSaladOptions();
                break;
            case 3:
                try {
                    salad.addVegetable(new Greenery("Dill", 3.4, 6.2, 4.0, 18.5));
                } catch (SaladHasIngredientException e) {
                    System.out.println("Salad already contains this vegetable");
                }
                runCustomSaladOptions();
                break;
            case 4:
                try {
                    salad.addVegetable(new Greenery("Punch", 2.1, 4.5, 1.4, 12.5));
                } catch (SaladHasIngredientException e) {
                    System.out.println("Salad already contains this vegetable");
                }
                runCustomSaladOptions();
                break;
            case 5: // Main Menu
                runMenu();
                break;
            case 6: //Creation of salad is finished
                runSaladOptions();
                break;
            default:
                System.out.println(ERROR_INCORRECT_OPTION);
                runCustomSaladOptions();
        }
    }

    private static void runSaladOptions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_SALAD);
        int option = readIntFromConsole();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                System.out.println(SEPARATOR_LINE);
                try {
                    salad.printAllInfo();
                } catch (NoIngredientsException e) {
                    System.out.println("salad has no ingredients.");
                }
                runSaladOptions();
                break;
            case 2:
                System.out.println(SEPARATOR_LINE);
                try {
                    System.out.println("salad '" + salad.getName() + "' has " + salad.getCalories() + "calories");
                } catch (IngredientNotExistsException e) {
                    System.out.println("Ingredient not exists in salad");
                }
                runSaladOptions();
                break;
            case 3:
                sortOptions();
                break;
            case 4:
                findOptions();
                break;
            case 5:
                runMenu();
                break;
            default:
                System.out.println(ERROR_INCORRECT_OPTION);
                runSaladOptions();
        }
    }

    private static void findOptions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_FIND);
        int option = readIntFromConsole();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                findByCalories();
                runSaladOptions();
                break;
            case 2:
                runSaladOptions();
                break;
            default:
                System.out.println(ERROR_INCORRECT_OPTION);
                findOptions();
        }
    }

    private static void findByCalories() {
        System.out.println("Enter min value: ");
        int min = readIntFromConsole();
        System.out.println("Enter max value: ");
        int max = readIntFromConsole();

        System.out.println("vegetables from the range:");
        Info.printVegetablesInfo(salad.findByCalories(min, max));
    }

    private static void sortOptions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(OPTIONS_SORT);
        int option = readIntFromConsole();
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                salad.sortByCalories();
                try {
                    salad.printAllInfo();
                } catch (NoIngredientsException e) {
                    System.out.println("salad has no ingredients.");
                }
                runSaladOptions();
                break;
            case 2:
                runSaladOptions();
                break;
            default:
                System.out.println(ERROR_INCORRECT_OPTION);
                findOptions();
        }
    }
}
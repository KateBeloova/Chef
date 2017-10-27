package components.types;

import interfacee.Washed;
import components.Vegetable;

public class Roots extends Vegetable implements Washed {
    private String color;

    public Roots(String name, double proteins, double fat, double calories, double weight) {
        super(name, proteins, fat, calories, weight);
        color = "green";
    }

    @Override
    public void wash() {

    }
}
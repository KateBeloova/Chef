package components.types;

import components.Vegetable;

public class Greenery extends Vegetable {
    private String type;

    public Greenery() {
        super();
    }

    public Greenery(String name, double proteins, double fat, double calories, double weight) {
        super(name, proteins, fat, calories, weight);
        type = "Greenery";
    }

}

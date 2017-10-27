package components;

public class Vegetable {

    private String name;
    private double proteins;
    private double fat;
    private double calories;
    private double weight;

    public Vegetable() {

    }

    public Vegetable(String name, double proteins, double fat, double calories, double weight) {
        this.name = name;
        this.proteins = proteins;
        this.calories = calories;
        this.fat = fat;
        this.weight = weight;
    }

   public void SetName(String name) {
        this.name = name;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() throws NullPointerException {
        if (this.name == "" || this.name == null) {
            throw new NullPointerException();
        }
        return this.name;
    }

    public double getCalories() {
        return this.calories;
    }

    public double getProteins() {
        return this.proteins;
    }

    public double getFat() {
        return this.fat;
    }

    public double getWeight() {
        return this.weight;
    }
}

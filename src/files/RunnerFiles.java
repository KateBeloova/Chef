package files;

import components.Vegetable;

import java.io.*;

public class RunnerFiles {
    private static final String PATH = "D://Test.txt";

    public static void main(String[] args) throws IOException {
        Vegetable veg = new Vegetable("Pepper", 1, 2, 3, 4);
        System.out.print("Written to file: ");
        System.out.println(veg.getName() + " " + veg.getCalories() + " " + veg.getFat()
                + " " + veg.getProteins() + " " + veg.getWeight());
        writeToFile(veg);

        System.out.print("Read from file: ");
        Vegetable vegFromFile = readFromFile();
        System.out.println(vegFromFile.getName() + " " + vegFromFile.getCalories() + " " + vegFromFile.getFat() + " " + vegFromFile.getProteins() + " " + vegFromFile.getWeight());
    }

    private static Vegetable readFromFile() throws FileNotFoundException {
        Vegetable veg = new Vegetable();

        File file = new File(PATH);
        if (!file.exists()) {
            throw new FileNotFoundException(PATH);
        }
        try {
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            br.close();
            return readVegetableFromLine(line);
        } catch (Exception e) {
            System.out.println("Error creating file.");
            System.exit(0);
        }

        return veg;
    }

    private static Vegetable readVegetableFromLine(String line) {
        String[] vegParameters = new String[0];
        try {
            vegParameters = line.split("\\s+");
        } catch (Exception e) {
            System.out.println("Error occurred. ");
        }
        return new Vegetable(vegParameters[0], Double.parseDouble(vegParameters[1]), Double.parseDouble(vegParameters[2]), Double.parseDouble(vegParameters[3]), Double.parseDouble(vegParameters[4]));
    }

    private static void writeToFile(Vegetable veg) throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error creating file.");
                System.exit(0);
            }
        }
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(veg.getName() + " " + veg.getCalories() + " " + veg.getFat() + " " + veg.getProteins() + " " + veg.getWeight());
            bw.close();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}

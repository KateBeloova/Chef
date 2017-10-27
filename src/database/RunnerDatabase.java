package database;

import components.Vegetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RunnerDatabase {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vegetables";

    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection connection = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        DatabaseReader reader = new DatabaseReader(connection);
        reader.setConnection(DriverManager.getConnection(DB_URL, USER, PASS));
        printAllFromDB(reader);
    }

    private static void printAllFromDB(DatabaseReader reader) {
        int rows = reader.getRowNumber();
        System.out.println("Database contains " + rows + " rows:");
        for (int i = 1; i <= rows; i++) {
            Vegetable veg = reader.readInfo(i);
            System.out.println(veg.getName() + ": calories = " + veg.getCalories() + ", fat = " + veg.getFat() + ", carbs = " + veg.getWeight());
        }
    }


}

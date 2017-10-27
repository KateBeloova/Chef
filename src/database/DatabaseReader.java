package database;

import components.Vegetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseReader {

    private Connection connection;
    private PreparedStatement prState = null;
    private ResultSet rs = null;

    public DatabaseReader(Connection connection) {
        super();
        this.connection = connection;
    }

    public int getRowNumber() {
        int size = 0;
        try {
            prState = connection.prepareStatement("SELECT * from vegetable;");
            rs = prState.executeQuery();
            while (rs.next()) {
                size++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
            }
            try {
                if (prState != null)
                    prState.close();
            } catch (SQLException e) {
            }
        }
        return size;
    }

    public Vegetable readInfo(int id) {
        Vegetable vegetable = null;
        try {
            prState = connection.prepareStatement("SELECT * from vegetable where id=?;");
            prState.setInt(1, id);

            rs = prState.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    vegetable = new Vegetable(rs.getString("NAME"), rs.getDouble("CALORIES"), rs.getDouble("FAT"), rs.getDouble("CARBS"), 0);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
            }
            try {
                if (prState != null)
                    prState.close();
            } catch (SQLException e) {
            }
        }
        return vegetable;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}

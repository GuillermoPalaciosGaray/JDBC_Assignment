package edu.tcs.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButilities {



    public static Connection connection = null;

    public static Connection getConnection() throws IOException {
        ReadConfiguration readConfiguration = new ReadConfiguration();

        String configurationText= readConfiguration.readTxtConfiguration("C:\\Users\\xmen9\\OneDrive\\Escritorio\\ConfigurationJDBC.txt");
        String[] configurations = configurationText.split(";");
        String DRIVER = readConfiguration.getDriver();
        String URL = readConfiguration.getURL();
        String USER = readConfiguration.getUser();
        String PASSWORD = readConfiguration.getPassword();
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexion exitosa");
                return connection;
            }
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
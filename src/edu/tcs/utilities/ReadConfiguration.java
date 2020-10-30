package edu.tcs.utilities;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class ReadConfiguration {


    String result = "";
    InputStream inputStream;

    public String getDriver() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String DRIVER="";
        try {
            //Input stream store the path of my config file
         inputStream = new FileInputStream("C:\\Ejercicios de Java\\JDBC_Config_External\\resources\\config\\config.properties");
        properties.load(inputStream);
            DRIVER = properties.getProperty("DRIVER");
//            System.out.println("The DRIVER is: "+properties.getProperty("DRIVER"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
            return  DRIVER;
    }
    public String getURL() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String URL="";
        try {
            //Input stream store the path of my config file
            inputStream = new FileInputStream("C:\\Ejercicios de Java\\JDBC_Config_External\\resources\\config\\config.properties");
            properties.load(inputStream);
            URL = properties.getProperty("URL");
//            System.out.println("The URL is: "+properties.getProperty("URL"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return URL;
    }
    public String getUser() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String USER="";
        try {
            //Input stream store the path of my config file
            inputStream = new FileInputStream("C:\\Ejercicios de Java\\JDBC_Config_External\\resources\\config\\config.properties");
            properties.load(inputStream);
            USER= properties.getProperty("USER");
//            System.out.println("The USER is: "+properties.getProperty("USER"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return USER;
    }
    public String getPassword() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String PASSWORD ="";
        try {
            //Input stream store the path of my config file
            inputStream = new FileInputStream("C:\\Ejercicios de Java\\JDBC_Config_External\\resources\\config\\config.properties");
            properties.load(inputStream);
            PASSWORD = properties.getProperty("PASSWORD");
//            System.out.println("The password is: "+properties.getProperty("PASSWORD"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return PASSWORD;
    }

    //This one was my first attemp to read the configurations from an external TXT file
    public String readTxtConfiguration(String path){
        String configText = "";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String temp = "";
            String bfRead;
            //Do the cycle meanwhile it has data in it
            while ((bfRead = bf.readLine())!=null){

                temp = temp+bfRead; //Text of the file

            }
            configText=temp;

        }catch(Exception e){
        e.printStackTrace();
        }
        return configText;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ultimatesoftware.sghc;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author chiti
 */
public class ConnectionFile {

    private Properties prop ;
    private String url="jdbc:postgresql://localhost:5432/sghc";
    private String username="postgres";
    private String password="postgres";
    private String dialect="org.hibernate.dialect.PostgreSQLDialect";
    private String showSql="true";
    private String currentSessionContextClass="thread";
    private String driverClass="org.postgresql.Driver";
    private String c3p0MinSize="5";
    private String c3p0MaxSize="20";
    private String c3p0TimeOut="1800";
    private String c3p0MaxStatements="50";

    public ConnectionFile() {

    }

   public ConnectionFile(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties createPropertiesFile(){

        OutputStream output = null;
        boolean ok=false;
        try {
            // set the properties value
            prop=new Properties();
            prop.setProperty("hibernate.dialect", dialect);
            prop.setProperty("hibernate.connection.driver_class", driverClass);
            prop.setProperty("hibernate.connection.url", url);
            prop.setProperty("hibernate.connection.username", username);
            prop.setProperty("hibernate.connection.password", password);
            prop.setProperty("hibernate.show_sql", showSql);
            prop.setProperty("hibernate.current_session_context_class", currentSessionContextClass);
            prop.setProperty("hibernate.c3p0.min_size", c3p0MinSize);
            prop.setProperty("hibernate.c3p0.max_size", c3p0MaxSize);
            prop.setProperty("hibernate.c3p0.timeout", c3p0TimeOut);
            prop.setProperty("hibernate.c3p0.max_statements", c3p0MaxStatements);
            prop.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
            // save properties to project root folder
            FileOutputStream fileOut = new FileOutputStream("connection.properties");
            prop.store(fileOut, null);
            fileOut.close();
            ok = true;


        } catch (IOException io) {
            Message m = new Message();
            m.showMessage("Error",io.toString(), Alert.AlertType.ERROR);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop;
    }
    public String saveProperties(Properties p){
        String mensaje ="No se ha podido guardar: ";
       try {
           FileOutputStream fileOut = new FileOutputStream("connection.properties");

           p.store(fileOut, null);
           fileOut.close();
           mensaje="Datos guardados correctamente";
       }catch(Exception e){
           mensaje=""+e.toString();
       }
       return mensaje;
    }

    public Properties getPropertiesFile(){
        boolean exist=false;
        try (InputStream input = new FileInputStream("connection.properties")) {
            if (input != null)
                exist = true;
            prop = new Properties();
            prop.load(input);
        }catch(Exception e){
            System.out.println(e);
        }
        return prop;
    }

}

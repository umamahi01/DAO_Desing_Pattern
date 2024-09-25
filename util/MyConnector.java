/**connects to data base by using single-ton design pattern */


package com.tap.util;
import java.sql.Connection;
import java.sql.DriverManager;



public class MyConnector {
   
    private MyConnector(){
    }

    private static  MyConnector myconnectobj = new MyConnector();
    public static MyConnector getConnectorObj(){
        return myconnectobj;
    }

    public Connection getConnection() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
               return DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","root");
            }
            catch(Exception e){
                e.printStackTrace();
            }

             return null;   
    }
}
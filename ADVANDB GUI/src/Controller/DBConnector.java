/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author WilliamPC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnector {
    private final static String DB_NAME = "whatdo";
    private final static String URL_NAME = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private final static String DRIVER = "com.mysql.jdbc.Driver" ;
    private final static String USERNAME = "root";
    private final static String PASSWORD = "water";
    private static DBConnector connector;
    private Connection connect;
    
    
    private DBConnector(){
        
        
        try{
            Class.forName(DRIVER).newInstance();
            connect = DriverManager.getConnection(URL_NAME, USERNAME, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("no connection");
        }
    }
    
    public Connection getConnection(){
        
        
        return connect;
    }
    
    
//    public static void executeStatement(String statement){
//        Connection conn = getConnection();
//        ResultSet res = null;
//        try{
//            Statement st = conn.createStatement();
//            st.execute(statement);
//            conn.close();
//        }catch(SQLException e){
//            e.printStackTrace();
//            System.out.println("DB Error");
//        }
//    }
//    
//    public static ResultSet executeQuery(String query){
//        ResultSet result = null;
//        Connection conn = DBConnector.getConnection();
//        try{
//            Statement st = conn.createStatement();
//            result = st.executeQuery(query);
//        }catch(SQLException ex){
//             Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
    
    public Connection getConnect(){
        return connect;
    }
    
    public static DBConnector getInstance(){
        if(connector == null){
            connector = new DBConnector();
        }
        return connector;
    }
    
   
}
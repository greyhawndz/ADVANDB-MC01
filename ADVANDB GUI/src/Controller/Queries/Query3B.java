/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Queries;

import Controller.DBConnector;
import Controller.QueryHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author WilliamPC
 */
public class Query3B {
     private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    private double start;
    private double end;
    public Query3B(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(){
        
        try{
            String update = "CREATE TEMPORARY TABLE IF NOT EXISTS optimized_years AS\n" +
                            "Select mlenresid as \"Years of Residence\"\n" +
                            "from hpq_mem mem, hpq_hh hh\n" +
                            "where hh.id = mem.id AND hh.tenur = 1 AND mem.jstatus = 1;\n" +
                            "\n";
            String query = 
                            "Select * from optimized_years;"; //Add query here
            PreparedStatement updateStatement = connect.prepareStatement(update);
            statement = connect.prepareStatement(query);
            //TODO: Set statements here
            start = System.currentTimeMillis();
            updateStatement.executeUpdate();
             result = statement.executeQuery();
             end = System.currentTimeMillis();
             
             if(result != null){
                 //Send data to query handler so that it can notify view to open a new window and display data
                 table = new JTable();
                 table.setModel(DbUtils.resultSetToTableModel(result));
                 QueryHandler.NotifyTableView(table, start, end);
             }           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(Query1A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        if(result != null){
            try {
               result.close();
            } catch (SQLException ex) {
                Logger.getLogger(Query1A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
       /*  if(connect != null){
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(Query1A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/   
    }
}

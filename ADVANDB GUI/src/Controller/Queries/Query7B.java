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
public class Query7B {
     private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    private double start;
    private double end;
    public Query7B(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(){
        
        try{
            String update = "create temporary table if not exists optimized_fishloc as \n" +
                            "Select hh.catch_fish_loc as \"Fishing Location\", sum(animals.aquani_vol) as \"Total Volume per location\"\n" +
                            "from hpq_hh hh, hpq_mem mem, hpq_aquaequip equip, hpq_aquani animals\n" +
                            "where mem.id = hh.id and equip.hpq_hh_id = hh.id and animals.hpq_hh_id = hh.id and hh.yrs_in_fishind >= 2 and mem.age_yr >= 35 and mem.age_yr <= 50 and hh.boat1_own = 1 and catch_fish = 1\n" +
                            "group by hh.catch_fish_loc;";
            String query = "select * from optimized_fishloc;"; //Add query here
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
        
            
        /*  if(connect != null){
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(Query1A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/      
    }
}

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
public class Query4B {
     private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    private double start;
    private double end;
    public Query4B(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(){
        
        try{
            String update = "create temporary table if not exists flood_death as\n" +
                            "SELECT  prov,mun,zone,brgy, count(death.mdeady) as \"Flood Death Count\" \n" +
"                            from  hpq_death death, hpq_hh hh\n" +
"                            where  death.hpq_hh_id = hh.id AND (hh.calam2 = 1 AND hh.calam2_aid = 2 AND death.mdeady = 13) or death.mdeady_o = \"nalunod\"\n" +
"                            Group by prov,mun,zone,brgy;";
            String query = "Select * from flood_death"; //Add query here
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

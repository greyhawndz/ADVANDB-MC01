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
public class RollupQuery {
    private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    public RollupQuery(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(){
        
        try{
            String query = "SELECT prov, mun, zone, brgy, aquanitype, aquanitype_o, SUM(aquani_vol)\n" +
                            "FROM aquani, household, aquani_volume\n" +
                            "WHERE aquani.id = aquani_volume.aquani_id AND household.id = aquani_volume.household_id\n" +
                            "GROUP BY prov, mun, zone, brgy, aquanitype, aquanitype_o"; //Add query here
            statement = connect.prepareStatement(query);
             result = statement.executeQuery();
             
             if(result != null){
                 table = new JTable();
                 table.setModel(DbUtils.resultSetToTableModel(result));
                 QueryHandler.NotifyTableView(table);
             }
                     
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        /*if(connect != null){
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(Query1A.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  */
        
        
    }
}

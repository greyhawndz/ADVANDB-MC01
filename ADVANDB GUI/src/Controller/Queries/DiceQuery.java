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
public class DiceQuery {
    private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    public DiceQuery(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(int select){
        
        try{
            String query = "SELECT prov, mun, zone, brgy, SUM(aquani_vol), aquaequiptype, aquaequiptype_o, \n" +
                            "boat1, boat2, boat3, boat4, boat5\n" +
                            "FROM aquani, household, aquani_volume, aquaequip\n" +
                            "WHERE aquani.id = aquani_volume.aquani_id AND aquani_volume.aquaequip_id = aquaequip.id AND household.id = aquani_volume.household_id\n" +
                            "AND aquanitype = ? AND aquani_line = 6\n" +
                            "GROUP BY prov, mun, zone, brgy, aquaequiptype, aquaequiptype_o, boat1, boat2, boat3, boat4, boat5"; //Add query here
            statement = connect.prepareStatement(query);
            statement.setInt(1, select);
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

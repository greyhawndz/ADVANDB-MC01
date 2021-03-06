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
public class Query6A {
     private DBConnector connector;
    private Connection connect;
    private ResultSet result;
    private PreparedStatement statement;
    private JTable table;
    private double start;
    private double end;
    public Query6A(){
        connector = DBConnector.getInstance();
        connect = connector.getConnect();
    }
    
    public void ProcessQuery(){
        
        try{
            String query = "Select count(hh.id) as \"Number of Farmers with owned Tax Declared Lands\", crop.croptype as \"Crop\"\n" +
                            "from hpq_hh hh, hpq_crop crop, hpq_alp alp ignore index (alp_tenur)\n" +
                            "where crop.hpq_hh_id = hh.id AND alp.hpq_hh_id = hh.id AND hh.landagri >= 1 AND alp.alp_tenur_o = \"tax declaration\"\n" +
                            "group by crop.croptype"; //Add query here
            statement = connect.prepareStatement(query);
            //TODO: Set statements here
            start = System.currentTimeMillis();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Queries.*;
import Model.Timer;
import View.TableView;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WilliamPC
 */
public class QueryHandler {
   
    
    
    public static void OnNotification(int index) throws SQLException{
        switch(index){
            case 0: RollupQuery rollup = new RollupQuery();
                    
                    rollup.ProcessQuery();
                    
                    break;
            case 1: DrillDownQuery drillDown = new DrillDownQuery();
                    
                    drillDown.ProcessQuery();
                    
                    break;
            case 2: SliceQuery slice = new SliceQuery();
                    
                    slice.ProcessQuery();
                    
                    break;
            case 3: DiceQuery dice = new DiceQuery();
                    
                    dice.ProcessQuery();
                   
                    break;
            
        }
    }
    
    public static void NotifyTableView(JTable table){
        new TableView(table);
    }
}

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
   
    private static long totalTime;
    
    
    public static void OnNotification(int index){
        switch(index){
            case 0: Query1A query1A = new Query1A();
                    
                    query1A.ProcessQuery();
                    
                    break;
            case 1: Query1B query1B = new Query1B();
                    
                    query1B.ProcessQuery();
                    
                    break;
            case 2: Query2A query2A = new Query2A();
                    
                    query2A.ProcessQuery();
                    
                    break;
            case 3: Query2B query2B = new Query2B();
                    
                    query2B.ProcessQuery();
                   
                    break;
            case 4: Query3A query3A = new Query3A();
                   
                    query3A.ProcessQuery();
                   
                    break;
            case 5: Query3B query3B = new Query3B();
                   
                    query3B.ProcessQuery();
                    
                    break;
            case 6: Query4A query4A = new Query4A();
                   
                    query4A.ProcessQuery();
                   
                    break;
            case 7: Query4B query4B = new Query4B();
                    
                    query4B.ProcessQuery();
                    
                    break;
            case 8: Query5A query5A = new Query5A();
                    
                    query5A.ProcessQuery();
                    
                    break;
            case 9: Query5B query5B = new Query5B();
                    
                    query5B.ProcessQuery();
                    
                    break;
            case 10: Query6A query6A = new Query6A();
                    
                     query6A.ProcessQuery();
                    
                    break;
            case 11: Query6B query6B = new Query6B();
                    
                     query6B.ProcessQuery();
                  
                     break;
            case 12: Query7A query7A = new Query7A();
                    
                     query7A.ProcessQuery();
                 
                     break;
            case 13: Query7B query7B = new Query7B();
                    
                     query7B.ProcessQuery();
                    
                     break;
        }
    }
    
    public static void NotifyTableView(JTable table, long start, long end){
        totalTime = end - start;
        System.out.println("Pasok?");
        new TableView(table, totalTime);
    }
}

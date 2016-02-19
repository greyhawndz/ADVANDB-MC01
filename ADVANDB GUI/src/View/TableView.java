/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WilliamPC
 */
public class TableView extends JFrame{
    private JTable table;
    private JLabel timeLabel;
    private JLabel timeVal;
    private long time;
    
    public TableView(JTable table, long time){
        this.table = table;
        this.time = time;
        DrawComponents();
    }
    
    public void DrawComponents(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        timeLabel = new JLabel("Execution Time: ");
        String t = Long.toString(time);
        timeVal = new JLabel(t);
        p.add(table, BorderLayout.NORTH);
        p2.add(timeLabel);
        p2.add(timeVal);
        p.add(p2,BorderLayout.SOUTH);
        p.setBorder(new EmptyBorder(10,10,10,10));
        this.add(p);
    }
}

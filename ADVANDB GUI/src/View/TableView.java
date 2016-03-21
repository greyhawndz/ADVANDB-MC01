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
    
    
    public TableView(JTable table){
        this.table = table;
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DrawComponents();
        this.setVisible(true);
    }
    
    public void DrawComponents(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        p.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.NORTH);
        p.add(p2,BorderLayout.SOUTH);
        p.setBorder(new EmptyBorder(10,10,10,10));
        this.add(p);
    }
}

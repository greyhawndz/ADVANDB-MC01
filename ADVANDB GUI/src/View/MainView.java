/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.QueryHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author WilliamPC
 */
public final class MainView extends JFrame {
    private Toolkit tk;
    private JButton executeButton;
    private JTable table;
    private JPanel panel;
    private JLabel queryLabel;
    private JComboBox querySelect;
    private String[] comboBoxVal = {"Roll-Up", "Drill-Down", "Slice", "Dice"};
    public MainView(){
        this.setSize(400,100); 
       
        tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getWidth() / 2) + 100;
        this.setLocation(xPos,yPos);
        this.setResizable(false);
        
        this.setTitle("MC02");
        DrawComponents();
        SetListeners();
        
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void DrawComponents(){
        panel = new JPanel();
        queryLabel = new JLabel("Olap Operation: ");
        querySelect = new JComboBox(comboBoxVal);
        executeButton = new JButton("Execute Operation");
        panel.add(queryLabel);
        panel.add(querySelect);
        panel.add(executeButton);
        panel.setBorder(new EmptyBorder(20,10,10,10));
        this.add(panel);
    }
    
    public void SetListeners(){
        executeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(querySelect.getSelectedIndex());
                try {
                    QueryHandler.OnNotification(querySelect.getSelectedIndex());
                } catch (SQLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
   /* public void DrawComponents(){
        JPanel panel = new JPanel();
        
        
        
        
        panel.add(queryLabel);
        panel.add(executeButton);
        this.add(panel);
    }*/

 

    
    
}

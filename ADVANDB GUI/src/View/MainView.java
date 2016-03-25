/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.QueryHandler;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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
    private JPanel card1;
    private JPanel card2;
    private JPanel card3;
    private JPanel card4;
    private JPanel main;
    private JPanel cards;
    private JLabel queryLabel;
    private JComboBox querySelect;
    private String[] comboBoxVal = {"Roll-Up", "Drill-Down", "Slice", "Dice"};
    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;
    private JRadioButton button4;
    private JRadioButton button5;
    private JRadioButton button6;
    private JRadioButton button7;
    private JRadioButton button8;
    private JRadioButton button9;
    private JRadioButton button10;
    private JRadioButton button11;
    private JRadioButton button12;
    private ButtonGroup group;
    private ButtonGroup group2;
    private CardLayout cl;
    public MainView(){
        this.setSize(800,100); 
       
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
        main = new JPanel();
        cards = new JPanel(new CardLayout());
        panel = new JPanel();
        
        card1 = new JPanel();
        card2 = new JPanel();
        card3 = new JPanel();
        card4 = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Input");
        
        button1 = new JRadioButton("Tilapia");
        button2 = new JRadioButton("Milkfish");
        button3 = new JRadioButton("Catfish");
        button4 = new JRadioButton("Mudfish");
        button5 = new JRadioButton("Carp");
        button6 = new JRadioButton("Other");
        button7 = new JRadioButton("Tilapia");
        button8 = new JRadioButton("Milkfish");
        button9 = new JRadioButton("Catfish");
        button10 = new JRadioButton("Mudfish");
        button11 = new JRadioButton("Carp");
        button12 = new JRadioButton("Other");
        button1.setSelected(true);
        button7.setSelected(true);
        group = new ButtonGroup();
        group2 = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);
        group.add(button5);
        group.add(button6);
        
        group2.add(button7);
        group2.add(button8);
        group2.add(button9);
        group2.add(button10);
        group2.add(button11);
        group2.add(button12);
        
        
        queryLabel = new JLabel("Olap Operation: ");
        querySelect = new JComboBox(comboBoxVal);
        executeButton = new JButton("Execute Operation");
        panel.add(queryLabel);
        panel.add(querySelect);
        panel.add(executeButton);
        panel.setBorder(new EmptyBorder(20,10,10,10));
        
       
        
      
        card3.setBorder(title);
        card3.add(button1);
        card3.add(button2);
        card3.add(button3);
        card3.add(button4);
        card3.add(button5);
        card3.add(button6);
        
        card4.setBorder(title);
        card4.add(button7);
        card4.add(button8);
        card4.add(button9);
        card4.add(button10);
        card4.add(button11);
        card4.add(button12);
        
        cards.add(card1, comboBoxVal[0]);
        cards.add(card2, comboBoxVal[1]);
        cards.add(card3, comboBoxVal[2]);
        cards.add(card4, comboBoxVal[3]);
        main.add(panel);
        main.add(cards);
        
        querySelect.setEditable(false);
        cl = (CardLayout) cards.getLayout();
        
        
        this.add(main);
    }
    
    public void SetListeners(){
        
        querySelect.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent evt){
                System.out.println("Item state changed");
                System.out.println((String)evt.getItem());
                cl.show(cards, (String) evt.getItem());
                
            }
        
        });
        executeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(querySelect.getSelectedIndex());
                try {
                    int select = getSelectedButton();
                    QueryHandler.OnNotification(querySelect.getSelectedIndex(), select);
                } catch (SQLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public int getSelectedButton(){
        int select = 0;
        
        if(button1.isSelected() || button7.isSelected())
            select = 1;
        else if(button2.isSelected() || button8.isSelected())
            select = 2;
        else if(button3.isSelected() || button9.isSelected())
            select = 3;
        else if(button4.isSelected() || button10.isSelected())
            select = 4;
        else if(button5.isSelected() || button11.isSelected())
            select = 5;
        else if(button6.isSelected() || button12.isSelected())
            select = 6;
        return select;
    }
    
   /* public void DrawComponents(){
        JPanel panel = new JPanel();
        
        
        
        
        panel.add(queryLabel);
        panel.add(executeButton);
        this.add(panel);
    }*/

 

    
    
}

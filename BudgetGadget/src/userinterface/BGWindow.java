package userinterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//created 8/31/2016

public class BGWindow extends JFrame{
    private JButton newEntry;
    private JTextField year, month, day;
    private int x_win_size = 500, y_win_size = 500;
    private JPanel panel;
    
    public BGWindow()
    {
        super("BudgetGadget BETA");
        year = new JTextField("Year", 4);
        month = new JTextField("Month", 2);
        day = new JTextField("Date", 2);
        
        panel = new JPanel();
        JLabel label1 = new JLabel("Tell me something");
        label1.setText("New text");
        label1.setToolTipText("Doesn't do anyhthing");
        panel.add(label1);
        
        setLayout(new FlowLayout());
        this.defaultWinSetup();
        newEntry = new JButton("New Entry");
        add(panel);
        add(year);
        add(month);
        add(day);
        add(newEntry);
    }
    
    private void defaultWinSetup()
    { 
        //tookkit can communicate with the OS to get data about it
        Toolkit tk = Toolkit.getDefaultToolkit();
        //the current screen res
        Dimension dim = tk.getScreenSize();
        x_win_size = dim.width;
        y_win_size = dim.height;
        System.out.println("The screen is " + x_win_size + " by " + y_win_size);
        this.setSize(x_win_size, y_win_size);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}

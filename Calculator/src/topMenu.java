import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class topMenu implements ActionListener {
    //Menu bar and menu bar items
    JMenuBar menuBar;
    JMenuItem scientificMode;
    JMenuItem standardMode;

    //Frame variables and reference variable of 
    JFrame frame;
    scientific sciCalc;
    standard stand;

    topMenu() {
        stand=new standard();
        menuBar = new JMenuBar();  
        JMenu menu = new JMenu("=");
        menu.setFont(new Font("SansSerif", Font.BOLD, 35));
        
        scientificMode = new JMenuItem("Scientific Mode");
        standardMode = new JMenuItem("Standard Mode");
      
        scientificMode.addActionListener(this);
        standardMode.addActionListener(this);

        scientificMode.setFont(new Font("SansSerif", Font.ITALIC, 15));
        standardMode.setFont(new Font("SansSerif", Font.ITALIC, 15));
        
        //addinng buttons to menus
        menu.add(scientificMode);
        menu.add(standardMode);
        menuBar.add(menu);

        frame = new JFrame("Scientific Calculator");
        sciCalc = new scientific();
        frame.setJMenuBar(menuBar);

        ImageIcon icon = new ImageIcon("java calculator1/Java Calculator/Calculator/src/calculator.png");//calculator icon
        frame.setIconImage(icon.getImage());
        frame.setLayout(new BorderLayout());
        frame.add(sciCalc.textHolder, BorderLayout.NORTH);
        frame.add(sciCalc.standardButtonHolder, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,450);
        frame.setResizable(false);
        frame.setVisible(true);

    }


    // action listener for menu bar buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scientificMode) {
            frame.add(sciCalc.scientificPanel, BorderLayout.WEST);
            frame.revalidate();
            frame.repaint();
        } else if (e.getSource() == standardMode) {
            frame.remove(sciCalc.scientificPanel);
            frame.revalidate();
            frame.repaint();
        }

    }
}


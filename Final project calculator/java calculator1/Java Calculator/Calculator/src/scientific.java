import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class scientific extends standard {
    JPanel scientificPanel;
    scientificListener sl;
    JButton abs, sin, log, cos, ln, tan, factorial, xY, sqrt, arcsin, arccos, arctan;

    public scientific() {
        sl = new scientificListener();
        scientificPanel = new JPanel();
        scientificPanel.setLayout(new GridLayout(6, 2,4,3));

        // Create the buttons one by one
        abs = new JButton("abs");
        sin = new JButton("sin");
        log = new JButton("log");
        cos = new JButton("cos");
        ln = new JButton("ln");
        tan = new JButton("tan");
        factorial = new JButton("x!");
        arcsin = new JButton("arcsin");
        xY = new JButton("xY");
        arccos = new JButton("arccos");
        sqrt = new JButton("sqrt");
        arctan = new JButton("arctan");

        // Register action listeners
        abs.addActionListener(sl);
        sin.addActionListener(sl);
        log.addActionListener(sl);
        cos.addActionListener(sl);
        ln.addActionListener(sl);
        tan.addActionListener(sl);
        factorial.addActionListener(sl);
        arcsin.addActionListener(sl);
        xY.addActionListener(sl);
        arccos.addActionListener(sl);
        sqrt.addActionListener(sl);
        arctan.addActionListener(sl);

        abs.setBackground(new Color(40, 56, 120));
        abs.setBorder(null);
        abs.setFocusable(false);
        abs.setForeground(Color.white);
        abs.setFont(new Font("sansserif", Font.BOLD, 16));

        sin.setBackground(new Color(40, 56, 120));
        sin.setBorder(null);
        sin.setFocusable(false);
        sin.setForeground(Color.white);
        sin.setFont(new Font("sansserif", Font.BOLD, 16));




        log.setBackground(new Color(66, 61, 71));
        log.setBorder(null);
        log.setFocusable(false);
        log.setForeground(Color.white);
        log.setFont(new Font("sansserif", Font.BOLD, 16));

        cos.setBackground(new Color(66, 61, 71));
        cos.setBorder(null);
        cos.setFocusable(false);
        cos.setForeground(Color.white);
        cos.setFont(new Font("sansserif", Font.BOLD, 16));

        ln.setBackground(new Color(66, 61, 71));
        ln.setBorder(null);
        ln.setFocusable(false);
        ln.setForeground(Color.white);
        ln.setFont(new Font("sansserif", Font.BOLD, 16));

        tan.setBackground(new Color(66, 61, 71));
        tan.setBorder(null);
        tan.setFocusable(false);
        tan.setForeground(Color.white);
        tan.setFont(new Font("sansserif", Font.BOLD, 16));

        factorial.setBackground(new Color(66, 61, 71));
        factorial.setBorder(null);
        factorial.setFocusable(false);
        factorial.setForeground(Color.white);
        factorial.setFont(new Font("sansserif", Font.BOLD, 16));

        xY.setBackground(new Color(66, 61, 71));
        xY.setBorder(null);
        xY.setFocusable(false);
        xY.setForeground(Color.white);
        xY.setFont(new Font("sansserif", Font.BOLD, 16));

        arcsin.setBackground(new Color(66, 61, 71));
        arcsin.setBorder(null);
        arcsin.setFocusable(false);
        arcsin.setForeground(Color.white);
        arcsin.setFont(new Font("sansserif", Font.BOLD, 16));

        arccos.setBackground(new Color(66, 61, 71));
        arccos.setBorder(null);
        arccos.setFocusable(false);
        arccos.setForeground(Color.white);
        arccos.setFont(new Font("sansserif", Font.BOLD, 16));

        sqrt.setBackground(new Color(66, 61, 71));
        sqrt.setBorder(null);
        sqrt.setFocusable(false);
        sqrt.setForeground(Color.white);
        sqrt.setFont(new Font("sansserif", Font.BOLD, 16));

        arctan.setBackground(new Color(66, 61, 71));
        arctan.setBorder(null);
        arctan.setFocusable(false);
        arctan.setForeground(Color.white);
        arctan.setFont(new Font("sansserif", Font.BOLD, 16));

        // Add the buttons to the panel
        scientificPanel.add(abs);
        scientificPanel.add(sin);
        scientificPanel.add(log);
        scientificPanel.add(cos);
        scientificPanel.add(ln);
        scientificPanel.add(tan);
        scientificPanel.add(factorial);
        scientificPanel.add(arcsin);
        scientificPanel.add(xY);
        scientificPanel.add(arccos);
        scientificPanel.add(sqrt);
        scientificPanel.add(arctan);
    }

    public class scientificListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == xY) {
                
                calculable += "^";
            } else if (e.getSource() == factorial) {
                calculable += "!";
            } else {
                clicked = (JButton) e.getSource();
                thebutton = clicked.getText();
                calculable += thebutton + "(";
            }
            input.setText(calculable);
            try{
                String result = ExpressionEvaluator.evaluate(input.getText());
                double temp = Double.parseDouble(result);
                temp = Math.round( temp* Math.pow(10,2)) / Math.pow(10,2);
                display.setText(String.valueOf(temp));
            }
            catch(Exception ex){
                display.setText("");
            }
            
        }
    }
}
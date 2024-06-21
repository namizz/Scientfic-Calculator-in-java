import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class standard {
    JPanel standardButtonHolder;// this panel contains all the buttons on standard calculator 
    JPanel textHolder;//this panel contains text filed that return input of the use and output 
    JTextField input;
    JTextField display;

    ArrayList<JButton> numButtons;//this array number button 
    JButton plus, percent, minus, multiply, divide, equal, answer, dot, clearAll, delete, pi, openBracket, closeBracket, e;
    //variable that are used in action listener class
    buttonListener bl;
    String thebutton;
    String calculable = "";
    JButton clicked;
    String ans="";

    public standard() {
        standardButtonHolder = new JPanel(new GridLayout(6, 4, 4, 3));
        setOperatorButtons();//this function create buttons that are other than numbers
        createNumberButtons();//this function create number buttons
        addButtonsToPanel();//this function add the buttons to standardButtonHolder panel


        textHolder = new JPanel(new BorderLayout());
        input = new JTextField();
        input.setEditable(false);
        input.setFont(new Font("Serif", Font.PLAIN, 20));
        input.setBorder(null);
        display = new JTextField();
        display.setBorder(null);

        display.setHorizontalAlignment(JTextField.RIGHT);

        display.setFont(new Font("arial", Font.PLAIN, 20));
        display.setEditable(false);
        textHolder.add(input, BorderLayout.NORTH);
        textHolder.add(display, BorderLayout.CENTER);
    }

    public void setOperatorButtons() {
        dot = new JButton(".");
        equal = new JButton("=");
        openBracket = new JButton("(");
        closeBracket = new JButton(")");
        pi = new JButton("π");
        e = new JButton("e");
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        delete = new JButton("DEL");
        clearAll = new JButton("CE");
        answer = new JButton("ANS");
        percent = new JButton("%");

        dot.setBackground(Color.white);
        dot.setFocusable(false);
        dot.setBorder(null);
        dot.setFont(new Font("sansserif", Font.BOLD, 16));
        equal.setBackground(Color.white);
        equal.setBorder(null);
        equal.setFocusable(false);
        equal.setFont(new Font("sansserif", Font.BOLD, 16));
        openBracket.setBackground(new Color(179, 191, 255));
        openBracket.setBorder(null);
        openBracket.setFocusable(false);
        openBracket.setForeground(Color.white);
        openBracket.setFont(new Font("sansserif", Font.BOLD, 16));

        bl = new buttonListener();

        // Button registration
        dot.addActionListener(bl);
        e.addActionListener(bl);
        closeBracket.addActionListener(bl);
        openBracket.addActionListener(bl);
        pi.addActionListener(bl);
        delete.addActionListener(bl);
        clearAll.addActionListener(bl);
        plus.addActionListener(bl);
        minus.addActionListener(bl);
        divide.addActionListener(bl);
        multiply.addActionListener(bl);
        answer.addActionListener(bl);
        percent.addActionListener(bl);
        equal.addActionListener(bl);

        dot.setBackground(Color.white);
        dot.setFocusable(false);
        dot.setBorder(null);
        dot.setFont(new Font("sansarif", Font.BOLD, 16));
        equal.setBackground(Color.white);
        equal.setBorder(null);
        equal.setFocusable(false);
        equal.setFont(new Font("sansarif", Font.BOLD, 16));

        openBracket.setBackground(new Color(66, 61, 71));
        openBracket.setBorder(null);
        openBracket.setFocusable(false);
        openBracket.setForeground(Color.white);
        openBracket.setFont(new Font("sansarif", Font.BOLD, 16));

        closeBracket.setBackground(new Color(66, 61, 71));
        closeBracket.setBorder(null);
        closeBracket.setFocusable(false);
        closeBracket.setForeground(Color.white);
        closeBracket.setFont(new Font("sansarif", Font.BOLD, 16));

        clearAll.setBackground(new Color(66, 61, 71));
        clearAll.setBorder(null);
        clearAll.setFocusable(false);
        clearAll.setForeground(Color.white);
        clearAll.setFont(new Font("sansarif", Font.BOLD, 16));

        divide.setBackground(new Color(66, 61, 71));
        divide.setBorder(null);
        divide.setFocusable(false);
        divide.setForeground(Color.white);
        divide.setFont(new Font("sansarif", Font.BOLD, 20));

        multiply.setBackground(new Color(66, 61, 71));
        multiply.setBorder(null);
        multiply.setFocusable(false);
        multiply.setForeground(Color.white);
        multiply.setFont(new Font("sansarif", Font.BOLD, 20));

        minus.setBackground(new Color(66, 61, 71));
        minus.setBorder(null);
        minus.setFocusable(false);
        minus.setForeground(Color.white);
        minus.setFont(new Font("sansarif", Font.BOLD, 20));

        plus.setBackground(new Color(66, 61, 71));
        plus.setBorder(null);
        plus.setFocusable(false);
        plus.setForeground(Color.white);
        plus.setFont(new Font("sansarif", Font.BOLD, 20));

        delete.setBackground(new Color(255, 0, 0));
        delete.setBorder(null);
        delete.setFocusable(false);
        delete.setForeground(Color.white);
        delete.setFont(new Font("sansarif", Font.BOLD, 16));

        pi.setBackground(Color.WHITE);
        pi.setBorder(null);
        pi.setFocusable(false);
        pi.setForeground(Color.BLACK);
        pi.setFont(new Font("sansarif", Font.BOLD, 16));

        percent.setBackground(Color.WHITE);
        percent.setBorder(null);
        percent.setFocusable(false);
        percent.setForeground(Color.BLACK);
        percent.setFont(new Font("sansarif", Font.BOLD, 16));

        e.setBackground(Color.WHITE);
        e.setBorder(null);
        e.setFocusable(false);
        e.setForeground(Color.BLACK);
        e.setFont(new Font("sansarif", Font.BOLD, 16));

        answer.setBackground(new Color(66, 61, 71));
        answer.setFocusable(false);
        answer.setForeground(Color.white);
        answer.setFont(new Font("sansarif", Font.BOLD, 16));

    }

    public void createNumberButtons() {
        numButtons = new ArrayList<JButton>();
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(bl);
            button.setBackground(Color.white);
            button.setForeground(Color.black);
            button.setFocusable(false);
            button.setBorder(null);
            button.setFont(new Font("sansserif", Font.BOLD, 16));
            numButtons.add(button);
        }
    }
    
    public void addButtonsToPanel() {
        standardButtonHolder.add(openBracket);
        standardButtonHolder.add(closeBracket);
        standardButtonHolder.add(clearAll);
        standardButtonHolder.add(delete);
        for (int i = 7; i < 10; i++) {
            standardButtonHolder.add(numButtons.get(i));
        }
        standardButtonHolder.add(divide);
        for (int i = 4; i < 7; i++) {
            standardButtonHolder.add(numButtons.get(i));
        }
        standardButtonHolder.add(multiply);
        for (int i = 1; i < 4; i++) {
            standardButtonHolder.add(numButtons.get(i));
        }
        standardButtonHolder.add(minus);
        standardButtonHolder.add(numButtons.get(0));
        standardButtonHolder.add(dot);
        standardButtonHolder.add(equal);
        standardButtonHolder.add(plus);
        standardButtonHolder.add(pi);
        standardButtonHolder.add(e);
        standardButtonHolder.add(percent);
        standardButtonHolder.add(answer);
    }
    //Action Listener for standard buttons
    public class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        
            if (e.getSource() == delete) {
                if (!calculable.isEmpty()) {
                    calculable = calculable.substring(0, calculable.length() - 1);
                }
            } else if(e.getSource()==equal){
                calculable+="";

            } 
            else if (e.getSource() == clearAll) {
                try {
                    ans = ExpressionEvaluator.evaluate(input.getText());

                } catch (Exception eb) {

                }

                calculable = "";
            } else if (e.getSource() == answer) {
                calculable += ans;
            } else if (e.getSource() == percent) {
                calculable += "%(";
            } else if (e.getSource() == e) {
                calculable += "e^";
            }

            else {
                clicked = (JButton) e.getSource();
                thebutton = clicked.getText();
                calculable += thebutton;
            }
            if (e.getSource() == equal) {
                try {
                    double temp = Double.parseDouble(display.getText());
                    temp = Math.round(temp * Math.pow(10, 2)) / Math.pow(10, 2);
                    input.setText(String.valueOf(temp));
                    calculable = String.valueOf(temp);
                    display.setText("");
                    
                } catch (Exception ex) {
                    display.setText("");
                }
                

            } else {
                input.setText(calculable);
                try {
                    
                    
                    String result = ExpressionEvaluator.evaluate(input.getText());
                    if (isDouble(result)) {
                    double temp = Double.parseDouble(result);
                    temp = Math.round(temp * Math.pow(10, 2)) / Math.pow(10, 2);
                    display.setText(String.valueOf(temp));
                    }
                    else{
                        display.setText(result);
                    }
                    
                } catch (Exception ex) {
                    String res = input.getText();
                    if (res == null || res.isEmpty()){
                        display.setText("");
                    }
                    else
                    display.setText("");
                }
            }

        }
        public boolean isDouble(String str) {
            // Regular expression for matching a double
            String doubleRegex = "-?\\d+(\\.\\d+)?";
            return str.matches(doubleRegex);
        }
    }
}
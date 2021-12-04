import normal.*;
import scientific.Scientific;
import java.awt.event.*;

import javax.swing.*;

public class Calculator {

    public static void main(String args[]) {
        Calculator c = new Calculator();
        c.init();
    }

    private String str;
    private Calc1 normal = new Calc1();
    private Scientific scientific = new Scientific();
    private JTextArea manual_equation_area = new JTextArea();

    public void init() {

        JFrame f = new JFrame("Scientific Calculator");
        JTextField output = new JTextField();
        output.setBounds(270, 220, 430, 40);
        output.setEditable(false);

        JTextField equation_area = new JTextField();
        equation_area.setBounds(270, 170, 430, 40);
        equation_area.setEditable(false);

        manual_equation_area.setBounds(270, 270, 430, 40);
        manual_equation_area.setEditable(true);

        JButton manual_calculate = new JButton("calculate");
        manual_calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    str = manual_equation_area.getText();
                    if (str.charAt(0) == '\0') {
                        return;
                    }
                    String val[] = new String[100];
                    val = str.split(" ");
                    normal.add(val);
                    manual_equation_area.setText("");
                    System.out.println(str);
                } catch (Exception er) {
                    System.out.println(er);
                }
            }
        });
        manual_calculate.setBounds(490, 440, 100, 30);

        JButton one = new JButton("1");
        one.setBounds(270, 560, 100, 30);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("1");
                normal.add("1");
            }
        });

        JButton two = new JButton("2");
        two.setBounds(380, 560, 100, 30);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("2");
                normal.add("2");
            }
        });
        JButton three = new JButton("3");
        three.setBounds(490, 560, 100, 30);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("3");
                normal.add("3");
            }
        });

        JButton four = new JButton("4");
        four.setBounds(270, 520, 100, 30);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("4");
                normal.add("4");
            }
        });
        JButton five = new JButton("5");
        five.setBounds(380, 520, 100, 30);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("5");
                normal.add("5");
            }
        });

        JButton six = new JButton("6");
        six.setBounds(490, 520, 100, 30);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("6");
                normal.add("6");
            }
        });
        JButton seven = new JButton("7");
        seven.setBounds(270, 480, 100, 30);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("7");
                normal.add("7");
            }
        });

        JButton eight = new JButton("8");
        eight.setBounds(380, 480, 100, 30);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("8");
                normal.add("8");
            }
        });

        JButton nine = new JButton("9");
        nine.setBounds(490, 480, 100, 30);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("9");
                normal.add("9");
            }
        });

        JButton zero = new JButton("0");
        zero.setBounds(380, 600, 100, 30);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("0");
                normal.add("0");
            }
        });

        JButton plus = new JButton("+");
        plus.setBounds(600, 560, 100, 30);
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("+");
                normal.add("+");
            }
        });

        JButton minus = new JButton("-");
        minus.setBounds(600, 520, 100, 30);
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("-");
                normal.add("-");
            }
        });

        JButton multiplication = new JButton("*");
        multiplication.setBounds(600, 480, 100, 30);
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("*");
                normal.add("*");
            }
        });

        JButton division = new JButton("/");
        division.setBounds(600, 440, 100, 30);
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("/");
                normal.add("/");
            }
        });

        JButton total = new JButton("=");
        total.setBounds(600, 600, 100, 30);
        total.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(normal.total());
                equation_area.setText(normal.showEqn());
                String str = normal.total();
                normal.reset();
                normal.add(str);
            }
        });

        JButton all_clear = new JButton("AC");
        all_clear.setBounds(270, 440, 100, 30);
        all_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                normal.reset();
                output.setText(" ");
                equation_area.setText("");
            }
        });

        JButton show_equation = new JButton("eqn");
        show_equation.setBounds(380, 440, 100, 30);
        show_equation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equation_area.setText(normal.showEqn());
            }
        });

        JButton PI = new JButton("PI");
        PI.setBounds(160, 560, 100, 30);
        PI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(scientific.getPiValue()));
                normal.add(String.valueOf(scientific.getPiValue()));
            }
        });

        JButton e_value = new JButton("e");
        e_value.setBounds(270, 600, 100, 30);
        e_value.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(String.valueOf(scientific.getEValue()));
                normal.add(String.valueOf(scientific.getEValue()));
            }
        });

        JButton inverse = new JButton("1/x");
        inverse.setBounds(160, 520, 100, 30);
        inverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.getInverse(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.getInverse(valDouble)));
                equation_area.setText("1/" + valDouble);
            }
        });

        JButton sqrt = new JButton("sqrt");
        sqrt.setBounds(160, 440, 100, 30);
        sqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.sqRoot(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.sqRoot(valDouble)));
                equation_area.setText("Sqrt(" + valDouble + ")");
            }
        });

        JButton square = new JButton("X^2");
        square.setBounds(160, 480, 100, 30);
        square.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.square(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.square(valDouble)));
                equation_area.setText("Square(" + valDouble + ")");
            }
        });

        JButton sin = new JButton("sin");
        sin.setBounds(50, 560, 100, 30);
        sin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.sin(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.sin(valDouble)));
                equation_area.setText("sin(" + valDouble + ")");
            }
        });

        JButton cos = new JButton("cos");
        cos.setBounds(50, 520, 100, 30);
        cos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.cos(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.cos(valDouble)));
                equation_area.setText("cos(" + valDouble + ")");
            }
        });

        JButton tan = new JButton("tan");
        tan.setBounds(50, 480, 100, 30);
        tan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.tan(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.tan(valDouble)));
                equation_area.setText("tan(" + valDouble + ")");
            }
        });

        JButton log = new JButton("log");
        log.setBounds(50, 600, 100, 30);
        log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.log(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.log(valDouble)));
                equation_area.setText("log(" + valDouble + ")");
            }
        });

        JButton ln = new JButton("ln");
        ln.setBounds(160, 600, 100, 30);
        ln.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double valDouble = Double.parseDouble(normal.total());
                output.setText(String.valueOf(scientific.ln(valDouble)));
                normal.reset();
                normal.add(String.valueOf(scientific.ln(valDouble)));
                equation_area.setText("ln(" + valDouble + ")");
            }
        });

        JButton max_min = new JButton("max/min");
        max_min.setBounds(50, 440, 100, 30);
        max_min.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    System.out.print("Entered\n");
                    String str = manual_equation_area.getText();
                    double val[] = new double[25];
                    for(int i=0;i<str.length();i++){
                        try {
                            val[i] = Double.parseDouble(str.split(" ")[i]);
                        } catch (ArrayIndexOutOfBoundsException er) {
                            break;
                        }
                    }
                    output.setText(String.valueOf("Max: " + scientific.maximum(val) + "\tMin: " + scientific.minimum(val)));
                    equation_area.setText("Max and Min of (" + manual_equation_area.getText() + ")");
                    manual_equation_area.setText("");
                }
                catch(Exception er){System.out.println(er);}
            }
        });

        f.add(manual_calculate);
        f.add(output);
        f.add(equation_area);
        f.add(manual_equation_area);
        f.add(one);
        f.add(two);
        f.add(three);
        f.add(four);
        f.add(five);
        f.add(six);
        f.add(seven);
        f.add(eight);
        f.add(nine);
        f.add(zero);
        f.add(plus);
        f.add(minus);
        f.add(multiplication);
        f.add(division);
        f.add(total);
        f.add(all_clear);
        f.add(show_equation);
        f.add(PI);
        f.add(e_value);
        f.add(inverse);
        f.add(sqrt);
        f.add(square);
        f.add(sin);
        f.add(cos);
        f.add(tan);
        f.add(log);
        f.add(ln);
        f.add(max_min);
        f.setLayout(null);
        f.setSize(750, 700);
        f.setVisible(true);
        f.setEnabled(true);
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }
}

// 10 + 5 - 2 * 10 / 8 + 100 q
// 10.2 * 3 - 10 / 6 + 8 * 5 * 0 + 10 / 100 + 0.3 * 0.2 / 0.5 q
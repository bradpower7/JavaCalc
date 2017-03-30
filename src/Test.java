import Jraph.DataPoint2D;
import eval.Token;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Brad Power on 3/29/2017 for JavaCalc.
 */
public class Test extends JFrame {
    private JPanel numberPanel;
    private JPanel functionPanel;
    private JPanel modifierPanel;
    private JPanel operatorPanel;
    private JPanel GraphPanel;

    private JButton log10Button;
    private JButton sinButton;
    private JButton cosButton;
    private JButton tanButton;
    private JButton arctanButton;
    private JButton arccosButton;
    private JButton lnButton;
    private JButton arcsinButton;
    private JButton expButton;
    private JButton powButton;

    private JButton addButton;
    private JButton subButton;
    private JButton multButton;
    private JButton divButton;

    private JButton fraslMinusButton;
    private JButton sqrtButton;
    private JButton invButton;
    private JButton equalsButton;

    private JButton xButton;
    private JButton DELButton;
    private JButton CLRButton;
    private JButton leftBracketButton;
    private JButton rightBracketButton;

    private JButton decimalButton;
    private JButton Button0;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private JButton Button5;
    private JButton Button6;
    private JButton Button7;
    private JButton Button8;
    private JButton Button9;

    private JTextField ResultTextField;
    private JPanel mainPanel;

    private CalculationModule calcModule;

    public Test() {
        calcModule = new CalculationModule();
        $$$setupUI$$$();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getRootPane().setDefaultButton(equalsButton);
        setTitle("JavaCalc");
        setBackground(Color.GRAY.darker());
        //setUndecorated(true);
        //setShape(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));


        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                ResultTextField.requestFocusInWindow();
            }
        });

        pack();
        //setVisible(true);
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getRootPane().setDefaultButton(equalsButton);
        frame.pack();
        frame.setVisible(true);
    }*/

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //StandardCalcPanel = new javax.swing.JPanel();

        ResultTextField = new JTextField();


        sqrtButton = new TokenButton("sqrt");
        powButton = new TokenButton("^");
        invButton = new TokenButton("^-1");
        log10Button = new TokenButton("log10");
        lnButton = new TokenButton("ln");
        expButton = new TokenButton("e^");
        sinButton = new TokenButton("sin");
        arcsinButton = new TokenButton("arcsin");
        cosButton = new TokenButton("cos");
        arccosButton = new TokenButton("arccos");
        tanButton = new TokenButton("tan");
        arctanButton = new TokenButton("arctan");

        divButton = new TokenButton("/");
        multButton = new TokenButton("*");
        subButton = new TokenButton("-");
        addButton = new TokenButton("+");

        Button0 = new TokenButton("0");
        Button1 = new TokenButton("1");
        Button2 = new TokenButton("2");
        Button3 = new TokenButton("3");
        Button4 = new TokenButton("4");
        Button5 = new TokenButton("5");
        Button6 = new TokenButton("6");
        Button7 = new TokenButton("7");
        Button8 = new TokenButton("8");
        Button9 = new TokenButton("9");

        xButton = new TokenButton("x");
        leftBracketButton = new TokenButton("(");
        rightBracketButton = new TokenButton(")");
        decimalButton = new TokenButton(".");

        fraslMinusButton = new JButton();
        DELButton = new JButton();
        CLRButton = new JButton();
        equalsButton = new JButton();

        GraphPanel = new JPanel();


        /*setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaCalc");
        setResizable(false);*/

        //StandardCalcPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ResultTextField.setEditable(true);
        ResultTextField.setFocusable(true);
        //ResultTextField.setFocusTraversalKeysEnabled(false);
        //ResultTextField.setText(Integer.toString(0));
        ResultTextField.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        ResultTextField.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escPressed");

        class ClearAction extends AbstractAction {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ClearButtonActionPerformed(e);
                ResultTextField.setText("");
            }
        }

        ResultTextField.getActionMap().put("escPressed", new ClearAction());
        ResultTextField.setVisible(true);
        ResultTextField.setBorder(BorderFactory.createEmptyBorder());

        /*class ClearAction extends AbstractAction {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultTextField.setText("");
            }
        }*/

        class ButtonColourChanger extends MouseAdapter {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GRAY.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GRAY.darker());
            }
        }

        log10Button.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        log10Button.setText("Clear");
        log10Button.setFocusable(false);
        log10Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        log10Button.addMouseListener(new ButtonColourChanger());

        sinButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        sinButton.setText("Clear");
        sinButton.setFocusable(false);
        sinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        sinButton.addMouseListener(new ButtonColourChanger());

        cosButton.addMouseListener(new ButtonColourChanger());

        cosButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        cosButton.setText("Clear");
        cosButton.setFocusable(false);
        cosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        cosButton.addMouseListener(new ButtonColourChanger());

        tanButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        tanButton.setText("Clear");
        tanButton.setFocusable(false);
        tanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        tanButton.addMouseListener(new ButtonColourChanger());

        lnButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lnButton.setText("Clear");
        lnButton.setFocusable(false);
        lnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        lnButton.addMouseListener(new ButtonColourChanger());

        expButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        expButton.setText("Clear");
        expButton.setFocusable(false);
        expButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        expButton.addMouseListener(new ButtonColourChanger());

        arcsinButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        arcsinButton.setText("Clear");
        arcsinButton.setFocusable(false);
        arcsinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        arcsinButton.addMouseListener(new ButtonColourChanger());

        arccosButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        arccosButton.setText("Clear");
        arccosButton.setFocusable(false);
        arccosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        arccosButton.addMouseListener(new ButtonColourChanger());

        arctanButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        arctanButton.setText("Clear");
        arctanButton.setFocusable(false);
        arctanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });

        arctanButton.addMouseListener(new ButtonColourChanger());

        CLRButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        CLRButton.setText("Clear");
        CLRButton.setFocusable(false);
        CLRButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        CLRButton.addMouseListener(new ButtonColourChanger());


        sqrtButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        //SqrtButton.setText("<html>&radic");
        sqrtButton.setText("sqrt");
        sqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        sqrtButton.addMouseListener(new ButtonColourChanger());

        powButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        powButton.setText("<html>x<sup>2</sup>");
        powButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        powButton.addMouseListener(new ButtonColourChanger());

        invButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        invButton.setText("<html><sup>1</sup>&frasl;<sub>x</sub>");
        invButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        invButton.addMouseListener(new ButtonColourChanger());

        divButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        divButton.setText("<html>&divide");
        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        divButton.addMouseListener(new ButtonColourChanger());

        multButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        multButton.setText("<html>&times");
        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        multButton.addMouseListener(new ButtonColourChanger());

        subButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        subButton.setText("<html>&minus");
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        subButton.addMouseListener(new ButtonColourChanger());

        addButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("+");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        addButton.addMouseListener(new ButtonColourChanger());

        xButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        xButton.setText("x");
        xButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        xButton.addMouseListener(new ButtonColourChanger());

        leftBracketButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        leftBracketButton.setText("(");
        leftBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        leftBracketButton.addMouseListener(new ButtonColourChanger());

        rightBracketButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        rightBracketButton.setText(")");
        rightBracketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        rightBracketButton.addMouseListener(new ButtonColourChanger());

        decimalButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        decimalButton.setText(".");
        decimalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        decimalButton.addMouseListener(new ButtonColourChanger());

        Button9.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button9.setText("9");
        Button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button9.addMouseListener(new ButtonColourChanger());

        Button6.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button6.setText("6");
        Button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button6.addMouseListener(new ButtonColourChanger());

        Button3.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button3.setText("3");
        Button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button3.addMouseListener(new ButtonColourChanger());

        Button0.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button0.setText("0");
        Button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button0.addMouseListener(new ButtonColourChanger());

        Button2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button2.setText("2");
        Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button2.addMouseListener(new ButtonColourChanger());

        Button5.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button5.setText("5");
        Button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button5.addMouseListener(new ButtonColourChanger());

        Button8.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button8.setText("8");
        Button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button8.addMouseListener(new ButtonColourChanger());

        Button7.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button7.setText("7");
        Button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button7.addMouseListener(new ButtonColourChanger());

        Button4.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button4.setText("4");
        Button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button4.addMouseListener(new ButtonColourChanger());

        Button1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        Button1.setText("1");
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TokenButtonActionPerformed(evt);
            }
        });
        Button1.addMouseListener(new ButtonColourChanger());

        fraslMinusButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        fraslMinusButton.setText("<html><sup>+</sup>&frasl;<sub>&minus;</sub>");
        fraslMinusButton.setFocusable(false);
        fraslMinusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NegateButtonActionPerformed(evt);
            }
        });
        fraslMinusButton.addMouseListener(new ButtonColourChanger());

        DELButton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        DELButton.setText("Delete");
        DELButton.setFocusable(false);
        DELButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        DELButton.addMouseListener(new ButtonColourChanger());

        equalsButton.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        equalsButton.setText("=");
        equalsButton.setFocusable(false);
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EqualsButtonActionPerformed(evt);
            }
        });
        equalsButton.addMouseListener(new ButtonColourChanger());


        //pack();
    }

    private void TokenButtonActionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String text = ((TokenButton) source).getTokenText();
        //ResultTextField.setText(ResultTextField.getText().concat(text));
        int i = ResultTextField.getCaretPosition();
        ResultTextField.setText(ResultTextField.getText().substring(0, i) + text + ResultTextField.getText().substring(i, ResultTextField.getText().length()));
        ResultTextField.setCaretPosition(i + text.length());
    }

    private void ClearButtonActionPerformed(ActionEvent evt) {

        ResultTextField.setText("");
    }

    private void DeleteButtonActionPerformed(ActionEvent evt) {
        String currentText = ResultTextField.getText();
        StringBuilder sb = new StringBuilder(currentText);
        if (currentText.length() == 0) {
            ResultTextField.setText("");
        } else if (!currentText.matches("0")) {
            sb.deleteCharAt(sb.length() - 1);
            ResultTextField.setText(sb.toString());
        }
    }

    private void NegateButtonActionPerformed(ActionEvent evt) {
        String currentText = ResultTextField.getText();
        StringBuilder sb = new StringBuilder(currentText);
        if (currentText.startsWith("-")) {
            sb.deleteCharAt(0);
            ResultTextField.setText(sb.toString());
        } else {
            sb.insert(0, "-");
            ResultTextField.setText(sb.toString());
        }
    }

    private void EqualsButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_EqualsButtonActionPerformed

        ArrayList<DataPoint2D> data = calcModule.evaluateExpression(ResultTextField.getText());
        /*series = new XYSeries("series");
        for(DataPoint2D pt : data){
            series.add(pt.getX(), pt.getY());
        }
        dataset.removeAllSeries();
        dataset.addSeries(series);

        chart.getXYPlot().getRenderer().setSeriesVisibleInLegend(0, false);
        cp.repaint();*/

        if (!ResultTextField.getText().contains(Character.toString('x'))) {
            ResultTextField.setText(Double.toString(data.get(0).getY()));
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setAutoscrolls(false);
        mainPanel.setDoubleBuffered(true);
        mainPanel.setEnabled(false);
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        numberPanel = new JPanel();
        numberPanel.setLayout(new GridBagLayout());
        numberPanel.setOpaque(false);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(numberPanel, gbc);
        Button7.setAutoscrolls(false);
        Button7.setBackground(new Color(-10921639));
        Button7.setBorderPainted(false);
        Button7.setContentAreaFilled(true);
        Button7.setFocusPainted(true);
        Button7.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button7.setForeground(new Color(-1));
        Button7.setMaximumSize(new Dimension(50, 50));
        Button7.setMinimumSize(new Dimension(50, 50));
        Button7.setPreferredSize(new Dimension(50, 50));
        Button7.setSelected(false);
        Button7.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button7, gbc);
        Button8.setBackground(new Color(-10921639));
        Button8.setBorderPainted(false);
        Button8.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button8.setForeground(new Color(-1));
        Button8.setMaximumSize(new Dimension(50, 50));
        Button8.setMinimumSize(new Dimension(50, 50));
        Button8.setPreferredSize(new Dimension(50, 50));
        Button8.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button8, gbc);
        Button9.setBackground(new Color(-10921639));
        Button9.setBorderPainted(false);
        Button9.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button9.setForeground(new Color(-1));
        Button9.setMaximumSize(new Dimension(50, 50));
        Button9.setMinimumSize(new Dimension(50, 50));
        Button9.setPreferredSize(new Dimension(50, 50));
        Button9.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button9, gbc);
        Button4.setBackground(new Color(-10921639));
        Button4.setBorderPainted(false);
        Button4.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button4.setForeground(new Color(-1));
        Button4.setMaximumSize(new Dimension(50, 50));
        Button4.setMinimumSize(new Dimension(50, 50));
        Button4.setPreferredSize(new Dimension(50, 50));
        Button4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button4, gbc);
        Button5.setBackground(new Color(-10921639));
        Button5.setBorderPainted(false);
        Button5.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button5.setForeground(new Color(-1));
        Button5.setMaximumSize(new Dimension(50, 50));
        Button5.setMinimumSize(new Dimension(50, 50));
        Button5.setPreferredSize(new Dimension(50, 50));
        Button5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button5, gbc);
        Button1.setBackground(new Color(-10921639));
        Button1.setBorderPainted(false);
        Button1.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button1.setForeground(new Color(-1));
        Button1.setMaximumSize(new Dimension(50, 50));
        Button1.setMinimumSize(new Dimension(50, 50));
        Button1.setPreferredSize(new Dimension(50, 50));
        Button1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button1, gbc);
        Button2.setBackground(new Color(-10921639));
        Button2.setBorderPainted(false);
        Button2.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button2.setForeground(new Color(-1));
        Button2.setMaximumSize(new Dimension(50, 50));
        Button2.setMinimumSize(new Dimension(50, 50));
        Button2.setPreferredSize(new Dimension(50, 50));
        Button2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button2, gbc);
        Button3.setBackground(new Color(-10921639));
        Button3.setBorderPainted(false);
        Button3.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button3.setForeground(new Color(-1));
        Button3.setMaximumSize(new Dimension(50, 50));
        Button3.setMinimumSize(new Dimension(50, 50));
        Button3.setPreferredSize(new Dimension(50, 50));
        Button3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button3, gbc);
        Button0.setBackground(new Color(-10921639));
        Button0.setBorderPainted(false);
        Button0.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button0.setForeground(new Color(-1));
        Button0.setMaximumSize(new Dimension(100, 50));
        Button0.setMinimumSize(new Dimension(100, 50));
        Button0.setPreferredSize(new Dimension(100, 50));
        Button0.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button0, gbc);
        decimalButton.setBackground(new Color(-10921639));
        decimalButton.setBorderPainted(false);
        decimalButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        decimalButton.setForeground(new Color(-1));
        decimalButton.setMaximumSize(new Dimension(50, 50));
        decimalButton.setMinimumSize(new Dimension(50, 50));
        decimalButton.setPreferredSize(new Dimension(50, 50));
        decimalButton.setText(".");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(decimalButton, gbc);
        rightBracketButton.setBackground(new Color(-10921639));
        rightBracketButton.setBorderPainted(false);
        rightBracketButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        rightBracketButton.setForeground(new Color(-1));
        rightBracketButton.setMaximumSize(new Dimension(50, 50));
        rightBracketButton.setMinimumSize(new Dimension(50, 50));
        rightBracketButton.setPreferredSize(new Dimension(50, 50));
        rightBracketButton.setText(")");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(rightBracketButton, gbc);
        leftBracketButton.setBackground(new Color(-10921639));
        leftBracketButton.setBorderPainted(false);
        leftBracketButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        leftBracketButton.setForeground(new Color(-1));
        leftBracketButton.setMaximumSize(new Dimension(50, 50));
        leftBracketButton.setMinimumSize(new Dimension(50, 50));
        leftBracketButton.setPreferredSize(new Dimension(50, 50));
        leftBracketButton.setText("(");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(leftBracketButton, gbc);
        xButton.setBackground(new Color(-10921639));
        xButton.setBorderPainted(false);
        xButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        xButton.setForeground(new Color(-1));
        xButton.setMaximumSize(new Dimension(50, 50));
        xButton.setMinimumSize(new Dimension(50, 50));
        xButton.setPreferredSize(new Dimension(50, 50));
        xButton.setText("x");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(xButton, gbc);
        Button6.setBackground(new Color(-10921639));
        Button6.setBorderPainted(false);
        Button6.setFont(new Font("Lao UI", Font.PLAIN, 18));
        Button6.setForeground(new Color(-1));
        Button6.setMaximumSize(new Dimension(50, 50));
        Button6.setMinimumSize(new Dimension(50, 50));
        Button6.setPreferredSize(new Dimension(50, 50));
        Button6.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        numberPanel.add(Button6, gbc);
        modifierPanel = new JPanel();
        modifierPanel.setLayout(new GridBagLayout());
        modifierPanel.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(modifierPanel, gbc);
        fraslMinusButton.setBackground(new Color(-10921639));
        fraslMinusButton.setBorderPainted(false);
        fraslMinusButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        fraslMinusButton.setForeground(new Color(-1));
        fraslMinusButton.setMaximumSize(new Dimension(100, 50));
        fraslMinusButton.setMinimumSize(new Dimension(100, 50));
        fraslMinusButton.setPreferredSize(new Dimension(100, 50));
        fraslMinusButton.setText("±");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        modifierPanel.add(fraslMinusButton, gbc);
        sqrtButton.setBackground(new Color(-10921639));
        sqrtButton.setBorderPainted(false);
        sqrtButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        sqrtButton.setForeground(new Color(-1));
        sqrtButton.setMaximumSize(new Dimension(100, 50));
        sqrtButton.setMinimumSize(new Dimension(100, 50));
        sqrtButton.setPreferredSize(new Dimension(100, 50));
        sqrtButton.setText("√");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        modifierPanel.add(sqrtButton, gbc);
        invButton.setBackground(new Color(-10921639));
        invButton.setBorderPainted(false);
        invButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        invButton.setForeground(new Color(-1));
        invButton.setMaximumSize(new Dimension(100, 50));
        invButton.setMinimumSize(new Dimension(100, 50));
        invButton.setPreferredSize(new Dimension(100, 50));
        invButton.setText("1/x");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        modifierPanel.add(invButton, gbc);
        equalsButton.setBackground(new Color(-10921639));
        equalsButton.setBorderPainted(false);
        equalsButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        equalsButton.setForeground(new Color(-1));
        equalsButton.setMaximumSize(new Dimension(100, 50));
        equalsButton.setMinimumSize(new Dimension(100, 50));
        equalsButton.setPreferredSize(new Dimension(100, 50));
        equalsButton.setText("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        modifierPanel.add(equalsButton, gbc);
        CLRButton.setBackground(new Color(-10921639));
        CLRButton.setBorderPainted(false);
        CLRButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        CLRButton.setForeground(new Color(-1));
        CLRButton.setMaximumSize(new Dimension(100, 50));
        CLRButton.setMinimumSize(new Dimension(100, 50));
        CLRButton.setPreferredSize(new Dimension(100, 50));
        CLRButton.setText("CLR");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        modifierPanel.add(CLRButton, gbc);
        functionPanel = new JPanel();
        functionPanel.setLayout(new GridBagLayout());
        functionPanel.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(functionPanel, gbc);
        log10Button.setBackground(new Color(-10921639));
        log10Button.setBorderPainted(false);
        log10Button.setFont(new Font("Lao UI", Font.PLAIN, 18));
        log10Button.setForeground(new Color(-1));
        log10Button.setMaximumSize(new Dimension(100, 50));
        log10Button.setMinimumSize(new Dimension(100, 50));
        log10Button.setPreferredSize(new Dimension(100, 50));
        log10Button.setText("log10");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(log10Button, gbc);
        sinButton.setBackground(new Color(-10921639));
        sinButton.setBorderPainted(false);
        sinButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        sinButton.setForeground(new Color(-1));
        sinButton.setMaximumSize(new Dimension(100, 50));
        sinButton.setMinimumSize(new Dimension(100, 50));
        sinButton.setPreferredSize(new Dimension(100, 50));
        sinButton.setText("sin");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(sinButton, gbc);
        cosButton.setBackground(new Color(-10921639));
        cosButton.setBorderPainted(false);
        cosButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        cosButton.setForeground(new Color(-1));
        cosButton.setMaximumSize(new Dimension(100, 50));
        cosButton.setMinimumSize(new Dimension(100, 50));
        cosButton.setPreferredSize(new Dimension(100, 50));
        cosButton.setText("cos");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(cosButton, gbc);
        tanButton.setBackground(new Color(-10921639));
        tanButton.setBorderPainted(false);
        tanButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        tanButton.setForeground(new Color(-1));
        tanButton.setMaximumSize(new Dimension(100, 50));
        tanButton.setMinimumSize(new Dimension(100, 50));
        tanButton.setPreferredSize(new Dimension(100, 50));
        tanButton.setText("tan");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(tanButton, gbc);
        arctanButton.setBackground(new Color(-10921639));
        arctanButton.setBorderPainted(false);
        arctanButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        arctanButton.setForeground(new Color(-1));
        arctanButton.setMaximumSize(new Dimension(100, 50));
        arctanButton.setMinimumSize(new Dimension(100, 50));
        arctanButton.setPreferredSize(new Dimension(100, 50));
        arctanButton.setText("arctan");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(arctanButton, gbc);
        arccosButton.setBackground(new Color(-10921639));
        arccosButton.setBorderPainted(false);
        arccosButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        arccosButton.setForeground(new Color(-1));
        arccosButton.setMaximumSize(new Dimension(100, 50));
        arccosButton.setMinimumSize(new Dimension(100, 50));
        arccosButton.setPreferredSize(new Dimension(100, 50));
        arccosButton.setText("arccos");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(arccosButton, gbc);
        lnButton.setBackground(new Color(-10921639));
        lnButton.setBorderPainted(false);
        lnButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        lnButton.setForeground(new Color(-1));
        lnButton.setMaximumSize(new Dimension(100, 50));
        lnButton.setMinimumSize(new Dimension(100, 50));
        lnButton.setPreferredSize(new Dimension(100, 50));
        lnButton.setText("ln");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(lnButton, gbc);
        arcsinButton.setBackground(new Color(-10921639));
        arcsinButton.setBorderPainted(false);
        arcsinButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        arcsinButton.setForeground(new Color(-1));
        arcsinButton.setMaximumSize(new Dimension(100, 50));
        arcsinButton.setMinimumSize(new Dimension(100, 50));
        arcsinButton.setPreferredSize(new Dimension(100, 50));
        arcsinButton.setText("arcsin");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(arcsinButton, gbc);
        expButton.setBackground(new Color(-10921639));
        expButton.setBorderPainted(false);
        expButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        expButton.setForeground(new Color(-1));
        expButton.setMaximumSize(new Dimension(100, 50));
        expButton.setMinimumSize(new Dimension(100, 50));
        expButton.setPreferredSize(new Dimension(100, 50));
        expButton.setText("e^x");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(expButton, gbc);
        powButton.setBackground(new Color(-10921639));
        powButton.setBorderPainted(false);
        powButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        powButton.setForeground(new Color(-1));
        powButton.setMaximumSize(new Dimension(100, 50));
        powButton.setMinimumSize(new Dimension(100, 50));
        powButton.setPreferredSize(new Dimension(100, 50));
        powButton.setText("x^y");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        functionPanel.add(powButton, gbc);
        operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridBagLayout());
        operatorPanel.setOpaque(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(operatorPanel, gbc);
        addButton.setBackground(new Color(-10921639));
        addButton.setBorderPainted(false);
        addButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        addButton.setForeground(new Color(-1));
        addButton.setMaximumSize(new Dimension(100, 50));
        addButton.setMinimumSize(new Dimension(100, 50));
        addButton.setPreferredSize(new Dimension(100, 50));
        addButton.setText("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        operatorPanel.add(addButton, gbc);
        subButton.setBackground(new Color(-10921639));
        subButton.setBorderPainted(false);
        subButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        subButton.setForeground(new Color(-1));
        subButton.setMaximumSize(new Dimension(100, 50));
        subButton.setMinimumSize(new Dimension(100, 50));
        subButton.setPreferredSize(new Dimension(100, 50));
        subButton.setText("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        operatorPanel.add(subButton, gbc);
        multButton.setBackground(new Color(-10921639));
        multButton.setBorderPainted(false);
        multButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        multButton.setForeground(new Color(-1));
        multButton.setMaximumSize(new Dimension(100, 50));
        multButton.setMinimumSize(new Dimension(100, 50));
        multButton.setPreferredSize(new Dimension(100, 50));
        multButton.setText("*");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        operatorPanel.add(multButton, gbc);
        divButton.setBackground(new Color(-10921639));
        divButton.setBorderPainted(false);
        divButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        divButton.setForeground(new Color(-1));
        divButton.setMaximumSize(new Dimension(100, 50));
        divButton.setMinimumSize(new Dimension(100, 50));
        divButton.setPreferredSize(new Dimension(100, 50));
        divButton.setText("/");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        operatorPanel.add(divButton, gbc);
        DELButton.setBackground(new Color(-10921639));
        DELButton.setBorderPainted(false);
        DELButton.setFont(new Font("Lao UI", Font.PLAIN, 18));
        DELButton.setForeground(new Color(-1));
        DELButton.setMaximumSize(new Dimension(100, 50));
        DELButton.setMinimumSize(new Dimension(100, 50));
        DELButton.setPreferredSize(new Dimension(100, 50));
        DELButton.setText("DEL");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        operatorPanel.add(DELButton, gbc);
        ResultTextField.setBackground(new Color(-16777216));
        ResultTextField.setFocusable(true);
        ResultTextField.setFont(new Font("Lao UI", Font.PLAIN, 36));
        ResultTextField.setForeground(new Color(-1));
        ResultTextField.setHorizontalAlignment(4);
        ResultTextField.setMaximumSize(new Dimension(50, 100));
        ResultTextField.setMinimumSize(new Dimension(50, 100));
        ResultTextField.setPreferredSize(new Dimension(50, 100));
        ResultTextField.setSelectedTextColor(new Color(-1));
        ResultTextField.setSelectionColor(new Color(-4473925));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(ResultTextField, gbc);
        GraphPanel.setPreferredSize(new Dimension(500, 400));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(GraphPanel, gbc);
        GraphPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /*public static void main(String args[]) {
        /* Create and display the form
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }*/

}
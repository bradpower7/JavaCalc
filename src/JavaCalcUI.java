/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Jraph.DataPoint2D;
import org.jfree.chart.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
     @Over    @Ov    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
erride
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
ride
    p    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
ublic void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*
 * @author Dylan
 */
public class JavaCalcUI extends javax.swing.JFrame {


    private String graphExpression;
    private boolean lastNum = false;

    private CalculationModule calcModule;

    /**
     * Creates new form JavaCalcUI
     */
    public JavaCalcUI() {
        result = 0;
        op1 = 0;
        op2 = 0;
        ans = 0;
        initComponents();

        calcModule = new CalculationModule();
        graphExpression = new String();



        dataset = new XYSeriesCollection();

        chart = ChartFactory.createXYLineChart(null,null,null,dataset);
        cp = new ChartPanel(chart);
        GraphPanel.add(cp, java.awt.BorderLayout.CENTER);
        GraphPanel.validate();
        //GraphPanel.add(plotPanel, java.awt.BorderLayout.CENTER);
        //GraphPanel.validate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StandardCalcPanel = new javax.swing.JPanel();
        ResultTextField = new javax.swing.JTextField();
        ClearButton = new javax.swing.JButton();
        SqrtButton = new javax.swing.JButton();
        SquaredButton = new javax.swing.JButton();
        InverseButton = new javax.swing.JButton();
        DivideButton = new javax.swing.JButton();
        MultiplyButton = new javax.swing.JButton();
        SubtractButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        EqualsButton = new javax.swing.JButton();
        Button9 = new javax.swing.JButton();
        Button6 = new javax.swing.JButton();
        Button3 = new javax.swing.JButton();
        DecimalButton = new javax.swing.JButton();
        Button0 = new javax.swing.JButton();
        Button2 = new javax.swing.JButton();
        Button5 = new javax.swing.JButton();
        Button8 = new javax.swing.JButton();
        Button7 = new javax.swing.JButton();
        Button4 = new javax.swing.JButton();
        Button1 = new javax.swing.JButton();
        NegateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        GraphPanel = new javax.swing.JPanel();
        XButton = new javax.swing.JButton();
        LeftBracketButton = new JButton();
        RightBracketButton = new JButton();
        //GraphTextField = new javax.swing.JTextField();
        //GraphButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaCalc");
        setResizable(false);

        StandardCalcPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        ResultTextField.setEditable(false);
        ResultTextField.setText(Integer.toString(0));
        ResultTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ClearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        SqrtButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SqrtButton.setText("<html>&radic");
        SqrtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        SquaredButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SquaredButton.setText("<html>x<sup>2</sup>");
        SquaredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        InverseButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        InverseButton.setText("<html><sup>1</sup>&frasl;<sub>x</sub>");
        InverseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        DivideButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DivideButton.setText("<html>&divide");
        DivideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        MultiplyButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MultiplyButton.setText("<html>&times");
        MultiplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        SubtractButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SubtractButton.setText("<html>&minus");
        SubtractButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AddButton.setText("+");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButtonActionPerformed(evt);
            }
        });

        EqualsButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EqualsButton.setText("=");
        EqualsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualsButtonActionPerformed(evt);
            }
        });

        XButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        XButton.setText("x");
        XButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XButtonActionPerformed(evt);
            }
        });

        LeftBracketButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LeftBracketButton.setText("(");
        LeftBracketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BracketButtonActionPerformed(evt);
            }
        });

        RightBracketButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RightBracketButton.setText(")");
        RightBracketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BracketButtonActionPerformed(evt);
            }
        });

        Button9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button9.setText("9");
        Button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button6.setText("6");
        Button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button3.setText("3");
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        DecimalButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DecimalButton.setText(".");
        DecimalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecimalButtonActionPerformed(evt);
            }
        });

        Button0.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button0.setText("0");
        Button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button2.setText("2");
        Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button5.setText("5");
        Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button8.setText("8");
        Button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button7.setText("7");
        Button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button4.setText("4");
        Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        Button1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Button1.setText("1");
        Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberActionPerformed(evt);
            }
        });

        NegateButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NegateButton.setText("<html><sup>+</sup>&frasl;<sub>&minus;</sub>");
        NegateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StandardCalcPanelLayout = new javax.swing.GroupLayout(StandardCalcPanel);
        StandardCalcPanel.setLayout(StandardCalcPanelLayout);
        StandardCalcPanelLayout.setHorizontalGroup(
            StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StandardCalcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResultTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                    .addComponent(XButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LeftBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(RightBracketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                .addComponent(SqrtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SquaredButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InverseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DivideButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                .addComponent(Button1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AddButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                .addComponent(NegateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DecimalButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EqualsButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                .addComponent(Button7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MultiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StandardCalcPanelLayout.createSequentialGroup()
                                .addComponent(Button4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        StandardCalcPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddButton, Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, DecimalButton, DivideButton, EqualsButton, InverseButton, MultiplyButton, NegateButton, SqrtButton, SquaredButton, SubtractButton});

        StandardCalcPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ClearButton, DeleteButton, XButton, LeftBracketButton, RightBracketButton});

        StandardCalcPanelLayout.setVerticalGroup(
            StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StandardCalcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ResultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(XButton)
                        .addComponent(LeftBracketButton)
                        .addComponent(RightBracketButton)
                    .addComponent(DeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(SqrtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SquaredButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InverseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DivideButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MultiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button9)
                        .addComponent(Button8)
                        .addComponent(Button7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button6)
                        .addComponent(Button5)
                        .addComponent(Button4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton)
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Button3)
                        .addComponent(Button2)
                        .addComponent(Button1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EqualsButton)
                    .addGroup(StandardCalcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DecimalButton)
                        .addComponent(Button0)
                        .addComponent(NegateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StandardCalcPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddButton, Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, DecimalButton, DivideButton, EqualsButton, InverseButton, MultiplyButton, NegateButton, SqrtButton, SquaredButton, SubtractButton});

        StandardCalcPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClearButton, DeleteButton, XButton, LeftBracketButton, RightBracketButton});

        GraphPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        GraphPanel.setLayout(new java.awt.BorderLayout());

        /*GraphTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        GraphButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GraphButton.setText("Plot!");
        GraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphActionPerformed(e);
            }
        });*/

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(StandardCalcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 612, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GraphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StandardCalcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

        )));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BracketButtonActionPerformed(ActionEvent evt){
        Object source = evt.getSource();
        if(source == LeftBracketButton){
            ResultTextField.setText(ResultTextField.getText().concat("("));
            graphExpression += " ( ";
        }
        else{
            ResultTextField.setText(ResultTextField.getText().concat(")"));
            graphExpression += " ) ";
        }
    }
    private void XButtonActionPerformed(java.awt.event.ActionEvent evt){
        if(ResultTextField.getText().matches("0")){
            ResultTextField.setText("x");
            graphExpression += " x ";
        }
        else {
            ResultTextField.setText(ResultTextField.getText().concat("x"));
            graphExpression += " x ";
        }
    }
    private void OperatorButtonActionPerformed(java.awt.event.ActionEvent evt){
        Object source = evt.getSource();

        String opText ="";
        String expText = "";
        if(ResultTextField.getText().matches("^0$")){
            ResultTextField.setText("");
        }
        if(source instanceof JButton){
            if(source == SqrtButton) {
                opText = "sqrt(";
                expText = "sqrt ( ";
            }
            else if(source == SquaredButton) {
                opText ="^2";
                expText = " ^ 2";
            }
            else if(source == InverseButton){
                opText = "^-1";
                expText = " ^ -1";

            }
            else if(source == MultiplyButton){
                opText = "*";
                expText = " * ";
            }
            else if(source == DivideButton){
                opText = "/";
                expText = " / ";
            }
            else if(source == AddButton){
                opText = "+";
                expText = " + ";
            }
            else if(source == SubtractButton){
                opText = "-";
                expText = " - ";
            }
            else{
                opText = "";
                expText = "";
            }
        }

        graphExpression += (expText);
        ResultTextField.setText(ResultTextField.getText().concat(opText));
    }

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {
        Object source = evt.getSource();
        String currentText = ResultTextField.getText();
        StringBuilder sb = new StringBuilder(currentText);

        if(source == ClearButton) {
            ResultTextField.setText("0");
            graphExpression = "";
            result = 0;
            op1 = 0;
            op2 = 0;
            ans = 0;
        }
        else if(source == DeleteButton) {
            if(currentText.matches("0")) {/*Do nothing*/}
            else if(currentText.length() == 1) {
                ResultTextField.setText("0");
                graphExpression = "";
            }
            else {
                sb.deleteCharAt(sb.length() - 1);
                ResultTextField.setText(sb.toString());

            }
        }
        else { //NegateButton
            if(currentText.matches("0")) {/*Do nothing*/}
            else if(!currentText.contains("-")) {
                sb.insert(0, "-");
                graphExpression.trim();
                graphExpression = "-1 * " + graphExpression;
                ResultTextField.setText(sb.toString());
            }
            else { // currentText.contains("-")
                sb.deleteCharAt(0);
                graphExpression = "-1 * " + graphExpression;
                ResultTextField.setText(sb.toString());
            }
        }
    }

    private void DecimalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecimalButtonActionPerformed
        String currentText = ResultTextField.getText();
        /*if(currentText.contains(".")) {/*Do nothing}*/
        /*else if(currentText.)
        else*/
            ResultTextField.setText(ResultTextField.getText().concat("."));
            graphExpression+=".";
    }//GEN-LAST:event_DecimalButtonActionPerformed

    private void EqualsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqualsButtonActionPerformed

        ArrayList<DataPoint2D> data = calcModule.evaluateExpression(ResultTextField.getText());
        series = new XYSeries("series");
        for(DataPoint2D pt : data){
            series.add(pt.getX(), pt.getY());
        }
        dataset.removeAllSeries();
        dataset.addSeries(series);

        chart.getXYPlot().getRenderer().setSeriesVisibleInLegend(0, false);
        cp.repaint();

        if(!graphExpression.contains(Character.toString('x'))) {
            ResultTextField.setText(Double.toString(data.get(0).getY()));
        }
    }//GEN-LAST:event_EqualsButtonActionPerformed

    private void NumberActionPerformed(java.awt.event.ActionEvent evt) {
        Object source = evt.getSource();
        String currentText = ResultTextField.getText();
        String num;
        // Check the source of the ActionEvent
        if(source == Button0)
            num = "0";
        else if(source == Button1)
            num = "1";
        else if(source == Button2)
            num = "2";
        else if(source == Button3)
            num = "3";
        else if(source == Button4)
            num = "4";
        else if(source == Button5)
            num = "5";
        else if(source == Button6)
            num = "6";
        else if(source == Button7)
            num = "7";
        else if(source == Button8)
            num = "8";
        else // Button 9
            num = "9";

        // Manipulate ResultTextField accordingly
        if(currentText.matches("0")) {
            if(num.matches("0")) {/*Do nothing*/}
            else {
                ResultTextField.setText(num);
                graphExpression += num;
                lastNum = true;
            }
        }
        else {
            ResultTextField.setText(currentText.concat(num));
            graphExpression += num;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaCalcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaCalcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaCalcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaCalcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaCalcUI().setVisible(true);
            }
        });
    }

    private double result, op1, op2, ans;
    private Operator operator;
    //private GraphTypeModel graphTypeModel = new GraphTypeModel();
    private XYSeries series;
    private XYSeriesCollection dataset;
    private JFreeChart chart;
    private ChartPanel cp;
    //private GraphingData data = new GraphingData();
    //private PlotPanel plotPanel = new PlotPanel();
    private StringBuilder graphString = new StringBuilder("");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Button0;
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JButton Button4;
    private javax.swing.JButton Button5;
    private javax.swing.JButton Button6;
    private javax.swing.JButton Button7;
    private javax.swing.JButton Button8;
    private javax.swing.JButton Button9;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DecimalButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DivideButton;
    private javax.swing.JButton EqualsButton;
    //private javax.swing.JButton GraphButton;
    private javax.swing.JPanel GraphPanel;
    //private javax.swing.JTextField GraphTextField;
    private javax.swing.JButton XButton;
    private javax.swing.JButton LeftBracketButton;
    private javax.swing.JButton RightBracketButton;
    private javax.swing.JButton InverseButton;
    private javax.swing.JButton MultiplyButton;
    private javax.swing.JButton NegateButton;
    private javax.swing.JTextField ResultTextField;
    private javax.swing.JButton SqrtButton;
    private javax.swing.JButton SquaredButton;
    private javax.swing.JPanel StandardCalcPanel;
    private javax.swing.JButton SubtractButton;
    // End of variables declaration//GEN-END:variables
}

enum Operator {
    Multiply, Divide, Add, Subtract, Sqrt, Inverse, Square
}

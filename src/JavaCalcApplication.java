import Jraph.DataPoint2D;
import Jraph.Graph2D;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */
public class JavaCalcApplication extends MouseAdapter{

    CalculationModule calc = new CalculationModule();

    ArrayList<DataPoint2D> data = calc.evaluateExpression("2 ^ x");

    GraphModule graphModule = new GraphModule();
    JFrame frame = new JFrame("Test");

    GridModel model;
    GridPanel gridPanel;

    public JavaCalcApplication(){
        // Initialize frame and add the paintPanel in the center
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new GridModel(new Graph2D(data));
        gridPanel = new GridPanel(400, 400, model);

        frame.add(gridPanel);

        gridPanel.addMouseListener(this);

        frame.pack();
        frame.setResizable(false); // Must not be resizable because we aren't
        frame.setVisible(true);	   // handling changes in size.

    }

    public void mousePressed(MouseEvent e){
        model.graph();
        gridPanel.repaint();
    }

    public static void main(String [] args){
        //graphModule.getGraph(data);

        /*for(DataPoint2D pt : data){
            System.out.println("(" + pt.getX() + ", " + pt.getY() + ")");

        }*/

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JavaCalcApplication();
            }
        });
    }
}

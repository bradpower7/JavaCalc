import Jraph.DataPoint2D;

import eval.*;

import java.util.ArrayList;

/**
 * Created by Brad Power on 3/7/17 for JavaCalc.
 */
public class CalculationModule {

    private int _pointsPerUnit;     // # of input values evaluated per 1.0 division of graph
    private Double _max;            // max value calculated
    private Double _min;            // min value calculated
    private Double _increment;

    public CalculationModule(){
        _pointsPerUnit = 10;
        _max = 50.0;
        _min = -50.0;

        _increment = 1.0/_pointsPerUnit;
    }

    public ArrayList<DataPoint2D> evaluateExpression(String ex){
        ExpressionEvaluator evaluator = new ExpressionEvaluator(ex);
        ArrayList<DataPoint2D> data = new ArrayList<>();


        for(Double val = _min; val < _max; val+=_increment){
            DataPoint2D dataPoint = new DataPoint2D(val, evaluator.evaluate(val));
            data.add(dataPoint);        // evaluates at input, adds to data
        }

        // calculate min/max

        return data;
    }

    public Double evaluate(String ex){
        ExpressionEvaluator evaluator = new ExpressionEvaluator(ex);
        return evaluator.evaluate();
    }
}

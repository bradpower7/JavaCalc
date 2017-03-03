package Jraph;

import java.util.ArrayList;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */
public abstract class Graph2D {
    private ArrayList<DataPoint2D> _data;
    private GraphColour _colour;
    private int _xAxisRes;
    private int _yAxisRes;

    public Graph2D(ArrayList<DataPoint2D> data, GraphSettings settings){
        _data = data;
        _colour = settings.getColour();
        _xAxisRes = settings.getXAxisRes();
        _yAxisRes = settings.getYAxisRes();
    }

    public GraphColour getColour(){
        return _colour;
    }
    public void setColour(GraphColour colour){
        _colour = colour;
    }
    public int getXAxisRes(){
        return _xAxisRes;
    }
    public void setXAxisRes(int xAxisRes){
        _xAxisRes = xAxisRes;
    }
    public int getYAxisRes(){
        return _yAxisRes;
    }
    public void setYAxisRes(int yAxisRes){
        _yAxisRes = yAxisRes;
    }
    public ArrayList<DataPoint2D> getData(){
        return _data;
    }
}

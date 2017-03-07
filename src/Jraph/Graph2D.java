package Jraph;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */
public class Graph2D {

    private ArrayList<DataPoint2D> _data;
    private Color _colour;

    public Graph2D(ArrayList<DataPoint2D> data){
        _data = data;
        _colour = Color.RED;        // default, will add capability to change later
    }

    public ArrayList<DataPoint2D> getData(){ return _data; }
    public ArrayList<Double> getXValues(){
        ArrayList<Double> xVals = new ArrayList<>();
        for(DataPoint2D pt : _data){
            xVals.add(pt.getX());
        }
        return xVals;
    }
    public ArrayList<Double> getYValues(){
        ArrayList<Double> yVals = new ArrayList<>();
        for(DataPoint2D pt : _data){
            yVals.add(pt.getY());
        }
        return yVals;
    }

}

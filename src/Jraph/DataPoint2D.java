package Jraph;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */

// note: class now immutable, changed from Initial Design Document
final public class DataPoint2D {
    private Double _xVal;
    private Double _yVal;

    public DataPoint2D(Double xVal, Double yVal){
        _xVal = xVal;
        _yVal = yVal;
    }

    public Double getX(){
        return _xVal;
    }
    public Double getY(){
        return _yVal;
    }
}

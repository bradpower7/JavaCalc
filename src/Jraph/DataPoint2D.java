package Jraph;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */

// note: class now immutable, changed from Initial Design Document
final public class DataPoint2D {
    private float _xVal;
    private float _yVal;

    public DataPoint2D(float xVal, float yVal){
        _xVal = xVal;
        _yVal = yVal;
    }

    public float getX(){
        return _xVal;
    }
    public float getY(){
        return _yVal;
    }
}

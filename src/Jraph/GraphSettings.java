package Jraph;

/**
 * Created by Brad Power on 2/23/2017 for JavaCalc.
 */
final public class GraphSettings {
    private GraphColour _colour;
    private int _xAxisRes;
    private int _yAxisRes;

    /*private string _xAxisTitle;
    private string _yAxisTitle;

    private string _plotTitle;*/

    public GraphSettings(GraphColour colour, int xAxisRes, int yAxisRes){
        _colour = colour;
        _xAxisRes = xAxisRes;
        _yAxisRes = yAxisRes;
    }

    public GraphColour getColour(){
        return _colour;
    }

    public int getXAxisRes(){
        return _xAxisRes;
    }

    public int getYAxisRes(){
        return _yAxisRes;
    }
}

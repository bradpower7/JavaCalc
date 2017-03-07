import Jraph.DataPoint2D;
import Jraph.Graph2D;

import java.util.ArrayList;

/**
 * Created by Brad Power on 3/7/17 for JavaCalc.
 */
public class GraphModule {



    public GraphModule(){

    }


    public Graph2D getGraph(ArrayList<DataPoint2D> data){
        return new Graph2D(data);
    }
}

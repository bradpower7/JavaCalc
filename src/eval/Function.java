package eval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brad Power on 3/9/17 for JavaCalc.
 */
public class Function {

    protected String str;
    protected Evaluable func;
    protected int numOperands;

    public Function(String str, Evaluable function, int numOperands){
        this.str = str;
        func = function;
        this.numOperands = numOperands;
    }

    public String getName(){
        return str;
    }
    public Evaluable getFunc(){
        return func;
    }
    public int getNumOperands(){
        return numOperands;
    }
    public Double evaluate(List<Double> inputs){
        if(inputs.size() != numOperands){
            throw new Exception("Bruh wyd");
        }
        return func.eval(inputs);
    }
}

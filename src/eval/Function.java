package eval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brad Power on 3/9/17 for JavaCalc.
 */
public class Function extends TokenType{

    protected Evaluable func;
    protected int numOperands;

    public Function(String text, Evaluable function, int numOperands){
        super(text);
        func = function;
        this.numOperands = numOperands;
    }

    public Evaluable getFunc(){
        return func;
    }
    public int getNumOperands(){
        return numOperands;
    }
    public Double evaluate(List<Double> inputs){
        if(inputs.size() == numOperands){
            return func.eval(inputs);
        }
        return null;
    }
}

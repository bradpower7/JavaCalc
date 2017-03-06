package eval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class FunctionToken extends Token {

    private int _numOperands;

    protected Evaluable _funcMethod;      // this stores a method

    public FunctionToken(String token, Evaluable funcMethod, int numOperands){
        super(token);
        _funcMethod = funcMethod;
        _numOperands = numOperands;
    }
    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        stack.push(this);
    }

    @Override
    public void evaluateRpn(Stack<Double> evalStack) {
        if(evalStack.size() >= _numOperands){
            ArrayList<Double> operands = new ArrayList<>();
            for(int i=0; i<_numOperands; i++){
                operands.add(evalStack.pop());
            }
            evalStack.push(_funcMethod.eval(operands));     // wacky.
        }
    }
}

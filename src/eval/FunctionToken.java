package eval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class FunctionToken extends Token {

    private int numOperands;

    protected Evaluable funcMethod;      // this stores a method

    public FunctionToken(String token, Evaluable funcMethod, int numOperands){
        super(token);
        this.funcMethod = funcMethod;
        this.numOperands = numOperands;
    }
    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        stack.push(this);
    }

    @Override
    public void evaluateRpn(Stack<Double> evalStack) {
        if(evalStack.size() >= numOperands){
            ArrayList<Double> operands = new ArrayList<>();
            for(int i=0; i<numOperands; i++){
                operands.add(evalStack.pop());
            }
            evalStack.push(funcMethod.eval(operands));
        }
    }
}

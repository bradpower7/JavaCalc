package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class VariableToken extends Token {

    public VariableToken(String token){
        super(token);
    }
    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        output.add(this);
    }
    @Override
    public void evaluateRpn(Stack<Double> evalStack) {
            // intentionally left blank, lol
    }
}

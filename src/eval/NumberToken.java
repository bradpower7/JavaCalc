package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class NumberToken extends Token {
    public NumberToken(String token){
        super(token);
    }

    public void toPostfix(LinkedList<Token> output, Stack<Token> stack){
        output.add(this);
    }
    public void evaluateRpn(Stack<Double> evalStack){
        evalStack.push(Double.parseDouble(getToken()));
    }
}

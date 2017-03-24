package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class NumberToken extends Token {

    String numberText;

    public NumberToken(String token){
        super(token);
    }

    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack){
        output.add(this);
    }
    @Override
    public void evaluateRpn(Stack<Double> evalStack){
        evalStack.push(Double.parseDouble(getToken()));
    }

    @Override
    public boolean matches(String text){
        return text.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}

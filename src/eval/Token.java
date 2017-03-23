package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public abstract class Token {
    protected String token;

    public Token(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    /**
     * Modifies an output queue and operator stack based on this token's properties.
     * @param output
     * @param stack
     */
    public abstract void toPostfix(LinkedList<Token> output, Stack<Token> stack);

    /**
     * Modifies an evaluation stack for an RPN expression based on this token's properties.
     * @param evalStack
     */
    public abstract void evaluateRpn(Stack<Double> evalStack);


    public boolean matches(String text){
        return this.token.matches(text);
    }
}



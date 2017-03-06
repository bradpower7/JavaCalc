package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public abstract class Token {
    protected String _token;
    //private TokenType _type;

    public Token(String token){
        _token = token;
        //_type = type;
    }

    public String getToken(){
        return _token;
    }
    public void setToken(String str){
        _token = str;
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

   /* public TokenType getType(){
        return _type;
    }
    public void setType(TokenType type){
        _type = type;
    }*/


}



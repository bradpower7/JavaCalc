package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class ParenthesisToken extends Token {

    public ParenthesisToken(String token){
        super(token);
    }

    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        if(token.equals("(")){
            stack.push(this);
        }
        else if(token.equals(")")){
            while(!stack.isEmpty()){
                if(!stack.peek().getToken().equals("(")){
                    output.add(stack.pop());
                }
                else{
                    stack.pop();
                    break;      // trash code, prob fix
                }
            }
        }
        else{
            return;
        }
    }

    @Override
    public void evaluateRpn(Stack<Double> evalStack) {
        // this is intentionally blank.
    }

    @Override
    public boolean matches(String text){
        return text.matches("\\" + this.token);
    }
}

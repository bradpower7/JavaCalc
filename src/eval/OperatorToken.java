package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class OperatorToken extends FunctionToken {

    private int prec;
    private boolean assocLeft;

    public OperatorToken(String token, Evaluable opMethod, int precedence, boolean associativityLeft){
        super(token, opMethod, 2);
        this.prec = precedence;
        assocLeft = associativityLeft;
    }

    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        if (!stack.isEmpty()) {
            Token temp = stack.peek();
            while (temp.getClass().equals(this.getClass())) {
                if ((this.isAssociativityLeft() && (this.getPrecedence() <= ((OperatorToken) temp).getPrecedence()) ||
                        !this.isAssociativityLeft() && this.getPrecedence() < ((OperatorToken) temp).getPrecedence())) {
                    output.add(stack.pop());        // remove op from stack, add to queue
                    if(stack.isEmpty()){
                        break;
                    }
                    temp = stack.peek();
                } else {
                    break;
                }
            }
        }
        stack.push(this);
    }

    public int getPrecedence(){
        return prec;
    }
    public boolean isAssociativityLeft(){
        return assocLeft;
    }


    @Override
    public boolean matches(String text){
        return text.matches("\\" + this.token);
    }
}

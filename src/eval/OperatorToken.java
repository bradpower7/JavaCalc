package eval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class OperatorToken extends Token {

    private int _prec;
    private char _assoc;        // 'L' or 'R'
    private int _numOperands;

    private Evaluable _opMethod;

    public OperatorToken(String token, int precedence, int numOperands, char associativity, Evaluable opMethod){
        super(token);
        _prec = precedence;
        _assoc = associativity;
        _numOperands = numOperands;
        _opMethod = opMethod;
    }

    @Override
    public void toPostfix(LinkedList<Token> output, Stack<Token> stack) {
        if (!stack.isEmpty()) {
            Token temp = stack.peek();
            while (temp.getClass().equals(this.getClass())) {
                if ((this.getAssociativity() == 'L' && (this.getPrecedence() <= ((OperatorToken) temp).getPrecedence()) ||
                        this.getAssociativity() == 'R' && this.getPrecedence() < ((OperatorToken) temp).getPrecedence())) {
                    output.add(stack.pop());        // remove op from stack, add to queue
                    temp = stack.peek();
                } else {
                    break;
                }
            }
        }
        stack.push(this);
    }
    @Override
    public void evaluateRpn(Stack<Double> evalStack) {
        if(evalStack.size() >= _numOperands){
            ArrayList<Double> operands = new ArrayList<>();
            for(int i=0; i<_numOperands; i++){
                operands.add(evalStack.pop());
            }
            evalStack.push(_opMethod.eval(operands));     // wacky.
        }

    }
    public int getPrecedence(){
        return _prec;
    }
    public char getAssociativity(){
        return _assoc;
    }
}

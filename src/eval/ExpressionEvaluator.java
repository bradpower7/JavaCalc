package eval;

import java.util.LinkedList;
import java.util.Stack;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

    private String _opTokens;
    private String _funcTokens;
    private String _numTokens;
    private String _varTokens;

    private LinkedList<Token> rpnTokens;

    public ExpressionEvaluator(String ex){
        _opTokens = "-+/*^";     // the order of these operators matters, determines operator precedence during evaluation

        rpnTokens = infixToPostfix(ex);
        _funcTokens = "sin|cos|tan|log|ln";
        _numTokens = "(0-9)*";
        _varTokens = "x";
        //_constTokens = "pi|$e";      // will need to fix this so functions can be added /w 'e' in them

    }

    public Double evaluate(Double input){
        // convert infix to RPN
        for(Token tk : rpnTokens){
            if(tk.getType() == TokenType.VARIABLE){
                tk.setToken(input.toString());
            }
        }

        // TO BE CONTINUED.........
        return null;
    }

    /**
     * Converts a valid expression to a RPN list.
     * @param ex
     * @return list of tokens in postfix form
     */
    private LinkedList<Token> infixToPostfix(String ex){
        String[] split = ex.split("\\s");
        LinkedList<Token> tokens = new LinkedList<>();

        // Turn everything into Token objects
        for(String str : split){
            tokens.add(makeToken(str));     // automatically creates correct form of Token
        }

        LinkedList<Token> output = new LinkedList<>();
        Stack<Token> stack = new Stack<>();
        Stack<Integer> precStack = new Stack<>();

        // convert to Reverse Polish Notation form
        for(Token tk : tokens){
            if(tk.getType() == TokenType.NUMBER || tk.getType() == TokenType.VARIABLE){
                output.add(tk);
            }
            else if(tk.getType() == TokenType.FUNCTION){
                stack.push(tk);
            }
            else if(tk.getType() == TokenType.OPERATOR){
                // WHILE operator tk2 at top of stack:
                // if tk.associativity is LEFT and tk.precedence <= tk2.precedence
                // OR
                // if tk.associativity is RIGHT and tk.precedence < tk2.precedence
                    // pop tk2 onto output
                // at end of iteration push tk onto stack
                if(stack.isEmpty()) {
                    stack.push(tk);
                }
                else{
                    Token temp = stack.peek();
                    while(temp.getType() == TokenType.OPERATOR){
                        int tkPrec = _opTokens.indexOf(tk.getToken()) / 2;      // finds precedence of operator
                        int op2Prec = _opTokens.indexOf(temp.getToken()) / 2;   // i didn't come up with this idea, this too clever for me
                        if(op2Prec > tkPrec || (op2Prec == tkPrec && tk.getToken().equals("^"))){
                            output.add(stack.pop());        // remove op from stack, add to queue
                        }
                        else{
                            break;      // bad code, sorry :(
                        }
                    }
                    stack.push(tk);
                }
            }
            else if(tk.getType() == TokenType.LEFTBRACKET){
                stack.push(tk);
            }
            else if(tk.getType() == TokenType.RIGHTBRACKET){
                while(!stack.isEmpty()){
                    if(stack.peek().getType() != TokenType.LEFTBRACKET){
                        output.add(stack.pop());
                    }
                    else{
                        stack.pop();
                        break;      // trash code
                    }
                }
            }
            else{
                return null;            // this is kinda trash, change later
            }
        }

        // While no more tokens to read, push all onto stack
        while(!stack.isEmpty()){
            if(stack.peek().getType() != TokenType.LEFTBRACKET ||
                    stack.peek().getType() != TokenType.RIGHTBRACKET){
                output.add(stack.pop());
            }
            else{
                return null;        // should replace with exception but not right now
            }
        }
        return output;

    }

    /**
     * Generates a Token object from a string.
     * @param str
     * @return tokenized string
     */
    private Token makeToken(String str){
        if(str.matches(_opTokens))
            return new Token(str, TokenType.OPERATOR);
        else if(str.matches(_funcTokens)){
            return new Token(str, TokenType.FUNCTION);
        }
        else if(str.matches(_numTokens)){
            return new Token(str, TokenType.NUMBER);
        }
        else if(str.matches(_varTokens)){
            return new Token(str, TokenType.VARIABLE);
        }
        else if(str.equals("(")){
            return new Token(str, TokenType.LEFTBRACKET);
        }
        else if(str.equals(")")){
            return new Token(str, TokenType.RIGHTBRACKET);
        }
        else{
            return new Token(str, TokenType.INVALID);
        }

    }

}

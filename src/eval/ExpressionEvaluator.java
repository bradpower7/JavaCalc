package eval;

import java.util.*;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

    private List<Token> tokenTypes;
    private LinkedList<Token> rpnTokens;


    private Token multToken = null;

    public ExpressionEvaluator(String ex){

        tokenTypes = new ArrayList<>();

        // Creates math function methods
        tokenTypes.add(new FunctionToken("sin", (List<Double> operands) -> Math.sin(operands.get(0)), 1));
        tokenTypes.add(new FunctionToken("cos", (List<Double> operands) -> Math.cos(operands.get(0)), 1));
        tokenTypes.add(new FunctionToken("tan", (List<Double> operands) -> Math.tan(operands.get(0)), 1));
        tokenTypes.add(new FunctionToken("log10", (List<Double> operands) -> Math.log10(operands.get(0)), 1));
        tokenTypes.add(new FunctionToken("log", (List<Double> operands) -> Math.log(operands.get(0)), 1 ));
        tokenTypes.add(new FunctionToken("sqrt", (List<Double> operands) -> Math.sqrt(operands.get(0)), 1));

        // Creates operator methods
        tokenTypes.add(new OperatorToken("+", (List<Double> operands) ->  operands.get(0) + operands.get(1), 2, true ));
        tokenTypes.add(new OperatorToken("-", (List<Double> operands) ->  operands.get(1) - operands.get(0), 2, true ));
        tokenTypes.add(new OperatorToken("*", (List<Double> operands) ->  operands.get(0) * operands.get(1), 3, true ));
        tokenTypes.add(new OperatorToken("/", (List<Double> operands) ->  operands.get(0) / operands.get(1), 3, true ));
        tokenTypes.add(new OperatorToken("^", (List<Double> operands) ->  Math.pow(operands.get(1), operands.get(0)), 4, false ));

        // Add brackets
        tokenTypes.add(new ParenthesisToken("("));
        tokenTypes.add(new ParenthesisToken(")"));

        // Add variables
        tokenTypes.add(new VariableToken("x"));


        // Reference commonly used tokens
        for(Token tk : tokenTypes){
            if(tk.getToken().equals("*")){
                multToken = tk;
            }
        }

        rpnTokens = infixToPostfix(ex);

    }

    /**
     * Evalutes an expression for a single input, which will replace any variable tokens.
     * @param input
     * @return
     */
    public Double evaluate(Double input){
        Stack<Double> evalStack = new Stack<>();
        for(Token tk : rpnTokens){
            if(tk instanceof VariableToken){
                tk = new NumberToken(input.toString());
            }
            tk.evaluateRpn(evalStack);
        }

        if(evalStack.size() > 1){
            return null;
        }
        else{
            return evalStack.pop();
        }
    }

    /**
     * Evaluates an expression without an input (with no variables).
     * @pre No variable tokens.
     * @return
     */
    public Double evaluate(){
        Stack<Double> evalStack = new Stack<>();
        for(Token tk : rpnTokens){
            tk.evaluateRpn(evalStack);
        }

        if(evalStack.size() > 1){
            return null;
        }
        else{
            return evalStack.pop();
        }
    }

    private String[] parseExpression(String ex){
        int i;

        String text;
        String preStr;
        String postStr;

        // This for loop combined with the lower while loop tries to find every instance of
        // each token type in the string (except numbers)
        for(Token token : tokenTypes){
            text = token.getToken();
            i = ex.indexOf(text);

            preStr = " ";
            postStr = " ";

            // Finds all instances of a token in the string, separates by whitespace
            while(i != -1){
                ex = ex.substring(0,i) + preStr + ex.substring(i,i+text.length()) + postStr + ex.substring(i+text.length(), ex.length());       // inserts whitespace before token
                i = ex.indexOf(text, i+text.length()+postStr.length());
            }
        }

        // Trims any leading/trailing whitespace (to prevent empty strings) then splits
        return ex.trim().split("\\s+");
    }

    /**
     * Converts a valid expression to a RPN list.
     * @param ex
     * @return list of tokens in postfix form
     */
    private LinkedList<Token> infixToPostfix(String ex){
        ex = ex.trim();
        String[] split = parseExpression(ex);
        List<Token> tokens = new LinkedList<>();

        // Turn everything into Token objects
        for(String str : split){
            tokens.add(makeToken(str));     // automatically creates correct form of Token
        }

        // Deal with weird notation cases here
        for(int i=0; i<tokens.size()-1; i++){
            Token tk = tokens.get(i);
            // Multiplication without using * sign
            if(tk instanceof NumberToken || tk instanceof VariableToken){
                if((tokens.get(i+1) instanceof FunctionToken && !(tokens.get(i+1) instanceof OperatorToken)) || tokens.get(i+1) instanceof VariableToken){
                    tokens.add(i+1, this.multToken);
                }
            }
            // Negation
            if((tk.getToken().equals("-") && i == 0) || (tk.getToken().equals("-") && tokens.get(i-1).getToken().equals("("))){
                tokens.remove(i);
                tokens.add(i, new NumberToken("-1"));
                tokens.add(i+1, multToken);
            }
        }

        LinkedList<Token> output = new LinkedList<>();
        Stack<Token> stack = new Stack<>();

        // converts to Reverse Polish Notation form
        for(Token tk : tokens){
            tk.toPostfix(output, stack);
        }

        // While no more tokens to read, push all onto stack
        while(!stack.isEmpty()){
            if(!stack.peek().getToken().equals("(") ||
                    !stack.peek().getToken().equals(")")){
                output.add(stack.pop());
            }
        }
        return output;

    }

    /**
     * References or creates a Token object from a string.
     * @param str
     * @return tokenized string
     */
    private Token makeToken(String str){
        for(Token tk : tokenTypes){
            if(tk.matches(str)){
                return tk;
            }
        }

        // If no matching token found, check to see if number:
        if(str.matches("[-+]?[0-9]*\\.?[0-9]+")){
            return new NumberToken(str);
        }
        else{
            return null;        // if not a matching token or number, invalid string
        }
    }
}

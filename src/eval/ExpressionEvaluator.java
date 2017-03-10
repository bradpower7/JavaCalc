package eval;

import java.util.*;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

   // private ArrayList<String> _functions;
   // private ArrayList<String> _operators;

    private List<TokenType> tokenTypes;
    private LinkedList<Token> rpnTokens;

    public ExpressionEvaluator(String ex){

        tokenTypes = new ArrayList<>();

        // Creates math function methods
        tokenTypes.add(new Function("sin", (List<Double> operands) -> Math.sin(operands.get(0)), 1));
        tokenTypes.add(new Function("cos", (List<Double> operands) -> Math.cos(operands.get(0)), 1));
        tokenTypes.add(new Function("tan", (List<Double> operands) ->  Math.tan(operands.get(0)), 1));
        tokenTypes.add(new Function("log10", (List<Double> operands) ->  Math.log10(operands.get(0)), 1));
        tokenTypes.add(new Function("log", (List<Double> operands) ->  Math.log(operands.get(0)), 1 ));
        tokenTypes.add(new Function("sqrt", (List<Double> operands) -> Math.sqrt(operands.get(0)), 1));

        // Creates operator methods
        tokenTypes.add(new Operator("+", (List<Double> operands) ->  operands.get(0) + operands.get(1), 2, true ));
        tokenTypes.add(new Operator("-", (List<Double> operands) ->  operands.get(1) - operands.get(0), 2, true ));
        tokenTypes.add(new Operator("*", (List<Double> operands) ->  operands.get(0) * operands.get(1), 3, true ));
        tokenTypes.add(new Operator("/", (List<Double> operands) ->  operands.get(0) / operands.get(1), 3, true ));
        tokenTypes.add(new Operator("^", (List<Double> operands) ->  Math.pow(operands.get(1), operands.get(0)), 4, false ));

        // Add brackets
        tokenTypes.add(new TokenType("("));
        tokenTypes.add(new TokenType(")"));

        rpnTokens = infixToPostfix(ex);

    }

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

    private ArrayList<String> parseExpression(String ex){
        // Prepare for spaghetti
        int i;
        String text;
        String preStr;
        String postStr;
        for(TokenType token : tokenTypes){
            text = token.getText();
            i = ex.indexOf(text);
            while(i != -1){
                // do stuff
                if(token instanceof Operator){

                }
                else if(token instanceof Function){
                    if(i > 0){
                        if(ex.substring(i-1,i).matches("[0-9]")){
                            preStr = " * ";
                        }
                        else if(ex.substring(i-1,i).matches("-")){
                            if(i > 1){
                                if(ex.substring(i-2,i-1).matches("[0-9]")){
                                    preStr = " ";
                                }
                                else{
                                    preStr = "-1 * ";
                                }
                            }
                            else{
                                preStr = "-1 * ";
                            }
                        }
                        else {

                        }
                    }
                }
                ex = ex.substring(0,i) + preStr + ex.substring(i,i+text.length()) + postStr + ex.substring(i+text.length(), ex.length());       // inserts whitespace before token
                i = ex.indexOf(text, i+1);
            }
        }
    }

    /**
     * Converts a valid expression to a RPN list.
     * @param ex
     * @return list of tokens in postfix form
     */
    private LinkedList<Token> infixToPostfix(String ex){
        ex = ex.trim();
        String[] split = ex.split("\\s+");
        LinkedList<Token> tokens = new LinkedList<>();

        // Turn everything into Token objects
        for(String str : split){
            tokens.add(makeToken(str));     // automatically creates correct form of Token
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
     * Generates a Token object from a string.
     * @param str
     * @return tokenized string
     */
    private Token makeToken(String str){
        // Check to see if string is double
        boolean isDbl = false;
        try
        {
            Double.parseDouble(str);
            isDbl = true;
        }
        catch(NumberFormatException e)
        {
            isDbl = false;
        }
        if(isDbl){
            return new NumberToken(str);
        }
        else if(){
            return new FunctionToken(str, _funcMethods.get(str), _opFuncNumOfOperands.get(str));        // NOTE: not all tokenTypes have 1 operand. change later
        }
        else if(_opMethods.containsKey(str)){
            return new OperatorToken(str, _opPrecedences.get(str), _opFuncNumOfOperands.get(str), _opAssociativites.get(str), _opMethods.get(str));
        }
        else if(str.equals("x")){
            return new VariableToken(str);
        }
        else if(str.equals("(")){
            return new ParenthesisToken(str);
        }
        else if(str.equals(")")){
            return new ParenthesisToken(str);
        }
        else{
            return null;
        }
    }
}

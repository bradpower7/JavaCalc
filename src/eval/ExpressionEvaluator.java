package eval;

import java.util.*;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

    private List<Token> tokenTypes;
    private LinkedList<Token> rpnTokens;

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

    private String[] parseExpression(String ex){
        // Prepare for spaghetti...
        // This method lets the user input strings that are closer to what a human would write
        // (for one example: would let the user input '9x' as opposed to '9*x')
        // basically makes assumptions about how humans use shortcuts to write math rather than writing
        // 100% grammatically correct expressions
        //
        // As a result, this method tends to check alot of edge cases one by one, and is quite complicated...
        // we've attempted to explain most of our logic.

        int i;

        String text;
        String preStr;
        String postStr;

        // This for loop combined with the lower while loop tries to find every instance of
        // each token type in the string (except numbers)
        for(Token token : tokenTypes){
            text = token.getToken();
            i = ex.indexOf(text);

            preStr = "";
            postStr = "";



            // Keep going until no more instances found
            /*while(i != -1){
                // Functions and variables have some similar operations
                if(token instanceof FunctionToken || token instanceof VariableToken){
                    if(text.equals("-")){

                    }
                    // Checking for edge cases regarding the character before the token requires the token index to not be 0
                    if(i > 0) {

                        // Check for negative sign before a Function or Variable token
                        // (subtraction, or negation? conceptually the same, but typically written differently)
                        if (ex.substring(i - 1, i).matches("-")) {
                            if (i > 1) {
                                // If character before the negative sign is a number or variable, assume subtraction
                                if (ex.substring(i - 2, i - 1).matches("[0-9x]")) {
                                    preStr = " ";
                                }
                                // Otherwise consider it negation
                                else {
                                    preStr = "-1 * ";
                                }
                            }
                            // If index of negation sign is first in the string, can also assume negation
                            else {
                                preStr = "-1 * ";
                            }
                        }
                        // If the character before token is a number or variable, assume multiplication
                        else if (ex.substring(i - 1, i).matches("[0-9x]")) {
                            preStr = " * ";
                        }
                        else {
                            preStr = " ";
                        }
                    }
                    postStr = " ";      // no matter what, should add space after a function name or variable
                }
                // If not a function, variable, number, or variable, just add spaces
                // We do not account for spaces before and after numbers because the logic for other tokens should
                // add in all necessary whitespace anyways.
                else if (!text.matches("[0-9x]")){
                    preStr = " ";
                    postStr = " ";
                }
                ex = ex.substring(0,i) + preStr + ex.substring(i,i+text.length()) + postStr + ex.substring(i+text.length(), ex.length());       // inserts whitespace before token
                i = ex.indexOf(text, i+text.length()+postStr.length());
            }*/
        }
        return ex.split("\\s+");
    }

    /**
     * Converts a valid expression to a RPN list.
     * @param ex
     * @return list of tokens in postfix form
     */
    private LinkedList<Token> infixToPostfix(String ex){
        ex = ex.trim();
        String[] split = parseExpression(ex);
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




        // Check to see if string is double
        /*boolean isDbl = false;
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
            return new NumberTokenType(str);
        }
        else if(){
            return new FunctionToken(str, , _opFuncNumOfOperands.get(str));        // NOTE: not all tokenTypes have 1 operand. change later
        }
        else if(_opMethods.containsKey(str)){
            return new OperatorTokenType(str, _opPrecedences.get(str), _opFuncNumOfOperands.get(str), _opAssociativites.get(str), _opMethods.get(str));
        }
        else if(str.equals("x")){
            return new VariableTokenType(str);
        }
        else if(str.equals("(")){
            return new ParenthesisToken(str);
        }
        else if(str.equals(")")){
            return new Parenthesis

            Token(str);
        }
        else{
            return null;
        }*/
    }
}

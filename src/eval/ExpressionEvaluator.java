package eval;

import java.sql.Array;
import java.util.*;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

   // private ArrayList<String> _functions;
   // private ArrayList<String> _operators;

    private List<Function> functions;
    private LinkedList<Token> rpnTokens;

    public ExpressionEvaluator(String ex){

        functions = new ArrayList<>();

        // Creates math function methods
        functions.add(new Function("sin", (List<Double> operands) -> Math.sin(operands.get(0)), 1));
        functions.add(new Function("cos", (List<Double> operands) -> Math.cos(operands.get(0)), 1));
        functions.add(new Function("tan", (List<Double> operands) ->  Math.tan(operands.get(0)), 1));
        functions.add(new Function("log10", (List<Double> operands) ->  Math.log10(operands.get(0)), 1));
        functions.add(new Function("log", (List<Double> operands) ->  Math.log(operands.get(0)), 1 ));
        functions.add(new Function("sqrt", (List<Double> operands) -> Math.sqrt(operands.get(0)), 1));

        // Creates operator methods
        functions.add(new Operator("+", (List<Double> operands) ->  operands.get(0) + operands.get(1), 2, true ));
        functions.add(new Operator("-", (List<Double> operands) ->  operands.get(1) - operands.get(0), 2, true ));
        functions.add(new Operator("*", (List<Double> operands) ->  operands.get(0) * operands.get(1), 3, true ));
        functions.add(new Operator("/", (List<Double> operands) ->  operands.get(0) / operands.get(1), 3, true ));
        functions.add(new Operator("^", (List<Double> operands) ->  Math.pow(operands.get(1), operands.get(0)), 4, false ));

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
            return new FunctionToken(str, _funcMethods.get(str), _opFuncNumOfOperands.get(str));        // NOTE: not all functions have 1 operand. change later
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

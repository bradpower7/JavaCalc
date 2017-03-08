package eval;

import java.util.*;


/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class ExpressionEvaluator {

   // private ArrayList<String> _functions;
   // private ArrayList<String> _operators;

    private HashMap<String, Evaluable> _funcMethods;
    private HashMap<String, Evaluable> _opMethods;

    private HashMap<String, Integer> _opPrecedences;
    private HashMap<String, Character> _opAssociativites;
    private HashMap<String, Integer> _opFuncNumOfOperands;

    private LinkedList<Token> rpnTokens;

    public ExpressionEvaluator(String ex){
        // ***BAD CODE AHEAD***
        // All of this will be refactored later
        // Creates math function methods
        _funcMethods = new HashMap<>();
        _funcMethods.put("sin", (ArrayList<Double> operands) ->  Math.sin(operands.get(0)) );
        _funcMethods.put("cos", (ArrayList<Double> operands) ->  Math.cos(operands.get(0)) );
        _funcMethods.put("tan", (ArrayList<Double> operands) ->  Math.tan(operands.get(0)) );
        _funcMethods.put("log10", (ArrayList<Double> operands) ->  Math.log10(operands.get(0)) );
        _funcMethods.put("log", (ArrayList<Double> operands) ->  Math.log(operands.get(0)) );

        // Creates operator methods
        _opMethods = new HashMap<>();
        _opMethods.put("+", (ArrayList<Double> operands) ->  operands.get(0) + operands.get(1)  );
        _opMethods.put("-", (ArrayList<Double> operands) ->  operands.get(0) - operands.get(1)  );
        _opMethods.put("*", (ArrayList<Double> operands) ->  operands.get(0) * operands.get(1)  );
        _opMethods.put("/", (ArrayList<Double> operands) ->  operands.get(0) / operands.get(1)  );
        _opMethods.put("^", (ArrayList<Double> operands) ->  Math.pow(operands.get(1), operands.get(0))  );

        // Operator & function number of operands
        _opFuncNumOfOperands = new HashMap<>();
        _opFuncNumOfOperands.put("+", 2);
        _opFuncNumOfOperands.put("-", 2);
        _opFuncNumOfOperands.put("*", 2);
        _opFuncNumOfOperands.put("/", 2);
        _opFuncNumOfOperands.put("^", 2);
        _opFuncNumOfOperands.put("sin", 1);
        _opFuncNumOfOperands.put("cos", 1);
        _opFuncNumOfOperands.put("tan", 1);
        _opFuncNumOfOperands.put("log10", 1);
        _opFuncNumOfOperands.put("log", 1);

        // Operator precedences (used for order of operations)
        _opPrecedences = new HashMap<>();
        _opPrecedences.put("+", 2);
        _opPrecedences.put("-", 2);
        _opPrecedences.put("*", 3);
        _opPrecedences.put("/", 3);
        _opPrecedences.put("^", 4);

        // Operator associativities (from which direction are they evaluated)
        _opAssociativites = new HashMap<>();
        _opAssociativites.put("+", 'L');
        _opAssociativites.put("-", 'L');
        _opAssociativites.put("*", 'L');
        _opAssociativites.put("/", 'L');
        _opAssociativites.put("^", 'R');

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
        else if(_funcMethods.containsKey(str)){
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

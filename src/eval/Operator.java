package eval;

/**
 * Created by Brad Power on 3/9/17 for JavaCalc.
 */
public class Operator extends Function {

    protected int precedence;
    protected boolean assocLeft;

    public Operator(String str, Evaluable op, int precedence, boolean associativityLeft){
        super(str, op, 2);
        this.precedence = precedence;
        assocLeft = associativityLeft;
    }

    public int getPrecedence(){
        return precedence;
    }
    public boolean isAssociativityLeft(){
        return assocLeft;
    }


}

package eval;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Brad Power on 3/29/2017 for JavaCalc.
 */
public class ConstantToken extends NumberToken {

    protected Double value;

    public ConstantToken(String token, Double value){
        super(token);
        this.value = value;
    }

    public Double getValue(){
        return value;
    }

    @Override
    public boolean matches(String text){
        return text.matches(this.token);
    }
}

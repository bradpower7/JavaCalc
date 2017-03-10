package eval;

/**
 * Created by Brad Power on 3/9/2017 for JavaCalc.
 */
public class TokenType {
    protected String text;

    public TokenType(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}

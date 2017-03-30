import javax.swing.*;

/**
 * Created by Brad Power on 3/28/2017 for JavaCalc.
 */
public class TokenButton extends JButton {

    private String tokenText;

    public TokenButton(String token){
        super();
        tokenText = token;
        this.setFocusable(false);       // want buttons to be non-focusable by default b/c calculator
    }

    public void setTokenText(String token){
        tokenText = token;
    }
    public String getTokenText(){
        return tokenText;
    }
}

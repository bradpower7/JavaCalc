package eval;

/**
 * Created by Brad Power on 3/3/17 for JavaCalc.
 */
public class Token {
    private String _token;
    private TokenType _type;

    public Token(String token, TokenType type){
        _token = token;
        _type = type;
    }

    public String getToken(){
        return _token;
    }
    public void setToken(String str){
        _token = str;
    }
    public TokenType getType(){
        return _type;
    }


}



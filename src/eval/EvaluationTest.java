package eval;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public class EvaluationTest {
    public static void main(String args[]){
        ExpressionEvaluator eval = new ExpressionEvaluator("log(10)");
        Double output = eval.evaluate(1.0);


        ExpressionEvaluator eval2 = new ExpressionEvaluator("-5*x");
        Double output2 = eval2.evaluate(10.0);
        System.out.println(output);
        System.out.println(output2);
    }
}

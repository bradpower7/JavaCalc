package eval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brad Power on 3/6/17 for JavaCalc.
 */
public interface Evaluable {
    Double eval(List<Double> operands);
}

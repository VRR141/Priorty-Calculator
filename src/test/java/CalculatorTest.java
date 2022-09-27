import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    private Calculator sut;

    @Test
    public void getResultTest(){
        double expected = 10;

        String input = "25/(15-2.5)*5";
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        InterfaceStringIterator stringIterator = new StringIterator(input);
        InterfaceOperationsPriorities operationsPriorities = new OperationsPriorities();
        for (String op: operators){
            operationsPriorities.addOperator(op);
        }

        sut = new Calculator(stringIterator, operationsPriorities);
        double actual = sut.getResult();

        Assertions.assertEquals(expected, actual);
    }
}

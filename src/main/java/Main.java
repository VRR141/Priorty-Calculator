import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String input = "25/(12.5)*5";


    public static void main(String[] args) {

        Calculator calculator = new Calculator(getStringIterator(), getOperationsPriorities());
        double result = calculator.getResult();
        System.out.println(result);
    }

    private static InterfaceOperationsPriorities getOperationsPriorities(){
        OperationsPriorities operationsPriorities = new OperationsPriorities();
        List<String> operators = Arrays.asList("+", "-", "*", "/");

        for (String op: operators){
            operationsPriorities.addOperator(op);
        }

        return operationsPriorities;
    }

    private static InterfaceStringIterator getStringIterator(){
        return new StringIterator(input);
    }
}

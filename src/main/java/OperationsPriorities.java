import java.util.HashMap;
import java.util.Map;

public class OperationsPriorities implements InterfaceOperationsPriorities{

    private final Map<String, Integer> map;

    public OperationsPriorities() {
        map = new HashMap<>();
    }

    @Override
    public void addOperator(String operator) {
        map.put(operator, getPriority(operator));
    }

    @Override
    public void deleteOperator(String operator) {
        map.remove(operator);
    }

    public int getPriority(String operator){
        switch (operator){
            case "*":
            case "/":
                return 2;
        }
        return 1;
    }
}

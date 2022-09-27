import java.util.Stack;

public class Calculator{

    private final InterfaceStringIterator iterator;
    private final InterfaceOperationsPriorities priorities;
    private final Stack<Double> numbers;
    private final Stack<String> operators;

    public Calculator(InterfaceStringIterator iterator, InterfaceOperationsPriorities priorities) {
        this.iterator = iterator;
        this.priorities = priorities;
        numbers = new Stack<>();
        operators = new Stack<>();
    }

    public Double getResult() {
        while (iterator.hasNext()) {
            String element = iterator.next();
            try {
                double number = Double.parseDouble(element);
                numbers.push(number);
            } catch (NumberFormatException e) {
                if (element.equals("(")) {
                    operators.push(element);
                } else if (element.equals(")")) {
                    while (!operators.peek().equals("(")) {
                        calculate();
                    }
                    operators.pop();
                } else {
                    if (operators.empty()) {
                        operators.push(element);
                    } else {
                        int priority = priorities.getPriority(element);
                        while (!operators.empty() && !operators.peek().equals("(") && !operators.peek().equals(")") &&
                                priority <= priorities.getPriority(operators.peek())) {
                            calculate();
                        }
                        operators.push(element);
                    }
                }
            }
        }
        while (!operators.empty()) {
            calculate();
        }
        return numbers.pop();
    }
    private void calculate() {
        String operator = operators.pop();
        Double n2 = numbers.pop();
        Double n1 = numbers.pop();
        Double result = null;

        switch (operator) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
        }
        numbers.push(result);
    }

}
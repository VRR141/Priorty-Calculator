import java.util.Stack;

public class Calculator{

    private final InterfaceStringIterator iterator;
    private final Stack<Double> numbers;
    private final Stack<String> operators;

    public Calculator(InterfaceStringIterator iterator) {
        this.iterator = iterator;
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
                    if (operators.peek().equals("-")){
                        double negativeNumber = numbers.pop();
                        negativeNumber *= -1;
                        numbers.push(negativeNumber);
                        if (numbers.size() > 1){
                            operators.pop();
                            operators.push("+");
                            calculate();
                        } else {
                            operators.pop();
                        }
                    }
                } else {
                    if (operators.empty()) {
                        operators.push(element);
                    } else {
                        int priority = getPriority(element);
                        while (!operators.empty() && !operators.peek().equals("(") && !operators.peek().equals(")") &&
                                priority <= getPriority(operators.peek())) {
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

    private int getPriority(String operator){
        switch (operator){
            case "*":
            case "/":
                return 2;
        }
        return 1;
    }

}
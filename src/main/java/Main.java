public class Main {

    private static final String input = "-(2*4+5)+(5*5)";

    public static void main(String[] args) {
        StringIterator stringIterator = new StringIterator(input);
        Calculator calculator = new Calculator(stringIterator);
        double result = calculator.getResult();
        System.out.println(result);
    }
}

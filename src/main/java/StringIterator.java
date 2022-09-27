public class StringIterator implements InterfaceStringIterator {

    private String input;
    private int index;

    public StringIterator(String input) {
        this.input = input.replace(" ", "");
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return input!= null &&
                !input.isEmpty() &&
                index < input.length();
    }

    @Override
    public String next() {
        StringBuilder sb = new StringBuilder();
        char element = input.charAt(index);
        while (Character.isDigit(element) || element == '.' || (index == 0 && element == '-') ||
                (index > 0 && input.charAt(index - 1) == '(' && element == '-')){
            sb.append(element);
            index++;
            if (index == input.length()){
                return sb.toString();
            }
            element = input.charAt(index);
        }
        if (sb.length() != 0){
            return sb.toString();
        }
        index++;
        return Character.toString(element);
    }
}

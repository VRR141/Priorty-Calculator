import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator sut;

    @Test
    public void getResultTestFirst(){
        double expected = 10;

        String input = "25/(15-2.5)*5";
        InterfaceStringIterator stringIterator = new StringIterator(input);

        sut = new Calculator(stringIterator);
        double actual = sut.getResult();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getResultTestSecond() {
        double expected = -9;

        String input = "-(4+5)";
        InterfaceStringIterator stringIterator = new StringIterator(input);

        sut = new Calculator(stringIterator);
        double actual = sut.getResult();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getResultTestThird() {
        double expected = 30.5;

        String input = "-(4+5)-(-4.5-7*5)";
        InterfaceStringIterator stringIterator = new StringIterator(input);

        sut = new Calculator(stringIterator);
        double actual = sut.getResult();

        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void end(){
        sut = null;
    }

}

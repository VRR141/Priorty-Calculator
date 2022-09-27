import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

public class OperationsPrioritiesTest {

    private InterfaceOperationsPriorities sut;

    @AfterEach
    public void end(){sut = null;}

    @Test
    public void addOperatorTest(){
        sut = Mockito.mock(OperationsPriorities.class);
        sut.addOperator("+");

        Mockito.verify(sut, Mockito.only()).addOperator("+");
        Mockito.verify(sut, Mockito.times(0)).addOperator("-");
    }

    @ParameterizedTest
    @ValueSource( strings = {"+", "-"})
    public void getPriorityPlusMinusTest(String operator){
        int expected = 1;
        sut = new OperationsPriorities();
        int actual = sut.getPriority(operator);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource( strings = {"*", "/"})
    public void getPriorityMultipleDivideTest(String operator){
        int expected = 2;
        sut = new OperationsPriorities();
        int actual = sut.getPriority(operator);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteOperatorTest(){
        sut = Mockito.mock(OperationsPriorities.class);
        sut.deleteOperator("+");

        Mockito.verify(sut, Mockito.times(1)).deleteOperator("+");
        Mockito.verify(sut, Mockito.times(0)).deleteOperator("-");
    }

}

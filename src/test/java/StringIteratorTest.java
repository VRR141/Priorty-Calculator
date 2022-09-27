import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringIteratorTest {

    private InterfaceStringIterator sut;

    @AfterEach
    public void end(){
        sut = null;
    }

    @Test
    public void hasNextTest(){
        sut = new StringIterator("");
        boolean actual = sut.hasNext();
        Assertions.assertFalse(actual);
    }

    @Test
    public void nextTest(){
        List<String> expected = Arrays.asList("(", "1", "+", "25.5", ")", "*", "25", "-", "5.1");

        sut = new StringIterator("(1+25.5)*25-5.1");
        List<String> actual = new ArrayList<>();
        while (sut.hasNext()){
            actual.add(sut.next());
        }
        Assertions.assertEquals(expected, actual);
    }
}

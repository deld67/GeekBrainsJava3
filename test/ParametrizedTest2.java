import lesson6.myHomeworkClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParametrizedTest2 {
    private static myHomeworkClass myClass = null;

    private int[] inputArray;
    private boolean resVal;

    public ParametrizedTest2(int[]  inputArray, boolean resVal) {
        this.inputArray = inputArray;
        this.resVal = resVal;

    }

    @Parameters
    public static Collection abracadabra() {
        return Arrays.asList(new Object[][]{
                        { new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, true },
                        {new int[]{1, 2, 4, 4, 2, 3, 0, 1, 7}, false},
                        {new int[]{1, 2, 4, 4, 2, 3, 4,  7}, true}
                }
        );
    }

    @Test
    public void arrayTest() {
        Assert.assertEquals(myClass.testArray1or4(inputArray), resVal);
    }


    @Before
    public void init() {
        System.out.println("init myHomeworkClass");
        myClass = new myHomeworkClass();
    }

    @After
    public void tearDown() throws Exception {
        myClass = null;
    }
}

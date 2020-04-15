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
public class ParametrizedTest {
    private static myHomeworkClass myClass = null;

    private int[] inputArray;
    private int[] resArray;

    public ParametrizedTest(int[]  inputArray, int[] resArray) {
        this.inputArray = inputArray;
        this.resArray = resArray;

    }

    @Parameters
    public static Collection abracadabra() {
        return Arrays.asList(new Object[][]{
                        { new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7} },
                        {new int[]{1, 2, 4, 4, 2, 3, 0, 1, 7}, new int[]{2, 3, 0,1, 7}},
                        {new int[]{1, 2, 4, 4, 2, 3, 4,  7}, new int[]{7}}
                }
        );
    }

    @Test
    public void arrayTest() {
        Assert.assertArrayEquals(myClass.task1(inputArray),resArray );
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

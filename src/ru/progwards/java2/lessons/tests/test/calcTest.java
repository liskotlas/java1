//
//
//import calc.SimpleCalculator;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//import static org.junit.Assert.*;
//import static org.junit.runners.Parameterized.*;
//import static org.junit.runners.Parameterized.Parameters;
//
//@RunWith(Parameterized.class)
//
//public class calcTest {
//
//    @Parameter(0)
//    public int volue1;
//
//    @Parameter(1)
//    public int volue2;
//
//    @Parameter(2)
//    public int result;
//
//    @Parameters
//    public static Collection<Object[]> data(){
//        Object[][] data = new Object[][]{{1,2,3}, {5,3,8}, {121, 4, 125}};
//        return Arrays.asList(data);
//    }
//
//
//    private SimpleCalculator simpleCalculator;
//
//    @Before
//            public void initTest(){
//        simpleCalculator = new SimpleCalculator();
//    }
//
//
//
//@Test
//    public void testSum() {
//
//
//    int actual = simpleCalculator.sum(volue1, volue2);
//    assertEquals(result, actual);
//    }
//
//@Test
//    public void testDiff(){
//
//        int expected = 5;
//        int actual = simpleCalculator.diff(10, 5);
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    public void testMult(){
//
//        assertEquals(50, simpleCalculator.mult(5, 10));
//
//    }
//
//    @Test(expected = ArithmeticException.class)
//    public  void testDivZero(){
//         assertEquals(0, simpleCalculator.div(10, 0));
//    }
//
//    @After
//
//    public void destroyTest(){
//        simpleCalculator = null;
//    }
//
//}
//
//

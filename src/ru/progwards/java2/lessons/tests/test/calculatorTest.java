import Calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//@RunWith(Parameterized.class)


public class calculatorTest {

//    @Parameterized.Parameter(0)
//    public String string;
//
//    @Parameterized.Parameter(1)
//    public int result;
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data(){
//        Object[][] data = new Object[][]{{"2+4*(6-2)", 17}, {"18-6/(5*4-18)", 15}};
//        return Arrays.asList(data);
//    }



//    @Test
//
//    public void calcTest(){
//
//        try {
//            assertEquals(result, Calculator.calculate(string));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test(expected = ArithmeticException.class)
    public void calcTestZero(){

        try {
            assertEquals(0, Calculator.calculate("2+3/(2*6-1-9-2)"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}

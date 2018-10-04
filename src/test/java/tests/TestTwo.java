package tests;

import objects.BasicCalculatorPage;
import objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class TestTwo extends BaseTest {

    private static BasicCalculatorPage calc;
    private static CalculatorPage cal;

    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new BasicCalculatorPage(driver);
        cal = new CalculatorPage(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    //Testing if zero disappears while other number is chosen
    @Test
    public void calculator_zeroInFront(){
        cal.click_0();
        cal.click_2();
        Assert.assertEquals("2", cal.getResult());
    }

    // Testing if multiple clicks on zero button in the beggining of expression only leaves one zero in edit field
    @Test
    public void calculator_zeroMultipleClicks(){
        cal.click_0();
        cal.click_0();
        cal.click_0();
        cal.click_dot();
        cal.click_2();
        Assert.assertEquals("0.2", cal.getResult());
    }

    // Testing if in case of multiple clicks on the same operator button only one stays in edit field
    @Test
    public void calculator_operatorMultipleClicks(){
        cal.click_2();
        cal.click_3();
        cal.click_plus();
        cal.click_plus();
        Assert.assertEquals("23+", cal.getResult());
    }

    // Testing multiple clicks on different operator buttons and if only the last one stays active
    @Test
    public void calculator_diffOperatorMultipleClicks(){
        cal.click_2();
        cal.click_3();
        cal.click_plus();
        cal.click_divide();
        Assert.assertEquals("23/", cal.getResult());
    }

    //Testing if in case of dot and number entered in the beginning of the programm it is replaced with zero.number
    @Test
    public void calculator_dotNumber(){
        cal.click_dot();
        cal.click_3();
        cal.click_equal();
        Assert.assertEquals("0.3", cal.getResult());
    }


    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
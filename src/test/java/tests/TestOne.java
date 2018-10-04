package tests;

import objects.BasicCalculatorPage;
import objects.CalculatorPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOne extends BaseTest {

    private static BasicCalculatorPage calc;
    @Parameterized.Parameter
    public String expression;

    @Parameterized.Parameter(1)
    public String expected;

    @BeforeClass
    public static void setup() {
        calc = new BasicCalculatorPage(driver);
        calc.open();
    }

    @Before
    public void cleanup() {
        calc.clear();
    }

    // Testing basical arithmetic operations (+,-, /, *) and also some special cases - negative number, dividing by zero, big numbers
    @Test
    public void calculator_DataDrivenTest(){
        Assert.assertEquals(expected, calc.calculate(expression));
    }

    @Parameterized.Parameters (name="Test: {0}={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "100+100", "200" },
                { "100+0", "100" },
                { "100-200", "-100" },
                { "30/2", "15" },
                { "2/0", "Infinity" },
                { "12*0", "0" },
                { "131*2", "262" },
                { "10000000/-1111", "-9000.900090009001" }
        });
    }


    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
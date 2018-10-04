
import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Before
    public void setUrl(){
        baseUrl = "file://" + getAppPath();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }


    private final String getAppPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        return file.getAbsolutePath();
    }
}

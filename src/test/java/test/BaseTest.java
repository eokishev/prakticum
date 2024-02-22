package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }


}

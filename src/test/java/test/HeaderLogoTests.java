package test;

import org.junit.Test;
import page.object.HomePage;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HeaderLogoTests extends BaseTest {

    @Test
    public void clickScooterLogo() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoScooter();
        assertEquals("Открылась не главная страница \"Самоката\"", url, driver.getCurrentUrl());
    }
    @Test
    public void clickYandexLogo() {
        String url = "https://dzen.ru/";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoYandex();
        Set<String> handlesCount  = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        handlesCount.remove(currentHandle);
        driver.switchTo().window(handlesCount.toArray()[0].toString());
        String url2 =  (driver.getCurrentUrl()).substring(0,16);

        assertEquals("Открылась не главная страница \"Самоката\"", url, url2);
    }
}

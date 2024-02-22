package test;

import org.junit.Test;
import page.object.HomePage;
import page.object.TrackPage;

public class OrderStatusTests extends BaseTest{
    @Test
    public void enterIncorrectOrderNumber() {

        String orderNumber = "1";
        HomePage homePage = new HomePage(driver);
        TrackPage trackPage = new TrackPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage.checkOrderStatus(orderNumber);
        System.out.println(trackPage.getOrderColumns());
    }
}

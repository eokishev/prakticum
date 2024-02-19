package test;

import org.junit.Test;
import page.object.HomePage;
import page.object.OrderPageAboutRent;
import page.object.OrderPageForWhom;

import static org.junit.Assert.assertEquals;

public class OrderScooterTests extends ConfigurationWebDriver {
    @Test
    public void orderWithAllParameters() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String location = "Top";
        String name = "Окишев";
        String surname = "Евгений";
        String address = "Юности 3";
        String metro = "Савеловская";
        String phone = "+79137287101";
        String date = "21.06.2024";
        String rentalPeriod = "сутки";
        String colorScooter = "black";
        String comment = "Оставленный коментарий!";
        String resault = "Заказ оформлен";

        HomePage homePage = new HomePage(driver);
        OrderPageForWhom orderPageForWhom = new OrderPageForWhom(driver);
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        homePage.clickOrderButton(location);
        orderPageForWhom.makingOrderForWhom(name, surname, address, metro, phone);
        orderPageAboutRent.makingOrderAboutRent(date, rentalPeriod, colorScooter, comment);
        orderPageAboutRent.confirmOrder();
        assertEquals("Окно \"Заказ оформлен\" не появилось", resault, orderPageAboutRent.orderConfirmationWindow());
    }
    @Test
    public void orderWithoutComment() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String location = "Middle";
        String name = "Окишев";
        String surname = "Евгений";
        String address = "Юности 3";
        String metro = "Сокольники";
        String phone = "+79137287102";
        String date = "21.06.2024";
        String rentalPeriod = "трое суток";
        String colorScooter = "grey";
        String result = "Заказ оформлен";

        HomePage homePage = new HomePage(driver);
        OrderPageForWhom orderPageForWhom = new OrderPageForWhom(driver);
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        homePage.clickOrderButton(location);
        orderPageForWhom.makingOrderForWhom(name, surname, address, metro, phone);
        orderPageAboutRent.makingOrderAboutRent(date, rentalPeriod, colorScooter);
        orderPageAboutRent.confirmOrder();
        assertEquals("Окно \"Заказ оформлен\" не появилось", result, orderPageAboutRent.orderConfirmationWindow());
    }
}

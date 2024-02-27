package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackPage extends BasePage{
    public TrackPage(WebDriver driver){
        super(driver);
    }
    //Окно с информацией, что заказ не найден.
    private By notFound = By.xpath(".//div[@class = 'Track_NotFound__6oaoY']/img");

    public boolean getOrderColumns() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(notFound));
        return driver.findElement(notFound).isDisplayed();
    }
}

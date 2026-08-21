package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class GoogleCloudStartPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/";
    private By calculatorCookieAcceptButton = By.xpath("//button[@class='glue-cookie-notification-bar__accept']");
    private By pricingMenu = By.xpath("//a[contains(text(),'Pricing')]");

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("GoogleCloudStartPage page opened");
        return this;
    }

    public PrisingMenuSearchPage openPricingMenuCalculator (){
        driver.findElement(pricingMenu).click();
    return new PrisingMenuSearchPage(driver);
    }

    public void acceptCookiesIfPresent() {
        try {
            waitAndClick(calculatorCookieAcceptButton);
        } catch (TimeoutException e) {
            logger.info("Cookie snackbar did not appear");
        }
    }
}

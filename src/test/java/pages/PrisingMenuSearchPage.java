package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrisingMenuSearchPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    private String PAGE_URL = "https://cloud.google.com/products/calculator";
    private By CalculatoPpricingLink = By.xpath("//div[contains(text(),'Pricing calculator')]"); //div[text()='Pricing calculator']

    public PrisingMenuSearchPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("PrisingMenuSearchPage page opened");
        return this;

    }

    public CalculatorPricingPage openCalculatorPricingPage (){

        driver.findElement(CalculatoPpricingLink).click();
        return new CalculatorPricingPage(driver);
    }
}

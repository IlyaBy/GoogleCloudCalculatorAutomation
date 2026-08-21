package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailedViewPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/";

    private By detailedViewCost = By.xpath("//div[div[normalize-space()='Total estimated cost']]/div[contains(text(),'$3,883.62')]");

    public DetailedViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("GoogleCloudStartPage page opened");
        return this;
    }
    public String getDetailedViewCost() {
        WebElement detViewCalcEstimatedCost = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(detailedViewCost)));

        return detViewCalcEstimatedCost.getText();
    }

}

package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopMailRecipientPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://yopmail.com/en";

    private By randomEmailGeneratorButton = By.xpath("//a[@href='email-generator'][.//h3[text()='Random Email generator']]");
    private By generateNewMailButton = By.xpath("//button[@class='md but text f24 egenbut'][.//span[text()='New']]");//div[@class='nw'][.//span[text()='New']]
    private By generatedMailField = By.xpath("//div[@id='geny'][.//span[@class='genytxt']]");


    public YopMailRecipientPage(WebDriver driver) {
        super(driver);

    }

    public YopMailRecipientPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("YopMail page opened");
        return this;
    }

    public YopMailSenderPage returnToYopMailSenderPage() {
        switchToSecondTab();
        return new YopMailSenderPage(driver);
    }

    public void generateEmailToCopy(){
        scrollAndClick(randomEmailGeneratorButton);
        scrollAndClick(generateNewMailButton);
    }

    public String copyEmail(){

       return driver.findElement(generatedMailField).getText();

    }

}

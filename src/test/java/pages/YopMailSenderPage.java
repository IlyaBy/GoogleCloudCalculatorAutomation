package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class YopMailSenderPage extends AbstractPage{


    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://yopmail.com/en"; //moguppougatri-5706@yopmail.com
    private By yopMailConsentAcceptButton = By.xpath("//div[@class='fc-footer-buttons']//button[contains(@class, 'fc-cta-consent')]//p[@class='fc-button-label']"); //p[text()='Consent']
    private By randomEmailGeneratorButton = By.xpath("//a[@href='email-generator'][.//h3[text()='Random Email generator']]");//a[@href='email-generator'][.//h3[text()='Random Email generator']]

    private By checkInboxButton = By.xpath("//span[text()='Check Inbox']");
    private By newMailButton = By.xpath("//button[@id='newmail']");
    private By recipientField = By.xpath("//input[@id='msgto']");
    private By subjectField = By.xpath("//input[@id='msgsubject']");
    private By messageBodyField = By.xpath("//div[@id='msgbody']");
    private By sendMailButton = By.xpath("//button[@id='msgsend']");

    private By mailSentConfirmationMessege = By.xpath("//div[text()='Your message has been sent']");

    //private WebElement generatedYopMailAddress;

    public YopMailSenderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YopMailSenderPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("YopMailSender page opened");
        return this;
    }

    public CalculatorPricingPage returnToCalculatorPricingPage() {
        switchToFirstTab();
        return new CalculatorPricingPage(driver);
    }

    public YopMailRecipientPage openYopMaiRecipientTab() {

        openAndSwitchToEmailRecipientTab("https://yopmail.com/en");

        return new YopMailRecipientPage(driver);
    }

    public void generateEmailToSend(){
        waitAndClick(yopMailConsentAcceptButton);
        scrollAndClick(randomEmailGeneratorButton);
        scrollAndClick(checkInboxButton);
        waitAndClick(newMailButton);
    }

    public void sendNewEmail(){
        waitAndClick(newMailButton);
    }
    public void fillInEmailSubjectField(String emailSubject){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='ifmail']")));
        driver.findElement(subjectField).sendKeys(emailSubject);
        driver.switchTo().defaultContent();
    }
    public void fillInEmailBodyField(String emailBody){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='ifmail']")));
        driver.findElement(messageBodyField).sendKeys(emailBody);
        driver.switchTo().defaultContent();
    }
    public void fillInEmailRecipientField(String emailRecipient){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='ifmail']")));
        driver.findElement(recipientField).sendKeys(emailRecipient);
        driver.switchTo().defaultContent();
    }
    public void sendEmail(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='ifmail']")));
        driver.findElement(sendMailButton).click();
        driver.switchTo().defaultContent();
    }

    public String getTextFromEmailSendConfirmation(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='ifmail']")));
        WebElement mailConfirmationMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mailSentConfirmationMessege));
        return mailConfirmationMessage.getText();
    }
}

package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CalculatorPricingPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

    private String PAGE_URL = "https://cloud.google.com/products/calculator";

    private By addToEstimateButton = By.xpath("//span[@class='UywwFc-vQzf8d' and text()='Add to estimate']"); //span[contains(text(),'Add to estimate')]
    private By computeEngineTab = By.xpath("//h2[@class='honxjf' and normalize-space()='Compute Engine']");
    private By numberOfInstancesInput = By.xpath("//div[contains(., 'Number of instances')]/ancestor::div[contains(@class, 'QHLF5b')]//input[@type='number']");
    private By operatingSystemSelector = By.xpath("//div[@data-stable-unique-label-id='ucc-26']//div[@class='rHGeGc-aPP78e']");
    private By provisioningModelSelector = By.xpath("//div[text()='Regular']");

    private By machineFamilyListSelector = By.xpath("//div[@role='combobox'][.//*[text()='Machine Family']]");
    private By machineFamilyTypeSelector = By.xpath("//div[@role='combobox'][.//*[text()='Machine Family']]/following-sibling::div//li[@data-value='general-purpose']");

    private By seriesListSelector = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Series']]");
    private By seriesTypeSelector = By.xpath("//li[@role='option'][@data-value='n1']");

    private By machineTypeListSelector = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Machine type']]");
    private By machineTypeSelector = By.xpath("//li[@role='option'][@data-value='n1-standard-8']"); //li[@role='option']//span[normalize-space()='n1-standard-8']//li[@role='option'][@data-value='n1-standard-8']

    private By checkBoxAddGPU = By.xpath("//button[@aria-label='Add GPUs']");
    private By listOfGPU = By.xpath("//div[@role='combobox'][.//*[normalize-space()='GPU Model']]");//span[text()='GPU Model'][2]//div[@role='combobox'][.//*[text()='GPU Model']] //div[@jsname='O1htCb' and .//span[text()='GPU Model']]
    private By typeGPU = By.xpath("//div[.//span[text()='GPU Model']]//li[@data-value='nvidia-tesla-p100']");

    private By numberOfGPUSelector = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Number of GPUs']]");
    private By numberOfGPU = By.xpath("//li[@role='option'][@data-value='1']");

    private By SSDSelector = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Local SSD']]");
    private By SSDType = By.xpath("//ul[@aria-label='Local SSD']//li[@role='option'][@data-value='2']");

    private By regionSelector = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Region']]");
    private By regionType = By.xpath("//ul[@aria-label='Region']//li[@role='option'][@data-value='europe-west4']");

    private By detailedViewButton = By.xpath("//a[@aria-label='Open detailed view']");

    private By estimatedCost = By.xpath("//div[div[normalize-space()='Estimated cost']]//label[contains(text(),'$3,883.62')]");

    private By discountOptionsList = By.xpath("//div[@role='combobox'][.//*[normalize-space()='Committed use discount options']]");
    private By discountOption = By.xpath("//ul[@aria-label='Committed use discount options']//li[@role='option'][@data-value='1-year']");

    private By sendEmailButton = By.xpath("//button[contains(text(),'Send Email')]");

    public CalculatorPricingPage(WebDriver driver) {

        super(driver);
    }

    @Override
    public CalculatorPricingPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("calculatorPricing page opened");
        return this;
    }

    public void createCalculatorPricingPage() {
        GoogleCloudStartPage googlePage = new GoogleCloudStartPage(driver);
        googlePage.openPage();
        googlePage.acceptCookiesIfPresent();
        PrisingMenuSearchPage menuSearchPage = googlePage.openPricingMenuCalculator();
        menuSearchPage.openCalculatorPricingPage();
        scrollAndClick(addToEstimateButton);
        waitAndClick(computeEngineTab);
    }

    public void setNumberOfInstances(String numberOfInstances) {
        waitAndSendKeys(numberOfInstancesInput, numberOfInstances);
    }

    public void selectOperatingSystem() {
        scrollAndClick(operatingSystemSelector);
    }
    public void selectProvisioningModel() {
        scrollAndClick(provisioningModelSelector);
    }

    public void selectMachineFamily() {
        scrollAndClick(machineFamilyListSelector);
        waitAndClick(machineFamilyTypeSelector);
    }

    public void selectSeries(String series) {
        scrollAndClick(seriesListSelector);
        waitAndSendKeys(seriesTypeSelector, series);
        waitAndClick(seriesTypeSelector);
    }

    public void selectMachineType(String machineType) {
          scrollAndClick(machineTypeListSelector);
          waitAndSendKeys(machineTypeListSelector, machineType);

        //Expected should work according this logic:
        /* scrollAndClick(machineTypeListSelector);
        waitAndSendKeys(machineTypeSelector, machineType);
        waitAndClick(machineTypeSelector);*/
    }

    public void selectGPUType(String gpuType) {
        waitAndClick(checkBoxAddGPU);
        waitAndClick(listOfGPU);
        waitAndSendKeys(typeGPU, gpuType);
        waitAndClick(typeGPU);
    }

    public void selectGPUNumber(String gpuNumber) {
        waitAndClick(numberOfGPUSelector);
        waitAndSendKeys(numberOfGPU, gpuNumber);
        waitAndClick(numberOfGPU);
    }

    public void selectLocalSSD(String selectorType) {
        waitAndClick(SSDSelector);
        waitAndSendKeys(SSDType, selectorType);
        waitAndClick(SSDType);
    }

    public void selectRegion(String region) {
        waitAndClick(regionSelector);
        waitAndSendKeys(regionType, region);
        waitAndClick(regionType);
    }

    public void selectDiscountOptions(String option) {
        scrollAndClick(discountOptionsList);
        waitAndSendKeys(discountOption, option);
        waitAndClick(discountOption);
    }

    public void openDetailedView() {
        scrollAndClick(detailedViewButton);
    }
    public String getEstimatedCost(){
        WebElement calcEstimatedCost = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(estimatedCost)));

        return calcEstimatedCost.getText();

    }

    public DetailedViewPage switchToDetailedViewPage(){

        ((JavascriptExecutor)driver).executeScript("window.open()");
        String currentHandle= driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        String detailedViewWindow;
        for(String actual: handles)
        {
            if(!actual.equals(currentHandle))
            {
                detailedViewWindow=actual;
                driver.switchTo().window(detailedViewWindow);
                break;
            }
        }

        return new DetailedViewPage(driver);
    }

    public YopMailSenderPage openYopMaiSenderTab() {

        openAndSwitchToEmailSenderTab("https://yopmail.com/en");

        return new YopMailSenderPage(driver);
    }

}

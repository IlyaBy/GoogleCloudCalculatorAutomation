package tests;

import driver.BaseTest;
import driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CalculatorTest extends BaseTest {

   @Test
   public void CostComparingTest() {

       CalculatorPricingPage calcPage = new CalculatorPricingPage(driver);

       calcPage.createCalculatorPricingPage();
       calcPage.setNumberOfInstances("4");
       calcPage.selectOperatingSystem();
       calcPage.selectProvisioningModel();
       calcPage.selectMachineFamily();
       calcPage.selectSeries("n1");
       calcPage.selectMachineType("n1-standard-8");
       calcPage.selectGPUType("nvidia-tesla-p100");
       calcPage.selectGPUNumber("1");
       calcPage.selectLocalSSD("2x375 GB");
       calcPage.selectRegion("Netherlands (europe-west4)");
       calcPage.selectDiscountOptions("Resource-based CUD - 1 year");
       String calculatorEstimatedCost=calcPage.getEstimatedCost();
       calcPage.openDetailedView();
       DetailedViewPage detailedViewPage = calcPage.switchToDetailedViewPage();
       String detailedViewEstimatedCost=detailedViewPage.getDetailedViewCost();
       Assert.assertEquals(calculatorEstimatedCost, detailedViewEstimatedCost, "Costs do not match between calculator and detailed view");
   }

    @Test
    public void costSendByEmailTest() {
        CalculatorPricingPage calcPage = new CalculatorPricingPage(driver);

        calcPage.createCalculatorPricingPage();
        calcPage.setNumberOfInstances("4");
        calcPage.selectOperatingSystem();
        calcPage.selectProvisioningModel();
        calcPage.selectMachineFamily();
        calcPage.selectSeries("n1");
        calcPage.selectMachineType("n1-standard-8");
        calcPage.selectGPUType("nvidia-tesla-p100");
        calcPage.selectGPUNumber("1");
        calcPage.selectLocalSSD("2x375 GB");
        calcPage.selectRegion("Netherlands (europe-west4)");
        calcPage.selectDiscountOptions("Resource-based CUD - 1 year");

        String calculatorEstimatedCost=calcPage.getEstimatedCost();

        YopMailSenderPage mailSenderPage = calcPage.openYopMaiSenderTab();

        mailSenderPage.generateEmailToSend();
        mailSenderPage.fillInEmailSubjectField("Total estimated cost");
        mailSenderPage.fillInEmailBodyField(calculatorEstimatedCost);

        YopMailRecipientPage mailRecipientPage =  mailSenderPage.openYopMaiRecipientTab();

        mailRecipientPage.generateEmailToCopy();
        String RecipientPageMail= mailRecipientPage.copyEmail();

        mailRecipientPage.returnToYopMailSenderPage();
        mailSenderPage.sendNewEmail();
        mailSenderPage.fillInEmailRecipientField(RecipientPageMail);
        mailSenderPage.sendEmail();
        Assert.assertEquals(mailSenderPage.getTextFromEmailSendConfirmation(), "Your message has been sent", "Message was not sent successfully");
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

public class CheckoutPage {
    WebDriver driver;

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By successMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutDetails(String firstName, String lastName, String zip) throws InterruptedException {
        WebElement fname = driver.findElement(firstNameField);
        WebElement lname = driver.findElement(lastNameField);
        WebElement zipField = driver.findElement(postalCodeField);
        WebElement continueBtn = driver.findElement(continueButton);

        WaitUtils.waitForVisibility(driver, fname,8);
        fname.sendKeys(firstName);
        lname.sendKeys(lastName);
        zipField.sendKeys(zip);
        Thread.sleep(5000);
        WaitUtils.waitForClickability(driver, continueBtn, 8);
        continueBtn.click();
    	Thread.sleep(5000);
    }

    public void completeOrder() throws InterruptedException {
        WebElement finishBtn = driver.findElement(finishButton);
        WaitUtils.waitForClickability(driver, finishBtn, 8);
        finishBtn.click();
        Thread.sleep(5000);
    }

    public void verifyOrderSuccess(String expectedMsg) throws InterruptedException {
        WebElement msg = driver.findElement(successMessage);
        WaitUtils.waitForVisibility(driver, msg, 15);
        String actualMsg = msg.getText();
        Thread.sleep(5000);
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Order confirmation message mismatch.");
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By pageTitle = By.className("title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement user = driver.findElement(usernameField);
        WebElement pass = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        WaitUtils.waitForVisibility(driver, user, 8);
        user.sendKeys(username);
        pass.sendKeys(password);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WaitUtils.waitForClickability(driver, loginBtn, 8);
        loginBtn.click();
    }

    public void verifyLoginSuccess() {
        WebElement title = driver.findElement(pageTitle);
        WaitUtils.waitForVisibility(driver, title, 8);
        String actualTitle = title.getText();
        Assert.assertEquals(actualTitle, "Products", "Login failed or incorrect page title.");
    }
}

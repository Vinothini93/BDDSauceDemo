package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.BaseDriver;

public class SauceSteps {

    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("I launch the SauceDemo application")
    public void i_launch_the_sauce_demo_application() {
        BaseDriver.getDriver().get("https://www.saucedemo.com/");
    }
    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage = new LoginPage(BaseDriver.getDriver());  // driver is always non-null here
        loginPage.login(username, password);
    }

    @Then("I should see the Products page")
    public void i_should_see_the_products_page() {
        loginPage.verifyLoginSuccess();
    }

    @When("I add Sauce Labs Backpack and Sauce Labs Bike Light to the cart")
    public void i_add_items_to_the_cart() throws InterruptedException {
        cartPage = new CartPage(BaseDriver.getDriver());
        cartPage.addItemsToCart();
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() throws InterruptedException {
        cartPage.clickCheckout();
    }

    @And("I enter checkout details with first name {string}, last name {string}, and zip code {string}")
    public void i_enter_checkout_details(String fname, String lname, String zip) throws InterruptedException {
        checkoutPage = new CheckoutPage(BaseDriver.getDriver());
        checkoutPage.fillCheckoutDetails(fname, lname, zip);
    }

    @And("I finish the purchase")
    public void i_finish_the_purchase() throws InterruptedException {
        checkoutPage.completeOrder();
    }

    @Then("I should see the order confirmation message {string}")
    public void i_should_see_confirmation_message(String expectedMessage) throws InterruptedException {
        checkoutPage.verifyOrderSuccess(expectedMessage);
        BaseDriver.quitDriver(); // Close browser after full scenario
    }
}

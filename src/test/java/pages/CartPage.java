package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CartPage {
    WebDriver driver;

    By backpackItem = By.id("add-to-cart-sauce-labs-backpack");
    By bikeLightItem = By.id("add-to-cart-sauce-labs-bike-light");
    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemsToCart() throws InterruptedException {
        WebElement backpack = driver.findElement(backpackItem);
        WebElement bike = driver.findElement(bikeLightItem);
        WebElement cart = driver.findElement(cartIcon);

        WaitUtils.waitForClickability(driver, backpack, 8);
        backpack.click();
        Thread.sleep(5000);
        WaitUtils.waitForClickability(driver, bike, 8);
        bike.click();
        Thread.sleep(5000);
        WaitUtils.waitForClickability(driver, cart, 8);
        cart.click();
        Thread.sleep(5000);
    }

    public void clickCheckout() throws InterruptedException {
        WebElement checkoutBtn = driver.findElement(checkoutButton);
        WaitUtils.waitForClickability(driver, checkoutBtn, 8);
        checkoutBtn.click();
        Thread.sleep(5000);
    }
}

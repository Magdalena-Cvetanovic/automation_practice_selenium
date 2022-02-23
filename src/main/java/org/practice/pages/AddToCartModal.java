package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class AddToCartModal extends WebElementUtils {

    @FindBy(xpath = "//span[@title ='Continue shopping']")
    WebElement continueShoppingBtn;
    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedToCheckoutBtn;
    @FindBy(xpath = "//div[contains(@class,'layer_cart_product')]/h2")
    WebElement successMessage;


    public AddToCartModal(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getSuccessMessage() {
        tryAndCatchText(successMessage);
        return successMessage.getText();
    }

    public void continueShopping() {
        click(continueShoppingBtn);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutBtn);
    }
}

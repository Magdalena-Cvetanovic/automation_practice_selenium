package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class AddToCartModal extends WebElementUtils {

    @FindBy(xpath = "//i[contains(@class, 'icon-chevron-left left')]")
    WebElement continueShoppingBtn;
    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedToCheckoutBtn;
    @FindBy(id = "layer_cart_product_attributes")
    WebElement colorAndSize;
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    WebElement successMessage;
    @FindBy(xpath = "//span[contains(@title, 'Close window')]")
    WebElement closeWindowBtn;


    public AddToCartModal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        tryAndCatchText(successMessage);
        return successMessage.getText();
    }

    public String getColorAndSize() {
        tryAndCatchText(colorAndSize);
        return colorAndSize.getText();
    }

    public void continueShopping() {
        click(continueShoppingBtn);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public void closeWindow() {
        click(closeWindowBtn);
    }


}

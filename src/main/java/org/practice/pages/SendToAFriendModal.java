package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class SendToAFriendModal extends WebElementUtils {

    @FindBy(id = "friend_name")
    WebElement friendNameInputField;
    @FindBy(id = "friend_email")
    WebElement friendEmailInputField;
    @FindBy(id = "sendEmail")
    WebElement sendEmailBtn;
    @FindBy(linkText = "Cancel")
    WebElement cancelBtn;
    @FindBy(xpath = "//a[title='Close']")
    WebElement closeBtn;
    @FindBy(xpath = "//input[contains(@value,'OK')]")
    WebElement okBtn;
    @FindBy(xpath = "//div[contains(@class, 'fancybox-inner')]/p")
    WebElement successMessage;


    public SendToAFriendModal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillOutName(String text) {
        sendKeys(friendNameInputField, text);
    }

    public void fillOutEmail(String text) {
        sendKeys(friendEmailInputField, text);
    }

    public void send() {
        sendEmailBtn.click();
    }

    public void cancel() {
        cancelBtn.click();
    }

    public void close() {
        click(closeBtn);
    }

    public void clickOk() {
        click(okBtn);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

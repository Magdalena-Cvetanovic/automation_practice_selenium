package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.helpers.WebElementUtils;

public class ShoppingCartPage extends WebElementUtils {

    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[2]")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]")
    private WebElement proceedToCheckOutBtn;
    @FindBy(id = "email_create")
    private WebElement newEmailAddressInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createBtn;
    @FindBy(id = "email")
    private WebElement existingEmailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;
    @FindBy(id = "id_address_delivery")
    private WebElement deliveryAddressSelect;
    @FindBy(xpath = "//*[@id='center_column']/form/div/p/a")
    private WebElement addANewAddress;
    @FindBy(xpath = "//*[@id='center_column']/form/p/button")
    private WebElement addressStepProceedBtn;
    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;
    @FindBy(xpath = "//*[@id='form']/p/button")
    private WebElement shippingStepProceedBtn;
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    private WebElement payByBankWireOption;
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
    private WebElement payByCheckOption;
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement confirmOrderBtn;
    @FindBy(xpath = "//p[@class ='alert alert-success']")
    private WebElement successCheckMessage;
    @FindBy(xpath = "//strong[@class = 'dark']")
    private WebElement successBankMessage;
    @FindBy(xpath = "//*[@id='columns']/div[1]/span[2]")
    private WebElement navigationStep;
    @FindBy(xpath = "//div[contains(@class,'box')]")
    private WebElement paymentInformation;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getStep1() {
        String step1 = tryAndCatchText(navigationStep);
        return step1;
    }

    public Boolean userIsOnStep1(String step) {
        Boolean step1 = false;
        if (getStep1().contains(step)) {
            step1 = true;
        }
        return step1;
    }

    public String getStep2() {
        String step2 = tryAndCatchText(navigationStep);
        return step2;
    }

    public Boolean userIsOnStep2(String step) {
        Boolean step2 = false;
        if (getStep2().contains(step)) {
            step2 = true;
        }
        return step2;
    }

    public String getStep3() {
        String step3 = tryAndCatchText(navigationStep);
        return step3;
    }

    public Boolean userIsOnStep3(String step) {
        Boolean step3 = false;
        if (getStep3().contains(step)) {
            step3 = true;
        }
        return step3;
    }

    public String getStep4() {
        String step4 = tryAndCatchText(navigationStep);
        return step4;
    }

    public Boolean userIsOnStep4(String step) {
        Boolean step4 = false;
        if (getStep4().contains(step)) {
            step4 = true;
        }
        return step4;
    }

    public String getStep5() {
        String step5 = tryAndCatchText(navigationStep);
        return step5;
    }

    public Boolean userIsOnStep5(String step) {
        Boolean step5 = false;
        if (getStep5().contains(step)) {
            step5 = true;
        }
        return step5;
    }

    public void clickProceedToCheckoutStep1() {
        click(proceedToCheckOutBtn);
    }

    private void inputNewEmail() {
        sendKeys(newEmailAddressInput, emailGenerator());
    }

    private void clickCreateNewAccount() {
        click(createBtn);
    }

    public void createANewAccount() {
        inputNewEmail();
        clickCreateNewAccount();
    }

    public void clickProceedToCheckoutStep3() {
        click(addressStepProceedBtn);
    }

    public void clickAgreeTermsOfService() {
        moveAndClick(termsOfServiceCheckbox);
    }

    public void clickProceedToCheckoutStep4() {
        click(shippingStepProceedBtn);
    }

    public void payByBankWire() {
        click(payByBankWireOption);
    }

    public void payByCheck() {
        click(payByCheckOption);
    }

    public void choosePaymentMethod() {
        if (getRandomNumber() == 1) {
            payByBankWire();
        } else {
            payByCheck();
        }
    }

    public void clickConfirmOrder() {
        click(confirmOrderBtn);
    }

    private String getCorrectSuccessMsg() {
        String info = tryAndCatchText(paymentInformation);
        String successMsg = "";
        if (info.contains("bank wire")) {
            successMsg = tryAndCatchText(successBankMessage);
        } else {
            successMsg = tryAndCatchText(successCheckMessage);
        }
        return successMsg;
    }

    public Boolean orderIsComplete(String successMsg) {
        Boolean complete = false;
        if (getCorrectSuccessMsg().contains(successMsg)) {
            complete = true;
        }
        return complete;
    }
}


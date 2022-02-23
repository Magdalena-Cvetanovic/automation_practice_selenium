package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.practice.helpers.WebElementUtils;

import java.util.List;

public class CheckoutPage extends WebElementUtils {
    @FindAll({
            @FindBy (xpath = "//button[@type = 'submit']/span[contains(text(), 'Proceed to checkout')]"),
            @FindBy(xpath = "//button[@type = 'submit']/span[contains(text(), 'I confirm my order')]" )
    })
    private WebElement nextBtn;
    @FindBy(id = "email_create")
    private WebElement newEmailAddressInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountBtn;
    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;
    @FindBy(xpath = "//div[@id='HOOK_PAYMENT']/div/div/p/a")
    private List<WebElement> paymentOptions;
    @FindBy(xpath = "//div[@class ='box'][contains(.,'bank wire' or .,'check')")
    private WebElement successMsg;
    @FindBy(xpath = "//span[@class = 'navigation_page]")
    private WebElement navigationStep;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void clickProceed(){
        click(nextBtn);
    }
    private void inputNewEmail() {
        sendKeys(newEmailAddressInput, emailGenerator());
    }

    private void clickCreateNewAccount() {
        click(createAnAccountBtn);
    }

    public void createANewAccount() {
        inputNewEmail();
        clickCreateNewAccount();
    }

    public boolean userIsOnTheNextStep(String step){
        boolean correctStep = false;
        if(navigationStep.getText().equalsIgnoreCase(step)){
            correctStep = true;
        }else{
            System.out.println("User is on the wrong step");
        }
        return correctStep;
    }

    public void clickAgreeTermsOfService() {
        moveAndClick(termsOfServiceCheckbox);
    }

    public void choosePaymentOption(String payment){
        for (WebElement option : paymentOptions){
            if(option.getText().contains(payment)){
                click(option);
            }else {
                System.out.println("No such payment option. Enter bank wire or check to choose a payment option.");
            }
        }
    }
    private String getCorrectSuccessMsg() {
        String info = tryAndCatchText(successMsg);
        String success = "";
        if (info.contains("bank wire")) {
            success = tryAndCatchText(successMsg);
        } else if(info.contains("check")) {
            success = tryAndCatchText(successMsg);
        }
        return success;
    }

    public Boolean orderIsComplete(String successMsg) {
        Boolean complete = false;
        if (getCorrectSuccessMsg().contains(successMsg)) {
            complete = true;
        }
        return complete;
    }
}

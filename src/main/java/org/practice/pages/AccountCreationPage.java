package org.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.practice.helpers.WebElementUtils;

public class AccountCreationPage extends WebElementUtils {

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderM;
    @FindBy(id = "uniform-id_gender2")
    private WebElement genderF;
    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement daySelect;
    @FindBy(id = "months")
    private WebElement monthsSelect;
    @FindBy(id = "years")
    private WebElement yearsSelect;
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "company")
    private WebElement companyInput;
    @FindBy(id = "address1")
    private WebElement address1Input;
    @FindBy(id = "address2")
    private WebElement address2Input;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    private WebElement stateSelect;
    @FindBy(id = "postcode")
    private WebElement postCodeInput;
    @FindBy(id = "id_country")
    private WebElement countrySelect;
    @FindBy(id = "other")
    private WebElement additionalInfoInput;
    @FindBy(id = "phone")
    private WebElement homePhoneInput;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;
    @FindBy(id = "alias")
    private WebElement aliasInput;
    @FindBy(id = "submitAccount")
    private WebElement registerBtn;


    public AccountCreationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void chooseDay(String day) {
        Select days = new Select(daySelect);
        days.selectByValue(day);
    }

    private void chooseMonth(String month) {
        Select days = new Select(monthsSelect);
        days.selectByValue(month);
    }

    private void chooseYear(String year) {
        Select days = new Select(yearsSelect);
        days.selectByValue(year);
    }

    private void chooseState(String state) {
        Select states = new Select(stateSelect);
        states.selectByVisibleText(state);
    }

    public void fillOutForm(String firstname, String lastname, String password,
                            String day, String month, String year,
                            String company, String address1, String address2,
                            String city, String state, String postCode,
                            String mobilePhone, String alias) {
        click(genderF);
        sendKeys(customerFirstNameInput, firstname);
        sendKeys(customerLastNameInput, lastname);
        sendKeys(passwordInput, password);
        chooseDay(day);
        chooseMonth(month);
        chooseYear(year);
        sendKeys(companyInput, company);
        sendKeys(address1Input, address1);
        sendKeys(address2Input, address2);
        sendKeys(cityInput, city);
        chooseState(state);
        sendKeys(postCodeInput, postCode);
        sendKeys(mobilePhoneInput, mobilePhone);
        sendKeys(aliasInput, alias);
        click(registerBtn);
    }


}

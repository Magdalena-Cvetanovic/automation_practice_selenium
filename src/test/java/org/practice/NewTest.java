package org.practice;

import org.practice.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest extends BasicTest{

    @Test(priority = 1)
    public void shouldSearchAndViewProduct() {
        HomePage hp = new HomePage(driver);
        hp.search("Shirt");
        SearchResultPage srp = new SearchResultPage(driver);
        String url = driver.getCurrentUrl();
        srp.viewProduct();
        Assert.assertFalse(driver.getCurrentUrl().equals(url));
    }
    @Test(priority = 2)
    public void shouldRecommendToAFriend(){
        ProductPage pp = new ProductPage(driver);
        pp.sendToAFriend();
        SendToAFriendModal stafm = new SendToAFriendModal(driver);
        stafm.fillOutName("magi");
        stafm.fillOutEmail("magi@mailinator.com");
        stafm.clickSend();
        Assert.assertTrue(stafm.getSuccessMessage().contains("successfully"));
        stafm.clickOk();
    }
    @Test(priority = 3)
    public void shouldAddToCartAndContinueShopping(){
        ProductPage pp = new ProductPage(driver);
        pp.chooseColor("blue");
        pp.chooseSize("m");
        pp.addToCart();
        AddToCartModal atcm = new AddToCartModal(driver);
        Assert.assertTrue(atcm.getSuccessMessage().contains("successfully"));
        atcm.continueShopping();
    }
    @Test(priority = 4)
    public void shouldAddTwoDiscountedProductsToCompareInDresses() {
        Navigation nav = new Navigation(driver);
        nav.clickNavLink("dresses");
        SearchResultPage srp = new SearchResultPage(driver);
        srp.findProductWithDiscount();
        Assert.assertTrue(srp.twoProductsAdded());
        srp.clickCompareBtn();
    }
    @Test(priority = 5)
    public void shouldChooseBiggerDiscountAndGoToCheckout(){
        AddToCartModal atcm = new AddToCartModal(driver);
        ProductComparisonPage pcp = new ProductComparisonPage(driver);
        pcp.chooseProductWithDiscountOf20Percent();
        Assert.assertTrue(atcm.getSuccessMessage().contains("successfully"));
        atcm.proceedToCheckout();
    }
    @Test(priority = 6)
    public void shouldCompleteCheckout() {
        CheckoutPage cp = new CheckoutPage(driver);
        String step1 = properties.getProperty("step1Name");
        String step2 = properties.getProperty("step2Name");
        String step3 = properties.getProperty("step3Name");
        String step4 = properties.getProperty("step4Name");
        String step5 = properties.getProperty("step5Name");
        String bankPayment = properties.getProperty("bankPayment");
        String step6 = properties.getProperty("step6Name");
        sa.assertTrue(cp.userIsOnTheNextStep(step1));
        cp.scrollDownJsByMore();
        cp.clickProceedToCheckout();
        sa.assertTrue(cp.userIsOnTheNextStep(step2));
        cp.createANewAccount();
        AccountCreationPage acp = new AccountCreationPage(driver);
        String firstname = properties.getProperty("firstName");
        String lastname = properties.getProperty("lastName");
        String password = properties.getProperty("pass");
        String day = properties.getProperty("day");
        String month = properties.getProperty("month");
        String year = properties.getProperty("year");
        String company = properties.getProperty("companyName");
        String address1 = properties.getProperty("streetName");
        String address2 = properties.getProperty("streetNo");
        String city = properties.getProperty("cityName");
        String state = properties.getProperty("stateName");
        String postCode = properties.getProperty("postalCode");
        String mobilePhone = properties.getProperty("mobilePhone");
        String alias = properties.getProperty("aliasAddress");
        acp.fillOutForm("m", firstname, lastname, password, day, month, year, company, address1, address2, city, state, postCode, mobilePhone, alias);
        sa.assertTrue(cp.userIsOnTheNextStep(step3));
        cp.clickProceed();
        sa.assertTrue(cp.userIsOnTheNextStep(step4));
        cp.clickAgreeTermsOfService();
        cp.clickProceed();
        sa.assertTrue(cp.userIsOnTheNextStep(step5));
        cp.choosePaymentOption("bank");
        sa.assertTrue(cp.userIsOnTheNextStep(bankPayment));
        cp.clickProceed();
        sa.assertTrue(cp.userIsOnTheNextStep(step6));
        sa.assertAll();
    }
}

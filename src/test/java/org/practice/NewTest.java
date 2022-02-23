package org.practice;

import org.practice.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest extends BasicTest{

    @Test
    public void shouldSearchAndViewProduct(){
//        HomePage hp = new HomePage(driver);
//        hp.search("Shirt");
        SearchResultPage srp = new SearchResultPage(driver);
//        srp.viewProduct();
//        ProductPage pp = new ProductPage(driver);
//        pp.sendToAFriend();
//        SendToAFriendModal stafm = new SendToAFriendModal(driver);
//        stafm.fillOutName("magi");
//        stafm.fillOutEmail("magi@mailinator.com");
//        stafm.clickSend();
//        stafm.getSuccessMessage();
//        stafm.clickOk();
//        pp.chooseColor("blue");
//        pp.chooseSize("m");
//        pp.addToCart();
        AddToCartModal atcm = new AddToCartModal(driver);
//        atcm.continueShopping();
        Navigation nav = new Navigation(driver);
        nav.clickNavLink("dresses");
        srp.findProductWithDiscount();
        Assert.assertTrue(srp.twoProductsAdded());
        srp.clickCompareBtn();
        ProductComparisonPage pcp = new ProductComparisonPage(driver);
        pcp.chooseProductWithDiscountOf20Percent();
        atcm.proceedToCheckout();
        ShoppingCartPage scp = new ShoppingCartPage(driver);
        scp.clickProceedToCheckout();
        CheckoutPage cp = new CheckoutPage(driver);
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
        acp.fillOutForm(firstname, lastname, password, day, month, year, company, address1, address2, city, state, postCode, mobilePhone, alias);
        String step1 = properties.getProperty("step1Name");
        String step2 = properties.getProperty("step2Name");
        String step3 = properties.getProperty("step3Name");
        String step4 = properties.getProperty("step4Name");
        String step5 = properties.getProperty("step5Name");



        Assert.assertTrue(cp.orderIsComplete(properties.getProperty("orderCompleteMsg")));



    }
}

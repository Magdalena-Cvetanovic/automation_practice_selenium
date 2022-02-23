//package org.practice  ;
//
//import org.practice.pages.*;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class ShoppingTest extends BasicTest {
//
//    @Test(priority = 1)
//    public void search() {
//
//        String searchParam = properties.getProperty("searchParam");
//        HomePage hp = new HomePage(driver);
//        hp.search(searchParam);
//        SearchResultPage srp = new SearchResultPage(driver);
//
//        sa.assertTrue(driver.getCurrentUrl().contains(searchParam));
//        sa.assertTrue(srp.getSearchResultText().contains(searchParam
//                .toUpperCase()));
//        sa.assertAll();
//
//    }
//
//    @Test(priority = 2)
//    public void openProduct() {
//
//        String currentUrl = driver.getCurrentUrl();
//        SearchResultPage srp = new SearchResultPage(driver);
//        srp.scrollDownJsByMore();
//        srp.clickProduct();
//        Assert.assertNotEquals(driver.getCurrentUrl(), currentUrl);
//
//
//    }
//
//    @Test(priority = 3)
//    public void recommendToFriend() {
//
//        ProductPage pp = new ProductPage(driver);
//        pp.sendToAFriend();
//        SendToAFriendModal stafm = new SendToAFriendModal(driver);
//        stafm.fillOutName(properties.getProperty("exampleName"));
//        stafm.fillOutEmail(properties.getProperty("exampleEmail"));
//        stafm.send();
//        Assert.assertTrue(stafm.getSuccessMessage().equalsIgnoreCase(properties.getProperty("successMessage")));
//        stafm.clickOk();
//    }
//
//    @Test(priority = 4)
//    public void shop() throws InterruptedException {
//        String color = properties.getProperty("color");
//        String size = properties.getProperty("size");
//        String successMessage = properties.getProperty("successMessage1");
//
//        ProductPage pp = new ProductPage(driver);
//        pp.chooseColor(properties.getProperty("color"));
//        pp.chooseSize(properties.getProperty("size"));
//        pp.addToCart();
//
//        AddToCartModal atcm = new AddToCartModal(driver);
//        String actualSuccessMessage = atcm.getSuccessMessage();
//        Thread.sleep(1000);
//        sa.assertTrue(actualSuccessMessage.contains(successMessage));
//        sa.assertTrue(atcm.getColorAndSize().contains(color));
//        sa.assertTrue(atcm.getColorAndSize().contains(size));
//        sa.assertAll();
//
//    }
//
//    @Test(priority = 5)
//    public void addToCompareSection() throws InterruptedException {
//        AddToCartModal atcm = new AddToCartModal(driver);
//        atcm.continueShopping();
//        String dressType = properties.getProperty("dressType");
//        Navigation nav = new Navigation(driver);
//        nav.clickDresses();
//        SearchResultPage srp = new SearchResultPage(driver);
//        srp.scrollDownJsByMore();
//        srp.clickAddToCompare(dressType);
//        Thread.sleep(2000);
//        Assert.assertTrue(srp.productsAdded());
//    }
//
//    @Test(priority = 6)
//    public void goToCompareSection() throws InterruptedException {
//
//        SearchResultPage srp = new SearchResultPage(driver);
//        String currentUrl = driver.getCurrentUrl();
//        srp.clickCompareBtn();
//        sa.assertFalse(currentUrl.equals(driver.getCurrentUrl()));
//        ProductComparisonPage pcp = new ProductComparisonPage(driver);
//        sa.assertTrue(pcp.pageIsComparison(properties.getProperty("pageNameComparison").toUpperCase()));
//        pcp.scrollDownJsByLess();
//        pcp.chooseProduct();
//        String message = properties.getProperty("successMessage1");
//        AddToCartModal atcm = new AddToCartModal(driver);
//        sa.assertTrue(atcm.getSuccessMessage().contains(message));
//        sa.assertAll();
//    }
//
//    @Test(priority = 7)
//    public void checkoutProcess() {
//        AddToCartModal atcm = new AddToCartModal(driver);
//        atcm.proceedToCheckout();
//        ShoppingCartPage scp = new ShoppingCartPage(driver);
//        String step1 = properties.getProperty("step1Name");
//        sa.assertTrue(scp.userIsOnStep1(step1));
//        scp.clickProceedToCheckoutStep1();
//        String step2 = properties.getProperty("step2Name");
//        sa.assertTrue(scp.userIsOnStep2(step2));
//        scp.createANewAccount();
//        AccountCreationPage acp = new AccountCreationPage(driver);
//        String firstname = properties.getProperty("firstName");
//        String lastname = properties.getProperty("lastName");
//        String password = properties.getProperty("pass");
//        String day = properties.getProperty("day");
//        String month = properties.getProperty("month");
//        String year = properties.getProperty("year");
//        String company = properties.getProperty("companyName");
//        String address1 = properties.getProperty("streetName");
//        String address2 = properties.getProperty("streetNo");
//        String city = properties.getProperty("cityName");
//        String state = properties.getProperty("stateName");
//        String postCode = properties.getProperty("postalCode");
//        String mobilePhone = properties.getProperty("mobilePhone");
//        String alias = properties.getProperty("aliasAddress");
//        String successMsg = properties.getProperty("orderCompleteMsg");
//        acp.fillOutForm(firstname, lastname, password, day, month, year, company, address1, address2, city, state, postCode, mobilePhone, alias);
//        String step3 = properties.getProperty("step3Name");
//        sa.assertTrue(scp.userIsOnStep3(step3));
//        scp.clickProceedToCheckoutStep3();
//        String step4 = properties.getProperty("step4Name");
//        sa.assertTrue(scp.userIsOnStep4(step4));
//        scp.scrollDownJsByLess();
//        scp.clickAgreeTermsOfService();
//        scp.clickProceedToCheckoutStep4();
//        String step5 = properties.getProperty("step5Name");
//        sa.assertTrue(scp.userIsOnStep5(step5));
//        scp.scrollDownJsByLess();
//        scp.choosePaymentMethod();
//        scp.scrollDownJsByLess();
//        scp.clickConfirmOrder();
//        scp.scrollDownJsByLess();
//        sa.assertTrue(scp.orderIsComplete(successMsg));
//        sa.assertAll();
//
//
//    }
//
//}

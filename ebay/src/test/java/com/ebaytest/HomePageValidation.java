package com.ebaytest;

import com.base.TestBase;
import com.ebay.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageValidation extends TestBase {
    //@Test(dataProviderClass =DataProviders.class,dataProvider = "searchData")
    public void validateUserBeingAbleToTypeOnSearchBar(String data) {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.typeOnSearchBar(data);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToClickOnSignInButton() {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.clickOnSignButton();
    }
    @Test
    public void validateUserBeingAbleToClickOnAddCart() {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.clickOnAddCart();
    }


}

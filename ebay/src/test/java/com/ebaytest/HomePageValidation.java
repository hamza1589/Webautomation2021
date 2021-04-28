package com.ebaytest;

import com.base.TestBase;
import com.ebay.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageValidation extends TestBase {
    @Test(enabled = false)
    public void validateUserBeingAbleToTypeOnSearchBar() {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.typeOnSearchBar();
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

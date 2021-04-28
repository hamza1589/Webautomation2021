package com.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(id = "gh-ac")
    private WebElement searchBar;

    @FindBy(linkText = "Sign in")
    private WebElement signbutton;

    @FindBy(css = ".gh-cart-icon")
    private WebElement addcart;

    public void clickOnSearchBar() {
        searchBar.click();
    }

    public void typeOnSearchBar() {
        searchBar.sendKeys("java books");
    }

    public void clickOnSignButton() {
        signbutton.click();

    }
    public void clickOnAddCart(){
        addcart.click();
    }

}

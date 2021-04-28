package com.ebay.pages;

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

    public void typeOnSearchBar(String data) {
        searchBar.sendKeys("data");
    }

    public void clickOnSignButton() {
        signbutton.click();

    }
    public void clickOnAddCart(){
        addcart.click();
    }

}

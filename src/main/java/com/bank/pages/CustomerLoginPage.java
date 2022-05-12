package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomerName;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public void searchingCustomerNameFromDropDown(String text) {
        Reporter.log("Searching and Selecting Customer name : " + text + " from drop down list " + searchCustomerName.toString());
        selectByVisibleTextFromDropDown(searchCustomerName, text);
    }

    public void clickOnLoginButton(){
        Reporter.log("Clicking on Login Button : " + loginButton.toString());
        clickOnElement(loginButton);
    }








}

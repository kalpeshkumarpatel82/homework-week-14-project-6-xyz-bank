package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomerName;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement selectCurrency;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public void searchingCustomerNameFromDropDown(String text) {
        Reporter.log("Searching and Selecting Customer name : " + text + " from drop down list " + searchCustomerName.toString());
        selectByVisibleTextFromDropDown(searchCustomerName, text);
    }

    public void selectingCurrencyFromDropDown(String text) {
        Reporter.log("Selecting Currency  : " + text + " from drop down list " + selectCurrency.toString());
        selectByVisibleTextFromDropDown(selectCurrency, text);
    }

    public void clickingOnProcessButton() {
        Reporter.log("Clicking on Process Button : " + processButton.toString());
        clickOnElement(processButton);
    }


    public String accountAddedAlertConfirmPopup() {
        Reporter.log("Getting Confirm Message of Account Added Successfully from Alert Pop-up Passing to return ");
        switchToAlert();
        return getTextFromAlert();
    }

    public void acceptingAccountAddedAlertPopup() {
        try {
            switchToAlert();
            acceptAlert();
        } catch (Exception e){
            System.out.println("Alert not handled");
        }
        //acceptAlert();
        Reporter.log("Accepting alert popup of Account Added Successfully");
    }


}

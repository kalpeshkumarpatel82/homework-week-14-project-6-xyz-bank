package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccount;
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[3]")
    WebElement customers;

    public void clickOnAddCustomerButton(){
        Reporter.log("Clicking on Add Customer Button : " + addCustomer.toString());
        clickOnElement(addCustomer);
    }

    public void clickOnOpenAccountButton() {
        Reporter.log("Clicking on Open Account Button : " + openAccount.toString());
        clickOnElement(openAccount);
    }

    public void clickOnCustomersButton() {
        Reporter.log("Clicking on Customers Button : " + customers.toString());
        clickOnElement(customers);
    }




}

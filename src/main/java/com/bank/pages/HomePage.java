package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankMangerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    public void clickOnBankManagerButton() {
        Reporter.log("Clicking on BankManager Login Button : " + bankMangerLoginButton.toString());
        clickOnElement(bankMangerLoginButton);
        }

    public void clickOnCustomerButton() {
        Reporter.log("Clicking on Customer Login Button : " + bankMangerLoginButton.toString());
        clickOnElement(customerLoginButton);
    }

    public void clickOnHomeButton() {
        Reporter.log("Clicking on Home Button : " + homeButton.toString());
        clickOnElement(homeButton);
    }

//    public String getParentWindows(){
//        return getParentWindows();
//    }
}

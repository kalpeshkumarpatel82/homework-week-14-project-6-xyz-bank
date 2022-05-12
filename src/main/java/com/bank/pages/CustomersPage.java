package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//strong/span[@class='fontBig ng-binding']")
    WebElement welcomeHeader;

    public void clickingOnLogoutButton(){
        Reporter.log("Clicking on Logout Button : " + logoutButton.toString());
        clickOnElement(logoutButton);
    }

    public String gettingTextOfLogoutButton(){
        Reporter.log("Getting text from Logout Button : " + logoutButton.toString());
        return getTextFromElement(logoutButton);
    }

    public String gettingTextOfWelcomeMessage(){
        Reporter.log("Getting text from WelCome Message : " + welcomeHeader.toString());
        return getTextFromElement(welcomeHeader);
    }


}

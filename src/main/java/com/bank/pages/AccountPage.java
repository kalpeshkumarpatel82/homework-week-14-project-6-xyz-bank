package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement depositTab;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountDeposit;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement depositButton;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawTab;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountWithdraw;

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessful;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement withdrawSuccessful;


    public void clickingOnDepositTab() {
        Reporter.log("Clicking on Deposit Tab : " + depositTab.toString());
        clickOnElement(depositTab);
    }

    public void sendingAmountToDeposit(String text) {
        Reporter.log("Sending Amount to Deposit : " + text + " to " + amountDeposit.toString());
        sendTextToElement(amountDeposit,text);
    }

    public void clickingOnDepositButton() {
        Reporter.log("Clicking on Deposit Button : " + depositButton.toString());
        clickOnElement(depositButton);
    }

    public void clickingOnWithdrawTab() {
        Reporter.log("Clicking on Withdraw Tab : " + withdrawTab.toString());
        clickOnElement(withdrawTab);
    }

    public void sendingAmountToWithDraw(String text) {
        Reporter.log("Sending Amount to Withdraw : " + text + " to " + amountWithdraw.toString());
        sendTextToElement(amountWithdraw,text);
    }

    public void clickingOnWithdrawButton() {
        Reporter.log("Clicking on Withdraw Button : " + withdrawButton.toString());
        clickOnElement(withdrawButton);
    }

    public String gettingTextDepositConfirmation() {
        Reporter.log("Getting text from Deposit Confirm Message : " + depositSuccessful.toString());
        return getTextFromElement(depositSuccessful);
    }

    public String gettingTextWithdrawConfirmation() {
        Reporter.log("Getting text from Withdraw Confirm Message : " + withdrawSuccessful.toString());
        return getTextFromElement(withdrawSuccessful);
    }
}

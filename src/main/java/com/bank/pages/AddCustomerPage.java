package com.bank.pages;
/* 
 Created by Kalpesh Patel
 */

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement firstNameField;
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement lastNameField;
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]")
    WebElement postcodeField;
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement addCustomerButton;

    public void enterDataToFirstNameField(String text) {
        Reporter.log("Sending First Name to : " + text + " to " + firstNameField.toString());
        sendTextToElement(firstNameField, text);
    }

    public void enterDataToLastNameField(String text) {
        Reporter.log("Sending Last Name to : " + text + " to " + lastNameField.toString());
        sendTextToElement(lastNameField, text);
    }

    public void enterDataToPostcodeField(String text) {
        Reporter.log("Sending Postcode to : " + text + " to " + postcodeField.toString());
        sendTextToElement(postcodeField, text);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Clicking on Add Customer Button : " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
    }

    public String customerAddedAlertConfirmPopup(){
        Reporter.log("Getting Confirm Message of Customer Added Successfully from Alert Pop-up Passing to return " );
        return getTextFromAlert();
    }

    public void acceptingCustomerAddedAlertPopup() {
        Reporter.log("Accepting alert popup of Customer Added Successfully ");
        acceptAlert();
    }

}

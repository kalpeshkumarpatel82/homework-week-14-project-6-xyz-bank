package com.bank.testsuite;
/* 
 Created by Kalpesh Patel
 */

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BankTest extends TestBase {
    HomePage homePage;
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        openAccountPage = new OpenAccountPage();

    }

    //1
    @Test(priority = 0, groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully()  {
        homePage.clickOnBankManagerButton();
        bankManagerLoginPage.clickOnAddCustomerButton();
        addCustomerPage.enterDataToFirstNameField("Suresh");
        addCustomerPage.enterDataToLastNameField("Modi");
        addCustomerPage.enterDataToPostcodeField("750002");
        addCustomerPage.clickOnAddCustomerButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addCustomerPage.customerAddedAlertConfirmPopup().substring(0, 27), "Customer added successfully", "Failed to Add customer");
        softAssert.assertAll();
        addCustomerPage.acceptingCustomerAddedAlertPopup();
        homePage.clickOnHomeButton();
    }

    //2
    @Test(priority = 1, groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully()  {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerButton();
        bankManagerLoginPage.clickOnOpenAccountButton();
        openAccountPage.searchingCustomerNameFromDropDown("Suresh Modi");
        openAccountPage.selectingCurrencyFromDropDown("Pound");
        openAccountPage.clickingOnProcessButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(openAccountPage.accountAddedAlertConfirmPopup().substring(0, 29), "Account created successfully ", "Failed to Add Account");
        openAccountPage.acceptingAccountAddedAlertPopup();
        softAssert.assertAll();
        homePage.clickOnHomeButton();
    }

    //3
    @Test(priority = 2, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerButton();
        customerLoginPage.searchingCustomerNameFromDropDown("Suresh Modi");
        customerLoginPage.clickOnLoginButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(customersPage.gettingTextOfWelcomeMessage(), "Suresh Modi", "Failed to navigate to Customer Page");
        softAssert.assertEquals(customersPage.gettingTextOfLogoutButton(), "Logout", "Failed to navigate to Customer Page");
        softAssert.assertAll();
        customersPage.clickingOnLogoutButton();
    }

    //4
    @Test(priority = 3, groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerButton();
        customerLoginPage.searchingCustomerNameFromDropDown("Suresh Modi");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickingOnDepositTab();
        accountPage.sendingAmountToDeposit("100");
        accountPage.clickingOnDepositButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(accountPage.gettingTextDepositConfirmation(), "Deposit Successful", "Failed to Deposit");
        softAssert.assertAll();
    }

    //5
    @Test(priority = 4, groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerButton();
        customerLoginPage.searchingCustomerNameFromDropDown("Suresh Modi");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickingOnWithdrawTab();
        accountPage.sendingAmountToWithDraw("50");
        accountPage.clickingOnWithdrawButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(accountPage.gettingTextWithdrawConfirmation(), "Transaction successful", "Failed to Withdraw");
        softAssert.assertAll();
    }
}

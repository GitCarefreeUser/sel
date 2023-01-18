package com.eurotech.tests.extentReport;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongUsernameTest() {
        // Name of the Test
        extentLogger =report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Enter wrong username");
        loginPage.emailInput.sendKeys("eurotech@gmail");

        extentLogger.info("Enter Teacher Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login Button");
        loginPage.loginBtnLoginPage.click();

        String expectedUrl ="";
        String actualText= dashboardPage.alertMessage.getText();

        Assert.assertEquals(actualText,expectedUrl);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.alertMessage.getText());

    }

    @Test
    public void wrongPassword() {
        //Name of the Test
        extentLogger=report.createTest("Negative Login Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email = ConfigurationReader.get("usernameTeacher");
//        String password = ConfigurationReader.get("passwordTeacher");

        loginPage.emailInput.sendKeys(email);
        extentLogger.info("Entering valid username");
        loginPage.passwordInput.sendKeys("test12345!");
        extentLogger.info("Entering password username");
        loginPage.loginBtnLoginPage.click();
        extentLogger.info("Click on login button");
        String expectedText = "Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
        String actualText = dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText,expectedText);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());
    }
}

package com.eurotech.tests.ExamplesTestBase;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class LoginPositiveTest extends TestBase {
    @Test
    public void login() {
        LoginPage lp = new LoginPage();
        lp.username.sendKeys(ConfigurationReader.get("username"));
        lp.password.sendKeys(ConfigurationReader.get("password"));
        lp.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));


    }
}

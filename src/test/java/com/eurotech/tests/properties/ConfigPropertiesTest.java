package com.eurotech.tests.properties;

import com.eurotech.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigPropertiesTest {
    @Test
    public void test1(){
        String browserType = ConfigurationReader.get("browser");
        System.out.println(browserType);

        String urlName = ConfigurationReader.get("url");
        System.out.println(urlName);
    }

    @Test
    public void openBrowserUsingConfReader() throws InterruptedException {

        WebDriver driver= Driver.get();

        driver.get(ConfigurationReader.get("url"));
        String userName=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));

    }
}

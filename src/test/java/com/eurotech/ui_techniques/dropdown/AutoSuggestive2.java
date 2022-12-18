package com.eurotech.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/auto-complete");
        driver.findElement(By.cssSelector("#autoCompleteMultipleInput")).sendKeys("bl");
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']/div"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("Black")) {
                option.click();
                break;
            }
        }

    }
}

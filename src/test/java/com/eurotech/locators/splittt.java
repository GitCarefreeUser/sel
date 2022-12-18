package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class splittt {

    //password siteden geliyor
    //sendkeys ( ) icinde ezbere yazmak HARDCODING
    //onun yerine siteden splitt ile aldik
    //site passwordun o kismini degistirse bile ana cumlesi ayni kalmak sartiyla password
    //generic oldu
    //metot bize password donuyor

    //generic icin sonraki adim
    //configuration.properties kullanmak
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Reset Login']")).click();
        String passwordText=driver.findElement(By.tagName("p")).getText();
        String [] passwordArray=passwordText.split("'");
        String password=passwordArray[1];
        return password;
//        System.out.println(passwordArray.length);
//        for (String s : passwordArray) {
//            System.out.println(s);
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        String name="John";
        String password=getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button[class*='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+name+",");

        driver.findElement(By.xpath("//button[.='Log Out']")).click();

        driver.quit();



    }
}

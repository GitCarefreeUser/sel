package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
    /*

        asagida maindeki testi chrome browser'da calistiriyoruz
        eger baska browser'larda test etmek istersek
        tum kodu degistirmeye gerek yok
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        burda
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FireFoxDriver();

        yazmak yeterli
        alt kismi ayni sekilde, degisiklik yapmadan calisir
        ANA MANTIK BU


     */


public class DifferentBrowser {
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
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();


        //firefox icin bu iki kodu uyarlayalim
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver=new FirefoxDriver();

        //internet explorer icin

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();



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

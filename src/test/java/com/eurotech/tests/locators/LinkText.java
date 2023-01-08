package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinkText {
    /*
    By.linkText kullanmak icin developer toolsta html code satirinin tag'i a olmali
    yoksa bu locator calismaz
    ayrica kod satirinda a tag'i yaninda href attribute'u da olmali
    hreaf=.. bulunucak, value # bile olsa onemli degil calisir

    BU KOD SATIRINDAKI TEXT'i ALIP " " ICINE YAPISTIRIRIZ

    BIR DE PARTIAL OLANI VAR, TEXT'IN BIR KISMINI YAPISTIRSAK DA OLUR
    ORNEK:
    pages folder'i loginPage class'i:

    @FindBy(partialLinkText = "Forgot")
    public WebElement forgotPassword;


     */

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys("john");
        driver.findElement(By.xpath("//form[@class='form']/input[2]")).sendKeys("White");
        driver.findElement(By.xpath("//form[@class='form']/button")).click();
        System.out.println(driver.findElement(By.xpath("//form[@class='form']/p")).getText());

        //alttaki locator'in html hali su:
        //<a href="#" xpath="1">Forgot your password?</a>
        //tagname a ve href attribute var---- By.linkText kullanabiliriz
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);


        //ama alttaki satirda bu locator no such element der, bulamaz
        //<button class="reset-pwd-btn" xpath="1">Reset Login</button>
        //tagname a degil cunku
        //  driver.findElement(By.linkText("Reset Login")).click(); -->HATA

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //linkText ile locate

        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();



    }
    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://eurotech.study/");
        driver.findElement(By.id("rcc-confirm-button")).click();

        driver.findElement(By.linkText("Login")).click();
    }

        @Test
    public void clickWithJS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));
        //<a href="https://www.amazon.com.tr/ref=footer_tr" class="nav_a">Turkey</a>

        //a tagname'i var-href attribute var
        //text'i alip By.LinkText icine koyariz


        //   linkTurkey.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkTurkey); //click yapiyor


    }
}

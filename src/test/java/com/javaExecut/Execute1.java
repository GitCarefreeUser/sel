package com.javaExecut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Execute1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    //SAYFA LK ACILISTA UST KISMI GORUNUR NORMAL OLARAK
    //BIZ SAYFANIN ORTASINDA BIR BASLIK BELIRLEYIP LOCATE ETTIK
    //SCROLL BENZERI ORAYA JAVASCRIPT ILE INDIRICEZ
    @Test
    public void scrollToElement() {
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.id("ez-accept-all")).click();
        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",demoTable);

    }
    //SAYFANIN EN ALTINDA BIR BUTONU LOCATE EDIYORUZ VE
    //JAVASCRIPT ILE ONU CLICK'LIYORUZ
    @Test
    public void clickWithJS() {

        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.cssSelector("#sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));


        //   linkTurkey.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkTurkey); //click yapiyor

        //O BUTONA KADAR SAYFAYI SADECE INDIRMEK-SCROLL ICIN, ustteki gibi
        //su kodu kullanirdik:

        // executor.executeScript("arguments[0].scrollIntoView(true);", linkTurkey);


    }
    //CLICKLEMEYE BASKA ORNEK
    @Test
    public void scrollToElement2() {
        driver.get("https://www.amazon.co.uk/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement linkTurkey = driver.findElement(By.linkText("Turkey"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click();", linkTurkey);

    }
    /*
    ALTTAKI PAGE'TE NORMALDE BOX'A DIREK TEXT GONDEREMEYIZ
    ENABLED BUTONUNU CLICKLEMEMIZ LAZIM ONCE
    NOT INTERACTABLE HATASI VERIRDI SELENIUM
    AMA JAVASCRIPT KODUYLA YAZINCA
    ENABLE BUTONUNU HIC CLICKLEMEDEN
    SADECE YAZIYI YAZACAGIMIZ BOX LOCATE'I ILE HALLOLDU
     */
    @Test
    public void sendKeysWithJS() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        //yazi yazacagimiz box

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String text="Hello world!";  //yazmak istedigimiz yazi
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);
        //javascript enable butonunu arka planda hallederek yaziyi yazdi

    }

    /*
    NORMAL SCROLL METODU
    SAYFADA ASAG INMEK ICIN , SAGDAN TUTUP ASAGI CEKMEK GIBI
    BIR HAREKETI SAGLIYOR
     */

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");


    }

    @Test
    public void scrollDownAndUp2() throws InterruptedException {

        driver.get("https://www.amazon.co.uk/");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }


}

package com.eurotech.hover;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Act {
    /*
    sayfada uzerine gelip-tiklamadan mouse'u o elementin ustunde tutunca
    baska kisimlar acilir
    mouse'u orda tiklamadan tutturmak icin
    Actions classindan faydalaniriz
     */
	WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1() throws InterruptedException {
    	driver.get("https://www.amazon.com/");

        /*
        ilk is Actions classindan bir object create ederiz
        ana driver'imizi argument olarak bu object parametresine gondeririz
        sonra object variable'imiz . ve Action class metotlari ile islemler yapariz
        asagida
        1-buyuk harf girme
        2-gonderdigimiz sendkey'i secme
        3-hover
        islemleri var
         */
        Actions actions=new Actions(driver);

        //sayfada search buttonuna yazi yazmak icin once clickleriz orayi

         actions.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox")))
                 .click()
                 .keyDown(Keys.SHIFT)  //klavyede yazarken shift tusuna basii tutarsak
                 //buyuk harf yazar--bu keydown ile bu hareketi yaptik
                 .sendKeys("hello").doubleClick().perform();

        //actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        WebElement move = driver.findElement(By.id("nav-link-accountList"));
        Thread.sleep(5000);
        actions.moveToElement(move).contextClick().perform();

        //Action metotlari genelde build().perform() ile bitiyor
        //yazmayi unutmayalim




    }

   

    

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
	
}

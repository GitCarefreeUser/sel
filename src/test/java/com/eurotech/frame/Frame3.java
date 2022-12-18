package com.eurotech.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frame3 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void frameTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        // 1- Switch to frame(iframe) using by nameOrId
        //driver.switchTo().frame("mce_0_ifr");

        // 2- Switch to frame using by index number(java index)
        //driver.switchTo().frame(0);

        // 2- Switch to frame using by locator like a normal web element
        WebElement frameWebElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameWebElement);

        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));

        Thread.sleep(2000);

        textBox.clear();  //page'teilgili yerdeki default gelen yaziyi sildik
        Thread.sleep(2000);
        //baska yazi gonderdik
        textBox.sendKeys("Welcome Home");

        // Switch back to main HTML
        // just one level HTML up
        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println("header.getText() = " + header.getText());

    }
    /*
    NESTED FRAMES
     */
    @Test
    public void iframeTest() {
        /*
        bu page'te 2 ayri frame var--kardesler gibi
        ilk frame icinde de 3 tane frame var
         */

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //sayfadaki 2 ana frame'den usttekine giriyoruz
        // Switch to frame-top
        //name ileye ornek ayni zamanda-code satirinda name=...var
        driver.switchTo().frame("frame-top");

        //ilk frame 'e girdik
        //bu frame icinde de 3 tane kardes frame var left-middle-right
        // Switch to frame-left
        driver.switchTo().frame("frame-left");

        // get the text
        System.out.println("Text of Left Frame = " + driver.findElement(By.tagName("body")).getText());

            //kardeslerden ilkine yani left olana switch ettik
        //middle isimliye girmek icin bir uste cikicaz direk birinden oteki kardeslere gecemeyiz
        // Switch to parent frame
        driver.switchTo().parentFrame();

        //simdi middle olan kardese switch edicez

        // Switch to frame-middle using by index number
        driver.switchTo().frame(1);

        // get the text
        System.out.println("Text of Middle Frame = " + driver.findElement(By.id("content")).getText());

        // Switch to main HTML directly
        //alttaki ile ic frameden bir ust frame'e geliriz
        //eger ana html'e cikmak istersek iki kere ayni metodu yazmaliyiz
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();

        //bu ise direk atlayarak framlerden cikarir

        driver.switchTo().defaultContent();

        // Switch to Bottom frame
        driver.switchTo().frame("frame-bottom");

        // get the text
        System.out.println("Text of Bottom Frame = " + driver.findElement(By.tagName("body")).getText());


    }

    @Test
    public void testHW() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[text()='Black']")).click();
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");


        WebElement frameWebElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameWebElement);

        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));

        Thread.sleep(2000);

        textBox.clear();
        Thread.sleep(2000);

        textBox.sendKeys("Welcome Home");


        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println("header.getText() = " + header.getText());

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }
}

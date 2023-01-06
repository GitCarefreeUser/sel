package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextDifference {
    /*

      */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        driver.get("https://www.spicejet.com/");
       driver.findElement(By.xpath("//div[contains(text(),'Select Date')]"));

        /*
            ustteki 1 match yakaliyor
            alttaki 12 match var
            . yapinca dedigimiz tag'li parentlar da geliyor
            text() deyince direk textin yazili oldugu tag'i veriyor

            ayrica, contains kullaniyorsak = yok yerine virgul var
             */

        driver.findElement(By.xpath("(//div[contains(.,'Select Date')])[12]"));


    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("//span[.='You selected Ok']")).getText());
        /*
        test1 ile ayni ornek
        ustteki satirda 1 match var
        alttaki satir 0 match
        text()= yazinca tek " " icinde text istiyor gibi
        biz locate'i yazinca //span[.='You selected Ok']  ifadesindeki '  ' icini eksiksiz ariyor
        .= ile yazinca parcali da olsa buluyor
        ama text()= ile yazinca tekt keywordunden dolayi birebir aynisini bulamiyor
        cunku html'de o kisim iki tane " " icine yazilmis, ayri gibi birbirinden text yapisi olarak yani
         */
        System.out.println(driver.findElement(By.xpath("//span[text()='You selected Ok']")).getText());
    }

    @Test
    public void test3() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();

        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("john");
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.xpath("//span[text()='You entered hhhh']"));
        // bu locater'da 0 match var cunku html'de texti parcali yazmislar soyle:

        /*
        <span id="promptResult" class="text-success"  xpath="1">
        "You entered"
        "hhhh"
        </span>
         */
        //ama . ile yazinca locater'i buluyor
        driver.findElement(By.xpath("//span[.='You entered hhhh']"));

        /*
        test1 ve test2' ye ilave aciklama soyle olabilir:
        text() kullaninca >arasinda yazili olan tek parca < yi ariyor

        .= ile yazinca >arsinda " "     " "< gibi 1 den fazla "" ile ayrilmis da olsa
        o texti veriyor
         */


    }

    @Test
    public void test4() {
        /*
        <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        String name="John";
        String password="rahulshettyacademy";
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button[class*='submit']")).click();

        //text alttaki satirda cikiyor ve tek parca ama
        //icinden ' ' ile olan kismi almak icin split kullandik
        //test1, test2 ve test3 'den farkli konu bu
        //bulunsun diye ekledik bu classa test3 olarak
        driver.findElement(By.xpath("//div[@class='login-container']/h2"));

        //split yaptigi yer locators folderi splitt classinda bir metotta var
        //bakarsin lazim olursa :)

        driver.findElement(By.xpath("//button[.='Log Out']")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

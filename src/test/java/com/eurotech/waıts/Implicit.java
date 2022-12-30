package com.eurotech.waıts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Implicit {
    /*
    sayfaya istek gonderdigimizde, bazen page arka planinda sayfanin gelmesi 3-5 sn zaman alir
    ama selenium cok hizli kalir ve
    locate edecegimiz elementi bulamaz
    aslinda element orda, acilacak ama
    senkronizasyon sorunu var
    selenium'a click dedik mesela
    gider hemen elementi arar clicklemek icin
    biz de wait'lerle biraz bekle demis oluruz seleniuma

    2 cesit wait var
    1-IMPLICITLY WAIT

    global olarak yazilir
    tum test code line'larina uygulanir

    2-EXPLICITLY WAIT

    specific bir locater icin uygulanir, implicit'de diyelim 5 sn verdik, ama
    bazi sayfayapisi elementlerde bu sure yetmez
    ama tum line'lara uygulamayiz cunku frameworku sebebsiz yavaslatir ve
    varsa sure hatasi-onu yakalayamayiz
    bu nedenle explicit wait sadece specifik uygulanir


     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        /*
        implicit wait yazilisi selenium 4 guncellemesiyle degisti
        altta iki versiyonu da var
         */

        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        /*
        implicit waiti //'layip test'i calistirirsak fail olur
        unable to locate element hatasi aliriz
         */
    }
    @Test
    public void implicitlyWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement itsgone = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println("itsgone.getText() = " + itsgone.getText());
    }

    @Test
    public void implicitlyWait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        System.out.println("[@id='message']\")).getText() = " + driver.findElement(By.xpath("//p[@id='message']")).getText());

    }

}

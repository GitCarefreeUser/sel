package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Error1 {

    //elementclickIntercepted
    /*
    asagidaki sayfada slayt degisimi gibi bir uygulama var
    2 click arasi slayt soldan saga geciyor
    ama selenium hizli davraniyor ve sayfanin kendini bulmasina zaman kalmadan clicklemeye gidiyor
    o zaman da bu hatayi veriyor

    Element ...is not clickable at point ...Other element would receive the click:  der
     */

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);  //thread'in yeri onemli, page'te slayti degistiren buton ilk clcik-ustteki
        //bu clicklendikten sonra pagete view'in stable olmasi icin zaman lazim
        //o yuzden buraya koyuyoruz-2 click arasi
        driver.findElement(By.className("reset-pwd-btn")).click();
       System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());

       //burdan ayni slayt takasini geri dogru yapma imkani var page'te
        //login'e basinca slaytlar yine yer degistirioyr
        //ayni hatayi tekrar verir bu yuzden bir thread daha lazim, login sonrasi


       //bu page'e bakinca name-password -phone number verisi girip
        //sonra reset clickleniyor, yani 2-3 atir data gonderip editbox'i doldurabiliyoruz , hata vermeden calisiyor
        //yani sayfanin stable olmasi icin yeter ure gecmis gibi dusunulebilir
        //ama oyle olmuyor, reset button'da
        //ustteki hatayi veriyor
        //sayfa acilip kendini bulmus saymiyor

    }
}

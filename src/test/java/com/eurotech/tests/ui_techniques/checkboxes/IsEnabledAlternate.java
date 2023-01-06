package com.eurotech.tests.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabledAlternate {
    /*
       sayfada default olarak oneway secili geliyor
       bu durumda return bileti lazim degil ve developer'da return date'i disabled yapmis
       biz bunu check edicez
       donus tarihi kisminin enable olmamasi lazim
       ama isEnabled bazen dogru sonuc vermiyor
       UI da gorunus olarak enabled degil ama tiklayinca enable oluyor
       current teknoloji ile artik boyle yazilmis kod
       isEnabled ise twoway'e tiklamadan returndate'in aktif olmamasini bekliyor
       bu yuzden dogru sonuc vermiyor
       bu durumda test etmek icin getAttribute metodundan faydalanacagiz
       return date kismi kapali ve acikken html kod satirinda
       en azindan bir attribute value'sunda degisiklik olur
       bunu takip edip if li bir yapiyla sonucu alicaz
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
        //oneway secili, returndate ekranda kapali gorunuyor ve
        //alttakinin false donmesi lazim ama true donuyor
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Select Date')]")).isEnabled());

            /*
            ARA NOT:
            //div[contains(text(),'Select Date')] burda tek match var
            //div[.,'Select Date')]  ile coklu match cikiyor
            farklari var iki syntaxin

            ayrica, contains kullaniyorsak = yok yerine virgul var
             */
        WebElement date=driver.findElement(By.xpath("//div[contains(text(),'Select Date')]"));
        System.out.println(date.getAttribute("style"));
        //default olarak returndate kapali iken-enabled degilken
        //style attribute value'su nu aldik
        //simdi de twoway buttonunu tiklayip style value'suna bakalim
        driver.findElement(By.xpath("//div[contains(text(),'round trip')]")).click();
        System.out.println(date.getAttribute("style"));
        /*
        ciktilar once ve sonrasinda soyle:
        font-family: inherit; opacity: 0.5;
        font-family: inherit; opacity: 1;
        yani cliklemeden once 0.5 sonra 1 olmus
        bunu if icinde yazicaz
        test2 metoduna GECCCCCC
         */
    }

    @Test
    public void test2() {
        driver.get("https://www.spicejet.com/");


        WebElement date=driver.findElement(By.xpath("//div[contains(text(),'Select Date')]"));

        WebElement twoWay=driver.findElement(By.xpath("//div[contains(text(),'round trip')]"));
        twoWay.click();

        if (date.getAttribute("style").contains("1")){
            System.out.println("it is enabled");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
        //RadyoButton classinda da ayni mantik var BAKKKKKKKKKKKKKKKK

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

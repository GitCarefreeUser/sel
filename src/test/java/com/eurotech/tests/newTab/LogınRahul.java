package com.eurotech.tests.newTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class LogınRahul {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        //linkText ile locate
        //locators folderind LinkText classinda da var
        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

        /*
        selenium 24. satirdaki page'te
        ama ustteki code ile new tab acildi
        ama selenium direk o sayfaya gecmez
        explicitly soylememiz gerekir
         */
        /*
        ekranda 2 sayfa acik , birine firstPage diyelim, digerine de seconPage
        bu sayfalardan istedigimize gecis yapabilmek icin page'lerin id'lerini kullanicaz
        bize id 'leri lazim
        driver.switchTo().window( ); metodu ile seleniuma yeni id-yeni sayfa bilgisi veririz
        sondaki ( ) icine parametre olarak yeni id'yi gondericez

        icinde bulundugumuz page'in id'si
         driver.getHandle();
         return type'i string
        String windowHandle = driver.getWindowHandle();


        ikinci sayfayi actirdigimizda iki sayfa acik ve iki tane id olacak

        selenium'a yeni sayfada islem yaptirabilmek icin yeni sayfanin id'sini alabilmek icin
        tekli getHandle() kullanamiyoruz, cogul olani kullaninca
        selenium'a bilgi gecebiliyoruz

        bu iki id'yi de
        getWindowHandles(); metodu ile aliyoruz--cogul, sonu s ile bitiyor -handles
        aldiktan sonra store etmek icin--return type'i Set
        return type'i da --sag click de de gorulur-- set<String >

        set variable'imizde 2 id olacak artik
        yeni sayfanin id'sini selenium'a gecmek icin de
        set'in icinden almamiz lazim
        bunun icin de iterator lazim


                 excel'de de --sheet'lere girmek icin iterator kullanmistik
                 excel folder'i,,,,First isimli classta var

                 */



        Set<String> windowHandles = driver.getWindowHandles();//   [firstPageId,secondPageId]
        Iterator<String> it = windowHandles.iterator();
        String firstPage=it.next();  //  ilk index-->firstPageId
        String secondPage=it.next(); //set'teki ikinci element--secondPageId
        driver.switchTo().window(secondPage); // burda da selenium'a kontrolu 2. sayfaya al diyoruz


        //artik yeni acilan sayfada selenium
        //bu kode'lari yazmadan selenium'a yeni sayfadan locate-click filan yaptiramazdik

        //yeni sayfadan texti alicaz, html soyle:
        /*
        <p class="im-para red" css="1">
        "Please email us at"
        <strong>
        <a href="mailto:mentor@rahulshettyacademy.com">
        mentor@rahulshettyacademy.com</a>
        </strong>
        "with below template to receive response"
        </p>

         */
        //css ile alalim
        //css'te class value'sunda arada bosluk varsa kapatilir ve araya nokta konurdu
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String s = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        //ust satir sonunu gettext() ile bitirirken ; koyuyorsak bir stringe atamaliyiz
        //compiler not a statement hatasi verir, o haliyle bir variable'a atanmamis string value'su sadece cunku

        //simdi aldigimiz texti-->onceki sayfada login sayfasi--yani firstPage'e goturup
        //username kismina send edicez
        //selenium su an ikinci sayfada
        //tekrar ilk sayfaya switch edelim:

        driver.switchTo().window(firstPage);
        //alert folder'inda one isimli clastta 29.line'da da switchTo var
        //alertlerde switchTo().alert();  olarak geciyordu
        //frame icinden element locatinde de switchto var


        //konuya donersek simdi ilk sayfamizdayiz, seleniumda kontrol ilk sayfada

        driver.findElement(By.cssSelector("#username")).sendKeys(s);
        //burda yaptigimiz sey--secondPage'ten aldigimiz ve splitle boldugumuz exti
        //firstPage'te username'e send etmek

    }

    @Test
    public void testName() {
        driver.get("https://the-internet.herokuapp.com/windows");

        // get the title of current page
        System.out.println("Title Before New Window = " + driver.getTitle());

        // get the id of current page
        System.out.println("Id of First Window = " + driver.getWindowHandle());

        // click on "Click Here"
        //driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {

            driver.switchTo().window(tab);

            if(driver.getTitle().equals("New Window")) {
                break;
            }

        }
        System.out.println("Title After New Window = " + driver.getTitle());
        System.out.println("Id of Second Tab = " + driver.getWindowHandle());

    }

    @AfterMethod
    public void tearDown() {

    }
}

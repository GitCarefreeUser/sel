package com.eurotech.newTab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class RahulLogin {
    /*
    bu class'ta new tab'tan text alma uzun anlatildi
    orjinal devami LoginRahul isimli classta
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
        getWindowHandles(); metodu bu id'leri store eder
        cogul, sonu s ile bitiyor -handles
        return type'i da --sag click de de gorulur-- set<String >
        set variable'imizde 2 id olacak artik
        bu id'leri kullanabilmek icin iterator lazim
         */
        Set<String> windowHandles = driver.getWindowHandles(); //   [firstPageId,secondPageId]
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

        //eger usttekı switch islemlerini yapmasaydik
        //yeni sayfadan text alan code no such element derdi
        //cunku selenium ilk sayfada o elementi arayacakti
        //ama switch ile selenium'a yeni sayfaya gec diyoruz
        /*
        simdi aldigimiz textin icinden @li gmail adresini split ile cikaralim

         */
        //alttaki kodun gettext() kisim--return type'i string
        //string bir variable'a assign ettik
        String gmail=driver.findElement(By.cssSelector(".im-para.red")).getText();
        /*
        gmail variable'inda Please email us at mentor@rahulshettyacademy.com with below template to receive response
        var
        bu texti "  " bosluklardan split edelim

         */
        gmail.split(" "); //burda cumleyi bosluklarina gore ayirip herbirini bir element olarak
        //array'e attik
        String[] arr=gmail.split(" ");
        for (String s : arr) {
            System.out.println(s);

        }
        //bize lazim olan 4.su
        System.out.println(arr[4]);

        /*
        mesela bu split islemini bosluk yerine -at- kelimesinden ayiralim:
        split'te ( ) icine yazdigimiz seyden itibaren parcalar ve ( ) icindekini yazmaz
        burda at -leri kaldiracak oncesi ve sonrasi olarak arraye element olarak atacak
        cumlede 2 tane at var
        arrayde 3 element olacak
        ve at-ifadesi olmayacak iclerinde
         */
        String[] ats = gmail.split("at");
        //ama ilk at'ten sonrasinda bir bosluk var onu da trim ile almamiz lazim

        String trim = ats[1].trim();
        System.out.println(trim);
        //bu ifadede gmail'li kismin devami kelimeler var, gmailli kisim sadece lazim
        //bir split daha yapalim bu sefer " " kullanalim
        String[] s = trim.split(" ");
        System.out.println(s[0]);

        /*
        arr arrayinin [4] index nolu elementi ve
        s arrayinin [0] index nolu elementi
        ikisi de bize gmailli kismi veriyor

        " " dan ayirarak yaptigimiz ikinci usul split'i yani s arrayine attigimiz islemi tek satirda code olarak da
        yazabiliriz:
         bize texti veren kod suydu:
        String gmail=driver.findElement(By.cssSelector(".im-para.red")).getText();

         */
        String s1 = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println("s1 = " + s1);

        //LOCATORS FOLDER'INDA SPLITTT CLASSINDA DA VAR

    }

    @AfterMethod
    public void tearDown() {

    }
}

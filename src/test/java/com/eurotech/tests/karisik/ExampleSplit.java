package com.eurotech.tests.karisik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class ExampleSplit {
    /*
    webtable folder'i Rahul1 classinda da var
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
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();  //sag clickte return type zaten Alert veriyor
        //devaminda 2-3 alert daha tiklicaz
        //ama her seferinde switchto.alert yazmaya gerek kalmadi burda bir kere yazinca
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        System.out.println(alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());

        driver.findElement(By.id("promtButton")).click();
        String name="john";
        alert.sendKeys(name);
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.findElement(By.id("promptResult")).getText());
        System.out.println(driver.findElement(By.id("promptResult")).getText().split(" ")[2]);
        String actual=driver.findElement(By.id("promptResult")).getText().split(" ")[2];
        String expected=name;

        Assert.assertEquals(actual,expected);


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Reset Login']")).click();
        String passwordText=driver.findElement(By.tagName("p")).getText();
        String [] passwordArray=passwordText.split("'");
        String password=passwordArray[1];
        System.out.println(password);
    }

    @Test
    public void test3() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

        Set<String> windowHandles = driver.getWindowHandles(); //   [firstPageId,secondPageId]
        Iterator<String> it = windowHandles.iterator();
        String firstPage=it.next();  //  ilk index-->firstPageId
        String secondPage=it.next(); //set'teki ikinci element--secondPageId
        driver.switchTo().window(secondPage); // burda da selenium'a kontrolu 2. sayfaya al diyoruz

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
    public void tearDown() throws InterruptedException {

    Thread.sleep(1000);
    }
}

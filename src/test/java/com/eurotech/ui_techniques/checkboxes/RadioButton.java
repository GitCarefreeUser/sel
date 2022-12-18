package com.eurotech.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
radio buttonda 4-5 button var onlardan sadece birini secebiliyoruz
birini sectiysek digerini secemiyoruz
BIRDEN FAZLA SECIM IMKANI TANIYANA checkbox denir
onu diger classta uygulayacagiz

tester mantigiyla bakiinca radiobutton'da birini sectik diyelim bunun isSelected'i true
diger bos-secili olmayan seceneklerin isSelected'inin false donmesini bekleriz

secili olup olmadigini isSelected ile gorebiliyoruz
true donerse secili
false donerse secili degil demektir
asserte de kullaniriz
test1 i uyguladigimiz sitede sonuclar hatali geliyor , sitede sorun olabilir
ama test2 if ile getAttribute metodundan faydalanarak testi yaptik
 */

public class RadioButton {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        driver.get("https://demo.aspnetawesome.com/");
       // driver.findElement(By.xpath("//div[@class='o-chk']")).click();
        WebElement legume = driver.findElement(By.xpath("//div[.='Legumes']"));

        //driver.findElement(By.xpath("//input[@value='155']")).click();  interactable hatasi
        WebElement vegetable = driver.findElement(By.xpath("//div[text()='Vegetables']"));

        System.out.println(legume.isSelected());
        System.out.println(vegetable.isSelected());

       /*
       bu ornekte legumes secili, fruits secili degil
       ama ikisinin de isSlected i false donuyor
       bu testi if ile test2 de yaptik oraya gec

        */



    }

    @Test
    public void test2() {
        /*
        secili olanda class attribute value'su 'o-chk o-chked' oluyor
        secili degilse 'o-chk'
        isSelected metodu hatali dondugu icin
        getAttribute ile classin value'larindaki bu degisiklikten
        faydalanip assert edicez

        isEnabled CLASSINDA DA BENZER MANTIK VAR BAKKKKK

         */

        driver.get("https://demo.aspnetawesome.com/");

        WebElement legume = driver.findElement(By.xpath("//div[.='Legumes']"));

        WebElement vegetable = driver.findElement(By.xpath("//div[text()='Vegetables']"));


        WebElement fr=driver.findElement(By.xpath("//label/div[contains(@class,'o-chk o-chked')]"));
        if (fr.getAttribute("class").contains("chked")){
            System.out.println("legume secili");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }



    }

    @Test
    public void test3() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement e1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement e2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        System.out.println(e1.isSelected());
        System.out.println(e2.isSelected());

        //Assert.assertTrue(e1.isSelected()); bu code'un mantigi hatali soyle ki:
        //( ) icinden ne bekliyoruz , secili degil false donmesini bekliyoruz
        //o zaman .assertFalse dememiz lazim ki, metot ve ( ) ici tutsun
        Assert.assertFalse(e1.isSelected());
        Assert.assertTrue(e2.isSelected());


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

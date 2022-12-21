package com.eurotech.ui_techniques.dropdown.static_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");

        /*
        sayfada ok'lu butona geldik, sag click ve inspect dedik
        eger karsimiza select classi yani select tag'li code cikarsa
        o elementi locate edip webelement'e assign ediyoruz
        sonra da select object'si create edip ona argument olarak pass ediyoruz

        ama  clikleyince select tagi cikmiyorsa normal baska bir tag'li ise
        o elementi yine locate ederiz ama  code'ta clickleriz

        select'liden ilk farki bu

        mesela Iki isimli classtan -selectli ornegiydi- alip bakalim
        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        burda click filan yok direk webelement type'inda assign vardi

        ama select tagi cikmasaydi orda
        bu code'u soyle yazardik:
        driver.findElement(By.id("oldSelectMenu")).click();

         */
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        /*
        ikinci is olarak
        ok'a tikladik bir liste acildi
        o listeden birini sag clickle inspect ediyoruz
        html'de birin vercek ama o acilan listedeki element sayisi kadar olani bulmaya calisip
        toplu locate ederiz
        ve list'e atariz

        loctae 'te mesela bu ornekte listede ilk vegetables gozuktu,sag clik dedik
        li taginda yazili
        li den cok vardi
        parent''lari ul idi
        o da cok
        ul lara bakinca 17 verdi
        enterlayarak inince bizim sayfada acik duran listeyi isaret eden -isik-higlight o kisma getiren
        10 numaraydi
        ( ) icine alip [10] yazinca aradigimiz 5 li listenin locate'i cikti
        /li ile de esas alt locate geldik
         */
        List<WebElement> elements = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        for (WebElement element : elements) {
            System.out.println(element.getText());

        }
        System.out.println(elements.get(1).getText());
        elements.get(1).click();

        System.out.println("papaya.get(4).isDisplayed() = " + elements.get(4).isDisplayed());



    }

    @Test
    public void test2() {
        //(//*[text()='Tomato'])[3]/../../li
        driver.get("https://demo.aspnetawesome.com/");
        /*
        sayfada papaya-legumes ustunde durunca tomato ile baslayan 5 meyvelik bir liste aciliyor

        1-  //*[text()='Tomato']     yazinca fazla match cikti
        enterla tarayinca bizim tomato 3. su imis
        parent yapmak icin locati ( ) icine alip yanina [3] yazdik
        (//*[text()='Tomato'])[3] oldu
        bu 1 tane match gosterdi o da tomato
        ama bize 5 li liste lazim ki Liste atip o 5 meyve ismi uzerinde islem yapabilelim
        bir ust parenta cu=iktik  (//*[text()='Tomato'])[3]/.. yazarak
        1 match ama li tagli ve meyvelerin oldugu listeyi gorduk
        bir ust parenta daha ciktik (//*[text()='Tomato'])[3]/../..
        ul tagina vardik ve ul tagi bu li taglarinin parent'i
        bize li tagli liste lazim-coklu -findElements ile list<webelement> icine atmak icin
        ul dan /li ile li taglilara baktik ve 5 match bulduk
        bize de bu lazim
        (//*[text()='Tomato'])[3]/../../li

        sayfada amacimiz dropdownlarda acilan listedeki butonlara islem yapabilmek
        textlerini almak, tiklamak filan assert edicez
        diyelim ok'a tiklayinca 10 tane meyve ismi acildi
        her birini tek tek locate etmektense
        toplu bu sekil yapariz
        ama onda da coklu match yakalamak icin bu sekil html de calisiriz
         */


        List<WebElement> elements = driver.findElements(By.xpath("(//*[text()='Tomato'])[3]/../../li"));
        System.out.println(elements.size());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);


    }
}

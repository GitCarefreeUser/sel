package com.eurotech.tests.ui_techniques.dropdown.static_;

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

public class Iki {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testName() {
        driver.get("https://demoqa.com/select-menu");
        /*
        sayfada ok'lu butona geldik, sag click ve inspect dedik
        eger karsimiza select classi yani select tag'li code cikarsa
        o elementi locate edip webelement'e assign ediyoruz
        sonra da select object'si create edip ona argument olarak pass ediyoruz

        ama  clikleyince select tagi cikmiyorsa normal baska bir tag'li ise
        o elementi yine locate ederiz ama  code'ta clickleriz

        select' tagi cikmayanla fark bu
        developerlar bazen select'li yazar bazen select kullanmadan

        mesela bu  classtan -selectli ornegiydi- alip bakalim
        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        burda click filan yok direk webelement type'inda assign var

        ama select tagi cikmasaydi
        bu code'u soyle yazardik:
        driver.findElement(By.id("oldSelectMenu")).click();

         */


        /*
        once sayfadaki elementi locate ediyoruz
        bu element yaninda ok acilan asagi dogru liste veren ve bizim
        secmemize musait bir button
        normade inspect ile locate ederken tek elementi locate ediyoruz
        ve sonra onu webelement variable'ina assign edip select classina argument vericez
         */
        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));

        //select classindan object creat ettik ve locate ettigimiz elementi arg olarak pass ediyoruz

        Select select=new Select(oldSelectMenu);
        System.out.println(select.getFirstSelectedOption().getText());

        //verify that default color is Red
        String expectedColor="Red";
        String actualColor=select.getFirstSelectedOption().getText();

        /*
        getFirstSelectedOption metodu select classina ait bir metot
        o yuzden select object reference'i ile kullanilir
        asagida liste atmistik, mesela o variable. ile cagiramayiz

        ve diyelim rengi yellow yaptik clickleyerek
        getfirstoption metodunu tekrar cagirsak
        bu sefer yellow verecek
        bu metot aslinda
        -sayfayi actigimizda ilk default olani veriyor
        baska renk sectikten sonra cagirirsak o reng verir
        yani ekranda gozuken ve secili olan rengi verir
         */
        Assert.assertEquals(actualColor,expectedColor,"verify that color is red");
        select.selectByVisibleText("Yellow");

        /*
        buraya kadar select classinin metotlarindan faydalanabiliriz
        ama iter icinde mesela elementleri yazdiralim ya da asserrt edelim dersek
        bu haliyle yapamayiz
        List'e atmamiz lazim
        bunu da getOptions metodu ile yapariz
         */
        List<WebElement> options = select.getOptions();//bu metodun return type'i list

        //bu metot sayesinde sayfada ok ile acilan ve  listelenen tum elementlerin locate'i
        //options variable'inda artik
        //sanki findElements ile bulmusuz gibi, hepsini toplu locate etmisiz gibi

        for (WebElement option : options) {
            System.out.println(option.getText());

        }

        //select classini kullanarak sayfada element secme
        //1-visible

        //select.selectByVisibleText("purple"); // bu kod sayfada purple'i tiklar, click filan demeye gerek yok
        //ama ( ) icini kucuk harfle yazdik
        //no suchelement hatasi verir
        select.selectByVisibleText("Purple");

        expectedColor="Purple";
        actualColor=select.getFirstSelectedOption().getText(); //string'e atayacagimiz icin
        //gettext diyoruz, yoksa webelement'i stringe atayamazsin hatasi verir onsuz

        Assert.assertEquals(actualColor,expectedColor);

        //select classini kullanarak sayfada element secme
        //2-index

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        expectedColor="Blue";
        actualColor=select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor,"verify that colour is blue");

        //burda mesela baska renk sectiysek assert error verir
        //intellij'de asagida yazar
        //expected :su su
        //actual: su su   diye

        //select classini kullanarak sayfada element secme
        //3-value

        //html'deki value isimli attribute'un degerini yazariz
        //ornek: <option value="5" xpath="1">Black</option>
        //value'su 5
        select.selectByValue("5"); //burda direk secmis oluyoruz bu haliyle
        //git ve value'su 5 olan reng butonunu tikla demis oluyoruz
        expectedColor="Black";
        actualColor=select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
       // driver.close();

    }
}

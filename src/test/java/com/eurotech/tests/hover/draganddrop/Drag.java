package com.eurotech.tests.hover.draganddrop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Drag {
    /*
    drag and drop'ta da actions classi kullanilir
    iki turlu yapabiliriz altta test1 ve test2 metotlarina bakalim

    ilki
     hover hareketi var
    ve hover hareketi icin movetoelement metodu kullaniriz
    page'te mouse'u goturmek istedigimiz yeri
    locate ederiz
    ve action classindan create ettigimiz obje uzerinden
    movetoelement metodunu cagiririz

    ikinci metot
    movetoelement kullanmadan-hover yapmadan
    action classinin draganddrop metodunu kullaniriz
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
        driver.get("https://demoqa.com/droppable");
        Actions ac=new Actions(driver);
        /*
        page'te mouse'i ustune goturecegimiz yer'i locate ediyoruz
         */
        WebElement draggable = driver.findElement(By.id("draggable"));
         /*
        page'te mouse'i ustune goturecegimiz 2. yer'i locate ediyoruz
         */
        WebElement droppable = driver.findElement(By.id("droppable"));

         /*
            Action classindan olusturdugumuz ve
            parametre olarak driver'i gonderdigimiz nesne uzerinden
            once moveToElement metodunu cagiriyoruz
            bu metot ile mouse'a ocate ettigimiz yere git diyoruz
            mouse -tiklamadan-locate edilen yere gidiyor

            code satirindaki ikinci movetoelement metodu ile
            mouse'a 34.satirdaki-locate ettigimiz yere git diyoruz
         */
        ac.moveToElement(draggable).clickAndHold().moveToElement(droppable).
                pause(4000).release().perform();

        /*
        assert icin ,
        sayfada drag and drop sonrasi
        dropped yazisi cikiyor bunu kullanalim
         */
        String expected="Dropped!";
        String actual=driver.findElement(By.xpath("//p[contains(.,'Dropped!')]")).getText();

        Assert.assertEquals(expected,actual);
        System.out.println(actual);

    }

    /*
    drag and rop icin ustteki metotta
    movetoeleent metodu ile yaptik

    yine action classinda draganddrop isimli metot le de alttaki gibi yapabiliriz
    bunda movetoelement kullanmaya gerek yok
     */
    @Test
    public void test2() {
        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions ac=new Actions(driver);
        ac.dragAndDrop(draggable,droppable).perform();

    }
}

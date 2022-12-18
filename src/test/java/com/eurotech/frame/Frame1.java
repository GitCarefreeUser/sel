package com.eurotech.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Frame1 {

    /*
    eger bir element frame icindeyse
    compiler -unable to locate element- hatasi verir

    DOM'da o element locate'i 0 gozukur cunku iframe icinde

    frames are component which are hosted on the web pages
    frames are specific containe and they are independent of html code.
    they are also html code but they are apperantly prepared

    bazen developerlar web page'in kodlarini yazarken sayfada bir bolumu-cerceve gibi bir yer
    bos birakirlar ve sonra buraya frame dedigimiz yapiyi getirip eklerler


    selenium can not identify the frames
    if you see frames in web application you can not handle it in normal fashion
    you have to tell selenium that:  this is in frame, so handle it accordingly
    you have to tell selenium it before you do it
   if you don't tell, selenium automatically thinks that element is a part of the html-or web browser-
   and it checks entire code and it can't find it

   we need to switchto the frame
   (framede-alertte-new tab olayinda da switchto kullaniyoruz)
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();// bu satiri yazmazsak nullpointer exception hatasi verir
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        driver.get("https://jqueryui.com/droppable/");
        //html'de kac frame var onu ogrenelim
        //frame'lerin tag'i iframe olur

        System.out.println(driver.findElements(By.tagName("iframe")).size());

            // usttekini asagidaki mantikla dusunebiliriz
        //ikisi de dogru
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        /*
        alttaki satirda elementi locate ettik ve locatorda sorun yok ama
        nu such element hatasi verdi
        cunku frame icinde
        driver.findElement(By.id("draggable")).click();

        html DOM'da <iframe

                     </iframe> arasinda kaliyor

        elementimiz iframe icinde mi diye html gozle ustten check edilir
        iframe var mi bakilir
        varsa once switchTo().frame () deriz
        ve iframe tag'li satiri locate ederiz
        frame( ) icine arg larak pass ederiz
        selenium boylece frame oldugunu anlar

        switchto().frame(  ) de pass etmenin 3 yolu var
        switchto yaparken framei almanin 3 yolu var
        driver.switchTo().frame() yazarken intellij veriyo zaten ekranda o uc yolu

        1-webelement
        2-index no
        3-name or id

        1-webelement'ten


         */
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        /*
        burda page'te drag and drop var
        bunu Actions classi ile yapabiliyoruz
         */
        Actions a=new Actions(driver);
        a.dragAndDrop(source,target).build().perform();
        Thread.sleep(1000);



    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        /*
        2-index

        html 1'den fazla frame varsa
        frame'lerin index nosunu arg olarak pass ederiz
        index no 0'dan baslar
        kac tane frame var onu ogrenmek icinse
        soyle yapabiliriz
        frame'lerin tag'i iframe olur
        By.tagname ile iframe arariz

        findElements --s var, cogul ariyoruz--
        System.out.println(driver.findElements(By.tagName("iframe")).size());

         */


        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // usttekini asagidaki mantikla dusunebiliriz
        //ikisi de dogru

        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());

        //ustteki iki code'ta ayni sey
        //sout ile iframe tag sayisini yani kac tane frame oldugunu ogrendik
        //bu ornekte 1 tane var dolayisiyla index no  olacak

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        Actions a=new Actions(driver);
        a.dragAndDrop(source,target).build().perform();
        Thread.sleep(1000);



    }
    @Test
    public void frameTest() throws InterruptedException {

        /*
        3-name or id ile
         */

        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to frame(iframe) using by nameOrId
        driver.switchTo().frame("mce_0_ifr");


        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));

        Thread.sleep(2000);

        textBox.clear();
        Thread.sleep(2000);

        textBox.sendKeys("Welcome Home");

        // Switch back to main HTML
        // just one level HTML up
        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println("header.getText() = " + header.getText());

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }
}

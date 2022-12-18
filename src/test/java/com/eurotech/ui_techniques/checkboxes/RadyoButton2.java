package com.eurotech.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadyoButton2 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
     /*
    html soyleydi:
    <div class="css-1dbjc4n" style="margin-right: 6px;"><svg data-testid="svg-img"
    viewBox="0 0 18 18" width="18" height="18" fill="#000" color="#000"
    preserveAspectRatio="none"><circle cx="9" cy="9" r="8" fill="#FFF" fill-rule="evenodd"
    stroke="#DDDDDD" stroke-width="2"></circle></svg></div>

    <svg data-testid="svg-img" viewBox="0 0 18 18" width="18"
    height="18" fill="#000" color="#000" preserveAspectRatio="none"
    xpath="1"><circle cx="9" cy="9" r="8" fill="#FFF" fill-rule="evenodd"
    stroke="#DDDDDD" stroke-width="2"></circle></svg>

    <circle cx="9" cy="9" r="8" fill="#FFF" fill-rule="evenodd"
    stroke="#DDDDDD" stroke-width="2" xpath="1"></circle>

     burda
     1-div ile
     2-svg ile locate edebiliriz
     */
     @Test
     public void test1() {
         driver.get("https://www.spicejet.com/");

         driver.findElement(By.xpath("(//div[@style='margin-right: 6px;'])[1]")).click();

     }

    @Test
    public void test2() {
        driver.get("https://www.spicejet.com/");
        //asagidaki element <svg taginda
        //syntax'i farkli yaziliyor, direk //svg diye yazmaya baslarsak ulasamayiz

        driver.findElement(By.xpath("(//*[local-name()='circle'])[5]")).click();

        /*
        bu svg'yi soyle de yazabiliriz, ama index no farkli cikiyor
                driver.findElement(By.xpath("((//*[name()='svg'])[15]")).click();
                her iki syntaxi ( ) icine alip parentmis gibi yaptik, sonra enter'la
               DOM'da ctrl+f satirinda aratiyoruz, page'te geldigi yer highlited oluyor zaten


         */


    }
    /*
    altta
    isSelected metodunu kullandik
    page'te checkbox'i sectik
    secili mi degil mi isSelected onu doner
    seciliyse true, degilse false doner
    bu sayfada direk true donmuyor
    html'i inceleyelim:
     */

    @Test
    public void test3() {
        driver.get("https://www.spicejet.com/");

        System.out.println(driver.findElement(By.xpath("(//*[local-name()='circle'])[5]")).isSelected());
        driver.findElement(By.xpath("(//*[local-name()='circle'])[5]")).click();
        System.out.println(driver.findElement(By.xpath("(//*[local-name()='circle'])[5]")).isSelected());

    }
    /*
    page'teki checkboxes sayisini sorsalardi:
    bu sayfada checkboxes farkli code'larla yazilmis
    normalde common bir locate bulup coklu secimle bulunur
    test1 'deki ornekten gidelim
    6 tane match ediyor
    normalde sayfada baska yerlerde de checkboxes var ama onlarla bu 8 tanesi
    common code yok, developer oyle yazmis
     */

    @Test
    public void test4() {
        driver.get("https://www.spicejet.com/");
        /*
        bu code'ta [1] ile istedigimiz checkboxe'i secmistik
        sondaki 1'i kaldirinca 8 match geldi

        size'ini alirken list'e atip sonra .size yerine direk sona .size yazip da alabiliriz
        findElements---> sonda s geldi cunku coklu secim yapiyoruz
         */

        System.out.println(driver.findElements(By.xpath("//div[@style='margin-right: 6px;']")).size());
        //List<WebElement> elements = driver.findElements(By.xpath("//div[@style='margin-right: 6px;']"));
        //bu locater ile text gelmedi, parent locator'di, bir alt tag ile arattik
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa']"));

        for (WebElement element : elements) {
            System.out.println(element.getText());

        }
        //normalde 8 checkbox vardi o bolumde
        //ama bu common locator 7 sini verdi , 8. farkli yazilmis html'de

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

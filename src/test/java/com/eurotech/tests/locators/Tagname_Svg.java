package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tagname_Svg {
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

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

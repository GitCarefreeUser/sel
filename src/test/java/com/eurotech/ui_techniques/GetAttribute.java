package com.eurotech.ui_techniques;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAttribute {

    /*
    tag satirinda atrribute'larin value'larini almak icin
    getAttribute( "") icine , attribute ismini yazar
    sout ile
    o attribute'in = sonrasi yazan value'sunu yazdirir

    */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");

    /*
    burda locate ettigimiz code
    driver.findElement(By.xpath("//input[@type='radio']")).click();
    normalde html'de var--HATTA BU LOCATER HIC HIGLIGHT YAPMADI PAGE'TE FRUITS KISMINDA
    ERHAN HOCANIN VIDEOSUNDA BULUYORDU ????

    ama bu haliyle  kullanamayiz, interactable hatasi verir
    html satirinda
    <input type="radio" value="153" name="itemParentCat" style="display:none" xpath="1">
    style=display.none diyor
    bu ifade interactable hatasina yol acar
    UI da yok o an icin
    Alert: This element is not interactable through selenium(automation) as it is not visible in UI.
    UI da yok ulasamaz selenium
    altindaki diger tag ile locate edecegiz
     */

        WebElement tt=driver.findElement(By.xpath("//input[contains(@value,'153')]"));
        System.out.println(tt.getAttribute("type"));

//        WebElement fr=driver.findElement(By.xpath("//div[contains(text(),'Fruits')]"));
//        fr.click();
        tt.click();



        //contains ile locate ederken = yok yerine , kullaniyorduk-hatirlatma


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

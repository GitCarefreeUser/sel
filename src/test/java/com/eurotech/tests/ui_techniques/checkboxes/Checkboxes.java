package com.eurotech.tests.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkboxes {
    /*
    radio button'dan farki
    birini secmemiz digerini etkilemiyor
    birden fazlasini secebiliriz

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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement e1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement e2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        e1.click();
        Assert.assertTrue(e1.isSelected());
        Assert.assertTrue(e2.isSelected());

        e2.click();
        Assert.assertTrue(e1.isSelected());
        Assert.assertFalse(e2.isSelected());

        /*
        ustteki assertlerde manual olarak site incelenmeli once
        bunlar checkboxe
        ilk sayfa acildiginda default olarak 1 secili degil 2 secili geliyor
        biz testte 1 i clickledik ve ikisi de secili oldu
        2 true bekledik

        sonra e2 yi clickledik bu sefer e2 seciliden cikti
        1 true 1 false bekledik

        manuel bu yapiyi gorup kodu oyle yazmak lazim
        yoksa e1 cliklenince e2 bosa cikiyordur diye dusunmek hataya yol acar
        checkbox birbirini etkilemez
        hepsi de secili olabilir
         */


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

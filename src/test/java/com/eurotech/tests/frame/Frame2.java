package com.eurotech.tests.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frame2 {
    /*
     selenium'a switchTo().frame() ile bilgi verdik
     ve diyelim drag and drop yaptik
     isimiz bitti
     sonra ayni page'te eger frame disinda bir yere tiklayacaksak
     selenium'u default hale cevirmemiz gerekir

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
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        Actions a=new Actions(driver);
        a.dragAndDrop(source,target).build().perform();

        //burda frame ile isimiz bitti
        //sayfada baska bir yere tiklayacagiz
        //defaulta donelim
        //2 tane metot ile yazabiliriz

        //1-driver.switchTo().defaultContent();
        //2-driver.switchTo().parentFrame();
        /*
        mesela icice yani nested frame varsa
        ikinci metot
        en icteki frameden bir ust frame'e cikarir
        en tepeye orjinal html'e donmek icin
        ayni metodu tekrar yazmaliyiz yani iki kere

        ama birinci metotta iki kere yazmaya gerek yok o direk html'e cikartir
         */
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Draggable")).click();


    }



    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }
}

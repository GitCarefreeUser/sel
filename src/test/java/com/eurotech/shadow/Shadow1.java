package com.eurotech.shadow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shadow1 {
    /*
    shadow icin 2 yol var
    1-
    DOM'da shadow yazili satirin bir ustunu locate ediyoruz
    SearchContext shadow1 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();

    seklinde SearchContext type'indan variable'a assign ediyoruz ve
    getShadowRoot() metodunu cagiriyoruz
    2-
    WebElement shadow1=driver.findElement(By.cssSelector("#userName"));
    SearchContext shadow2 = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",shadow1);

    burda shadow'un ait oldugu-bir ust satir- yeri locate ediyoruz
    javascrptli satira argument olarak gonderiyoruz

    IKI YONTEM DE CALISIR
    AMA IKINDE TEK SATIR KODLA IS HANDLE OLUYOR

    HER IKI YONTEM SONRASI:

    bu SearchContext type'indaki variable. (dot) ile direk findelement diyoruz
    burda shadow altindaki istedigimiz elementi locate ediyoruz
    shadow1.findElement(By.id("kils")).sendKeys("slm");
    aslinda scope locate'i bu, normal code'ta driver.findelement dedigimizde
    tum page'te ariyoruz
    ama shadow.findelement deyince
    shadow locater'indandan itibaren, yani sayfanin o kismindan itibaren ara demis oluyoruz
    ulasmak istedigimiz elementin host'u shadow
    YANI ELEMENTI SHADOW ICINDE ARIYORUZ

    intelliJ'i kapatip acinca bazen getShadowRoot() metot kismini sadece-silip tekrar yazmak gerekiyor
    shadow bulamiyor
    no such shadow root hatasi veriyor

    bazen element iki shadow icinde olabiliyor

    gozle ustu kontrol etmek lazim: TEST2 boyle ornek

    bu durumda 2. shadow'u locate ederken
    driver.findelement degil de--scope gibi--
    shadow1.findelement deriz
    (ilk shadow variable ismi:shadow1)

    DIGER BIR KONU:
    shadow altindaki elementi xpath ile locate edemeyiz
        invalid locator hatasi verir
        shadow1.findElement(By.xpath("//input[@id='kils']")).sendKeys("slm");

        By.id veya By.cssSelector ile locate etmemiz lazim

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
        driver.get("https://selectorshub.com/xpath-practice-page/");

        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "#userName";
        Thread.sleep(1000);
      //  SearchContext shadow1 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
        WebElement shadow1=driver.findElement(By.cssSelector("#userName"));
       SearchContext shadow2 = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot",shadow1);

        //shadow u locate ederken xpath, css ayrimi yok
        //SearchContext shadow1 = driver.findElement(By.xpath("//div[@id='userName']")).getShadowRoot();
        //SearchContext shadow1 = driver.findElement(By.id("userName")).getShadowRoot();
        Thread.sleep(1000);
        //shadow1.findElement(By.cssSelector("#kils")).sendKeys("slm");
        shadow2.findElement(By.id("kils")).sendKeys("slm");
        //shadow altindaki elementi xpath ile locate edemeyiz
        //invalid locator hatasi verir
        //shadow1.findElement(By.xpath("//input[@id='kils']")).sendKeys("slm");

        //By.id veya By.cssSelector ile locate etmemiz lazim


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");

        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "#userName";
        String cssSelectorForHost2 = "#app2";
        Thread.sleep(1000);
        SearchContext shadow1 = driver.findElement(By.id("userName")).getShadowRoot();
        Thread.sleep(1000);



        /*
        ilk shadow 'u locate edip searchcontext type'inda variable'a atadik
        burda scope gibi gorelim ve ikinci shadowu locate ederken
        drive.findelement degil de
        shadow1 . findelement
        diyoruz
        aradigimiz elementin hostu driver-tum page degil, shadowun locateri
         */
        SearchContext shadow2 = shadow1.findElement(By.cssSelector("div[id='app2']")).getShadowRoot();
        Thread.sleep(1000);
        shadow2.findElement(By.cssSelector("#pizza")).sendKeys("pizza");
    }
}

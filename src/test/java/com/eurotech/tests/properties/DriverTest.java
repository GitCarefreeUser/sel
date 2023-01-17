package com.eurotech.tests.properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverTest {
    /*
    normalde soyle yapiyorduk:
    ....................................
      WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    .....................................
    artik soyle kullanicaz:
    ..................
    WebDriver driver = Driver.get();
    ...................

    utilities folder'ina Driver class'i olusturduk
    Driver.get() ile ustteki kurulumu saglayan iki satir ordan otomatik gelicek
    Driver.get() ile Driver classinin get metoduna gidecek
    configuration.properties'e yazdigimiz browser=.... de yer alan
    chrome'sa Driver.get() metodunda o kismi bulup kurulumu ona gore yapicak
    ama configuration.properties'e firefox vb. yazarsak kurulumu onun browser'i ile yapacak

    configurationReader ordan--configuration.properties'ten alip metoda getirecek
    ve kurulum arka planda yapilacak

    artik
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        yazmaya gerek yok

        Driver classinda get() metoduna bak
        ConfigurationReader gidip configuration.properties'ten browser type'ini aliyor

     */

    @Test
    public void test3() {

        WebDriver driver = Driver.get();

        driver.get("https://www.google.com");

    }

    @Test
    public void test4() {

        WebDriver driver = Driver.get();

        driver.get("https://www.amazon.com");
    }

}

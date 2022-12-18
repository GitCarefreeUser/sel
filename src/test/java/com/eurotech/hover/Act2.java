package com.eurotech.hover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Act2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();

    }
    /*
    once Action classindan nesne create ediyoruz
    webdriver driver =....ile ustte beforemethod'ta tanimladigimiz driver'i
    parametreye gonderiyoruz

    hover ile yani mouse'u uzerine getirecegimiz kismi locate ediyoruz
    actions 'tan olusturdugumuz nesnenin moveTo( ) methoduna bu locate'i parametre gonderiyoruz
    actions metotlari build().perform() ile biter
    ac.moveToElement(hov).build().perform();
    bu kod satiri su anlama geliyor:  mouse'umuz hover yaptik yani
    istedigimiz kisma goturduk-tiklamadan
    mouse o kisma geldigi icin ekranda page'te baska sey aciir
    bizim sayfada acilan sey : view profile yazisi
    yani biz ac.moveToElement(hov).build().perform(); yazinca
    page'te mouse oraya gidiyor ve bu yazinin acilmasini sagliyor

    o yazi acildigi icin locate ediyoruz o yaziyi
    sout yapariz ya da assertTrue da isDisplayed diye kullaniriz

     */
    @Test
    public void Test1(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement hov=driver.findElement(By.xpath("(//img)[2]"));
        Actions ac=new Actions(driver);
        ac.moveToElement(hov).build().perform();
        WebElement vp = driver.findElement(By.xpath("//a[@href='/users/1']"));
        System.out.println(vp.getText());
        Assert.assertTrue(vp.isDisplayed());

    }
}

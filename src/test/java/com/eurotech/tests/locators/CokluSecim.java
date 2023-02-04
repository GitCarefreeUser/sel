package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CokluSecim {
    /*
    alttaki test'te
    sayfada tablo var ve sag sutunu alicaz

    //td[4]  bu 10 match buluyor
    su demek: en az 4 kardesi olan td 'den 10 tane var
    Parent -->  tr xpath="1">
                     <td>Jack</td>
                     <td>Engineer</td>
                     <td>Pune</td>
                     <td>32</td></tr>

     html'de bu sekilde td childi 4 tane olan parentlar var
     bunlarin sayisi 10
     10 parentin her biri de td tagnameli kardes sayisi 4 olan chldlara sahip

     bize sadece tablonun td si lazim
     bu td ler icinde sadece tablonunkini vericek olan lazim
     //td[4] dom'da ctrlf ile yazinca her bir match'te sayfanin neresiyse orasi cercevelenir ekranda
     tabloya geldigimizde, tablo yandiginda
     o td'nin parentina cikariz,
     parentina ciktik tablonunkinin:

    tr/td[4]
    td nin bir ustu tr ama tr/td[4] da istedgimizi vermedi
    tekrar unique bir parent lazimdi ve o da su:

     //div[@class='tableFixHead']//    53.satirda


     */
    @Test
    public void test1() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr/td[4]"));
        for (WebElement element : elements) {
            System.out.println(Integer.parseInt(element.getText()));

        }
    }
}

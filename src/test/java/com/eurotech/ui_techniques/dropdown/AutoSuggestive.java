package com.eurotech.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

        /*
        sayfaya 2-3 harflik bir kelime gonderince
        page'te sitenin otomatic onerdigi yerler aciliyor
        alt alta liste seklinde
        ordan istedigimizi alacagiz
        buna AUTOSUGGESTIVE DROPDOWNS deniyor
         */

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        /*
        amacimiz
        bu locater'daki tum items'lari almak
        o yuzden findelements dedik, s var sonda
        driver.findelements....sonda sag click deyince List e atilacagini ide soyluyor zaten
        return type'i list of elements

        tekli findelement dedigimizde de return type'i Webelement idi
        rahulFlight classinda 19. satirda ornek yapmistik

        bu code generic oldu
        sendkeys'te ne gonderirsek ona gore cikacak sonuclari verecek

         */

        //altta iter'da options icindeki tum locaterlar-tum itemlar
        //sirayla yazar
        //option icinde tekli varlar
        //options variable'inda hepsi var
        for (WebElement option : options) {
            System.out.println(option.getText()); //options'a store ettigimiz yerlerin tek tek textini alicaz
            //oralar neresiyse
            //bize india lazim, onu da if'le bulalim
            if (option.getText().equalsIgnoreCase("india")){
                option.click();
                break;  //break if'e en yakin loopu sonlandirir , bu ornekte de for loop'tan cikar
                //if oncesi sout var ama break, india bulunuca for loopu tamamen keser
                //kalanlari yazmadan cikacak
            }

        }

    }
}

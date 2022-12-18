package com.eurotech.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//static dropdown with SELECT CLASS
public class rahulFlight {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //once select tag'li dropdown'un yerini buluyoruz
        WebElement element=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        //sonra select object'mize bu yeri pass ediyoruz ki select object'si select tag'inin yerini bulsun html'de
        Select staticDropDown=new Select(element);

        //select classindaki metotlardan faydalanicaz
        //ilki index noya gore secmek
        staticDropDown.selectByIndex(3); //bu code git 3.indexi sec demek
        //click filan demeye gerek yok

        //secili olani getirecek, dondurdugu deger webelement
        //getText() ile texti aliyoruz
        //sectigimizi getirecek, bir nevi assert gibi gayriresmi
        //assert'lere gecmeden bu sekilde saglama yaptik
        System.out.println(staticDropDown.getFirstSelectedOption().getText());

        //ikincisi visibletext
        //dropdown listedeki elementleri text isimlerine gore seciyoruz
        staticDropDown.selectByVisibleText("AED");

        //SAGLAMA YAPALIM, NE SECTIYSEK YAZDIRSIN
        System.out.println(staticDropDown.getFirstSelectedOption().getText());

        //ucuncusu value
        //html'de soyleydi:  <option value="USD">USD</option>
                                    //attribute - text
        //aldigimiz -value attribute'nun- value'su
        //attribute ismi value
        //onun value'su ="" icinde
        //html'de text ile attribute'un value'su ayni yazilmis
        //text olani degil value='USD'  den value'yu aliyoruz
        staticDropDown.selectByValue("USD");
        System.out.println(staticDropDown.getFirstSelectedOption().getText());

        //getfirstselectedoptions'u assert gibi kullandik
        //ne sectigimizi gormek icin
        //normalde assertion kullanilir
        //sonraki classlarda var o konu


    }
}

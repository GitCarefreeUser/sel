package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class siblings {

    /*
    css'te yukari dogru parent'a cikamayiz
    xpath'te cikariz
    ---------------------------------------------------------
    //header/div/button[1]/following-sibling::button[2]

    bu kodda //header/div/button[1] kismindan
    parent to child anlasiliyor
    ama
    following-sibling::button[2] kismindan
    siblingler arasi gexdigini anliyoruz
    following dedigi icin de en son geldigi button[1] kismi da aslinda siblinge dahil
    folllowing-sibling dedigi button[1] 'in sonrasinda yer alan siblingleri

    //header/div/button[1]/parent::div
    burda da ilk parent'a ciktik

    bir ust parent'a cikmak icin :
    //header/div/button[1]/parent::div/parent::header
    tekrar yazariz parent::

    grandparent'a direk cikamayiz, parent'lari takip edicez

     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).click();

                //bu page henuz demo asamasinda
        //ama textini alalim buttonun

        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());


        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText());

        //WebElement names=driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header"));
       // System.out.println(names);



    }
}

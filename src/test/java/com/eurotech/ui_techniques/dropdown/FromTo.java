package com.eurotech.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromTo {

    //DYNAMIC DROPDOWN

    //alttaki ornekte rahul 52.videosundan
    //videoda indexle yapti ama sayfa html yapisi degismis olabilir index[] no yazmadan da burda caisti
    //53. videoda bu index nolu locate'i bazi larinin sevmedigini
    //hardcoding kabul ettigini bu nedenle parent to child seklinde yazmayi anlatti
    //FromTo2 classinda o ornek var oraya GEC

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[text()='From']/following-sibling::div")).click();

        driver.findElement(By.xpath("//div[text()='Ajmer']")).click();
        driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();



    }
}

package com.eurotech.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//STATIC DROPDOWN --WITHOUT SELECT CLASS



public class Passengers {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[text()='1 Adult']")).click();

        //tag yerine * da koyabiliriz
        //driver.findElement(By.xpath("//*[.='1 Adult']")).click();
        //driver.findElement(By.xpath("//div[contains(text(),'1 Adult')]")).click();

        //alt satirda yolcu sayisini tiklayarak seciyoruz
        //driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        //mesela 4 yetiskin secicez
        //bu kod satirini alt alt 4 defa yazmak bir cozum :)
        //onun yerine while loop kullanmak daha clean :)

        //while loop ornegi bu-devaminda da for ile yapicaz
        /*

        int i=1;
        while (i<5){
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            i++;
        }
        //1-2-3-4- defa clickleyecek
        //ilk clickte 2 yolcuya cikicak
        //i=2 de 3 yolcu olur---i=3 de 4----i=4 de 5 yolcu ve
        //i<5 nedeniyle looptan cikar

         */
        //FOR loop ornegiyle aynisini yapalim:

        for (int i=1;i<5;i++){
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'5 Adults')]")).getText());
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();

    }
}

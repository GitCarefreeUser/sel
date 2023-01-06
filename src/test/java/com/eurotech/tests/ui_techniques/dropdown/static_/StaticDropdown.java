package com.eurotech.tests.ui_techniques.dropdown.static_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticDropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.aspnetawesome.com/");
        WebElement element = driver.findElement(By.xpath("//button[@id='MultichkMealsSbm-awed']/div[@class='o-cptn']"));
        element.click();
        List<WebElement> vegetables = driver.findElements(By.xpath("(//div[.='Mango'])[13]/../../li"));
        System.out.println(vegetables.size());

        for (WebElement vegetable : vegetables) {
            System.out.println(vegetable.getText());
        }
        System.out.println(vegetables.get(0).getText());
       System.out.println(vegetables.get(1).getText());

    }
}

package com.eurotech.ui_techniques.dropdown.static_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Fullhd {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.fullhdfilmizlesene.pw/yeni-filmler-izle-2/12");
        WebElement movie= driver.findElement(By.name("tarz"));

        Select sl=new Select(movie);
        movie.click();  //CLICKLEMEDEN KOD CALISMIYOR ???????


        sl.selectByVisibleText("Türkçe Dublaj");
        List<WebElement> options = sl.getOptions();
        System.out.println(options.size());
        System.out.println(sl.getFirstSelectedOption().getText());
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
}

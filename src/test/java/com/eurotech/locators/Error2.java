package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Error2 {

    //NoSuchElementException  no such element: unable to locate element
    //selenium is saying no such element is present
    //it could not identify the element , but we confirmed that it's there

    //it is failing due to the time out issue
    //when i click on the sign in button, it takes a few minutes to show the error message on the page
    //but selenium is immediately trying to get text
    //but at the time we clicked on the sign in button , the message is not ready yet
    //it needs two seconds to show html componenet
    //selenium is very fast , it checks at miliseconds and at that time the message is not yet shown on the page
    //because of that synchorization issue, it fails saying that the element is not display

    //the solution s implicit wait



    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
    }
}

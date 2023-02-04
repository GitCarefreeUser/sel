package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AradaTirnak {

    /*
    By.xpath("//input[@type='email']")
    bu ornekte [@type='email'] de = sonrasini  normalde '' arasinda yaziyoruz
    ama
    DOM'da mesela soyle bir value var:
    Valentine's Day
    burda text icinde bir ' var
    attribute='' yerine
    attribute="" olarak cift tirnak icine yazicaz
    ama
    burdaki cift tirnak  \"Valentine's Day\"
    seklinde yazilir
    yoksa coompiler hata verir
    en distaki "" ler var zaten
    value'yu da "" icine alinca-ozel karakter gibi-
    \ lazim
    By.xpath("//img[@alt="Valentine's Day"]") orneginde

    By.xpath("//img[@alt=\"Valentine's Day\"]") seklinde yazariz

     */

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.nl/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.nl%2Fgp%2Fyourstore%2Fhome%3Flanguage%3Den%26path%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&language=en&openid.assoc_handle=nlflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

        //driver.findElement(By.id("ap_email")).sendKeys("aydinserbest34@gmail.com");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("aydinserbest34@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Sa21342134");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.xpath("//img[@alt=\"Valentine's Day\"]")).click();
    }
}

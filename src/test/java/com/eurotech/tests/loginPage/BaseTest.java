package com.eurotech.tests.loginPage;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

public class BaseTest extends TestBase {
    /*
    page'te ilk acilista ekrana gelen buttonlardan bazilari
    diger sayfalara gecsek bile degismez
    ornek amazon ust satirlardaki yan yana butonlar
    amazon'un her page'inde onlar yer aliyor
    bu tur butonlar basepage'e konabilir

    diger turlu sayfada her ayri modul icin pages folder'i altina bir class acip
    locater'ari oraya koyariz

    ornek loginPage
    dashboardPage
    addCart ...gibi

     */

    @Test
    public void test1() throws InterruptedException {
        LoginPage lp=new LoginPage();
        DashboardPage dp=new DashboardPage();
        lp.understandBtn.click();
        lp.loginBtnBasePage.click();
        lp.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        lp.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        lp.loginBtnLoginPage.click();
        Thread.sleep(500);
        List<WebElement> dashboardMenus = dp.dashboardMenus;
        for (WebElement dashboardMenu : dashboardMenus) {
            System.out.println(dashboardMenu.getText());

        }



    }
}

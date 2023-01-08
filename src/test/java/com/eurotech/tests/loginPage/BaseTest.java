package com.eurotech.tests.loginPage;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

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
    public void test1() {
        LoginPage lp=new LoginPage();
        lp.understandBtn.click();
        lp.loginBtnBasePage.click();
        lp.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        lp.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        lp.loginBtnLoginPage.click();

    }
}

package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage{

    @FindBy(id="user-name")
    public WebElement username;

    @FindBy(css="input[name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@class='submit-button btn_action']")
    public WebElement loginButton;

    //usttekilere ilave bir de findall var
    //ayni elementi iki ayri locate ederiz
    //veya demek--ya biri ya biri hangisi varsa getir demek

    @FindAll(
            {
                    @FindBy(id="login-button"),
                    @FindBy(name = "login-button")
            }
            )
    public WebElement loginButton2;

    //ustteki findAll --> or-veya demekti
    //her ikisini de sagla demek istedigimizde
    @FindBys(
            {
                    @FindBy(id="login-button"),
                    @FindBy(name = "login-button")
            }
    )
            public WebElement loginButton3;


}

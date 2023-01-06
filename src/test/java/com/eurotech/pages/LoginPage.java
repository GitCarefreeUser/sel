package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="user-name")
    public WebElement username;

    @FindBy(css="input[name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@class='submit-button btn_action']")
    public WebElement loginButton;
}

package com.eurotech.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
        //bu sayfada bulunan element ve methodlari kullanmama izin veriyor.
    }

    @FindBy(linkText = "Developers")
    public WebElement developers;

    @FindBy(linkText = "Login")
    public WebElement loginBtnBasePage;

    @FindBy(xpath = "//span[contains(text(),'Google')]")
    public WebElement signWithGoogle;

    @FindBy(xpath = "//span[contains(text(),'Github')]")
    public WebElement signWithGithub;

    @FindBy(linkText = "Sign Up")
    public WebElement signUp;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;


    public void navigateToMenu(String menuName) {

        WebElement menu =   Driver.get().findElement(By.xpath("//a[text()='" + menuName + "']"));

        menu.click();
    }



}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {

    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@role='button']")
    public WebElement ilkLoginButonu;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement emailTextBox;


    @FindBy(xpath = "//input[@id='formBasicPassword']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement ikinciLoginButonu;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement kullaniciProfilIsmi;


}
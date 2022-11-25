package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {

        // http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //login kutusuna "username" yazin
        WebElement loginKutusu = driver.findElement(By.xpath("//input[@name='user_login']"));
        loginKutusu.sendKeys("username");

        //password kutusun "password" yazin
        WebElement passKutusu = driver.findElement(By.xpath("//input[@id='user_password']"));
        passKutusu.sendKeys("password");

        //sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        //online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        // "Currency" drop down menusunden Eurozone'u secin
        WebElement ddo= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String secilenOption= select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption, "secilen option uygun degil");


        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionList = select.getOptions();
        
    }
}

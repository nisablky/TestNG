package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BrcPage brcPage;

    @Test
    public void yanlisSifre() throws InterruptedException {
        brcPage= new BrcPage();

        // bir test method olustur pozitiveLoginTesti()
        //  https://www.bluerentalcars.com/  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        Thread.sleep(2000);
        brcPage.ilkLoginButonu.click();


        // test data user email :  customer@bluerentalcars.com  ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }

    //bu class'da iki test methodu daha olusturun
    //biri yanlıs kullanıcı
    //digeri de yanlis sifre ve kullanici adi
}

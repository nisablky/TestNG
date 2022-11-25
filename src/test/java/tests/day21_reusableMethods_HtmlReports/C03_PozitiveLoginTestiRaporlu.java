package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PozitiveLoginTestiRaporlu extends TestBaseRapor {


    BrcPage brcPage= new BrcPage();

    @Test
    public void pozitiveLoginTest() {

        extentTest=extentReports.createTest("Pozitive Login", "Gecerli username ve sifre ile giris yapabilmeli");

        // bir test method olustur pozitiveLoginTesti()
        //  https://www.bluerentalcars.com/  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        // login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tiklandi");

        // test data user email :  customer@bluerentalcars.com  ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("login butonuna basildi");

        //degerleri girildiginde sayfaya basarili sekilde girilebildigini test
        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);
        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();


    }
}

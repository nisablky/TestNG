package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {

    BrcPage brcPage = new BrcPage();

    @Test
    public void pozitiveLoginTest() {


        // bir test method olustur pozitiveLoginTesti()
        //  https://www.bluerentalcars.com/  adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data user email :  customer@bluerentalcars.com  ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //degerleri girildiginde sayfaya basarili sekilde girilebildigini test
        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername,expectedUsername);

        Driver.closeDriver();


    }
}
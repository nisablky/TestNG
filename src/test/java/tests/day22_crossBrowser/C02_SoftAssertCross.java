package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C02_SoftAssertCross extends TestBaseCross {

    @Test
    public void test01() {

        //softassert baslangici obje olusturmaktir
        SoftAssert softAssert = new SoftAssert();

        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //title'in Amazon icerdigini test edin
        String expectedTitle ="Amazon";
        String actualTitle =driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        //arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "arama kutusuna erisilemiyor");

        //arama kutusuna nutella yazip aratin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //arama yapildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        //arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Nutella"),"sonuc yazisi Nutella icermiyor");

        //softassert'e biitis satirini soylemek icin assertAll() kullanilir
        //bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();

        /*
        softassert'un hata bulsa bile calısmaya devam etme ozelligi
        assertAll()'a kadar
        eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */

        System.out.println("assertion'larda fail olan olursa, burasi calismaz");
    }
}

package com.eurotech.addingCart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartAdd {
    WebDriver driver;
    String[] itemsNeeded={"Brocolli", "Potato", "Apple", "Strawberry", "Walnuts"};
    int j=0;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    /*
    page'teki urunlerin hepsini list'e attik
    getText ile yazdirdik
    urunu koda yazrken sadece cucumber cikmiyor
    Cucumber - 1 Kg cikiyor
    split ile bunu sadece cucumber'a donusturecez
     */
    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> h4 = driver.findElements(By.tagName("h4"));
        System.out.println(h4.size());


        for (WebElement veg : h4) {
           // System.out.println(veg.getText());--> bu uzun halini cikti verir
            String justName = veg.getText().split(" ")[0].trim();
            System.out.println(justName);

        }


    }
    /*
    ustte class seviyesinde define ettigimiz urun listemizi
    array'den
    arrayList'e cevirdik--hem memory'i yormaz
    hem de search'unden faydalanicaz

    ikinci konu da ustte istedigimiz listeden bir urun geldiginde if'e
    add to cart dicez ama add to cart DOM'da 30 tane var-urun sayisi gibi
     ve her urun locate'inin altinda tanimli DOM'da
     ona if icinde bak - incele
     */
    @Test
    public void test2() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> h4 = driver.findElements(By.tagName("h4"));
        System.out.println(h4.size());

        //array To arrayList
        List<String> newList = Arrays.asList(itemsNeeded);

        for (int i = 0; i < h4.size(); i++) {

            String justName = h4.get(i).getText().split(" ")[0].trim();

            /*
             siteden gelen urunleri h4'e attik ,
               bu h4 isimli list'i sirayla for icinde cagirip, elemanlarini sadece isim ve string olarak
               aldik-tek tek
               aldigimiz isim(siteden geliyor hala)
               simdi de o tekli gelen urun
                itemsNeeded urun listemizde var miyi karsilastiricaz

                ama karsilastirmayi newList ile yapicaz
                cunku itemsNeeded'i array'den arrayList'e cevirmistik 70.satirda

             */
            /*
            newList bizim onceden verili-urunlerimiz
            sayfada bunlari tiklayip add to cart yapicaz
            bizim listemizde, siteden gelen urun le tutuyor mu diye
            if'li bir condition kurduk
            yani siteden gelen urun bizim listemizde var mi varsa
            if icine gir diyoruz

            if icine niye giriyor
            cunku sitede o urune geldi mi add to cart demesi lazim


             */
            if (newList.contains(justName)){
            /*
               alttaki kod add to cart'in locate'i ve return type'i list,

               driver.findElements(By.xpath("//div[@class='product-action']/button"))

               ama list'e assign etmeden de sanki list'in icinden get(i) ile bir elemani cagirir gibi
               assignsiz cagiricaz
               yani diyelim cucumber 4. eleman
               bizim add to cart locate'inde de 4. ye tiklamamiz lazim

               NORMALDE LOCATE'I findelement 'te text ile de yapabilirdik
               ama text kullandigimizda mesela ilk urunu add to cart dedigimizde
               listeye gelen add to cart locate'lerinde kayma oluyor cunku biri DOM da add to cart 'dan degisiyor
               added oluyor
               tiklamada baska urun atiyor

               daha garanti olsun diye parent/toChild ile locate ettik


             */
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }

        }
    }

    /*
      ustteki testte ornek 5 urun secip, page'te add to cart dedik
      ama 5. yi de ekledikten sonra siteden gelen urunlerde hala ayni isimli baska urun var mi
      diye aramaya devam edecek
      liste tamamlaninca
      break dicez
      bunu da newList 'in size'ini kullanarak sinirlayalim
       */
    @Test
    public void test3() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> h4 = driver.findElements(By.tagName("h4"));
        System.out.println(h4.size());

        //array To arrayList
        List<String> newList = Arrays.asList(itemsNeeded);

        for (int i = 0; i < h4.size(); i++) {

            String justName = h4.get(i).getText().split(" ")[0].trim();


            if (newList.contains(justName)) {
                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j==newList.size()){
                    break;
                }
            }

        }
    }
    /*
    urunleri list'e atmistik , tek tek alip yeni bir <string > list'e attik
     */
    @Test
    public void test4() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> h4 = driver.findElements(By.tagName("h4"));
        System.out.println(h4.size());

        List <String>newList = new ArrayList<>();
        for (WebElement veg : h4) {

            String justName = veg.getText().split(" ")[0].trim();

            newList.add(justName);

        }
        System.out.println(newList);

    }
}

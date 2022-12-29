package com.eurotech.addingCart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartVegsDeneme {
    WebDriver driver;
/*
    @DataProvider
    public Object [][] test123(){
        String [][]data ={{"Turkey","Ankara"},
                {"Germany","Berlin"},
                {"UK","London"},
                {"Scotland","Edinburgh"},
                {"Netherlands","Amsterdam"},
                {"Saudi Arabia","Riyad"},
                {"United Arab Emirates","Abu Dabi"}
        };
        return data;
    }

 */
/*


    @Test(dataProvider = "test123")
    String[] consumerVegs=new String[]{"Brocolli", "Cauliflower", "Cucumber", "Beetroot",
            "Carrot", "Tomato", "Beans", "Brinjal", "Capsicum", "Mushroom", "Potato",
            "Pumpkin", "Corn", "Onion", "Apple", "Banana", "Grapes", "Mango",
            "Musk", "Orange", "Pears", "Pomegranate", "Raspberry", "Strawberry",
            "Water", "Almonds", "Pista", "Nuts", "Cashews", "Walnuts"};


 */
String[] consumerVegs=new String[]{"Brocolli", "Cauliflower", "Cucumber", "Beetroot",
        "Carrot", "Tomato", "Beans", "Brinjal", "Capsicum", "Mushroom", "Potato",
        "Pumpkin", "Corn", "Onion", "Apple", "Banana", "Grapes", "Mango",
        "Musk", "Orange", "Pears", "Pomegranate", "Raspberry", "Strawberry",
        "Water", "Almonds", "Pista", "Nuts", "Cashews", "Walnuts"};

    public static List<String> getElementsText(List<WebElement> list) {
        List<java.lang.String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    /*
    alisveris arrayini kullanici girsin
    asagida arraylaeri if le karsilastir
    musterinin verddigi arrayicinde , for la page'ten gelen list icindeki elemanlari karsilastirma mesela

            scanner la filan da olabilir
            String[] vegs musteriden gelsin
            pageteki 30 sebze izmini arraye ya da liste atalim
            ikisini kiyasla
            tutuyorsa add to cart a tiklasin

            HINTLININ VIDEOLARINDA VARDI GIBI ARRAY KIYASLAMA

     */
    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String []names = products.get(i).getText().split(" ");
            String formattedName=names[0].trim();

            List purchase= Arrays.asList(consumerVegs);
            // if (name.contains("Cucumber")){
            if (purchase.contains(formattedName)) {
                System.out.println(products.get(i));
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

            }

        }
    }
        @Test
        public void test2() {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            for (int i = 0; i < products.size(); i++) {
                String name=products.get(i).getText().split(" ")[0].trim();
                // if (name.contains("Cucumber")){
                if (name.equalsIgnoreCase("Cucumber")){
                    System.out.println(products.get(i));
                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                }

            }



        }
        /*
        String[] veges=new String[]{"Brocolli", "Cauliflower", "Cucumber", "Beetroot",
                "Carrot", "Tomato", "Beans", "Brinjal", "Capsicum", "Mushroom", "Potato",
                "Pumpkin", "Corn", "Onion", "Apple", "Banana", "Grapes", "Mango",
                "Musk", "Orange", "Pears", "Pomegranate", "Raspberry", "Strawberry",
                "Water", "Almonds", "Pista", "Nuts", "Cashews", "Walnuts"};

         */
        @Test
        public void test4(String[]expectedList) {   //List<String> expectedList


            List<String> consumerList = new ArrayList<>();
            consumerList.addAll(Arrays.asList(consumerVegs));
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            List<String> actualList = new ArrayList<>();

            for (WebElement product : products) {
                actualList.add(product.getText().split(" ")[0].trim());

            }
            System.out.println(consumerList);
            System.out.println(actualList);

            Assert.assertEquals(consumerList, actualList);
        }
    @Test
    public void test3(String[]expectedList) {   //List<String> expectedList


        List<String>consumerList = new ArrayList<>();
        consumerList.addAll(Arrays.asList(consumerVegs));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/cart");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List<String> actualList= new ArrayList<>();

        for (WebElement product : products) {
            actualList.add(product.getText().split(" ")[0].trim());

        }
        System.out.println(consumerList);
        System.out.println(actualList);

        Assert.assertEquals(consumerList,actualList);
//        System.out.println(actualList);
//        System.out.println(actualList.size());
//        List<String> expectedList=actualList;
//
//        System.out.println(consumerList);

//        List<String> expectedList1= {new ArrayList<>(}"Brocolli", "Cauliflower", "Cucumber", "Beetroot",
//                "Carrot", "Tomato", "Beans", "Brinjal", "Capsicum", "Mushroom", "Potato",
//                "Pumpkin", "Corn", "Onion", "Apple", "Banana", "Grapes", "Mango",
//                "Musk", "Orange", "Pears", "Pomegranate", "Raspberry", "Strawberry",
//                "Water", "Almonds", "Pista", "Nuts", "Cashews", "Walnuts"};
        //System.out.println(expectedList);

//        for (int i = 0; i < products.size(); i++) {
//            String []names = products.get(i).getText().split(" ");
//            String formattedName=names[0].trim();
//
//            List purchase= Arrays.asList(vegs);
//            // if (name.contains("Cucumber")){
//            if (purchase.contains(formattedName)) {
//                System.out.println(products.get(i));
//                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//
//            }
//
//        }
    }
}

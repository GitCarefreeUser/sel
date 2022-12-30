package com.eurotech.dataProvıder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Twoo {
    /*
    URLS	                    Page Titles to be verified
“https://www.google.com/”	            “Google”
“https://www.imdb.com/”	                “IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows”
“https://www.wikipedia.org/”        	“Wikipedia”
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getData() {
        String[][] dataArray = new String[3][2];
        dataArray[0][0] = "https://www.google.com/";
        dataArray[0][1] = "Google";
        dataArray[1][0] = "https://www.imdb.com/";
        dataArray[1][1] = "IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        dataArray[2][0] = "https://www.wikipedia.org/";
        dataArray[2][1] = "Wikipedia";

        return dataArray;

    }


    @Test(dataProvider = "getData")
    public void test1(String url, String expectedTitle) {

        driver.get(url);
        String titleActual = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertEquals(titleActual,expectedTitle);

    }

    public String[][] getData2() {
        return new String[][]{
                new String[]{"https://www.google.com/", "Google"},
                new String[]{"https://www.imdb.com/", "IMDb:"},
                new String[]{"https://www.wikipedia.org/", "Wikipedia"}


        };
    }
    @Test(dataProvider = "getData")
    public void test2(String url, String expectedTitle) {

        driver.get(url);
        String titleActual = driver.getTitle();

        if (titleActual.contains(expectedTitle)){
            System.out.println("expected title = " + expectedTitle +
                                " contained in actual title = "+titleActual);
        }else {
            System.out.println("expected title = " + expectedTitle +
                    " NOT contained in actual title = "+titleActual);

        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(titleActual,expectedTitle);

    }
}
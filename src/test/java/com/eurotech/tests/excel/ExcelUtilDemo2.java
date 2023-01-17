package com.eurotech.tests.excel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExcelUtil;

public class ExcelUtilDemo2 {

    /*
    dataProvider folder'inda Onee classindaki test1'i
    burda masaustu excelimize 2.sheet olarak newUser ismiyle gecirdik
    orda [][] = ile yazmistik
    burda excelden okuma yaparak
    ayni testi yapicaz

    NOT= excelden alicagimiz veri icin excelin dogru-ilgili sheet ismini
    parametre olarak girmeyu unutmayalim

    NOT=excelde masaustunde degisiklik yaparsak
    buraya tekrar yapistirmak gerekiyor
     */

    @DataProvider
    public Object [][] getExcelData(){

        ExcelUtil dataExcel=new ExcelUtil("src/test/resources/slm.xlsx", "newUser");

        String [][] excelArray= dataExcel.getDataArrayWithoutFirstRow();

        /*
        getDataArrayWithoutFirstRow() metodu ile bize verilen exceli
        @DataProvider'a uygun hale getirdik
        artik altta yazacagimiz @Test 'i @DataProvider'a baglayip veriyi burdan alabiliriz

        EN ALTTA ACIKLAMASI VAR ORAYA BAKKKKK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */

        return excelArray;
    }
    @Test(dataProvider = "getExcelData")
    public void test1(String userName, String password,String date) {
        WebDriver driver = Driver.get();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).clear();


    }



    /*

    DataProvider folder'inda Twoo isimli classtan alinti ORNEK

    elimizde soyle bir data var
    1-url
    2-page titles

    URLS	                    Page Titles to be verified
“https://www.google.com/”	            “Google”
“https://www.imdb.com/”	                “IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows”
“https://www.wikipedia.org/”        	“Wikipedia”

        bunu excel gibi de dusunebiliriz

        testimiz calisirken bu excel gibi olan veriden bir url gelicek, o url'yi acicaz
        acilan url'nin title'ini alicaz
        verilen title ile match ediyor mu assert edicez

        ustteki excel gibi dusunelim dedigimiz tabloda
        3 url ve 3 title var
        bunun her bir url+title'ini bir array dersek
        [][] dimensional array olur
        yani arraylerden kurulu two dimensional array
        ve herbir array
        testimize gelip bir tur calisacak
        3 array var 3 defa farkli data ile testimiz run olucak
        alt alta 3 ayri veriyi iceren 3 ayri test yazmak yerine
        bu sekilde 1 defa yazarak
        3 ayri veri ile run edebilecegiz

     @DataProvider
    public Object[][] getData() {
        String[][] dataArray = new String[3][2];
        dataArray[0][0] = "https://www.google.com/";  [0][0] ve [0][1]  ile bir array olusturduk aslinda
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
     */

    /*
    resource ltindaki exceli en ustte @DataProvider icine two dimensional array cevirdik

    aslinda exceli soyle de yazabilirdik:

    String [][]dataArray=

    {
    {country, city, vegetables, music},
    {nederland, amsterdam, banana, classic},
    {england, new york, apple, rock},
    {italy, rome, icecream, pop},
    {france, paris, lemon, folk}
    return dataArray;
    }

   dataProvider folder'indaki  Onee ve Twoo isimli classlarda yaptigimiz buydu

   BIZ BIR TEST YAZIYORUZ VE O TESTTE
   LOGIN TESTI ISE MESELA KULLANICI ADI LAZIM, PASSWORD LAZIM
   BIR KULLANICI ADI VE BIR PASSWORD'U BIR ARRAY'E KOYDUK
   IKINCI BIR KULLANICI ADI VE BIR PASSWORD'U BIR ARRAY'E KOYDUK
   BU SEKILDE ARRAYLERDEN OLUSAN BIR [][] ARRAY YAPTIK
   HAZIRLADIGIMIZ TESTTE
         driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        VAR DIYELIM
        TEST ILK RUN OLURKEN
        @DataProvider altindaki veride-excelden gelen
        arrayler icindeki buna ait bilgiler gelip
        testin ilgili yerine gececek
        mevzu bu
     */
}

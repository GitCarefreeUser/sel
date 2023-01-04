package com.eurotech.excel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class First {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test()
    public void test1() throws IOException {

        // driver.get("https://practicetestautomation.com/practice-test-login/");
        FileInputStream fis = new FileInputStream("src/test/resources/slm.xlsx");
        XSSFWorkbook xw = new XSSFWorkbook(fis);

        //xw variable'inda tum excel var artik
        //exceldeki tum sheet'ler var

        //excelde islem yapabilmek icin
        // xw object'si uzerinden once istedigimiz sheet'e girmemiz lazim

        //excelde 4 sheet create ettik
        //alttaki sheets variable'inda bu 4 sheet sayis var

        int sheets = xw.getNumberOfSheets();
        System.out.println(sheets);   //4 yazar

        //bizim sheet ismi -mrb- ve biz ona access edicez
        //mrb sheet'i 0. indexte -ilk sirada
        //getSheetAt() ile index no ile gireriz:

        //XSSFSheet sheet = xw.getSheetAt(0);

        //ama bunu generic yapalim

        //eger sheet ismi -mrb- ise o sheete access et diyelim

        for (int i = 0; i < sheets; i++) {

            if (xw.getSheetName(i).equalsIgnoreCase("mrb")) {
                XSSFSheet sheet = xw.getSheetAt(i);

                //excelde mrb isimli sheet'e girdik
                //bu sheet'te excelin row'lari var
                //ornegin biz excelde 3 row yaptik
                //sheet object'mizde bu 3 row var ve
                //istedigimiz row'a girmek icin
                //rows'lara access icin de iterator kullanicaz

                /*
                 windowHandle'da da iterator kullanmistik
                 newTab folder'i,,,,LognRahul isimli classta var

                 */

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                //bununla ilk siradaki row'a acces sagladik
                // rows icinde exceldeki tum row'lar ar
                //rows.next ile ilkine geldik
                //mesela altina bir daha rows.next yazsak ikinci row'a girmis olurduk
                //row'lar arasinda geziyoruz rows.next() ile
                //her bir row icin bir next() lazim
                //bz su an ilkindeyiz

                //simdi de ilk row'un tum satiri, o satirdaki her hucre-her column
                //arasinda gezelim
                //ustte atadigimiz firstRow variable'i ilk row'da ve onda o satirin tum hucreleri yuklu
                //row'lar arasi next() ile gezdigimiz gibi
                //1 row ici her hucreye de boyle iterator ve next() lazim
                Iterator<Cell> ce = firstRow.cellIterator();

                int k = 0;
                int column = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("music")) {

                        column = k;
                    }
                    k++;
                }
                System.out.println(column);


            }


        }

    }
}


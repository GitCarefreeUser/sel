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
import java.util.ArrayList;
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
        ArrayList<String> a=new ArrayList<>();

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
        //getSheetAt() ile index no ile girmek icin:

        //XSSFSheet sheet = xw.getSheetAt(0);

        //sheet ismi ile girmek icin ise

      // XSSFSheet mrb = xw.getSheet("mrb");  deriz

        //ama bunu generic yapalim

        //eger sheet ismi -mrb- ise o sheete access et diyelim

        for (int i = 0; i < sheets; i++) {

            if (xw.getSheetName(i).equalsIgnoreCase("mrb")) {
                XSSFSheet sheetAccess = xw.getSheetAt(i);  //sheet'e girme kodu buydu

                //excelde mrb isimli sheet'e girdik
                //sheetAccess isimli object'de excelin o sheetinde
                //kac row varsa -store edildi

                //bu sheet'te excelin row'lari var
                //ornegin biz excelde 3 row yaptiysak
                //sheetAccess object'mizde bu 3 row var ve
                //istedigimiz row'a girmek icin
                //rows'lara access icin de iterator kullanicaz

                /*
                 windowHandle'da da iterator kullanmistik
                 newTab folder'i,,,,LognRahul isimli classta var

                 */

                Iterator<Row> rows = sheetAccess.iterator();
                Row firstRow = rows.next();
                //bununla ilk siradaki row'a acces sagladik
                // rows icinde exceldeki tum row'lar var
                //rows.next ile ilkine geldik
                //mesela altina bir daha rows.next yazsak ikinci row'a girmis olurduk
                //row'lar arasinda geziyoruz rows.next() ile
                //her bir row icin bir next() lazim
                //bz su an ilkindeyiz

                //Row firstRow = rows.next(); dedigimizde ilk row'a girmis olduk bunun yaninda
                //o row'un tum hucreerine de erisim hakki kazandik
                //firstRow icinde o satirdaki tum hucreler var
                //simdi de ilk row'un tum satiri, o satirdaki her hucre-her column
                //arasinda gezelim
                //ustte atadigimiz firstRow variable'i ilk row'da ve onda o satirin tum hucreleri yuklu
                //row'lar arasi next() ile gezdigimiz gibi
                //her bir row ici her hucreye de boyle iterator ve next() lazim
                //bunu cellIterator ile saglicaz

                Iterator<Cell> ce = firstRow.cellIterator();
                //ce icinde o satirin - o row'un tum hucreleri var
                // ce.next() ile ilk hucreye geliriz
                //bir daha ce.next() yazarsak ilk satir ikinci hucresine geliriz
                //86-87. line'larda da row'lar arasi aynisini yapmistik

                //ama generic yazalim
                //o row'daki istedigimiz hucreye gidelim
                int k = 0;
                int column = 0;

                //alttaki while ile -eger ce variable'inda hucre var ise
                //dedik
                //ce.next ile de o hucreye access et dedik
                // o satirda 5 hucre var ise mesela
                //while icine gelip gelip
                //alttaki next ile sirayla diger hucreye access edicek
                //ama biz ismi music olan hucreye islem yaptiricaz

                while (ce.hasNext()) {
                    Cell value = ce.next(); //return type'i intellij'de kayitli zaten--sag click'te veriyor
                    if (value.getStringCellValue().equalsIgnoreCase("country")) {

                        column = k;
                    }
                    k++;
                }
                System.out.println(column); //music isimli hucrenin indexini aldik

                while (rows.hasNext()){
                    Row next = rows.next();
                    if (next.getCell(column).getStringCellValue().equalsIgnoreCase("italy")){
                        Iterator<Cell> cellIterator = next.cellIterator();
                        while (cellIterator.hasNext()) {
                            a.add(cellIterator.next().getStringCellValue());
                        }

                    }

                }

            }


        }

    }
}


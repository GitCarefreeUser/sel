package com.eurotech.excel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Seccond {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test()
    public void test1() throws IOException {
        //excelin path'ini parametre verdik
        FileInputStream fis = new FileInputStream("src/test/resources/slm.xlsx");
        //fis object'sini de xw object'sine parametre verdik
        XSSFWorkbook xw = new XSSFWorkbook(fis);
        //xw object'sinde tum excel var
        //ama excelde sheetler-sayfalar olur
        int sheets = xw.getNumberOfSheets();
        System.out.println(sheets);   //4 yazar
        //once bir sheet'e girmeliyiz
        //index no ile
        //XSSFSheet sheet = xw.getSheetAt(0);
        //ya da ismi ile
         XSSFSheet mrb = xw.getSheet("mrb");
         //mrb sheet'indeki sayfaya girdik
        //mrb sheetinin tum row'lari mrb object'sinde

        //ONCE ROW'A SONRA
        //O ROW UZERINDEN CELL'E GIRICEZ

        //mesela 0. row'un 3 index nolu cell'ine gidelim

        Row rows = mrb.getRow(0);
        //0. index yani ilk row 'a girdik
        //ilk satir tum cell'leriyle bu rows isimli object'de store edildi
        //rows object'si uzerinden 3 index nolu cell'e gidicez
        Cell cell = rows.getCell(3);

        //0.satir 3 index nolu hucre cell object'sinde artik
        //o hucrenin value'sunu yazdiralim

        // 2 turlu de yazdirabiliriz:
        // 1-toString ile
        //System.out.println(cell.toString());

        //2-getStringCellValue() metodu ile:
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);


    }
}

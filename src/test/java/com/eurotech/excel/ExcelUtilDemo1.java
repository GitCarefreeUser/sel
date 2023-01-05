package com.eurotech.excel;

import org.testng.annotations.Test;
import utilities.ExcelUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo1 {
    @Test
    public void readExcelFile() {

        /*
        ExcelUtil classinda excelden veriyi almak icin hazir metotlar var
        o metotlar ile excelden istedigimiz veriyi cekicez
        once o classin object'sini olustururuz
        ExcelUtil classindaki constructor nedeniyle, object olustururken 2 String parametre gireriz
        ilki:
        ve parametre olarak buraya-framework'te resources altina yukledigimiz excelin
        sag click copy path ile -path from content- diyerek -path'ini-aliriz
        "" icine yapistiririz
        ikinci parametremiz exceldeki sheet adimiz
        onu da "" icine yazariz
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ASLINDA AMAC bize hazir verilen exceldeki datayi kullanarak
        o exceli @DataProvider anotatione'ina cevirmek
         */
        ExcelUtil read=new ExcelUtil("src/test/resources/slm.xlsx","mrb");

        System.out.println(read.columnCount());
        System.out.println(read.rowCount());
        System.out.println(read.getColumnsNames());

        //exceli map olarak alabiliriz:
        //map yapisinda key and value olarak alalim
        //column'daki baslik ve altindaki value seklinde
        //row row list'e aticak
        //sout'ta ilk row'un country si music'i vb. gelicek


        List<Map<String, String>> dataList = read.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);

        }
        /*
        bu list of map ile istedigimiz value'yu cekebiliriz

        mesela italy'nin music value'sunu alalim

        burda once row , sonra o row'un uzerinden cell'e gidicez
         */
        System.out.println(dataList.get(2).get("music"));

        /*
        row'larin ilk hucrelerini ust column gibi ustten sayiyoruz ilk row ( ) icine yazmak icin
        country , excelin ilk row ve ilk column'u
        o satir haric
        kullanicilar ya da bu excel orneginde ulkeler
        column altindaki satirdan basliyor
        ve ilk ulkeyi 0'dan baslayarak sayiyoruz
        code'taki ikinci get ( ) icine column basligindan hangi key'in value'sunu getireceksek
        o basligi "" icine yaziyoruz
        column'daki key'ler kucuk buyuk harfe duyarli yoksa null verir,

         */

        //[][] dimensional array'e de atabiliriz
        String[][]dataArray=read.getDataArray();
        //getDataArray() dedigimizde ilk row da geliyor
        //ama excelde GENELDE ilk row'da basliklar olur
        //ve gercek testte sadece value'lari kullanacagimiz icin
        //bir baska metot kullaniriz
        //getDataArrayWithoutFirstRow()
        //burda simdilik bunu kullanmadik

        System.out.println(Arrays.deepToString(dataArray));

        /*
        her bir row'u bir array olarak aticak
        [country, city, vegetables, music],
        [nederland, amsterdam, banana, classic],
        ...gibi
         */

        /*
        bu son metodu [] [] arraye atmakla @dataProvider annatotation'inindaki
        hale getirmis olduk aslinda
        ExcelUtilDemo2 classina BAKKKKKKKK!!!!!!!!
         */


    }

}

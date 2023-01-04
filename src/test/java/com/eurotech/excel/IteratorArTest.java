package com.eurotech.excel;

import java.io.IOException;
import java.util.ArrayList;

public class IteratorArTest {
    public static void main(String[] args) throws IOException {
        IteratorArray d=new IteratorArray();
        ArrayList<String> italy = d.getData("italy");
        System.out.println("array element sayisi: "+italy.size());

        System.out.println(italy.get(0));
        System.out.println(italy.get(1));
        System.out.println(italy.get(2));
        System.out.println(italy.get(3));

        /*
        array'de italy row'unun cell value'lari var
        datayi excelden alip
        mesela sendkeys( ) icinde kullanabiliriz
        ORNEK
        driver.findElements(.....).sendKeys(italy.get(2));
         */


    }
}

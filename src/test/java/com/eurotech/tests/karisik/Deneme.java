package com.eurotech.tests.karisik;

public class Deneme {
    public static void main(String[] args) {
        byte b1=2;
        byte b2=b1;
        //byte b3=-b1;
        //byte b4=+b1;

        //  arti ve eksi kullaninca , o varible int haline geliyor
        //ve casting lazim
        byte b3=(byte)-b1;
        byte v=-8;

        int j=5;
        int k=++j;

//        System.out.println(k);
//        System.out.println(j);
//
//        k=j++;
//
//        System.out.println(k);
//        System.out.println(j);

        int a=7;
        //a++;
        System.out.println(a++);
        System.out.println(a);
    }
}

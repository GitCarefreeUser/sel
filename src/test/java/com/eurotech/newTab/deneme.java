package com.eurotech.newTab;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class deneme {
    public static void main(String[] args) {
        String a="1";
        String b="2";
        String c="3";
        Set<String> nums=new TreeSet<>();
        nums.add(a);
        nums.add(b);
        nums.add(c);

        System.out.println(nums);
//        for (String num : nums) {
//            System.out.println(num);
//
//        }
        Iterator<String> iterator = nums.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


    }
}

package com.star;

public class StringTest {
    public static void main(String[] args) {
        String s= new String("1");
        String a=s.intern();
        System.out.println(s==a);
        String s1="1";
        System.out.println(s);
        System.out.println(s==s1);
    }
}

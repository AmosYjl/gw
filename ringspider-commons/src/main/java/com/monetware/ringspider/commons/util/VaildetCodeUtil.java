package com.monetware.ringspider.commons.util;

public class VaildetCodeUtil {
    public static String  getRandomNum(){
        return  String.valueOf((int)((Math.random()*9+1)*1000));
    }
}

package com.xx.chinetek.chineteklib.util.function;

import java.math.BigDecimal;

/**
 * Created by GHOST on 2017/8/13.
 */

public class ArithUtil {
    private static final int DEF_DIV_SCALE=10;

    private ArithUtil(){}

    public static Float add(Float d1,Float d2){
        BigDecimal b1=new BigDecimal(Float.toString(d1));
        BigDecimal b2=new BigDecimal(Float.toString(d2));
        return b1.add(b2).floatValue();

    }

    public static Float sub(Float d1,Float d2){
        BigDecimal b1=new BigDecimal(Float.toString(d1));
        BigDecimal b2=new BigDecimal(Float.toString(d2));
        return b1.subtract(b2).floatValue();

    }

    public static Float mul(Float d1,Float d2){
        BigDecimal b1=new BigDecimal(Float.toString(d1));
        BigDecimal b2=new BigDecimal(Float.toString(d2));
        return b1.multiply(b2).floatValue();

    }

    public static Float div(Float d1,Float d2){

        return div(d1,d2,DEF_DIV_SCALE);

    }

    public static Float div(Float d1,Float d2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(Float.toString(d1));
        BigDecimal b2=new BigDecimal(Float.toString(d2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).floatValue();

    }
}

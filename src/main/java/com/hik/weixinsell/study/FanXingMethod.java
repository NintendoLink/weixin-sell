package com.hik.weixinsell.study;

/**
 *  1.泛型类，是在实例化类的时候指明泛型的具体类型；泛型方法，是在调用方法的时候指明泛型的具体类型 。
 *  2.在方法声明定义时，需要将所有的泛型列举出来
 */
public class FanXingMethod {

    public static void main(String[] args) {
        System.out.println(print("String","Integer"));
    }

    public  static  <T,K> T print(T t,K k){
        return t;
    }


}

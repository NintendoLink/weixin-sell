package com.hik.weixinsell.study;

public class FanXing {
    /**
     * 泛型：参数类型化
     * 1.泛型类，泛型方法，泛型接口
     * @param args
     */
    public static void main(String[] args) {
        General<String> general=new General<String>();
        String  str="String";
        general.setT(str);
        System.out.println(general.getT());
    }
}

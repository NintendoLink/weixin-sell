package com.hik.weixinsell.utils;

import java.util.Random;

public class KeyUtil {
//    生成唯一主键
    /**
     * 时间+随机数
     */
    public  static synchronized String getUniqueKey(){
        Random random=new Random();

        System.currentTimeMillis();
    //        生成六位随机数
        Integer number=random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}

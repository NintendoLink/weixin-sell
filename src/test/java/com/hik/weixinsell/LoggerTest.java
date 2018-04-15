package com.hik.weixinsell;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        /**
         * 在日志中输出变量
         */
        String  name="qhl";
        String password="123456";

        logger.info("name: {},password: {}",name,password);
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }


//    /**
//     * 加上注解之后就不必每次都写当前类的的类名
//     * @Slf4j
//     */
//    不知为何不行
//    public void test1(){
//        log.debug("debug...");
//        log.info("info...");
//        log.error("error...");
//    }
}

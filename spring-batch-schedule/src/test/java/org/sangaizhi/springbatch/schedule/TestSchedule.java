package org.sangaizhi.springbatch.schedule;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
public class TestSchedule {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
    }


}

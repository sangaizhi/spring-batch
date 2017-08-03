package org.sangaizhi.springbatch.schedule;

import org.junit.Test;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
public class TestSchedule {

    @Test
    public void main(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
//        JobExplorer explorer = (JobExplorer) context.getBean("jobExplorer");
    }


}

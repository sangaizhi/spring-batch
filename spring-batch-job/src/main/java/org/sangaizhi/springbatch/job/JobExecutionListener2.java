package org.sangaizhi.springbatch.job;

import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
@Component
public class JobExecutionListener2 {

    @BeforeJob
    public void before(){
        System.out.println("CsvJobExecutionListener2 Before");

    }
    @AfterJob
    public void after(){
        System.out.println("CsvJobExecutionListener2 After");

    }

}

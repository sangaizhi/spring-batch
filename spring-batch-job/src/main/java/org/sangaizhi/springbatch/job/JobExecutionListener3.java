package org.sangaizhi.springbatch.job;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
@Component
public class JobExecutionListener3 {

    public void before(){
        System.out.println("CsvJobExecutionListener3 Before");

    }
    public void after(){
        System.out.println("CsvJobExecutionListener3 After");

    }
}

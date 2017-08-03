package org.sangaizhi.springbatch.job;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
public class JobParameterValidatorTest {

    private ApplicationContext context;

    private JobLauncher jobLauncher;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
        jobLauncher = (JobLauncher) context.getBean("jobLauncher");
    }

    /**
     * 默认参数校验测试
     */
    @Test
    public void testJobParameterValidator1(){
        Job job = (Job) context.getBean("testValidatorJob");
        try {
            /* 运行Job */
            JobExecution result = jobLauncher.run(job, new JobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义参数校验测试
     */
    @Test
    public void testJobParameterValidator2(){
        Job job = (Job) context.getBean("testValidatorJob2");
        try {
            /* 运行Job */
            JobExecution result = jobLauncher.run(job, new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 组合参数校验测试
     */
    @Test
    public void testJobParameterValidator3(){
        Job job = (Job) context.getBean("testValidatorJob3");
        try {
            /* 运行Job */
            JobExecution result = jobLauncher.run(job, new JobParametersBuilder().addDate("date", new Date()).addString("name", "zhangsan").toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

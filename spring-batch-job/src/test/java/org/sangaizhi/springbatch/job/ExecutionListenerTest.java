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
public class ExecutionListenerTest {

    private ApplicationContext context;

    private JobLauncher jobLauncher;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
        jobLauncher = (JobLauncher) context.getBean("jobLauncher");
    }

    @Test
    public void testJobExecutionListener(){
        Job job = (Job) context.getBean("testListenerJob");
        try {
            /* 运行Job */
            JobExecution result = jobLauncher.run(job, new JobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

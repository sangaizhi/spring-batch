package org.sangaizhi.springbatch.cvs;

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
 * @date 2017/8/2
 */
public class JobLaunch {
    public static void main(String[] args) {
//        baseTest();
        advanceTest();
    }

    public static void baseTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("cvsJob");
        try {
            JobExecution result = launcher.run(job, new JobParametersBuilder().addDate("date",new Date()).addString("name","zhangsan").toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String inputResource = "file:C:\\Users\\Admin\\Desktop\\input.csv";
    private static final String outResource = "file:C:\\Users\\Admin\\Desktop\\out.csv";

    public static void advanceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("cvsJob");
        try {
            JobExecution result = launcher.run(job, new JobParametersBuilder().addString("inputResource",inputResource).addString("outResource", outResource).toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

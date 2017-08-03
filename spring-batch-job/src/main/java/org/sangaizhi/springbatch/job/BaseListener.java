package org.sangaizhi.springbatch.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
@Component
public class BaseListener implements JobExecutionListener {

    public void beforeJob(JobExecution jobExecution) {
        System.out.println("父 Job 的拦截器: before");
    }

    public void afterJob(JobExecution jobExecution) {
        System.out.println("父 Job 的拦截器: after");
    }
}

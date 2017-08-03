package org.sangaizhi.springbatch.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * 实现接口的方式实现Job拦截器
 * @author sangaizhi
 * @date 2017/8/3
 */
@Component
public class JobExecutionListener1 implements JobExecutionListener{

	public void beforeJob(JobExecution jobExecution) {
		System.out.println("CsvJobExecutionListener1 Before");
	}

	public void afterJob(JobExecution jobExecution) {
		System.out.println("CsvJobExecutionListener1 After");
	}
}

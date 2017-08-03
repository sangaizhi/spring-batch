package org.sangaizhi.springbatch.schedule;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import java.util.Date;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
public class SchedulerLauncher {

    private Job job;

    private JobLauncher jobLauncher;


    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void launch() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters parameters = new JobParametersBuilder().addDate("executeDate", new Date()).toJobParameters();
        jobLauncher.run(job,parameters);
    }


}

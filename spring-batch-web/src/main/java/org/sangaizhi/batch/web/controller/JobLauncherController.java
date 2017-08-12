package org.sangaizhi.batch.web.controller;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author sangaizhi
 * @date 2017/8/12
 */
@Controller
public class JobLauncherController {

    private static final String JOB_NAME = "jobName";

    /**
     * 负责调用 job 执行
     */
    @Autowired
    private JobLauncher jobLauncher;
    /**
     * job 注册器，存放了所有的 job 的对象，可以根据 Job 的名字获取对应的 Job 对象
     */
    @Autowired
    private JobRegistry jobRegistry;


    @RequestMapping(value = "executeJob", method =  RequestMethod.GET)
    public String launch(@RequestParam String jobName, HttpServletRequest request) throws NoSuchJobException, JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters parameters = buildParameters(request);
        jobLauncher.run(jobRegistry.getJob(jobName), parameters);
        return "success";
    }


    private JobParameters buildParameters(HttpServletRequest request){
        JobParametersBuilder parametersBuilder = new JobParametersBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            if(!Objects.equals(paramName, JOB_NAME)){
                parametersBuilder.addString(paramName, request.getParameter(paramName));
            }
        }
        return  parametersBuilder.toJobParameters();
    }

}

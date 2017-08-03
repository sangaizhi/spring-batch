package org.sangaizhi.springbatch.schedule;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Map;

/**
 * @author sangaizhi
 * @date 2017/8/3
 */
public class HelloTasklet implements Tasklet {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        String jobName = chunkContext.getStepContext().getJobName();
        System.out.println("Execute job:" + jobName + ".");
        JobParameters jobParameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
        System.out.println("JobParameters:" + jobParameterToString(jobParameters));
        return RepeatStatus.FINISHED;
    }
    /**
     * 转换为String类型格式.<br>
     * @param jobParameters
     * @return
     */
    private String jobParameterToString(JobParameters jobParameters){
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<String, JobParameter> param : jobParameters.getParameters().entrySet()) {
            sb.append(String.format(
                    "%s = %s (%s);",
                    param.getKey(),param.getValue().getValue(),param.getValue().getType()
            ));
        }
        return sb.toString();
    }
}

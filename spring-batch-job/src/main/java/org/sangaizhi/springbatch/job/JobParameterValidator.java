package org.sangaizhi.springbatch.job;

import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.stereotype.Component;

/**
 * 自定义参数校验器
 * @author sangaizhi
 * @date 2017/8/3
 */
@Component
public class JobParameterValidator implements JobParametersValidator {

	public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
		if (null == jobParameters) {
			throw new JobParametersInvalidException("参数不能为空");
		}
		Map<String, JobParameter> jobParameterMap = jobParameters.getParameters();
		if(!jobParameterMap.containsKey("name")){
		    throw new JobParametersInvalidException("需要 name 参数");
        }
        Object name = jobParameterMap.get("name").getValue();
		if(!(name instanceof String)){
            throw new JobParametersInvalidException("name 参数必须是 String 类型");
        }
	}
}

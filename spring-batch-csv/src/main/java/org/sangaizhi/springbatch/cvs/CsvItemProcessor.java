package org.sangaizhi.springbatch.cvs;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/8/2
 */
@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<Student, Student> {

    public Student process(Student item) throws Exception {
        item.setName(item.getId() +"_"+ item.getName());
        item.setSex("男".equals(item.getSexStr()) ? 0 : 1);
        item.setAge(item.getAge()+10);
        return item;
    }
}

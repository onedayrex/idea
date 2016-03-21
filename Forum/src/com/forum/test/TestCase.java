package com.forum.test;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Tarena-java on 2016/2/3.
 */
@Service("test")
public class TestCase {

    private DataSource ds;

    public DataSource getDs() {
        return ds;
    }

    @Resource(name = "db")
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

public static void main(String[] args){
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//    TopicService topicService= (TopicService) ctx.getBean("TopicService");
//    Topic topic = new Topic();
//    topicService.CreateTopic(topic);
}
}

package com.forum.dao;

import com.forum.entities.Topic;

import java.util.List;

/**
 * Created by Tarena-java on 2016/2/3.
 */
public interface TitleDao {
    public List<Topic> findAllTopic(String begin,String end);

    public Integer findAllCount();
}

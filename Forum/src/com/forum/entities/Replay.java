package com.forum.entities;

import java.sql.Timestamp;

/**
 * Created by onedayrex on 2016/2/5.
 */
public class Replay {
    private Integer id;
    private Integer topicid;
    private Integer userid;
    private String content;


    private Timestamp replaytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReplaytime() {
        return replaytime;
    }

    public void setReplaytime(Timestamp replaytime) {
        this.replaytime = replaytime;
    }
}

package com.forum.dao;

import com.forum.entities.Replay;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by onedayrex on 2016/2/5.
 */
public interface ReplayDao {

    public List<Replay> findTopicReplayById(int topicid,int begin,int end);

    public void creatReplay(Replay replay);

    public Integer findReplayCount(int topicid);
}

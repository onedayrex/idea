package com.forum.service;

import com.forum.entities.Manage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by onedayrex on 2016/2/13.
 */
public interface ManageService {
    public boolean checkManage(Manage manage,HttpServletRequest req);

    public void deleteTopic(int TopicId);
}

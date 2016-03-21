package com.forum.dao;

import com.forum.entities.Manage;

/**
 * Created by onedayrex on 2016/2/13.
 */
public interface ManageDao {
    public Manage findManageById(int manageid);

    public void deleteTopic(int TopicId);
}

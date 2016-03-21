package com.forum.dao;

import com.forum.entities.User;

/**
 * Created by onedayrex on 2016/2/12.
 */
public interface UserDao {
    public void updataPassword(User user);

    public User getUserById(int id);
}

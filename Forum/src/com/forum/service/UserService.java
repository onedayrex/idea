package com.forum.service;

import com.forum.entities.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by onedayrex on 2016/2/12.
 */
public interface UserService {
    public void updataPassword(HttpServletRequest req);

    public User toupdata(HttpServletRequest req);
}

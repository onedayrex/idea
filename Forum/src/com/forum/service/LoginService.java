package com.forum.service;

import com.forum.entities.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by onedayrex on 2016/2/5.
 */
public interface LoginService {
    public String findUserById(HttpServletRequest req);
}

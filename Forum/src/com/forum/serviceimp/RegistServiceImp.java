package com.forum.serviceimp;

import com.forum.dao.RegistDao;
import com.forum.entities.User;
import com.forum.service.RegistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by onedayrex on 2016/2/6.
 */
@Service("RegistService")
public class RegistServiceImp implements RegistService{
    private RegistDao registDao;

    public RegistDao getRegistDao() {
        return registDao;
    }
    @Resource(name = "RegistDao")
    public void setRegistDao(RegistDao registDao) {
        this.registDao = registDao;
    }

    @Override
    public void creatUser(User user) {
        registDao.creatUser(user);
    }
}

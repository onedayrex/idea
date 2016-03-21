package com.forum.serviceimp;

import com.forum.dao.ManageDao;
import com.forum.entities.Manage;
import com.forum.service.ManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by onedayrex on 2016/2/13.
 */
@Service("ManageService")
public class ManageServiceImp implements ManageService {
    private ManageDao manageDao;

    public ManageDao getManageDao() {
        return manageDao;
    }
    @Resource(name = "ManageDao")
    public void setManageDao(ManageDao manageDao) {
        this.manageDao = manageDao;
    }

    @Override
    public boolean checkManage(Manage manage,HttpServletRequest req) {
        Manage remanage = manageDao.findManageById(manage.getManageid());
        if (remanage!=null) {
            if(manage.getPassword().equals(remanage.getPassword())){
                HttpSession session = req.getSession();
                session.setAttribute("manage",remanage);
                return true;
            }else {
                req.setAttribute("error","密码错误");
                return false;
            }
        } else {
            req.setAttribute("error","没有此管理员");
            return false;
        }
    }

    @Override
    public void deleteTopic(int TopicId) {
        manageDao.deleteTopic(TopicId);
    }
}

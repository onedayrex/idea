package com.forum.serviceimp;

import com.forum.dao.TopicDao;
import com.forum.dao.UserDao;
import com.forum.entities.Topic;
import com.forum.entities.User;
import com.forum.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Tarena-java on 2016/2/3.
 */
@Service("TopicService")
public class TopicServiceImp implements TopicService {
    private TopicDao topicDao;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    @Resource(name = "UserDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }
    @Resource(name = "TopicDao")
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public void CreateTopic(HttpServletRequest req) {
        String title = req.getParameter("title");
        String info = req.getParameter("content");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Topic topic = new Topic();
        topic.setContent(info);
        topic.setTitle(title);
        topic.setUserid(user.getId());
        topicDao.CreatTopic(topic);
    }

    @Override
    public void getTopicById(HttpServletRequest req) {
        String id = req.getParameter("id");
        if(!id.isEmpty()&&id!=null){
            Topic topic = topicDao.getTopicById(new Integer(id));
            User user = userDao.getUserById(topic.getUserid());
            req.setAttribute("showuser",user);
            req.setAttribute("topic",topic);
        }

    }
}

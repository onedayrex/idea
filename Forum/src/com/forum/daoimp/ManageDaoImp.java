package com.forum.daoimp;

import com.forum.dao.ManageDao;
import com.forum.entities.Manage;
import com.sun.corba.se.impl.oa.toa.TOA;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by onedayrex on 2016/2/13.
 */
@Repository("ManageDao")
public class ManageDaoImp implements ManageDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Resource(name = "template")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Manage findManageById(int manageid) {
        String sql = "SELECT * FROM manage WHERE id=?";
        List<Manage> list = template.query(sql, new Object[]{manageid}, new ManageRowMapper());
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void deleteTopic(int TopicId) {
        String sql = "DELETE FROM replay WHERE topicid=?";
        template.update(sql,new Object[]{TopicId});
        sql = "DELETE FROM topic WHERE id=?";
        template.update(sql,new Object[]{TopicId});
    }

    class ManageRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Manage manage = new Manage();
            manage.setManageid(rs.getInt("id"));
            manage.setManagename(rs.getString("managename"));
            manage.setPassword(rs.getString("password"));
            return manage;
        }
    }
}

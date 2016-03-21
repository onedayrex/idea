package com.forum.daoimp;

import com.forum.dao.RegistDao;
import com.forum.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by onedayrex on 2016/2/6.
 */
@Repository("RegistDao")
public class RegistDaoImp implements RegistDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Resource(name = "template")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void creatUser(User user) {
        String sql = "INSERT INTO usertable VALUES (NULL,?,?,10,CURRENT_DATE,1)";
        template.update(sql,new Object[]{user.getUsername(),user.getPassword()});
    }

    class RegistRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setTopiclimit(rs.getInt("topiclimit"));
            user.setCreatime(rs.getTimestamp("creatime"));
            user.setUserdisable(rs.getInt("userdisable"));
            return user;
        }
    }
}

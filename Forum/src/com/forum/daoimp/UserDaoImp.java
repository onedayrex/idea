package com.forum.daoimp;

import com.forum.dao.UserDao;
import com.forum.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by onedayrex on 2016/2/12.
 */
@Repository("UserDao")
public class UserDaoImp implements UserDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Resource(name = "template")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void updataPassword(User user) {
        String sql = "UPDATE usertable SET password=? where id=?";
        template.update(sql,new Object[]{user.getPassword(),user.getId()});
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM usertable WHERE id=?";
        List<User> list = template.query(sql, new Object[]{id}, new UserRowMapper());
        if(list.isEmpty()){
            return null;
        }else {
            return list.get(0);
        }
    }

    class UserRowMapper implements RowMapper {

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

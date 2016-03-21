package com.forum.daoimp;

import com.forum.dao.LoginDao;
import com.forum.entities.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by onedayrex on 2016/2/5.
 */
@Repository("LoginDao")
public class LoginDaoImp implements LoginDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Resource(name = "template")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "SELECT * FROM usertable WHERE id=?";
        List<User> list = template.query(sql, new Object[]{id}, new LoginRowMapper());
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    class LoginRowMapper implements RowMapper{

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

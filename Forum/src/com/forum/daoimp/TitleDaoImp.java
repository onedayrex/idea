package com.forum.daoimp;

import com.forum.dao.TitleDao;
import com.forum.entities.Topic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tarena-java on 2016/2/3.
 */
@Repository("TitleDao")
public class TitleDaoImp implements TitleDao {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Resource(name = "template")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Topic> findAllTopic(String begin,String end) {
        String sql = "SELECT * FROM TOPIC ORDER BY creatime DESC LIMIT "+begin+","+end;
        return template.query(sql,new TitleRowMapper());
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<Topic> list = new ArrayList<Topic>();
//        try {
//            conn = ds.getConnection();
//            String sql = "SELECT * FROM TOPIC";
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()){
//                Topic topic = new Topic();
//                topic.setId(rs.getInt("ID"));
//                topic.setBlockid(rs.getInt("BLOCKID"));
//                topic.setUserid(rs.getInt("USERID"));
//                topic.setTitle(rs.getString("TITLE"));
//                topic.setContent(rs.getString("CONTENT"));
//                topic.setCreatime(rs.getTimestamp("CREATIME"));
//                topic.setLimit(rs.getInt("TOPICLIMIT"));
//                list.add(topic);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return list;
   }

    @Override
    public Integer findAllCount() {
        String sql = "SELECT COUNT(0) FROM topic";
        Integer temp = (Integer) template.queryForObject(sql, new CountRowMapper());
        return temp;
    }

    class TitleRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Topic topic = new Topic();
            topic.setId(rs.getInt("ID"));
            topic.setBlockid(rs.getInt("BLOCKID"));
            topic.setUserid(rs.getInt("USERID"));
            topic.setTitle(rs.getString("TITLE"));
            topic.setContent(rs.getString("CONTENT"));
            topic.setCreatime(rs.getTimestamp("CREATIME"));
            topic.setLimit(rs.getInt("TOPICLIMIT"));
            return topic;
        }
    }

    class CountRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Integer count = resultSet.getInt(1);
            return count;
        }
    }
}

package com.forum.daoimp;

import com.forum.dao.TopicDao;
import com.forum.entities.Topic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.swing.tree.TreePath;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Tarena-java on 2016/2/3.
 */
@Repository("TopicDao")
public class TopicDaoImp implements TopicDao {
    @Resource(name = "template")
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void CreatTopic(Topic topic) {
        String sql = "INSERT INTO TOPIC(blockid,userid,title,content,creatime) VALUES (1,?,?,?,?)";
        template.update(sql,new Object[]{topic.getUserid(),topic.getTitle(),topic.getContent(),new Date()});
//        Connection conn = null;
//        PreparedStatement ps = null;
//        System.out.print(ds);
//        try {
//            conn = ds.getConnection();
//            System.out.println(conn);
//            ps = conn.prepareStatement(sql);
//            ps.setString(1,topic.getTitle());
//            ps.setString(2,topic.getContent());
//            ps.executeUpdate();
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
    }

    @Override
    public Topic getTopicById(int id) {
        String sql = "SELECT * FROM topic WHERE id=?";
        return (Topic)template.queryForObject(sql,new Object[]{id},new TopicRowMapper());
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Topic topic=new Topic();
//        try {
//            conn = ds.getConnection();
//            String sql = "SELECT * FROM topic WHERE id=?";
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1,id);
//            rs = ps.executeQuery();
//            if (rs.next()){
//                topic.setId(rs.getInt("ID"));
//                topic.setBlockid(rs.getInt("BLOCKID"));
//                topic.setUserid(rs.getInt("USERID"));
//                topic.setTitle(rs.getString("TITLE"));
//                topic.setContent(rs.getString("CONTENT"));
//                topic.setCreatime(rs.getTimestamp("CREATIME"));
//                topic.setLimit(rs.getInt("TOPICLIMIT"));
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
//        return topic;
    }


    class TopicRowMapper implements RowMapper {
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

}


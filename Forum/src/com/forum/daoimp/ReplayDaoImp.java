package com.forum.daoimp;

import com.forum.dao.ReplayDao;
import com.forum.entities.Replay;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by onedayrex on 2016/2/5.
 */
@Repository("ReplayDao")
public class ReplayDaoImp implements ReplayDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Resource(name = "template")
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Replay> findTopicReplayById(int topicid,int begin,int end) {
        String sql = "SELECT * FROM replay WHERE topicid = ? LIMIT "+begin+","+end;
        return jdbcTemplate.query(sql,new Object[]{topicid},new ReplayRowMapper());
    }

    @Override
    public void creatReplay(Replay replay) {
        String sql = "INSERT INTO replay VALUES (NULL,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{replay.getTopicid(),replay.getUserid(),replay.getContent(),new Date()});
    }

    @Override
    public Integer findReplayCount(int topicid) {
        String sql = "SELECT COUNT(0) FROM replay WHERE topicid=?";
        Integer temp = (Integer) jdbcTemplate.queryForObject(sql, new Object[]{topicid},new CountRowMapper());
        return temp;
    }

    class ReplayRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            Replay replay = new Replay();
            replay.setId(rs.getInt("ID"));
            replay.setTopicid(rs.getInt("TOPICID"));
            replay.setUserid(rs.getInt("USERID"));
            replay.setContent(rs.getString("CONTENT"));
            replay.setReplaytime(rs.getTimestamp("REPLAYTIME"));
            return replay;
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

package com.dmti.dmtiIntelligence;

import com.dmti.dto.PageList;
import com.dmti.dto.PageParam;
import com.dmti.utils.Pagination;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageQueryServiceImpl implements PageQueryService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public PageList pageQueryComments(int offset, int limit, String search) {
        String sql = "";
        if (search == null || "".equals(search)){
            sql = "SELECT nickname,content,likedCount,time,songName FROM t_comment LEFT JOIN t_user ON t_comment.userId = t_user.userId LEFT JOIN hotsongs ON t_comment.songID = hotsongs.songID";
        }else {
            sql = "SELECT nickname,content,likedCount,time,songName FROM t_comment LEFT JOIN t_user ON t_comment.userId = t_user.userId LEFT JOIN hotsongs ON t_comment.songID = hotsongs.songID WHERE nickname LIKE '%"+search+"%'";
        }
        PageParam pageParam = new PageParam();
        pageParam.setLimit(limit);
        pageParam.setPage(computeOffset(offset,limit));
        List<Object> params = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        Pagination pagination = new Pagination(sqlBuilder.toString(), params.toArray(), pageParam, jdbcTemplate);
        PageList pageList = new PageList(pagination.getResultList(),pagination.getTotalRows());
        return pageList;
    }

    @Override
    public PageList pageQueryHotSongs(int offset, int limit, String search) {
        String sql = "";
        if (search == null || "".equals(search)){
            sql = "SELECT songID,songName,singerName,totcalComents FROM hotsongs";
        }else {
            sql = "SELECT songID,songName,singerName,totcalComents FROM hotsongs where songName like '%"+search+"%'";
        }
        PageParam pageParam = new PageParam();
        pageParam.setLimit(limit);
        pageParam.setPage(computeOffset(offset,limit));
        List<Object> params = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        Pagination pagination = new Pagination(sqlBuilder.toString(), params.toArray(), pageParam, jdbcTemplate);
        PageList pageList = new PageList(pagination.getResultList(),pagination.getTotalRows());
        return pageList;
    }

    @Override
    public PageList pageQueryPlayList(int offset, int limit, String search) {
        String sql = "";
        if (search == null || "".equals(search)){
            sql = "SELECT * FROM sheets";
        }else {
            sql = "SELECT * FROM sheets where sheetsname like '%"+search+"%'";
        }
        PageParam pageParam = new PageParam();
        pageParam.setLimit(limit);
        pageParam.setPage(computeOffset(offset,limit));
        List<Object> params = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        Pagination pagination = new Pagination(sqlBuilder.toString(), params.toArray(), pageParam, jdbcTemplate);
        PageList pageList = new PageList(pagination.getResultList(),pagination.getTotalRows());
        return pageList;
    }

    @Override
    public PageList pageQuerySongs(int offset, int limit, String search) {
        String sql = "";
        if (search == null || "".equals(search)){
            sql = "SELECT t1.*,t2.name FROM songs t1 LEFT JOIN sheets t2 ON t1.sheetid = t2.id";
        }else {
            sql = "SELECT t1.*,t2.name FROM songs t1 LEFT JOIN sheets t2 ON t1.sheetid = t2.id where songname like '%"+search+"%'";
        }
        PageParam pageParam = new PageParam();
        pageParam.setLimit(limit);
        pageParam.setPage(computeOffset(offset,limit));
        List<Object> params = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        Pagination pagination = new Pagination(sqlBuilder.toString(), params.toArray(), pageParam, jdbcTemplate);
        PageList pageList = new PageList(pagination.getResultList(),pagination.getTotalRows());
        return pageList;
    }

    @Override
    public Integer addHotSong(String songName, Integer songID, String singerName, Integer totcalComents) {
        return jdbcTemplate.update("insert into hotsongs(songID,songName,singerName,totcalComents) values(?,?,?,?)", songID, songName, singerName, totcalComents);
    }


    public Integer computeOffset(Integer offset,Integer limit) {
        Integer number = offset / limit + 1 ;
        return number;
    }
}


package com.dmti.dmtiIntelligence;

import com.dmti.dto.PageParam;
import com.dmti.utils.Pagination;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Luo
 * @description:
 * @time: 2019/12/4 17:55
 * Modified By:
 */
@Service
public class PageQueryServiceImpl implements PageQueryService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String,Object>> pageQueryComments(int offset, int limit) {
        PageParam pageParam = new PageParam();
        pageParam.setLimit(limit);
        pageParam.setPage(computeOffset(offset,limit));
        List<Object> params = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder("SELECT nickname,content,likedCount,time,songName,t1 FROM t_comment LEFT JOIN t_user ON t_comment.userId = t_user.userId LEFT JOIN hotsongs ON t_comment.songID = hotsongs.songID");
        return new Pagination(sqlBuilder.toString(), params.toArray(), pageParam, jdbcTemplate).getResultList();
    }
    public Integer computeOffset(Integer offset,Integer limit) {
        Integer number = offset / limit + 1 ;
        return number;
    }
}


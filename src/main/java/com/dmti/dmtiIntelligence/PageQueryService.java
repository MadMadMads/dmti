package com.dmti.dmtiIntelligence;

import com.dmti.dto.PageList;

import java.util.List;
import java.util.Map;

/**
 * @author: Luo
 * @description:
 * @time: 2019/12/4 17:55
 * Modified By:
 */
public interface PageQueryService {
    /**
     * 分页查询评论信息
     * @param offset
     * @param limit
     * @return
     */
    PageList pageQueryComments(int offset, int limit, String search);

    /**
     *  分页查询热门歌曲信息
     * @param offset
     * @param limit
     * @return
     */
    PageList pageQueryHotSongs(int offset, int limit, String search);

    /**
     *  分页查询热门歌单
     * @param offset
     * @param limit
     * @param search
     * @return
     */
    PageList pageQueryPlayList(int offset, int limit, String search);

    /**
     *  分页查询热门歌单中的歌曲
     * @param offset
     * @param limit
     * @param search
     * @return
     */
    PageList pageQuerySongs(int offset, int limit, String search);
}

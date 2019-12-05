package com.dmti.dmtiIntelligence;

public interface ComputeService {
    /**
     *  统计歌单的 标签
     * @return
     */
    Object computeBackData();
    /**
     *  统计评论时间（按一天24小时，每个小时的评论数量）
     * @return
     */
    Object computeCommentTime();
    /**
     *  统计用户年龄
     * @return
     */
    Object computeUserAgesComment();
}

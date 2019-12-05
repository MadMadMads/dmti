package com.dmti.dmtiIntelligence;

import java.util.List;
import java.util.Map;

/**
 * @author: Luo
 * @description:
 * @time: 2019/12/4 17:55
 * Modified By:
 */
public interface PageQueryService {
    List<Map<String,Object>> pageQueryComments(int offset, int limit);
}

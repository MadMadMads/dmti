package com.dmti.dmtiIntelligence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComputeServiceImpl implements ComputeService {
    @Resource
    private JdbcTemplate jdbctemplate;

    @Override
    public Object computeBackData() {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Object>> dataList = null;
//        do {
        dataList = jdbctemplate.queryForList("SELECT sheetsname , tags , createTime FROM sheets");
        for (Map<String, Object> tmepMap : dataList) {
            String tags = String.valueOf(tmepMap.get("tags"));
            if (tags == null || tags.equals("[]")) {
                continue;
            }
            String[] tagsAfter = tags.substring(1, tags.length() - 1).split(",");
            for (String tempStr : tagsAfter) {
                System.out.println(tempStr.trim());
                Integer tagCount = map.get(tempStr.trim());
                if (tagCount != null) {
                    tagCount++;
                    map.put(tempStr.trim(), tagCount);
                } else {
                    map.put(tempStr.trim(), 1);
                }
            }
        }
//        }while (dataList.size()==200);
        return map;
    }

    public Object computeCommentTime() {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Object>> dataList = null;
//        do {
        long startTimeSelect = System.currentTimeMillis();
        dataList = jdbctemplate.queryForList("SELECT time FROM t_comment");
        long endTimeSelect = System.currentTimeMillis();
        System.out.println((endTimeSelect - startTimeSelect) + "ms");

        long startTimeCompute = System.currentTimeMillis();
        int totalcount=0;
        for (Map<String, Object> tmepMap : dataList) {
            totalcount++;
            String time = String.valueOf(tmepMap.get("time"));
            if (time == null) {
                continue;
            }
            String timeAfter = time.substring(11, time.length() - 6);
            if(totalcount<30)
                System.out.println(timeAfter);
            Integer tagCount = map.get(timeAfter.trim());
            if (tagCount != null) {
                tagCount++;
                map.put(timeAfter.trim(), tagCount);
            } else {
                map.put(timeAfter.trim(), 1);
            }
        }
        long endTimeCompute = System.currentTimeMillis();
        System.out.println((endTimeCompute - startTimeCompute) + "ms");
        System.out.println(totalcount);
//        }while (dataList.size()==200);
        return map;
    }

    public Object computeUserAgesComment() {
        Map<String, Integer> map = new HashMap<>();
        List<Map<String, Object>> dataList = null;
//        do {
        long startTimeSelect = System.currentTimeMillis();
        dataList = jdbctemplate.queryForList("SELECT userId,birthday FROM t_user WHERE birthday>0 AND birthday<1577808000000");
        long endTimeSelect = System.currentTimeMillis();
        System.out.println((endTimeSelect - startTimeSelect) + "ms");

        long startTimeCompute = System.currentTimeMillis();
        int totalcount=0;
        for (Map<String, Object> tmepMap : dataList) {
            totalcount++;
            String userId = String.valueOf(tmepMap.get("userId"));
            if (userId == null) {
                continue;
            }
            List<Map<String, Object>> commentList = jdbctemplate.queryForList("SELECT userId FROM t_comment WHERE userId ="+userId);
            if(commentList!=null){
                String back = new SimpleDateFormat("yyyy").format(new Date(Long.valueOf(String.valueOf(tmepMap.get("birthday")))));
                String age = 2019-Integer.valueOf(back)+"";
                Integer tagCount = map.get(age+"");
                if(2019-Integer.valueOf(back)<=0)
                    System.out.println(userId+"-->"+age);
                if (tagCount != null) {
                    tagCount++;
                    map.put(age, tagCount);
                } else {
                    map.put(age, 1);
                }
            }

        }
        long endTimeCompute = System.currentTimeMillis();
        System.out.println((endTimeCompute - startTimeCompute) + "ms");
        System.out.println(totalcount);
        return map;
    }
}

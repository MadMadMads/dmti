package com.dmti.controller;

import com.dmti.dmtiIntelligence.ComputeService;
import com.dmti.dmtiIntelligence.PageQueryService;
import com.dmti.dto.PageList;
import com.dmti.pojo.CountPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @auther XuJun
 * @date 2019/11/11 10:44
 */
@CrossOrigin
@RestController
public class ComputeController {
    @Resource
    ComputeService computeservice;
    @Autowired
    PageQueryService pageQueryService;
    @Resource
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/compute")
    public Object compute() {
        List<CountPojo> list = new ArrayList<>();
        Map<String,Integer> map = (Map<String,Integer>)computeservice.computeBackData();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(new CountPojo(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/computeCommentTime")
    public Object computeCommentTime() {
        List<CountPojo> list = new ArrayList<>();
        Map<String,Integer> map = (Map<String,Integer>)computeservice.computeCommentTime();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(new CountPojo(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/computeUserAgesComment")
    public Object computeUserAgesComment() {
        List<CountPojo> list = new ArrayList<>();
        Map<String,Integer> map = (Map<String,Integer>)computeservice.computeUserAgesComment();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(new CountPojo(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    @ResponseBody
    @GetMapping("/pageQueryComments")
    public Object pageQueryComments(@RequestParam("offset") int offset,@RequestParam("limit") int limit) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM t_comment",Integer.class);
        List<Map<String,Object>> list = pageQueryService.pageQueryComments(offset,limit);
        PageList pageList = new PageList(list,count,count);
        return pageList;
    }
}

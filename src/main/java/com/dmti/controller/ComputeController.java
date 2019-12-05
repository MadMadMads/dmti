package com.dmti.controller;

import com.dmti.dmtiIntelligence.ComputeService;
import com.dmti.dmtiIntelligence.PageQueryService;
import com.dmti.dto.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        return computeservice.computeBackData();
    }
    @ResponseBody
    @RequestMapping("/computeCommentTime")
    public Object computeCommentTime() {
        return computeservice.computeCommentTime();
    }
    @ResponseBody
    @RequestMapping("/computeUserAgesComment")
    public Object computeUserAgesComment() {
        return computeservice.computeUserAgesComment();
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

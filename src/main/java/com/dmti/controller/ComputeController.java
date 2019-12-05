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

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
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
    public Object pageQueryComments(@RequestParam(name="offset",defaultValue = "1") int offset,@RequestParam(name = "limit",defaultValue = "100") int limit,@RequestParam(name="search",defaultValue = "") String search) {
        PageList pageList = pageQueryService.pageQueryComments(offset,limit,search);
        return pageList;
    }

    @ResponseBody
    @GetMapping("/pageQueryHotSongs")
    public Object pageQueryHotSongs(@RequestParam(name="offset",defaultValue = "1") int offset,@RequestParam(name = "limit",defaultValue = "100") int limit,@RequestParam(name="search",defaultValue = "") String search) {
        PageList pageList = pageQueryService.pageQueryHotSongs(offset,limit,search);
        return pageList;
    }

    @ResponseBody
    @GetMapping("/playList")
    public Object pageQueryPlayList(@RequestParam(name="offset",defaultValue = "1") int offset,@RequestParam(name = "limit",defaultValue = "100") int limit,@RequestParam(name="search",defaultValue = "") String search) {
        PageList pageList = pageQueryService.pageQueryPlayList(offset,limit,search);
        return pageList;
    }

    @ResponseBody
    @GetMapping("/songs")
    public Object pageQuerySongs(@RequestParam(name="offset",defaultValue = "1") int offset,@RequestParam(name = "limit",defaultValue = "100") int limit,@RequestParam(name="search",defaultValue = "") String search) {
        PageList pageList = pageQueryService.pageQuerySongs(offset,limit,search);
        return pageList;
    }
}

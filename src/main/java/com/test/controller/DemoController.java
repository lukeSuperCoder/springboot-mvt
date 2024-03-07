package com.test.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.test.pojo.User;
import com.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class DemoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    @ResponseBody
    public List<Map<String, Object>> init() {
        LocalDate date = LocalDate.now();
        String sql = "select id,name from test_table";
        System.out.printf("sql:%s", jdbcTemplate.queryForList(sql));
        return jdbcTemplate.queryForList(sql);
    }

    @RequestMapping("/getMvt")
    @ResponseBody
    public Object mvt() {
        String sql = "SELECT st_astext(ST_Union(ST_Intersection(\n" +
                "  ST_Buffer('POINT(0 0)', 2),\n" +
                "  ST_Buffer('POINT(3 0)', 2)\n" +
                "))) as text;";
        System.out.printf("sql:%s", jdbcTemplate.queryForList(sql));
        return jdbcTemplate.queryForList(sql).get(0).get("text");
    }
}

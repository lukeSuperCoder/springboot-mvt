package com.test.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_table")
public class User {
    private String name;
    @TableId
    private String id;
}


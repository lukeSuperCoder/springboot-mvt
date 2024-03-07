package com.test.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mapper.UserMapper;
import com.test.pojo.MVTReq;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    private byte[] mvt;

    @Override
    public IPage<User> findUserList(Page<User> page) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //分页
        return userMapper.selectPage(page, wrapper);
    }
    @Override
    public List<User> findUserById(User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.eq(User::getId, user.getId());
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        return users;
    }
    @Override
    public Map<String, Object> createUser(User user) {
        Assert.notNull(user, "user is null");
        int count = userMapper.insert(user);
        Map<String, Object> res = new HashMap<>();
        if(count > 0){
            res.put("code", 200);
            res.put("msg", "create success");
        }else{
            res.put("code", 500);
            res.put("msg", "create fail");
        }
        return res;
    }
    @Override
    public Map<String, Object> updateUser(User user) {
        Assert.notNull(user, "user is null");
        int count = userMapper.updateById(user);
        Map<String, Object> res = new HashMap<>();
        if(count > 0){
            res.put("code", 200);
            res.put("msg", "update success");
        }else{
            res.put("code", 500);
            res.put("msg", "update fail");
        }
        return res;
    }
    @Override
    public Map<String, Object> deleteUser(User user) {
        Assert.notNull(user, "user is null");
        int count = userMapper.deleteById(user.getId());
        Map<String, Object> res = new HashMap<>();
        if(count > 0){
            res.put("code", 200);
            res.put("msg", "delete success");
        }else{
            res.put("code", 500);
            res.put("msg", "delete fail");
        }
        return res;
    }

    @Override
    public Object getMvtByArea(MVTReq req) {
        Map<String, Object> resultMap = userMapper.getMvtByArea(req);
        mvt = (byte[]) resultMap.get("mvt");
        return mvt;
    }
}

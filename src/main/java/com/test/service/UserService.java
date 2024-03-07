package com.test.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.pojo.MVTReq;
import com.test.pojo.User;
public interface UserService extends IService<User> {
    public List<User> findUserById(User id);
    public IPage<User> findUserList(Page<User> page);

    public Map<String, Object> createUser(User user);

    public Map<String, Object> updateUser(User user);

    public Map<String, Object> deleteUser(User user);

    public Object getMvtByArea(MVTReq req);
}

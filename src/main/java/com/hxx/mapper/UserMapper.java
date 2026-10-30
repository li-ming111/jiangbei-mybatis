package com.hxx.mapper;

import com.hxx.domain.Demo;
import com.hxx.domain.TUser;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据id查询用户信息
    TUser selectUserById(Integer id);

    void insertUser(TUser user);

    void updateUser(TUser user);

    void deleteUser(Integer id);

    List<TUser> findByPage(Map<String,Integer> map);

    int selectCount();

    List<Demo> findAllEmp();
}





















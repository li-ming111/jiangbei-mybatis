package com.hxx.mapper;

import com.hxx.domain.Users;

import java.util.List;

public interface UsersMapper {
    List<Users> findAllUsers(int id);
    void insertUser(Users user);
}
package com.hxx.controller;

import com.hxx.domain.Demo;
import com.hxx.domain.TUser;
import com.hxx.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    static SqlSession sqlSession;
    static {
        try {
            //读取Mybatis配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            //获取SqlSession对象
            sqlSession = build.openSession();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectUserById(){
        //接口类型,配置文件中的方法的id必须与接口中的方法名一致
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        TUser user = mapper.selectUserById(1);
        System.out.println(user);
    }
    @Test
    public void testFindById(){
        //按照方法名称获取
        Object user = sqlSession.selectOne("com.hxx.mapper.UserMapper.findById", 1);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        TUser user = new TUser();
        user.setUsername("hxx");
        user.setAge(18);
        user.setSex("男");
        mapper.insertUser(user);
        //提交事务
        sqlSession.commit();
    }
    @Test
    public void testInsertUser1(){
        TUser user = new TUser();
        user.setUsername("张三");
        user.setAge(18);
        user.setSex("男");

        sqlSession.insert("com.hxx.mapper.UserMapper.insertUser",user);
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        TUser user = new TUser();
        user.setId(1);
        user.setUsername("李四");
        user.setAge(18);
        user.setSex("女");
        mapper.updateUser(user);
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testDeleteUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(18);
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testFindByPage() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("start",0);
        map.put("pageSize",2);
        List<TUser> users = mapper.findByPage(map);
        System.out.println(users);
    }
    @Test
    public void testSelectCount() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.selectCount();
        System.out.println(count);
    }

    @Test
    public void testFindAllEmp() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Demo> demos = mapper.findAllEmp();
        System.out.println(demos);
    }
}





















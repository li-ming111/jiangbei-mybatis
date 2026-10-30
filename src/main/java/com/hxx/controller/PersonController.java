package com.hxx.controller;

import com.hxx.domain.Order;
import com.hxx.domain.Orders;
import com.hxx.domain.Person;
import com.hxx.domain.Users;
import com.hxx.mapper.OrderMapper;
import com.hxx.mapper.OrdersMapper;
import com.hxx.mapper.PersonMapper;
import com.hxx.mapper.UsersMapper;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class PersonController {

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
    public void test1(){
        //获取接口的实现对象
        Person person = sqlSession.getMapper(PersonMapper.class).show(8) ;
        System.out.println(person);
    }

    @Test
    public void test2(){
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = mapper.findAllUsers(1);
        list.forEach(System.out::println);
    }

    @Test
    public void test3(){
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("hxx");
        users.setAddress("beijing");
        mapper.insertUser(users);

        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        Orders orders = new Orders();
        orders.setNumber("123456");
        orders.setUserId(users.getId());
        ordersMapper.insertOrder(orders);
        sqlSession.commit();
    }

    @Test
    public void test4() {
        List<Order> list = sqlSession.getMapper(OrderMapper.class).findByIdOrder1(6);
        list.forEach(System.out::println);
    }

    @Test
    public void test5() {//many-to-many关联查询
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.findByIdOrder(6);
        orders.forEach(System.out::println);
    }

    @Test
    public void test6() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        //person.setUsername("张");
        person.setAge(18);
        List<Person> list = mapper.findAllPerson1(person);
        list.forEach(System.out::println);
    }
    @Test
    public void test7() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        //person.setUsername("张");
        person.setAge(18);

        mapper.updatePerson(person);
    }

    @Test
    public void test8() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setUsername("张");
        //person.setAge(18);

        mapper.findAllTrim(person);
    }
    @Test
    public void test9() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        //person.setUsername("张");
        //person.setAge(18);

        mapper.findAllChoose(person);
    }

    @Test
    public void test10() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person1 = new Person();
        person1.setUsername("张");
        person1.setSex("男");
        Person person2 = new Person();
        person2.setUsername("李");
        person2.setSex("女");
        List<Person> list = List.of(person1, person2);

        mapper.insertPersonBatch(list);

        sqlSession.commit();
    }

    @Test
    public void test11() {
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        mapper.findAllMy().forEach(System.out::println);
    }
}






















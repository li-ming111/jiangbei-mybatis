package com.hxx.mapper;

import com.hxx.domain.Person;

import java.util.List;

public interface PersonMapper {

    List<Person> findAllMy();
    int insertPersonBatch(List<Person> list);

    Person show(int id);
    Person show1(int id);
    void insertPerson(Person person);

    List<Person> findAllPerson1(Person person);
    List<Person> findAllTrim(Person person);
    List<Person> findAllChoose(Person person);

    void updatePerson(Person person);
}
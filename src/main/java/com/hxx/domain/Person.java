package com.hxx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private Integer id;             // 主键id
    private String username;         // 姓名
    private Integer age;          // 年龄
    private String sex;            // 性别
    private IdCard card;  	   // 人员关联的证件
}
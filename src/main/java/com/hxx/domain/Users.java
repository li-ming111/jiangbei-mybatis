package com.hxx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
    private Integer id;                         // 用户编号
    private String username;              // 用户姓名
	private String address;                 // 用户地址
    private List<Orders> ordersList;  // 用户关联的订单
} 
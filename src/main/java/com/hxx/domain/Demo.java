package com.hxx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Demo {
    private Integer id;
    private String empName;
    private String empSex;
    private int empAge;
}

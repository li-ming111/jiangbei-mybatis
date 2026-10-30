package com.hxx.mapper;

import com.hxx.domain.IdCard;

public interface IdCardMapper {
    IdCard findById(Integer id);
    int insertCard(IdCard idCard);
}
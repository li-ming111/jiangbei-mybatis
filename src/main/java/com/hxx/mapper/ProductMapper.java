package com.hxx.mapper;

import com.hxx.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findByIdProduct(int oid);

} 
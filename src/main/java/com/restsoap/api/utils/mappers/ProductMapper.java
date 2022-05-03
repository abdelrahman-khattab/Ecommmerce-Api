package com.restsoap.api.utils.mappers;

import java.util.List;

import com.restsoap.api.controllers.beans.ProductBean;
import com.restsoap.api.entities.Product;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productBeanToEntity(ProductBean productBean);

    ProductBean productEntityToBean(Product productEntity);

    List<Product> listBeansToEntities(List<ProductBean> productBeans);

    List<ProductBean> listEntitiesToBeans(List<Product> productEntities);
}

package com.restsoap.api.utils.mappers;

import java.util.List;

import com.restsoap.api.controllers.beans.CartBean;
import com.restsoap.api.entities.Cart;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart cartBeanToEntity(CartBean cartBean);

    CartBean cartEntityToBean(Cart cartEntity);

    List<Cart> listBeansToEntities(List<CartBean> cartBeans);

    List<CartBean> listEntitiesToBeans(List<Cart> cartEntities);
}

package com.restsoap.api.utils.mappers;

import java.util.List;

import com.restsoap.api.controllers.beans.UserBean;
import com.restsoap.api.entities.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userBeanToEntity(UserBean userBean);

    UserBean userEntityToBean(User userEntity);

    List<User> listBeansToEntities(List<UserBean> userBeans);

    List<UserBean> listEntitiesToBeans(List<User> userEntities);
}

package com.restsoap.api.utils.mappers;

import java.util.List;

import com.restsoap.api.controllers.beans.CategoryBean;
import com.restsoap.api.entities.Category;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryBeanToEntity(CategoryBean categoryBean);

    CategoryBean categoryEntityToBean(Category categoryEntity);

    List<Category> listBeansToEntities(List<CategoryBean> categoryBeans);

    List<CategoryBean> listEntitiesToBeans(List<Category> categoryEntities);
}

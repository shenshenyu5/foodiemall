package com.imooc.mapper;

import com.imooc.my.mapper.MyMapper;
import com.imooc.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom{
    public List getSubCatList(Integer rootCatId);
    public List getSixNewItemsLazy(@Param("paramsMap") Map<String,Object> map);
}
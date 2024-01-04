package com.lanou.yoyoshop.dao;

import com.lanou.yoyoshop.bean.Type;

import java.util.List;

public interface ITypeDao {
    /**
     * 获取所有类型列表
     * @return
     */
    List<Type> selectAllTypeList();

    Type selectTypeByTypeId(int typeId);
}

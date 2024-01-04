package com.lanou.yoyoshop.service;

import com.lanou.yoyoshop.bean.Type;

import java.util.List;

public interface ITypeService {
    /**
     * 用来获取所有的类型列表
     */
    List<Type> getAllTypeList();

    /**
     * 根据TypeID 获取Type
     * @param typeId
     * @return
     */

    Type getTypeByTypeId(int typeId);
}

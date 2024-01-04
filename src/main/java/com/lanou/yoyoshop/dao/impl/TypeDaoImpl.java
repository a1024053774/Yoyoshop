package com.lanou.yoyoshop.dao.impl;

import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.dao.ITypeDao;
import com.lanou.yoyoshop.service.ITypeService;
import com.lanou.yoyoshop.util.DBUtils;

import java.util.List;

public class TypeDaoImpl implements ITypeDao {
    @Override
    public List<Type> selectAllTypeList() {
        List<Type> typeList = DBUtils.query("select * from type where status=1", Type.class);
        return typeList;
    }

    @Override
    public Type selectTypeByTypeId(int typeId) {
        Type type= DBUtils.queryOne("select * from type where id=? and status=1",Type.class,typeId);
        return type;
    }
}

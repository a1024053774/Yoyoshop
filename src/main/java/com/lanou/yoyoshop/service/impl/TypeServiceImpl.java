package com.lanou.yoyoshop.service.impl;

import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.dao.ITypeDao;
import com.lanou.yoyoshop.dao.impl.TypeDaoImpl;
import com.lanou.yoyoshop.service.ITypeService;

import java.util.List;

public class TypeServiceImpl implements ITypeService {
    ITypeDao typeDao= new TypeDaoImpl();
    @Override
    public List<Type> getAllTypeList() {
        return typeDao.selectAllTypeList();
    }

    @Override
    public Type getTypeByTypeId(int typeId) {
        return typeDao.selectTypeByTypeId(typeId);
    }
}

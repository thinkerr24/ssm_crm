package com.rr.crm.mapper;

import java.util.List;

import com.rr.crm.pojo.BaseDict;

public interface BaseDictMapper {
	// ��ѯ
	public List<BaseDict> selectBaseDictListByCode(String code);
}

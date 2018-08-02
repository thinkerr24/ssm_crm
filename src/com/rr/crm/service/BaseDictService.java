package com.rr.crm.service;

import java.util.List;

import com.rr.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> selectBaseDictListByCode(String code);
}

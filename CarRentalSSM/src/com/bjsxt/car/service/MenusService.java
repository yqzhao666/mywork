package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface MenusService {
	/**
	 * ͨ����ɫid��ѯ���ý�ɫ�µ����в˵�
	 * @param roleId
	 * @return
	 */
	public List<Menus> findMenusList(Roles roleId);
}

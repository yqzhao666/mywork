package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface MenusMapper {
	/**
	 * ͨ����ɫid��ѯ���ý�ɫ�µ����в˵�
	 * @param roles
	 * @return
	 */
	List<Menus> selectMenusByRoleId(Roles roles);
}

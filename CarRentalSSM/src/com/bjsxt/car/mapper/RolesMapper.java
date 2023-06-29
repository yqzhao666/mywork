package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface RolesMapper {
	
	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return int
	 */
	int insertOneRole(Roles role);
	/**
	 * ���ݽ�ɫ���Ʋ�ѯ��ɫid
	 * @param r
	 * @return Roles
	 */
	Roles selectIdByRoleName(Roles r);
	/**
	 * ����roles��menus
	 * @param map
	 * @return int
	 */
	int insertMenusForRole(Map<String, Long> map);
	/**
	 * ��ѯȫ����ɫ��Ϣ����roleName�������ж������rolename��Ϊ�գ������
	 * rolename��ѯ�������ѯȫ����ɫ��Ϣ
	 * @return List<Roles>
	 */
	List<Roles> selectAllRoles(Roles role);
	/**
	 * ���ݽ�ɫ���ķ�ҳ��ѯ
	 * @param map
	 * @return List<Roles>
	 */
	List<Roles> selectRolesByNameByPage(Map<String, Object> map);
	/**
	 * ͨ��������ѯ��ɫ��Ϣ
	 * @param roleid
	 * @return
	 */
	Roles selectByPrimaryKey(Long roleid);
	
	/**
	 * �����ɫ��ģ��Ĺ�ϵ
	 * @param role
	 * @return
	 */
	int deleteMenusForRole(Roles role);
	/**
	 * ɾ����ɫ����Ϣ
	 * @param roleid
	 * @return
	 */
	int deleteRolesById(Roles role);
	/**
	 * ��ѯ���н�ɫ��Ϣ
	 * @return
	 */
	List<Roles> selectAllRole();
	
	
}

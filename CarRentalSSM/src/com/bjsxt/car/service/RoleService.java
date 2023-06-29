package com.bjsxt.car.service;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.util.PageBean;

public interface RoleService {
	/**
	 * ����ɫ��ģ��������
	 * @param roleName ��ʾ��ɫ������
	 * @param idMap ϵͳ����ģ���µ���ģ��ĸ�id����id
	 * @return boolean
	 */
	boolean addMenusForRole(String roleName,List<Long> idLists);
	/**
	 * ���ݽ�ɫ���ķ�ҳ��ѯ����ѯȫ����ɫ
	 * @param page
	 * @return
	 */
	List<Roles> findAllRoles(PageBean<Roles> page, String roleName);
	/**
	 * ʹ�ý�ɫ����������ѯ
	 * @param roleName
	 * @return
	 */
	List<Roles> findAllRolesUseName(String roleName);
	/**
	 * ͨ����ɫid���в�ѯ������ɫ��Ϣ
	 * @param roleid
	 * @return
	 */
	Roles findOneByRoleid(Long roleid);
	/**
	 * �޸ĸý�ɫ��Ȩ��
	 * @param roleName
	 * @param idLists
	 * @return
	 */
	boolean updateMenusForRole(String roleName, List<Long> idLists);
	/**
	 * ͨ����ɫ��idɾ����ɫ����Ϣ
	 * @param roleid
	 * @return
	 */
	boolean deleteRoleById(Long roleid);

}

package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.util.PageBean;

public interface UserService {
	/**
	 * �����û�����������в�ѯ
	 * @param user
	 * @return
	 */
	Users findUserByUNameAndPwd(Users user);
	/**
	 * ��ѯ�û���Ϊusername�µ����еĲ˵�
	 * @param u
	 * @return
	 */
	List<Menus> findAllMenus(Users u);
	/**
	 * ��ѯ���н�ɫ 
	 * @return
	 */
	List<Roles> findAllRoles();
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	boolean addUsers(Users user);
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	List<Users> finAllUser();
	/**
	 * ��ҳ��ѯ
	 * @param page
	 * @return
	 */
	List<Users> findUserByPage(PageBean<Users> page);
	/**
	 * ��������ҳ��ѯ
	 * @param user
	 * @return
	 */
	List<Users> findUserByIf(Users user, PageBean<Users> page);
	/**
	 * ��������ѯ
	 * @param user
	 * @return
	 */
	List<Users> findUserByIf(Users user);
	/**
	 * ����������ѯ�û���Ϣ
	 * @param username
	 * @return
	 */
	Users findUserInfoByUName(String username);
	/**
	 * �޸�����
	 * @param user
	 * @return
	 */
	boolean updateUsers(Users user);
	/**
	 * ͨ������ɾ���û���Ϣ
	 * @param username
	 * @return
	 */
	boolean deleteUserByUsername(String username);

}

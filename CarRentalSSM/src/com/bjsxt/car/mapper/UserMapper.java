package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Users;
/**
 * usermapper
 * @author zql
 *
 */
public interface UserMapper {
	/***
	 * ͨ���û�����������в�ѯ
	 * @param user
	 * @return
	 */
	Users selectUserByNameAndPwd(Users user);
	/**
	 * �����û�������ѯ���Ĳ˵���Ϣ
	 * @param username
	 * @return List<Users>
	 */
	Users selectAllMenus(Users user);
	/**
	 * ��ѯ���е��û�
	 * @return
	 */
	List<Users> selectAllUsers();
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	int insertUsers(Users user);
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	List<Users> selectAllUser();
	/**
	 * ��ҳ��ѯ
	 * @param map
	 * @return
	 */
	List<Users> selectUserByPage(Map<String, Object> map);
	/**
	 * ��������ѯ
	 * @param user
	 * @return
	 */
	List<Users> selectUserByIf(Users user);
	/**
	 * �������ķ�ҳ��ѯ
	 * @param user
	 * @return
	 */
	List<Users> selectUserByIfForPage(Users user);
	/**
	 * ����������ѯ������Ϣ
	 * @param user
	 * @return
	 */
	Users selectOneUserByUname(Users user);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUsers(Users user);
	/**
	 * ͨ������ɾ��
	 * @param user
	 * @return
	 */
	int deleteUserByUsername(Users user);
	
	
	
	
}

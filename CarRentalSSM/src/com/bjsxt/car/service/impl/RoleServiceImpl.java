package com.bjsxt.car.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.RolesMapper;
import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.service.RoleService;
import com.bjsxt.car.util.PageBean;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolesMapper rolesMapper;

	@Override
	public boolean addMenusForRole(String roleName, List<Long> idLists) {
		// ������������£���һ����ӽ�ɫ���ڶ������ݽ�ɫ��ѯ����ɫ��id�����������ݽ�ɫ��id��ģ���id���й���
		// ʵ�ֽ�ɫȨ�޵����
		Roles role = null;
		// ��һ������ӽ�ɫ
		Roles r = new Roles();
		r.setRolename(roleName);
		int x = rolesMapper.insertOneRole(r);
		// �ڶ��������ݽ�ɫ���ƣ���ѯ��ɫid�������ӳɹ����ɹ�֮����Ҫ�����û�����ѯid
		if (x > 0) {
			role = rolesMapper.selectIdByRoleName(r);
		}
		// ��������������Ϣ,��ý�ɫid��������ɫ��ģ�����Ϣ
		Long roleId = role.getRoleid();
		// ��������
		int isAdd = 0;
		boolean flag = false;
		for (Long menuId : idLists) {
			// ʹ��map���ݲ���
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("roleid", roleId);
			map.put("menuid", menuId);
			isAdd = rolesMapper.insertMenusForRole(map);
		}

		if (isAdd > 0) {
			// �����ӳɹ�
			flag = true;
		}

		return flag;
	}

	@Override
	public List<Roles> findAllRoles(PageBean<Roles> page, String rolename) {
		// ��ҳ��ѯ֮ǰ�����Ȳ�ѯȫ�����������Ŀ����
		// List<Roles> roleAllList = rolesMapper.selectAllRoles();
		// ������ݵ�������
		// int totalCount = roleAllList.size();
		// page.setTotalCount(totalCount);
		// �˴�����map��mybatis���ݲ���
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rolename", rolename);
		map.put("start", page.getStartRow());// ��ʼ���к�
		map.put("end", page.getEndRow());// �������к�
		// Ȼ���ڽ��и��������ķ�ҳ��ѯ
		List<Roles> rolesList = rolesMapper.selectRolesByNameByPage(map);

		return rolesList;
	}

	@Override
	public List<Roles> findAllRolesUseName(String rolename) {
		Roles role = new Roles();
		role.setRolename(rolename);
		List<Roles> roleAllList = rolesMapper.selectAllRoles(role);
		return roleAllList;
	}

	@Override
	public Roles findOneByRoleid(Long roleid) {

		Roles role = rolesMapper.selectByPrimaryKey(roleid);
		return role;
	}

	@Override
	public boolean updateMenusForRole(String roleName, List<Long> idLists) {
		// �޸Ľ�ɫ��Ȩ�ޣ�����idLists���ϣ�Ȼ��һ��һ���Ľ����޸ģ�ͬ��֮ǰ���Ȼ�ȡ���û���id��
		//���������һ�����⣿
		//������ʲô�أ��������޸Ľ�ɫ��ʱ�������������޸ģ������޸Ĺ���Ľ�ɫ�Ĳ˵�������ȷ�������ܶ���
		//Ҳ�������ˣ������������޸Ľ�ɫ��Ϣ֮ǰ��������Ҫ�ȽӴ���ɫ��������Ϣ��Ȼ���ڸ���ǰ̨�ύ������ģ��id�������������
		// ��һ������ѯ�û���id

		Roles r = new Roles();
		r.setRolename(roleName);
		Roles role = rolesMapper.selectIdByRoleName(r);

		// ��������������Ϣ,��ý�ɫid���޸Ĺ�����ģ�����Ϣ
		Long roleId = role.getRoleid();
		//Ȼ��ɾ����ɫ�Ĺ�����Ϣ
		int isdelete = rolesMapper.deleteMenusForRole(role);
		int isUpdate = 0;
		boolean flag = false;
		if (isdelete>0) {
			// ��������
			
			
			for (Long menuId : idLists) {
				// ʹ��map���ݲ���
				Map<String, Long> map = new HashMap<String, Long>();
				map.put("roleid", roleId);
				map.put("menuid", menuId);
				// �˴���˵���޸ģ���������Ҳ�������
				isUpdate = rolesMapper.insertMenusForRole(map);
			}
			if (isUpdate > 0) {
				// �����ӳɹ�
				flag = true;
			}

		}
		return flag;
	}

	@Override
	public boolean deleteRoleById(Long roleid) {
		//ɾ��֮ǰ�Ƚ����ɫ�ͺ�ģ��Ĺ���
		Roles role = new Roles();
		role.setRoleid(roleid);
		//ɾ��֮ǰ���������ϵ
		rolesMapper.deleteMenusForRole(role);
		//ɾ����ɫ��Ϣ
		int x = rolesMapper.deleteRolesById(role);
		boolean flag = false;
		if (x>0) {
			//ɾ���ɹ�����true
			flag = true;
		}
		return flag;
	}

}

package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Loginlogs;

public interface LoginLogMapper {
	/**
	 * ��������ѯ�û���¼��Ϣ
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findAllLoginInfoByIf(Loginlogs logs);
	/**
	 * ��ҳ��ѯ��¼��־��Ϣ
	 * @return
	 */
	List<Loginlogs> selectAllLoginInfoByPage(Loginlogs logs);
		
}

package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Logs;

public interface LogInfoMapper {
	/**
	 * ������ѯ���е���־��Ϣ
	 * @return
	 */
	List<Logs> selectLogInfoByIf(Logs log);
	/**
	 * �������ķ�ҳ��ѯ
	 * @param log
	 * @return
	 */
	List<Logs> selectLogInfoByPage(Logs log);

}

package com.bjsxt.car.mapper;

import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;

/**
 * creat by gaoyu 2017��11��15��
 */
public interface LogMapper {
	// �����ͨ��־��Ϣ
	void saveInter(Logs log);
	// ��ӵ�¼��־
	void saveLoginInter(Loginlogs log);
}

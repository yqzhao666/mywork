package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;
import com.bjsxt.car.util.PageBean;

public interface LogInfoService {
	/**
	 * ������ѯ���е���־��Ϣ
	 * @return
	 */
	List<Logs> findLogInfoByIf(Logs log);
	/**
	 * ��ҳ��ѯ
	 * @param page
	 * @param log
	 * @return
	 */
	List<Logs> findLogInfoByPage(PageBean<Logs> page, Logs log);
	/**
	 * ��ѯ��¼��Ϣ����������ѯ
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findLoginInfoByIf(Loginlogs logs);
	/**
	 * ��ҳ��ѯ��¼��־��Ϣ
	 * @param page
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findLoginInfoByPage(PageBean<Loginlogs> page, Loginlogs logs);

}

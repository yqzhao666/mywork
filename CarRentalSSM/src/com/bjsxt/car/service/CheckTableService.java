package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Checktable;

public interface CheckTableService {
	/**
	 * ��鵥���������ѯ
	 * @param check
	 * @return
	 */
	List<Checktable> findCheckTableByIf(Checktable check);
	/**
	 * ͨ����鵥id��ѯ��鵥�����Ϣ
	 * @param checkid
	 * @return
	 */
	Checktable findCheckTableById(Long checkid);
	/**
	 * �޸ļ�鵥
	 * @param check
	 * @return
	 */
	boolean updateCheckTable(Checktable check);
	/**
	 * ɾ����鵥��ͨ��id
	 * @param checkid
	 * @return
	 */
	boolean deleteCheckTable(Long checkid);
	/**
	 * ��Ӽ�鵥
	 * @param checktable
	 * @return
	 */
	boolean addCheckTable(Checktable checktable);

}

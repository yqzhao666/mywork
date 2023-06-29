package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

public interface RentalTableService {
	/**
	 * ���ⵥ�Ķ�������ѯ
	 * @param renttable
	 * @return
	 */
	List<Renttable> findRentalTableByIf(Renttable renttable);
	/**
	 * ͨ�����ⵥ�������idȥ��ѯ���⵫�����Ϣ
	 * @param tableid
	 * @return
	 */
	Renttable findRentalByRenTableId(String tableid);
	/**
	 * ���³��ⵥ��
	 * @param renttable
	 * @return boolean
	 */
	boolean updateRentable(Renttable renttable);
	/**
	 * ��ӳ��ⵥ��
	 * @param rent
	 * @return
	 */
	boolean addRentTable(Renttable rent);

}

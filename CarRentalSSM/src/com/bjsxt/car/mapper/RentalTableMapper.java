package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

public interface RentalTableMapper {
	/**
	 * ���ⵥ��Ķ�������ѯ
	 * @param renttable
	 * @return
	 */
	List<Renttable> selectRentalTableByIf(Renttable renttable);
	/**
	 * ͨ��������ѯ���ⵥ�����Ϣ
	 * @param renttable
	 * @return
	 */
	Renttable selectRentaalTableByPrimaryKey(Renttable renttable);
	/**
	 * ���³��ⵥ��
	 * @param renttable
	 * @return
	 */
	int updateRenttable(Renttable renttable);
	/**
	 * ��ӳ��ⵥ��
	 * @param rent
	 * @return
	 */
	int insertRenttable(Renttable rent);

}

package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Checktable;

public interface CheckTableMapper {
	/**
	 * ��鵥��Ķ�������ѯ
	 * @param check
	 * @return
	 */
	List<Checktable> selectCheckByIf(Checktable check);
	/**
	 * ͨ��������ѯ��鵥�����Ϣ
	 * @param ct
	 * @return
	 */
	Checktable selectCheckByPrimaryKey(Checktable ct);
	/**
	 * �޸ļ�鵥
	 * @param check
	 * @return
	 */
	int updateCheckTable(Checktable check);
	/**
	 * ͨ��idɾ����鵥��
	 * @param ct
	 * @return
	 */
	int deleteCheckTableById(Checktable ct);
	/**
	 * ��Ӽ�鵥��
	 * @param checktable
	 * @return
	 */
	int insertCheckTable(Checktable checktable);

}

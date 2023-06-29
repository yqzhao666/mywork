package com.bjsxt.car.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017��11��15��
 */
public interface StatisticsMapper {
	//��ȡ���У��⳵��Ϣ
	List<Renttable> getAllStati(String date);
	//��ѯ����
	//Renttable getOneStati(int tableid);
	/**
	 * ��ѯ��������������ΪLong
	 * @param tableid
	 * @return
	 */
	Renttable getOneStati(Long tableid);
	
	//ͨ������id����
	List<Renttable> getAmountByCarIdMonth(Map<String,String> map);
}

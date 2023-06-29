package com.bjsxt.car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017��11��15��
 */

public interface StatisticsService {
	//��ȡ���У��⳵��Ϣ
	List<Renttable> getAllStati();
	//��ѯ����
	Renttable getOneStati(int tableid);
	/**
	 * ��ѯ����
	 * @param tableid
	 * @return
	 */
	Renttable getOneStati(Long tableid);
	
	//��ѯ���·ֲ�ͳ�Ƴ���������
	List<CarsRentMonth> getMonthAmount();
}

package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.CountBean;
import com.bjsxt.car.pojo.Renttable;

public interface CountRentService {
	/**
	 * ͳ��ÿ�����������޷���
	 * @return
	 */
	List<Renttable> countAllShouldPayPrice();
	/**
	 * ͳ��ÿ�����������ȥ�Ĵ���
	 * @return
	 */
	List<Renttable> countRentCarCount();

}

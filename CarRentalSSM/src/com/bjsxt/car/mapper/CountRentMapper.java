package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

/**
 * ͳ�Ƴ��ⵥ����Ϣmapper
 * @author zql
 *
 */
public interface CountRentMapper {

	List<Renttable> countAllShouldPayPrice();

	List<Renttable> countRentCarCount();
	
}

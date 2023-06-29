package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Customers;

public interface CustMapper {

	int saveCust(Customers cust);
	
	List<Customers> getAllCust(Customers cust);
	
	//��ѯȫ���ķ�ҳ
	List<Customers> getAllCustByPage(Map<String,Object> map);
	
	//ģ����ѯ�ķ�ҳ
	List<Customers> getAllCustByPage2(Map<String,Object> map);
	
	
	
	int deleteCust(String identity);
	
	Customers findOne(String identity);
	
	int updateCust(Customers cust);
	
//	List<Customers> getCustLike(Customers cust);
	
	/**
	 * �⳵ҵ��
	 */
	List<Customers> findOne1(String identity);
	
}




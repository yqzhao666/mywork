package com.bjsxt.car.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.car.pojo.Customers;
import com.bjsxt.car.service.CustService;

public class test01 {
	
	
	@Test
	public void test01(){
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		
		CustService bean = (CustService) context.getBean("custServiceImpl");
		
		Customers cust = new Customers("124", "123", "123", "123", "123", "123", "123");
		
		
		Customers saveCust = bean.saveCust(cust);
		
		System.out.println(saveCust);*/
		addCar();
		updateCar();
		deleteCar();
	}
	
	/**
	 * �������
	 */
	public void addCar(){
		System.out.println("������ӵķ���");
	}
	
	/**
	 * �����޸�
	 */
	public void updateCar(){
		System.out.println("�����޸ĵķ���");
	}
	
	/**
	 * ����ɾ��
	 */
	public void deleteCar(){
		System.out.println("����ɾ���ķ���");
	}

}

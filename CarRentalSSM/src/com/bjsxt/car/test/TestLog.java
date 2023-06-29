package com.bjsxt.car.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * creat by gaoyu 2017��11��15��
 */
public class TestLog {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		System.out.println("===============last:" + last);
	}

	/**
	 * �������
	 */
	public static void addCar() {
		System.out.println("������ӵķ���");
	}

	/**
	 * �����޸�
	 */
	public static void updateCar() {
		System.out.println("�����޸ĵķ���");
	}

	/**
	 * ����ɾ��
	 */
	public static void deleteCar() {
		System.out.println("����ɾ���ķ���");
	}

}

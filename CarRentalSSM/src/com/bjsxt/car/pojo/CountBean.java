package com.bjsxt.car.pojo;

import java.io.Serializable;

public class CountBean implements Serializable{
	private Cars car;
	public Cars getCar() {
		return car;
	}
	public void setCar(Cars car) {
		this.car = car;
	}
	//ÿ����������������
	private Long countPrice;
	//ÿ�������ı��
	private Long carid;
	//ÿ��������Ĵ���
	private Long carrentcount;
	public Long getCountPrice() {
		return countPrice;
	}
	public Long getCarrentcount() {
		return carrentcount;
	}
	public void setCarrentcount(Long carrentcount) {
		this.carrentcount = carrentcount;
	}
	public void setCountPrice(Long countPrice) {
		this.countPrice = countPrice;
	}
	public Long getCarid() {
		return carid;
	}
	public void setCarid(Long carid) {
		this.carid = carid;
	}
	
}

package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Cars;

/**
 * creat by gaoyu 2017��11��13��
 */
public interface CarMapper {
	// ��ӳ���
	int addCar(Cars car);

	// ����ȫ������
	List<Cars> getAllCars(Map<String,Object> map);
	
	//���ҵ���
	Cars getOneCar(String carNumber);

	//����
	int updateCar(Cars car);
	
	//ɾ��
	int deleteOne(Cars car);
	
	//��ҳ��ģ����ѯ
	List<Cars> getPageLikeCars(Map<String,Object> map);
	/**
	 * ��ͨ��������ѯȫ������
	 * @return
	 */
	List<Cars> selectAllCars();
}

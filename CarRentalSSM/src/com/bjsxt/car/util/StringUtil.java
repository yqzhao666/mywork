package com.bjsxt.car.util;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017��11��16��
 */
/*
 * ���������ʽ���ͳɹ���
 * 
 * 			[ {
				name : "��������",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "��ɯ����",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "��ʱ��",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "����",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "������",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "�ֿ�",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			} ]
 */
public class StringUtil {
	public static String formatString(List<CarsRentMonth> monthAmount){
		StringBuilder sb = new StringBuilder();
		//��ӿ�ͷ
		sb.append("[ ");
		//������������
		for(int i= 0 ; i< monthAmount.size() ;i++){
			CarsRentMonth carsRentMonth = monthAmount.get(i);
			System.out.println("��������==="+carsRentMonth.getCarName());
			System.out.println("�����·�map==="+carsRentMonth.getMap());
			sb.append("{ name :'"+carsRentMonth.getCarName()+"',");
			sb.append("data : [");
			//����map �·ݣ�����
			for(int j = 1 ; j<= carsRentMonth.getMap().size();j++){
				carsRentMonth.getMap().get(""+j);
				if(j==carsRentMonth.getMap().size()){
					sb.append(carsRentMonth.getMap().get(""+j));
				}else{
					sb.append(carsRentMonth.getMap().get(""+j)+",");
				}
			}
			if(i==(monthAmount.size()-1)){
				sb.append(" ] }");
			}else{
				sb.append(" ] },");
			}
		}
		//��ӽ�β
		sb.append(" ]");
		return sb.toString();
	}
	
}

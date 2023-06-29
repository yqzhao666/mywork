package com.bjsxt.car.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.CarMapper;
import com.bjsxt.car.mapper.StatisticsMapper;
import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.StatisticsService;
import com.bjsxt.car.util.DateUtil;

/**
 * creat by gaoyu
 * 2017��11��15��
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{
	@Autowired
	private StatisticsMapper mapper;
	@Autowired
	private CarMapper carMapper;
	/* 
	 * ��������⳵��Ϣ
	 */
	@Override
	public List<Renttable> getAllStati() {
		//���ϵͳ��ǰ�·ݵ����һ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastday = format.format(ca.getTime());
		System.out.println("===============last:" + lastday);
		return mapper.getAllStati(lastday);
	}
	/* 
	 * ��ѯ����ҵ����Ϣ
	 */
//	@Override
//	public Renttable getOneStati(int tableid) {
//		return mapper.getOneStati(tableid);
//	}
	@Override
	public Renttable getOneStati(Long tableid) {
		// TODO Auto-generated method stub
		return mapper.getOneStati(tableid);
	}
	
	@Override
	public Renttable getOneStati(int tableid) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * ��ѯ���·ֲ�ͳ�Ƴ���������
	 */
	@Override
	public List<CarsRentMonth> getMonthAmount() {
		// ��Ų�����map
		Map<String, String> paramap = new HashMap<String, String>();
		//��õ�����·�
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		//�������ڶ����š������֣��·��Լ���Ӧ���⳵����
		List<CarsRentMonth> crmList = new ArrayList<CarsRentMonth>();
		//map,����·ݣ��������
		Map<String, String> map2 = null;
		// ���Ȼ�ó�����ϢList
		List<Cars> AllCars = carMapper.selectAllCars();
		System.out.println("��һ����ȡ��ȫ������==============" + AllCars);
		// ����������Ϣ����ȡid
		for (Cars cars : AllCars) {
			//ʵ�����ڲ�map
			map2 = new HashMap<String, String>();
			//��ȡid
			String carid = cars.getCarNumber();
			// 12���·ݵĵ���,����ÿ���µģ������id�ĳ�������
			for (int i = 1; i <= 12; i++) {
				// ͨ��id���·ݲ���
				Map<String, String> map = DateUtil.getDate(year, i);
				/*System.out.println("���µ�һ�죺" + map.get("first"));
				System.out.println("�������һ�죺" + map.get("last"));*/
				// ���·ݷŽ�map
				paramap.put("carid", carid);
				paramap.put("start", map.get("first"));
				paramap.put("end", map.get("last"));
				List<Renttable> amount = mapper.getAmountByCarIdMonth(paramap);
				System.out.println(year+"��"+i+"�·�"+cars.getCarType()+"�����"+amount.size()+"��");
				//�����ݷ���map
				map2.put(""+i,""+amount.size());
			}
			//�����ݷ������map
			CarsRentMonth crm = new CarsRentMonth(map2, cars.getCarType());
			crmList.add(crm);
		}
		System.out.println("���г���Ϣ==========="+crmList);
		return crmList;
	}
}

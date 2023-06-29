package com.bjsxt.car.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.mapper.CarMapper;
import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.service.CarService;
import com.bjsxt.car.util.PageBean;

/**
 * creat by gaoyu 2017��11��13��
 */
@Service
public class CarServiceImpl implements CarService {
	// �Զ�װ��
	@Autowired
	private CarMapper mapper;

	/*
	 * ��ӳ���
	 */
	@Override
	public int addCar(Cars car) {
		return mapper.addCar(car);
	}

	/*
	 * ����ȫ������
	 */
	@Override
	public List<Cars> getAllCars(Map<String, Object> map) {
		return mapper.getAllCars(map);
	}

	/*
	 * ģ������ҳ��ѯ
	 */
	@Override
	public List<Cars> getPageLikeCars(Map<String, Object> map) {
		return mapper.getPageLikeCars(map);
	}

	/*
	 * ����
	 */
	@Override
	public int updateCar(Cars car) {
		return mapper.updateCar(car);
	}

	/*
	 * ��ѯ����
	 */
	@Override
	public Cars getOneCar(String carNumber) {
		return mapper.getOneCar(carNumber);
	}

	/*
	 * ɾ������
	 */
	@Override
	public int deleteOne(Cars car) {
		return mapper.deleteOne(car);
	}

	/**
	 * ͼƬ�ϴ��߼�����
	 */
	public String uploadImg(MultipartFile file, HttpSession session) {
		// �����������Ƿ����ϴ��ļ���
		String path = session.getServletContext().getRealPath("/upload");
		// �ж�
		File fi = new File(path);
		if (!fi.exists()) {
			// �������ļ���
			fi.mkdirs();
		}
		// ��ȡΨһ�ļ���
		String name = file.getOriginalFilename();
		String type = name.substring(name.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		String newName = uuid + type;
		// ָ���ļ��ϴ�Ŀ¼���ļ���
		try {
			file.transferTo(new File(fi, newName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newName;
	}

	/*
	 * ��ҳ
	 */
	@Override
	public PageBean getPageCar(String sindex, String sSize,Cars car) {
		PageBean pageBean = new PageBean();
		// ��ֵ��ҳ��Ϣ
		if (sindex != null && !"".equals(sindex)) {
			int index = Integer.parseInt(sindex);
			// Ϊbean��ֵҳ��
			pageBean.setIndex(index);
		}
		if (sSize != null && !"".equals(sSize)) {
			int size = Integer.parseInt(sSize);
			// ������ʾ����
			pageBean.setSize(size);
		}
		// bean����������
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("cars", car);
		int sizeCount = getAllCars(map1).size(); // ��ѯ���м���
		System.out.println("һ����" + sizeCount);
		pageBean.setTotalCount(sizeCount);

		// ���㿪ʼ�������ͽ�β����
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		System.out.println(start + ",,,," + end + "������" + sizeCount);
		// ��ѯ��ҳ�����Ϣ
		// ����Map��������
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cars", car);
		map.put("start", start);
		map.put("end", end);
		List<Cars> carList = getPageLikeCars(map);
		// ��Ҫ��ʾ���������õ�bean��
		pageBean.setList(carList);
		return pageBean;
	}
	/**
	 * ����ӵķ���--->��ͨ��������ѯȫ������
	 */
	@Override
	public List<Cars> findAllCars() {
		List<Cars> carList = mapper.selectAllCars();
		return carList;
	}

}

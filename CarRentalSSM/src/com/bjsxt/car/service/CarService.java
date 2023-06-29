package com.bjsxt.car.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.util.PageBean;

/**
 * creat by gaoyu 2017年11月13日
 */
public interface CarService {
	// 添加车辆
	int addCar(Cars car);

	// 查找全部车辆
	List<Cars> getAllCars(Map<String,Object> map);
	
	//分页，模糊查询
	List<Cars> getPageLikeCars(Map<String,Object> map);

	//查找单个
	Cars getOneCar(String carNumber);
	
	//更改
	int updateCar(Cars car);
	
	//删除
	int deleteOne(Cars car);
	
	// 上传图片
	String uploadImg(MultipartFile file, HttpSession session);
	
	//分页
	PageBean getPageCar(String sindex,String sSize,Cars car);
	/**
	 * 查询全部汽车
	 * @return
	 */
	List<Cars> findAllCars();
}

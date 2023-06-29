package com.bjsxt.car.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.service.CarService;
import com.bjsxt.car.service.impl.CarServiceImpl;
import com.bjsxt.car.util.PageBean;

/**
 * creat by gaoyu 2017年11月13日
 */
@Controller
@RequestMapping("/car")
public class CarController {

	// serrvice实现层类
	@Autowired
	private CarService service;

	/**
	 * 添加车辆
	 * 
	 * @param car
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/addCar")
	public String addCar(Cars car, MultipartFile file, HttpSession session) {
		// 调用图片上传业务逻辑，获得全路径
		String uploadImg = service.uploadImg(file, session);
		// 将路径设置到car对象中，存到数据库
		car.setCarImg(uploadImg);
		// 存储
		service.addCar(car);
		return "redirect:getPageCars";
	}

	/**
	 * 分页，模糊
	 * 
	 * @param car
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getPageCars")
	public String getPageCars(Cars car, HttpServletRequest request,
			HttpServletResponse response) {
		// 接受当前页，和一页数目
		String sindex = request.getParameter("page");
		String sSize = request.getParameter("size");
		PageBean pageBean = service.getPageCar(sindex, sSize, car);
		// 将bean 传到前台
		request.setAttribute("pageBean", pageBean);
		// 记住模糊查询的值
		request.setAttribute("oldCar", car);
		return "carManager/viewCars";
	}

	/**
	 * 查询单个
	 * 
	 * @param car
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getOneCar")
	public String getOneCar(Cars car, HttpServletRequest req,
			HttpServletResponse resp) {
		Cars oneCar = service.getOneCar(car.getCarNumber());
		req.setAttribute("oneCar", oneCar);
		return "carManager/updateCar";
	}

	/**
	 * 更改
	 * 
	 * @param car
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateCar")
	public String updateCar(Cars car, MultipartFile file, HttpSession session) {
		// 调用图片上传业务逻辑，获得全路径
		String uploadImg = null;
		if (file.getOriginalFilename() != null
				&& !"".equals(file.getOriginalFilename())) {
			uploadImg = service.uploadImg(file, session);
		}else{
			// 图片不变
			Cars oneCar = service.getOneCar(car.getCarNumber());
			uploadImg = oneCar.getCarImg();
		}
		// 将路径设置到car对象中，存到数据库
		car.setCarImg(uploadImg);
		// 更改
		System.out.println("修改后的应该是" + car);
		service.updateCar(car);
		return "redirect:getPageCars";
	}

	/**
	 * 删除
	 * 
	 * @param car
	 * @return
	 */
	@RequestMapping("/deleteOne")
	public String deleteOne(Cars car) {
		System.out.println("删除" + car.getCarNumber());
		service.deleteOne(car);
		return "redirect:getPageCars";
	}

	/**
	 * 测试跳转
	 */
	@RequestMapping("/test")
	public String Test() {
		System.out.println("测试");
		return "redirect:getAllCars";
	}
}

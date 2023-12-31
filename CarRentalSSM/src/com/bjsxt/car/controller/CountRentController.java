package com.bjsxt.car.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.car.pojo.CountBean;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.CountRentService;
import com.bjsxt.car.util.MyUtil;

/**
 * 统计出租情况
 * @author zql
 *
 */
@Controller
@RequestMapping("countRent")
public class CountRentController {
	@Autowired
	private CountRentService countService;
	/**
	 * 统计本公司的每辆车的销售额和和被出租的费用
	 * 响应json格式
	 * @return
	 */
	@RequestMapping("countPriceAndNum")
	public String countPriceAndNum(HttpServletRequest req){
		//统计每辆车被租出去的总费用
		List<Renttable> countAllShouldPayPrice = countService.countAllShouldPayPrice();
		
		//统计每辆车被租的次数
		List<Renttable> list = countService.countRentCarCount();
		for (Renttable r1 : countAllShouldPayPrice) {
			for (Renttable r2 : list) {
				//如果车牌号相同
				if (r1.getCars().getCarNumber().equals(r2.getCars().getCarNumber())) {
					//遍历将出租单r2的每辆车的出租状况给r1
					r1.setCarrentcount(r2.getCarrentcount());
				}
			}
		}
		String sires = MyUtil.getSires(countAllShouldPayPrice);
		System.out.println(sires);
		req.setAttribute("sires", sires);
		//req.setAttribute("list", countAllShouldPayPrice);
		//req.setAttribute("a", "carNumber");
		return "count/countRent";
	}
	
}

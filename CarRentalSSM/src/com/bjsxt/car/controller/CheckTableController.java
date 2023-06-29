package com.bjsxt.car.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjsxt.car.pojo.Checktable;
import com.bjsxt.car.service.CheckTableService;

/**
 * 检查单管理控制层
 * @author zql
 *
 */
@Controller
@RequestMapping("check")
public class CheckTableController {
	@Autowired
	private CheckTableService checkService;
	
	/**
	 * 绑定时间转换器，否则，提交日期参数将会产生400错误
	 * @param binder
	 */
  @InitBinder    
    public void initBinder(WebDataBinder binder) {    

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
    }
  /**
   * 检查单的多条件查询
   * @param tableid
   * @param check
   * @param req
   * @return
   */
	@RequestMapping("findCheckByIf")
	public String findCheckByIf(@RequestParam("tableid")Long tableid,Checktable check,HttpServletRequest req){
		List<Checktable> ck = checkService.findCheckTableByIf(check);
		req.setAttribute("CheckList", ck);
		return "operatorManager/viewCheckTables";
	}
	/**
	 * 通过id查询检查单的信息
	 * @param checkid
	 * @param req
	 * @return
	 */
	@RequestMapping("findByCheckId")
	public String findByCheckId(@RequestParam("checkid")Long checkid,HttpServletRequest req){
		
		Checktable ct = checkService.findCheckTableById(checkid);
		req.setAttribute("check", ct);
		return "operatorManager/updateCheckTable";
	}
	/**
	 * 更新检查单
	 * @param checkid
	 * @param check
	 * @return
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(@RequestParam("checkid")Long checkid,Checktable check){
		boolean flag = checkService.updateCheckTable(check);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
	/**
	 * 删除检查单，通过id
	 * @param checkid
	 * @return
	 */
	@RequestMapping("deleteByCheckId")
	public String deleteByCheckId(@RequestParam("checkid")Long checkid){
		boolean flag = checkService.deleteCheckTable(checkid);
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	}
}

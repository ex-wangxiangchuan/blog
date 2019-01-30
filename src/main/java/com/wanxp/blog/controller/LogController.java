package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.dto.*;
import com.wanxp.blog.service.LogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Log管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/log")
public class LogController extends BaseController {

	@Autowired
	private LogServiceI logService;


	/**
	 * 跳转到Log管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/log/log";
	}

	/**
	 * 获取Log数据表格
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(LogDTO log, Pageable pa) {
		return logService.queryInPage(log, pa);
	}
	/**
	 * 获取Log数据表格excel
	 * 
	 * @param user
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	@GetMapping("/download")
	public void download(LogDTO log, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(log,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Log页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		LogDTO log = new LogDTO();
		return "/log/logAdd";
	}

	/**
	 * 添加Log
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public Json add(LogDTO log) {
		Json j = new Json();		
		logService.add(log);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到Log查看页面
	 * 
	 * @return
	 */
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		LogDTO log = logService.get(id);
		request.setAttribute("log", log);
		return "/log/logView";
	}

	/**
	 * 跳转到Log修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		LogDTO log = logService.get(id);
		request.setAttribute("log", log);
		return "/log/logEdit";
	}

	/**
	 * 修改Log
	 * 
	 * @param log
	 * @return
	 */
	@PutMapping("/edit")
	public Json edit(LogDTO log) {
		Json j = new Json();		
		logService.edit(log);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除Log
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Json delete(@PathVariable Integer id) {
		Json j = new Json();
		logService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

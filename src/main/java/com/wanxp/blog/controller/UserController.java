package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.pageModel.*;
import com.wanxp.blog.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User管理控制器
 * 
 * @author John
 * 
 */
@RestController("/userController")
public class UserController extends BaseController {

	@Autowired
	private UserServiceI userService;


	/**
	 * 跳转到User管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/user/user";
	}

	/**
	 * 获取User数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	public DataGrid dataGrid(User user, PageHelper ph) {
		return userService.dataGrid(user, ph);
	}
	/**
	 * 获取User数据表格excel
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
	@RequestMapping("/download")
	public void download(User user, PageHelper ph, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(user,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加User页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		User user = new User();
		return "/user/userAdd";
	}

	/**
	 * 添加User
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public Json add(User user) {
		Json j = new Json();		
		userService.add(user);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到User查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Integer id) {
		User user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userView";
	}

	/**
	 * 跳转到User修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Integer id) {
		User user = userService.get(id);
		request.setAttribute("user", user);
		return "/user/userEdit";
	}

	/**
	 * 修改User
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/edit")
	public Json edit(User user) {
		Json j = new Json();		
		userService.edit(user);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除User
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public Json delete(Integer id) {
		Json j = new Json();
		userService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.pageModel.*;
import com.wanxp.blog.service.CommentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Comment管理控制器
 * 
 * @author John
 * 
 */
@RestController("/commentController")
public class CommentController extends BaseController {

	@Autowired
	private CommentServiceI commentService;


	/**
	 * 跳转到Comment管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/comment/comment";
	}

	/**
	 * 获取Comment数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	public DataGrid dataGrid(Comment comment, PageHelper ph) {
		return commentService.dataGrid(comment, ph);
	}
	/**
	 * 获取Comment数据表格excel
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
	public void download(Comment comment, PageHelper ph, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(comment,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Comment页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Comment comment = new Comment();
		return "/comment/commentAdd";
	}

	/**
	 * 添加Comment
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public Json add(Comment comment) {
		Json j = new Json();		
		commentService.add(comment);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到Comment查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Integer id) {
		Comment comment = commentService.get(id);
		request.setAttribute("comment", comment);
		return "/comment/commentView";
	}

	/**
	 * 跳转到Comment修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Integer id) {
		Comment comment = commentService.get(id);
		request.setAttribute("comment", comment);
		return "/comment/commentEdit";
	}

	/**
	 * 修改Comment
	 * 
	 * @param comment
	 * @return
	 */
	@RequestMapping("/edit")
	public Json edit(Comment comment) {
		Json j = new Json();		
		commentService.edit(comment);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除Comment
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public Json delete(Integer id) {
		Json j = new Json();
		commentService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

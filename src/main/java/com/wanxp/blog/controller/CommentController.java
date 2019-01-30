package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.dto.*;
import com.wanxp.blog.service.CommentServiceI;
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
 * Comment管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController extends BaseController {

	@Autowired
	private CommentServiceI commentService;


	/**
	 * 跳转到Comment管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/comment/comment";
	}

	/**
	 * 获取Comment数据表格
	 * 
	 * @param comment
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(CommentDTO comment, Pageable pa) {
		return commentService.queryInPage(comment, pa);
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
	@GetMapping("/download")
	public void download(CommentDTO comment, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(comment,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Comment页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		CommentDTO comment = new CommentDTO();
		return "/comment/commentAdd";
	}

	/**
	 * 添加Comment
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public Json add(CommentDTO comment) {
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
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request,@PathVariable Integer id) {
		CommentDTO comment = commentService.get(id);
		request.setAttribute("comment", comment);
		return "/comment/commentView";
	}

	/**
	 * 跳转到Comment修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		CommentDTO comment = commentService.get(id);
		request.setAttribute("comment", comment);
		return "/comment/commentEdit";
	}

	/**
	 * 修改Comment
	 * 
	 * @param comment
	 * @return
	 */
	@PutMapping("/edit")
	public Json edit(CommentDTO comment) {
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
	@DeleteMapping("/{id}")
	public Json delete(@PathVariable Integer id) {
		Json j = new Json();
		commentService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.dto.*;
import com.wanxp.blog.service.ContentServiceI;
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
 * Content管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/content")
public class ContentController extends BaseController {

	@Autowired
	private ContentServiceI contentService;


	/**
	 * 跳转到Content管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/content/content";
	}

	/**
	 * 获取Content数据表格
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(ContentDTO content, Pageable pa) {
		return contentService.queryInPage(content, pa);
	}
	/**
	 * 获取Content数据表格excel
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
	public void download(ContentDTO content, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(content,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Content页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		ContentDTO content = new ContentDTO();
		return "/content/contentAdd";
	}

	/**
	 * 添加Content
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public Json add(ContentDTO content) {
		Json j = new Json();		
		contentService.add(content);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到Content查看页面
	 * 
	 * @return
	 */
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		ContentDTO content = contentService.get(id);
		request.setAttribute("content", content);
		return "/content/contentView";
	}

	/**
	 * 跳转到Content修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		ContentDTO content = contentService.get(id);
		request.setAttribute("content", content);
		return "/content/contentEdit";
	}

	/**
	 * 修改Content
	 * 
	 * @param content
	 * @return
	 */
	@PutMapping("/edit")
	public Json edit(ContentDTO content) {
		Json j = new Json();		
		contentService.edit(content);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除Content
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Json delete(@PathVariable Integer id) {
		Json j = new Json();
		contentService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

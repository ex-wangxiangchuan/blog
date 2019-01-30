package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.dto.*;
import com.wanxp.blog.service.ContentMetaRelationshipServiceI;
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
 * ContentMetaRelationship管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/contentMetaRelationship")
public class ContentMetaRelationshipController extends BaseController {

	@Autowired
	private ContentMetaRelationshipServiceI contentMetaRelationshipService;


	/**
	 * 跳转到ContentMetaRelationship管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/contentmetarelationship/contentMetaRelationship";
	}

	/**
	 * 获取ContentMetaRelationship数据表格
	 * 
	 * @param
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(ContentMetaRelationshipDTO contentMetaRelationship, Pageable pa) {
		return contentMetaRelationshipService.queryInPage(contentMetaRelationship, pa);
	}
	/**
	 * 获取ContentMetaRelationship数据表格excel
	 * 
	 * @param
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws IOException 
	 */
	@GetMapping("/download")
	public void download(ContentMetaRelationshipDTO contentMetaRelationship, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(contentMetaRelationship,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加ContentMetaRelationship页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		ContentMetaRelationshipDTO contentMetaRelationship = new ContentMetaRelationshipDTO();
		return "/contentmetarelationship/contentMetaRelationshipAdd";
	}

	/**
	 * 添加ContentMetaRelationship
	 * 
	 * @return
	 */
	@PostMapping("/add")
	public Json add(ContentMetaRelationshipDTO contentMetaRelationship) {
		Json j = new Json();		
		contentMetaRelationshipService.add(contentMetaRelationship);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到ContentMetaRelationship查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		ContentMetaRelationshipDTO contentMetaRelationship = contentMetaRelationshipService.get(id);
		request.setAttribute("contentMetaRelationship", contentMetaRelationship);
		return "/contentmetarelationship/contentMetaRelationshipView";
	}

	/**
	 * 跳转到ContentMetaRelationship修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		ContentMetaRelationshipDTO contentMetaRelationship = contentMetaRelationshipService.get(id);
		request.setAttribute("contentMetaRelationship", contentMetaRelationship);
		return "/contentmetarelationship/contentMetaRelationshipEdit";
	}

	/**
	 * 修改ContentMetaRelationship
	 * 
	 * @param contentMetaRelationship
	 * @return
	 */
	@PutMapping("/edit")
	public Json edit(ContentMetaRelationshipDTO contentMetaRelationship) {
		Json j = new Json();		
		contentMetaRelationshipService.edit(contentMetaRelationship);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除ContentMetaRelationship
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Json delete(@PathVariable Integer id) {
		Json j = new Json();
		contentMetaRelationshipService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

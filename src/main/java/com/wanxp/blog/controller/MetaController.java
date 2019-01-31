package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.model.dto.*;
import com.wanxp.blog.service.MetaServiceI;
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
 * Meta管理控制器
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/meta")
public class MetaController extends BaseController {

	@Autowired
	private MetaServiceI metaService;


	/**
	 * 跳转到Meta管理页面
	 * 
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/meta/meta";
	}

	/**
	 * 获取Meta数据表格
	 * 
	 * @param
	 * @return
	 */
	@GetMapping("/dataGrid")
	public Page dataGrid(MetaDTO meta, Pageable ph) {
		return metaService.queryInPage(meta, ph);
	}
	/**
	 * 获取Meta数据表格excel
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
	public void download(MetaDTO meta, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		Page dg = dataGrid(meta,pa);
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Meta页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		MetaDTO meta = new MetaDTO();
		return "/meta/metaAdd";
	}

	/**
	 * 添加Meta
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public Json add(MetaDTO meta) {
		Json j = new Json();		
		metaService.add(meta);
		j.setSuccess(true);
		j.setMsg("添加成功！");		
		return j;
	}

	/**
	 * 跳转到Meta查看页面
	 * 
	 * @return
	 */
	@GetMapping("/viewPage/{id}")
	public String view(HttpServletRequest request, @PathVariable Integer id) {
		MetaDTO meta = metaService.get(id);
		request.setAttribute("meta", meta);
		return "/meta/metaView";
	}

	/**
	 * 跳转到Meta修改页面
	 * 
	 * @return
	 */
	@GetMapping("/editPage/{id}")
	public String editPage(HttpServletRequest request, @PathVariable Integer id) {
		MetaDTO meta = metaService.get(id);
		request.setAttribute("meta", meta);
		return "/meta/metaEdit";
	}

	/**
	 * 修改Meta
	 * 
	 * @param meta
	 * @return
	 */
	@PutMapping("/edit")
	public Json edit(MetaDTO meta) {
		Json j = new Json();		
		metaService.edit(meta);
		j.setSuccess(true);
		j.setMsg("编辑成功！");		
		return j;
	}

	/**
	 * 删除Meta
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Json delete(@PathVariable Integer id) {
		Json j = new Json();
		metaService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

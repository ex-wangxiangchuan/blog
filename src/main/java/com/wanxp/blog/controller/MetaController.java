package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.pageModel.*;
import com.wanxp.blog.service.MetaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController("/metaController")
public class MetaController extends BaseController {

	@Autowired
	private MetaServiceI metaService;


	/**
	 * 跳转到Meta管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		return "/meta/meta";
	}

	/**
	 * 获取Meta数据表格
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/dataGrid")
	public DataGrid dataGrid(Meta meta, PageHelper ph) {
		return metaService.dataGrid(meta, ph);
	}
	/**
	 * 获取Meta数据表格excel
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
	public void download(Meta meta, PageHelper ph, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException{
		DataGrid dg = dataGrid(meta,ph);		
		downloadFields = downloadFields.replace("&quot;", "\"");
		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
		List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
		downloadTable(colums, dg, response);
	}
	/**
	 * 跳转到添加Meta页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Meta meta = new Meta();
		return "/meta/metaAdd";
	}

	/**
	 * 添加Meta
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	public Json add(Meta meta) {
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
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Integer id) {
		Meta meta = metaService.get(id);
		request.setAttribute("meta", meta);
		return "/meta/metaView";
	}

	/**
	 * 跳转到Meta修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Integer id) {
		Meta meta = metaService.get(id);
		request.setAttribute("meta", meta);
		return "/meta/metaEdit";
	}

	/**
	 * 修改Meta
	 * 
	 * @param meta
	 * @return
	 */
	@RequestMapping("/edit")
	public Json edit(Meta meta) {
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
	@RequestMapping("/delete")
	public Json delete(Integer id) {
		Json j = new Json();
		metaService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}

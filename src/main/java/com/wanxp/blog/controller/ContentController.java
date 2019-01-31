package com.wanxp.blog.controller;

import com.wanxp.blog.model.dto.*;
import com.wanxp.blog.service.ContentServiceI;
import com.wanxp.blog.model.vo.ContentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
	@GetMapping(value = {"/page"})
	public Page dataGrid(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size
            , @RequestParam(name = "sortDirection") String sortDirection, @RequestParam(name = "sortBy") String sortBy) {
        PageRequest pa;
        if (!StringUtils.isEmpty(sortDirection)) {
            pa = PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortBy);
        }else {
            pa = PageRequest.of(page, size);
        }
		return contentService.queryInPage(pa);
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
//		Page dg = dataGrid(content,pa);
//		downloadFields = downloadFields.replace("&quot;", "\"");
//		downloadFields = downloadFields.substring(1,downloadFields.length()-1);
//		List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
//		downloadTable(colums, dg, response);
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
	@PostMapping("/")
	public Json add(@RequestBody ContentVO contentVO) {
		Json j = new Json();
		ContentDTO contentDTO = new ContentDTO();
        BeanUtils.copyProperties(contentVO, contentDTO);
		contentService.add(contentDTO);
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

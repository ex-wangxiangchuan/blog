package com.wanxp.blog.controller;

import com.wanxp.blog.interceptor.TokenManage;
import com.wanxp.blog.model.dto.ColumDTO;
import com.wanxp.blog.model.dto.SessionInfo;
import com.wanxp.blog.util.Objectx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import com.wanxp.thirdpart.oss.OSSUtil;
//import com.wanxp.util.Constants;
//import com.wanxp.util.ConvertNameUtil;
//import com.wanxp.util.Util;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 基础控制器
 * 
 * 其他控制器继承此控制器获得日期字段类型转换和防止XSS攻击的功能
 * 
 * @author John
 * 
 */
@RestController
@RequestMapping(value = "/base")
public abstract class BaseController extends Objectx {

	protected static final String EX_0001 = "EX0001";
	protected static final String SUCCESS_MESSAGE = "操作成功";
	public static final String DEFAULT_TOKEN = TokenManage.DEFAULT_TOKEN;
	public static final String MAP_ = "map_";
	private String _publishSettingVal = "2"; //生产环境


	@Autowired
	private TokenManage tokenManage;
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

		/**
		 * 防止XSS攻击
		 */
		//binder.registerCustomEditor(String.class, new StringEscapeEditor(true, true));
	}

//	/**
//	 * 用户跳转JSP页面
//	 *
//	 * 此方法不考虑权限控制
//	 *
//	 * @param folder
//	 *            路径
//	 * @param jspName
//	 *            JSP名称(不加后缀)
//	 * @return 指定JSP页面
//	 */
//	@RequestMapping("/{folder}/{jspName}")
//	public String redirectJsp(@PathVariable String folder, @PathVariable String jspName) {
//		return "/" + folder + "/" + jspName;
//	}
//
//	//@ExceptionHandler(Exception.class)
//	//@ResponseBody
//	public Json ExceptionHandler(Exception e) {
//		Json j = new Json();
////		if(_publishSettingVal.equals(ConvertNameUtil.getString(Constants.SYSTEM_PUBLISH_SETTING))){
////			j.setMsg(ConvertNameUtil.getString(Constants.SYSTEM_GLOBAL_MESSAGE));
////		}else{
////			j.setMsg(e.getMessage());
////		}
//		return j;
//	}
//
	/**
	 * 下载表格
	 * @param colums
	 * @param dg
	 * @param response
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	protected void downloadTable(List<ColumDTO> colums, Page dg, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
//		Iterator<Colum> it = colums.iterator();
//		while(it.hasNext()) {
//			Colum c = it.next();
//			if(c.isHidden()||"action".equals(c.getField()))
//				it.remove();
//		}
//		XSSFWorkbook xs=new XSSFWorkbook();
//		XSSFSheet sheet=xs.createSheet("exprot data");
//		XSSFRow row=sheet.createRow((short)0);
//		short i = 0;
//		for(Colum c: colums){
//			row.createCell(i).setCellValue(c.getTitle());
//			i++;
//		}
//		short j = 1;
//		Object invObj = null;
//		String fileName = null;
//		if(CollectionUtils.isNotEmpty(dg.getFooter())) {
//			dg.getRows().addAll(dg.getFooter());
//		}
//		for(Object o : dg.getRows()){
//			row = sheet.createRow(j);
//			Class<?> _class = o.getClass();
//			if(F.empty(fileName))
//			fileName = _class.getName();
//			i = 0;
//			for(Colum c: colums){
//				if(c.getField().startsWith(MAP_)){
//					Method method = _class.getMethod("getExtend");
//					Map<String,Object> map = (Map<String,Object>)method.invoke(o);
//					map = map == null ? new HashMap() : map;
//					invObj = map.get(c.getField().split("_")[1]);
//					if (invObj == null)
//						row.createCell(i).setCellValue("");
//					else
//						row.createCell(i).setCellValue(invObj.toString());
//				}else {
//					Method method = _class.getMethod("get" + F.toUpperCaseFirst(c.getField()));
//					invObj = method.invoke(o);
//					if (invObj == null)
//						row.createCell(i).setCellValue("");
//					else
//						row.createCell(i).setCellValue(invObj.toString());
//				}
//	        	i++;
//			}
//			j++;
//		}
//		String mimetype = "application/x-msdownload";
//		response.setContentType(mimetype);
//		String downFileName = fileName+".xlsx";
//		String inlineType = "attachment"; // 是否内联附件
//		response.setHeader("Content-Disposition", inlineType
//		    + ";filename=\"" + downFileName + "\"");
//		OutputStream out = null;
//		try {
//			out = response.getOutputStream();
//			xs.write(out);
//		} catch (IOException e) {
//		} finally {
//			if (out != null)
//				out.flush();
//			if (out != null)
//				out.close();
//		}
	}

	
	public String uploadFile(HttpServletRequest request, String dirName, MultipartFile file, String fileName){
//		if(file==null||file.isEmpty())
//			return null;
//		String realPath = request.getSession().getServletContext().getRealPath("/"+Constants.UPLOADFILE+"/"+dirName);
//		File f = new File(realPath);
//		if(!f.exists())
//			f.mkdir();
//
//		if(F.empty(fileName)) {
//			fileName = file.getOriginalFilename();
//		} else {
//			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//			fileName = fileName + "_" + Util.CreateNoncestr(4) + System.currentTimeMillis() + suffix;
//		}
//		try {
//			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, fileName));
//			return Constants.UPLOADFILE+"/"+dirName+"/"+fileName;
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//
		return null;
	}

	public String uploadFile(MultipartFile file){
//		if(file==null||file.isEmpty())
//			return null;
//		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//		String fileName = UUID.randomUUID() + suffix;
//		try {
//			return OSSUtil.putInputStream(OSSUtil.bucketName, file.getInputStream(), fileName);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
        return null;
	}

	public String uploadFile(String fileType, MultipartFile file){
//		if(file==null||file.isEmpty())
//			return null;
//		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//		String fileName = getYmdPath(fileType,suffix);
//		try {
//			return OSSUtil.putInputStream(OSSUtil.bucketName, file.getInputStream(), fileName);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
		return null;
	}
	protected String getYmdPath(String fileType,String fileName){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String path = fileType+"/"+calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.getTimeInMillis()+fileName;
		return path;
	}
	
	public String uploadFile(HttpServletRequest request, String dirName, MultipartFile file){
		//return uploadFile(request, dirName, file, dirName); //上传图片到本地保存
		return uploadFile(file); //OSS上传图片
	}

	
	public boolean deleteFile(HttpServletRequest request, String filePath){
		String realPath = request.getSession().getServletContext().getRealPath("/");  
		filePath = realPath + "/" + filePath;
		File f = new File(filePath);
		return f.delete();
	}

	protected SessionInfo getSessionInfo(HttpServletRequest request){
		SessionInfo s = tokenManage.getSessionInfo(request);
		return s;
	}
}
 
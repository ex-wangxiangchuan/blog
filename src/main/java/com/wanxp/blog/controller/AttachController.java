package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.pageModel.*;
import com.wanxp.blog.service.AttachServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Attach管理控制器
 *
 * @author John
 */
@RestController("/attachController")
public class AttachController extends BaseController {

    @Autowired
    private AttachServiceI attachService;


    /**
     * 跳转到Attach管理页面
     *
     * @return
     */
    @RequestMapping("/manager")
    public String manager(HttpServletRequest request) {
        return "/attach/attach";
    }

    /**
     * 获取Attach数据表格
     *
     * @param
     * @return
     */
    @RequestMapping("/dataGrid")
    public DataGrid dataGrid(Attach attach, PageHelper ph) {
        return attachService.dataGrid(attach, ph);
    }

    /**
     * 获取Attach数据表格excel
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
    @RequestMapping("/download")
    public void download(Attach attach, PageHelper ph, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        DataGrid dg = dataGrid(attach, ph);
        downloadFields = downloadFields.replace("&quot;", "\"");
        downloadFields = downloadFields.substring(1, downloadFields.length() - 1);
        List<Colum> colums = JSON.parseArray(downloadFields, Colum.class);
        downloadTable(colums, dg, response);
    }

    /**
     * 跳转到添加Attach页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(HttpServletRequest request) {
        Attach attach = new Attach();
        return "/attach/attachAdd";
    }

    /**
     * 添加Attach
     *
     * @return
     */
    @RequestMapping("/add")
    public Json add(Attach attach) {
        Json j = new Json();
        attachService.add(attach);
        j.setSuccess(true);
        j.setMsg("添加成功！");
        return j;
    }

    /**
     * 跳转到Attach查看页面
     *
     * @return
     */
    @RequestMapping("/view")
    public String view(HttpServletRequest request, Integer id) {
        Attach attach = attachService.get(id);
        request.setAttribute("attach", attach);
        return "/attach/attachView";
    }

    /**
     * 跳转到Attach修改页面
     *
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, Integer id) {
        Attach attach = attachService.get(id);
        request.setAttribute("attach", attach);
        return "/attach/attachEdit";
    }

    /**
     * 修改Attach
     *
     * @param attach
     * @return
     */
    @RequestMapping("/edit")
    public Json edit(Attach attach) {
        Json j = new Json();
        attachService.edit(attach);
        j.setSuccess(true);
        j.setMsg("编辑成功！");
        return j;
    }

    /**
     * 删除Attach
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Json delete(Integer id) {
        Json j = new Json();
        attachService.delete(id);
        j.setMsg("删除成功！");
        j.setSuccess(true);
        return j;
    }

}

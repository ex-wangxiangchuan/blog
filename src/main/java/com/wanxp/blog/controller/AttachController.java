package com.wanxp.blog.controller;

import com.alibaba.fastjson.JSON;
import com.wanxp.blog.dto.*;
import com.wanxp.blog.service.AttachServiceI;
import com.wanxp.blog.vo.AttachVO;
import org.springframework.beans.BeanUtils;
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
 * Attach管理控制器
 *
 * @author John
 */
@RestController
@RequestMapping(value = "/attach")
public class AttachController extends BaseController {

    @Autowired
    private AttachServiceI attachService;


    /**
     * 跳转到Attach管理页面
     *
     * @return
     */
    @GetMapping(value = "/manager")
    public String manager(HttpServletRequest request) {
        return "/attach/attach";
    }

    /**
     * 获取Attach数据表格
     *
     * @param
     * @return
     */
    @GetMapping("/dataGrid")
    public Page dataGrid(AttachDTO attach, Pageable pa) {
        return attachService.queryInPage(attach, pa);
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
    @GetMapping("/download")
    public void download(AttachDTO attach, Pageable pa, String downloadFields, HttpServletResponse response) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException {
        Page dg = dataGrid(attach, pa);
        downloadFields = downloadFields.replace("&quot;", "\"");
        downloadFields = downloadFields.substring(1, downloadFields.length() - 1);
        List<ColumDTO> colums = JSON.parseArray(downloadFields, ColumDTO.class);
        downloadTable(colums, dg, response);
    }

    /**
     * 跳转到添加Attach页面
     *
     * @param request
     * @return
     */
    @GetMapping("/addPage/")
    public String addPage(HttpServletRequest request) {
        AttachDTO attach = new AttachDTO();
        return "/attach/attachAdd";
    }

    /**
     * 添加Attach
     *
     * @return
     */
    @PostMapping("/")
    public Json add(@RequestBody AttachDTO attach) {
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
    @GetMapping("/{id}")
    public AttachVO get(@PathVariable Integer id) {
        AttachDTO attach = attachService.get(id);
        AttachVO attachVO = new AttachVO();
        BeanUtils.copyProperties(attach, attachVO);
        return attachVO;
    }

    /**
     * 跳转到Attach查看页面
     *
     * @return
     */
    @GetMapping("/viewPage/{id}")
    public String view(HttpServletRequest request, @PathVariable Integer id) {
        AttachDTO attach = attachService.get(id);
        request.setAttribute("attach", attach);
        return "/attach/attachView";
    }

    /**
     * 跳转到Attach修改页面
     *
     * @return
     */
    @GetMapping("/editPage/{id}")
    public String editPage(HttpServletRequest request,@PathVariable Integer id) {
        AttachDTO attach = attachService.get(id);
        request.setAttribute("attach", attach);
        return "/attach/attachEdit";
    }

    /**
     * 修改Attach
     *
     * @param attach
     * @return
     */
    @PutMapping("/")
    public Json edit(AttachDTO attach) {
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
    @DeleteMapping("/{id}")
    public Json delete(@PathVariable Integer id) {
        Json j = new Json();
        attachService.delete(id);
        j.setMsg("删除成功！");
        j.setSuccess(true);
        return j;
    }

}

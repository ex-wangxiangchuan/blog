package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.LogRepository;
import com.wanxp.blog.model.Log;
import com.wanxp.blog.model.dto.LogDTO;
import com.wanxp.blog.service.LogServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogServiceI {

	@Autowired
	private LogRepository repostory;

    @Override
    public Page<LogDTO> queryInPage(LogDTO dto, Pageable pa) {
        Page<Log> p = repostory.findAll(pa);
        List<LogDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            LogDTO d = new LogDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<LogDTO>(ds);
    }

    @Override
    public void add(LogDTO dto) {
        Log t = new Log();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public LogDTO get(Integer id) {
        Log t = repostory.getOne(id);
        LogDTO dto = new LogDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(LogDTO dto) {
        Log t = new Log();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }
}

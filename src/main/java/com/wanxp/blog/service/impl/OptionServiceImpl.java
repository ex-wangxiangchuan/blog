package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.OptionRepository;
import com.wanxp.blog.model.Option;
import com.wanxp.blog.dto.OptionDTO;
import com.wanxp.blog.service.OptionServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionServiceI {

    @Autowired
    private OptionRepository repostory;

    @Override
    public Page<OptionDTO> queryInPage(OptionDTO commentDTO, Pageable pa) {
        Page<Option> p = repostory.findAll(pa);
        List<OptionDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            OptionDTO d = new OptionDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<OptionDTO>(ds);
    }

    @Override
    public void add(OptionDTO dto) {
        Option t = new Option();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public OptionDTO get(Integer id) {
        Option t = repostory.getOne(id);
        OptionDTO dto = new OptionDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(OptionDTO dto) {
        Option t = new Option();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }
}

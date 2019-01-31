package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.MetaRepository;
import com.wanxp.blog.model.Meta;
import com.wanxp.blog.model.dto.MetaDTO;
import com.wanxp.blog.service.MetaServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaServiceImpl implements MetaServiceI {

	@Autowired
	private MetaRepository repostory;

    @Override
    public Page<MetaDTO> queryInPage(MetaDTO commentDTO, Pageable pa) {
        Page<Meta> p = repostory.findAll(pa);
        List<MetaDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            MetaDTO  d = new MetaDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<MetaDTO>(ds);
    }

    @Override
    public void add(MetaDTO dto) {
        Meta t = new Meta();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public MetaDTO get(Integer id) {
        Meta t = repostory.getOne(id);
        MetaDTO dto = new MetaDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(MetaDTO dto) {
        Meta t = new Meta();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }

}

package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.ContentRepository;
import com.wanxp.blog.model.Content;
import com.wanxp.blog.dto.ContentDTO;
import com.wanxp.blog.service.ContentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ContentServiceImpl implements ContentServiceI {

	@Autowired
	private ContentRepository repostory;

    @Override
    public Page<ContentDTO> queryInPage(ContentDTO dto, Pageable pa) {
        Page<Content> p = repostory.findAll(pa);
        List<ContentDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            ContentDTO d = new ContentDTO();
            copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<ContentDTO>(ds);
    }

    @Override
    public void add(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public ContentDTO get(Integer id) {
        Content t = repostory.getOne(id);
        ContentDTO dto = new ContentDTO();
        if (t != null)
            copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(ContentDTO dto) {
        Content t = new Content();
        copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }

}

package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.ContentMetaRelationshipRepository;
import com.wanxp.blog.model.ContentMetaRelationship;
import com.wanxp.blog.model.dto.ContentMetaRelationshipDTO;
import com.wanxp.blog.service.ContentMetaRelationshipServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentMetaRelationshipServiceImpl  implements ContentMetaRelationshipServiceI {

	@Autowired
	private ContentMetaRelationshipRepository repostory;
    @Override
    public Page<ContentMetaRelationshipDTO> queryInPage(ContentMetaRelationshipDTO dto, Pageable pa) {
        Page<ContentMetaRelationship> p = repostory.findAll(pa);
        List<ContentMetaRelationshipDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            ContentMetaRelationshipDTO d = new ContentMetaRelationshipDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<ContentMetaRelationshipDTO>(ds);
    }

    @Override
    public void add(ContentMetaRelationshipDTO dto) {
        ContentMetaRelationship t = new ContentMetaRelationship();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public ContentMetaRelationshipDTO get(Integer id) {
        ContentMetaRelationship t = repostory.getOne(id);
        ContentMetaRelationshipDTO dto = new ContentMetaRelationshipDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(ContentMetaRelationshipDTO dto) {
        ContentMetaRelationship t = new ContentMetaRelationship();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }
}

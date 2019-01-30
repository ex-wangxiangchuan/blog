package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.AttachRepostory;
import com.wanxp.blog.model.Attach;
import com.wanxp.blog.dto.AttachDTO;
import com.wanxp.blog.service.AttachServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceI {

	@Autowired
	private AttachRepostory repostory;

	@Override
	public Page<AttachDTO> queryInPage(AttachDTO dto, Pageable ph) {
		Page<Attach> p =repostory.findAll(ph);
        List<AttachDTO> attachDTOS = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            AttachDTO attachDTO = new AttachDTO();
            BeanUtils.copyProperties(x, attachDTO);
            attachDTOS.add(attachDTO);
        });
		return new PageImpl<AttachDTO>(attachDTOS);
	}

	@Override
	public void add(AttachDTO attachDTO) {
		Attach t = new Attach();
		BeanUtils.copyProperties(attachDTO, t);
		repostory.saveAndFlush(t);
	}

	@Override
	public AttachDTO get(Integer id) {
        Attach attach = repostory.getOne(id);
        AttachDTO attachDTO = new AttachDTO();
        if (attach != null)
            BeanUtils.copyProperties(attach, attachDTO);
		return attachDTO;
	}

	@Override
	public void edit(AttachDTO attachDTO) {
	    Attach attach = new Attach();
	    BeanUtils.copyProperties(attachDTO, attach);
		repostory.save(attach);
	}

	@Override
	public void delete(Integer id) {
        repostory.deleteById(id);
	}

}

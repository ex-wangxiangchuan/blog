package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.UserRepository;
import com.wanxp.blog.model.User;
import com.wanxp.blog.model.dto.UserDTO;
import com.wanxp.blog.service.UserServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepository repostory;

    @Override
    public Page<UserDTO> queryInPage(UserDTO commentDTO, Pageable pa) {
        Page<User> p = repostory.findAll(pa);
        List<UserDTO> ds = new ArrayList<>();
        if (p == null || p.getContent() == null)
            return null;
        p.getContent().stream().forEach(x -> {
            UserDTO d = new UserDTO();
            BeanUtils.copyProperties(x, d);
            ds.add(d);
        });
        return new PageImpl<UserDTO>(ds);
    }

    @Override
    public void add(UserDTO dto) {
        User t = new User();
        BeanUtils.copyProperties(dto, t);
        repostory.saveAndFlush(t);
    }

    @Override
    public UserDTO get(Integer id) {
        User t = repostory.getOne(id);
        UserDTO dto = new UserDTO();
        if (t != null)
            BeanUtils.copyProperties(t, dto);
        return dto;
    }

    @Override
    public void edit(UserDTO dto) {
        User t = new User();
        BeanUtils.copyProperties(dto, t);
        repostory.save(t);
    }

    @Override
    public void delete(Integer id) {
        repostory.deleteById(id);
    }
}

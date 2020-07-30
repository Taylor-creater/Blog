package com.blog.service.impl;

import com.blog.dao.LinkDao;
import com.blog.entity.Link;
import com.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("linkService")
public class LinkServiceimpl implements LinkService {
    @Resource
    private LinkDao linkDao;
    @Override
    public int add(Link link) {
        return linkDao.add(link);
    }

    @Override
    public int update(Link link) {
        return linkDao.update(link);
    }

    @Override
    public List<Link> list(Map<String, Object> map) {
        return linkDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return linkDao.getTotal(map);
    }

    @Override
    public Integer delete(Integer id) {
        return linkDao.delete(id);
    }
}

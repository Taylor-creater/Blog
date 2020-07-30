package com.blog.service;

import com.blog.entity.Link;

import java.util.List;
import java.util.Map;

public interface LinkService {
    public  int add(Link link);

    public  int update(Link link);

    public List<Link> list(Map<String, Object> map);

    public  Long getTotal(Map<String, Object> map);

    public  Integer delete(Integer id);
}

package com.blog.service;

import com.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    public  Integer add(Comment comment);

    public  Integer update(Comment comment);

    public List<Comment> list(Map<String, Object> map);

    public  Long getTotal(Map<String, Object> map);

    public  Integer delete(Integer id);
}

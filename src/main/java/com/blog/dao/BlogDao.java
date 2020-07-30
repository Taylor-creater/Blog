package com.blog.dao;

import com.blog.entity.Blog;
import java.util.List;
import java.util.Map;

public abstract interface BlogDao
{
  public  List<Blog> countList();
  
  public  List<Blog> list(Map<String, Object> map);
  
  public  Long getTotal(Map<String, Object> map);
  
  public  Blog findById(Integer id);
  
  public  Integer update(Blog blog);
  
  public  Blog getLastBlog(Integer id);
  
  public  Blog getNextBlog(Integer id);
  
  public  Integer add(Blog Blog);
  
  public  Integer delete(Integer id);
  //根据博客类型id查询博客数量
  public  Integer getBlogCountByTypeId(Integer typeid);
}




package com.blog.dao;

import com.blog.entity.BlogType;
import java.util.List;
import java.util.Map;

public  interface BlogTypeDao
{
  //查询所有博客类型
  public  List<BlogType> countlist();
  //根据id查询博客类型
  public  BlogType findbyid(Integer id);
  //不固定参数查询博客类型列表
  public  List<BlogType> list(Map<String, Object> paramMap);
  //根据不固定参数查询博客类型数量
  public  Long gettotal(Map<String, Object> paramMap);
  
  public  Integer add(BlogType blogType);
  
  public  Integer update(BlogType blogType);
  
  public  Integer delete(Integer id);
}




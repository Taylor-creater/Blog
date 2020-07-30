package com.blog.service;

import com.blog.entity.BlogType;
import java.util.List;
import java.util.Map;

public  interface BlogTypeService
{
  public  List<BlogType> countlist();
  
  public  List<BlogType> list(Map<String, Object> paramMap);
  
  public  Long gettotal(Map<String, Object> paramMap);
  
  public  Integer add(BlogType paramBlogType);
  
  public  Integer update(BlogType paramBlogType);
  
  public  Integer delete(Integer paramInteger);
}



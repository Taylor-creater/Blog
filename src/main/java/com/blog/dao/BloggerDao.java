package com.blog.dao;

import com.blog.entity.Blogger;
import org.apache.ibatis.annotations.Param;

public  interface BloggerDao
{
  public  Blogger find();
  
  public  Blogger getbyusername(@Param("username") String username);
  
  public  Integer update(Blogger paramBlogger);
}




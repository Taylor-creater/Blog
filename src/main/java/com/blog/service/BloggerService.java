package com.blog.service;

import com.blog.entity.Blogger;

public  interface BloggerService
{
  public  Blogger find();
  
  public  Blogger getbyusername( String userName);
  
  public  Integer update(Blogger paramBlogger);
}




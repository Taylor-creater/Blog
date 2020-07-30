 package com.blog.service.impl;

 import com.blog.dao.BlogTypeDao;
 import com.blog.entity.BlogType;
 import com.blog.service.BlogTypeService;
 import java.util.List;
 import java.util.Map;
 import javax.annotation.Resource;
 import org.springframework.stereotype.Service;

 @Service("blogTypeService")
 public class BlogTypeServiceImpl
   implements BlogTypeService
 {
   @Resource
   private BlogTypeDao blogTypeDao;

   public List<BlogType> countlist()
   {
     return this.blogTypeDao.countlist();
   }

   public List<BlogType> list(Map<String, Object> map)
   {
     return this.blogTypeDao.list(map);
   }

   public Long gettotal(Map<String, Object> map)
   {
     return this.blogTypeDao.gettotal(map);
   }

   public Integer add(BlogType blogType)
   {
     return this.blogTypeDao.add(blogType);
   }

   public Integer update(BlogType blogType)
   {
     return this.blogTypeDao.update(blogType);
   }

   public Integer delete(Integer id)
   {
     return this.blogTypeDao.delete(id);
   }
 }




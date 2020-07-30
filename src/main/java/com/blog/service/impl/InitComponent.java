package com.blog.service.impl;

import com.blog.entity.Blog;
import com.blog.entity.BlogType;
import com.blog.entity.Blogger;
import com.blog.entity.Link;
import com.blog.service.BlogService;
import com.blog.service.BlogTypeService;
import com.blog.service.BloggerService;
import com.blog.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void contextInitialized(ServletContextEvent src) {
        ServletContext application=src.getServletContext();
        //放博客类别信息
        BlogTypeService blogTypeService =(BlogTypeService) applicationContext.getBean("blogTypeService");
        List<BlogType> blogTypeCountList = blogTypeService.countlist();
        application.setAttribute("blogTypeCountList",blogTypeCountList);
        //放入博主信息
        BloggerService bloggerService =(BloggerService) applicationContext.getBean("bloggerService");
        Blogger blogger = bloggerService.find();
        application.setAttribute("blogger",blogger);
        //放博客发布时间
        BlogService blogService = (BlogService) applicationContext.getBean("blogService");
        List<Blog> blogs = blogService.countList();
        application.setAttribute("blogCountList", blogs);
        //放友情链接
        LinkService linkService=(LinkService) applicationContext.getBean("linkService");
        List<Link> linkList = linkService.list(null);
        application.setAttribute("linkList", linkList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext=applicationContext;
    }
}

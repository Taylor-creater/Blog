package com.blog.controller.controller;

import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import com.blog.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogController {
   @Resource
   BlogService blogService;
   @Resource
   CommentService commentService;
   @RequestMapping("/articles/{id}")
   public ModelAndView detail(@PathVariable("id") Integer id, HttpServletRequest request){
      ModelAndView mv=new ModelAndView();
      Blog blog = blogService.findById(id);
      mv.addObject("blog", blog);
      //阅读数+1
      blog.setClickhit(blog.getClickhit()+1);
      blogService.update(blog);
      //显示评论
      Map<String,Object> map=new HashMap<>();
      map.put("blogid", id);
      map.put("state", 1);
      List<Comment> commentList = commentService.list(map);
      mv.addObject("commentList",commentList);
      mv.addObject("mainPage", "foreground/blog/view.jsp");
      mv.addObject("pageCode",genUpAndDownPageCode(blogService.getLastBlog(id), blogService.getNextBlog(id),request.getServletContext().getContextPath() ));
      mv.addObject("pageTitle", blog.getTitle()+"_个人博客系统");
      mv.setViewName("mainTemp");
      return mv;
   }

  BlogIndex blogIndex=new BlogIndex();
   private String genUpAndDownPageCode(Blog lastBlog, Blog nextBlog, String projectContext)
   {
      StringBuffer pageCode = new StringBuffer();
      if ((lastBlog == null) || (lastBlog.getId() == null)) {
         pageCode.append("<p>上一篇：没有了</p>");
      } else {
         pageCode.append("<p>上一篇：<a href='" + projectContext + "/blog/articles/" + lastBlog.getId() + ".ac'>" + lastBlog.getTitle() + "</a></p>");
      }
      if ((nextBlog == null) || (nextBlog.getId() == null)) {
         pageCode.append("<p>下一篇：没有了</p>");
      } else {
         pageCode.append("<p>下一篇：<a href='" + projectContext + "/blog/articles/" + nextBlog.getId() + ".ac'>" + nextBlog.getTitle() + "</a></p>");
      }
      return pageCode.toString();
   }

   @RequestMapping("q")
   public ModelAndView q(String q,String page,HttpServletRequest request) throws Exception {
    ModelAndView mv=new ModelAndView();
    if (StringUtil.isEmpty(page)){
       page="1";
    }
    mv.addObject("mainPage", "foreground/blog/result.jsp");
      List<Blog> blogList = blogIndex.searchBlog(q);
      mv.addObject("blogList",blogList);
     mv.addObject("q", q);
     mv.addObject("resultTotal", blogList.size());
     mv.setViewName("mainTemp");
      return mv;
   }

}

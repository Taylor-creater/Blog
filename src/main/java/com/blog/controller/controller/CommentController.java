package com.blog.controller.controller;

import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.service.BlogService;
import com.blog.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    BlogService blogService;
    @RequestMapping("save")
    public String save(Comment comment, String imageCode, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sRand = (String) request.getSession().getAttribute("sRand");
        JSONObject result=new JSONObject();
        if (!sRand.equals(imageCode)){
            result.put("success", false);
            result.put("errorInfo", "验证码填写错误！");
            response.setContentType("application/json,charset=utf-8");
            response.getWriter().write(result.toString());
        }else {
            String userip=request.getRemoteAddr();
            comment.setUserip(userip);
            if (comment.getId()==null){
                commentService.add(comment);
                //给对应的博客增加回复数
                Blog blog = blogService.findById(comment.getBlog().getId());
                blog.setReplyhit(blog.getReplyhit()+1);
                blogService.update(blog);
                result.put("success", true);
                response.setContentType("application/json,charset=utf-8");
                response.getWriter().write(result.toString());
            }
        }
        return null;
    }
}

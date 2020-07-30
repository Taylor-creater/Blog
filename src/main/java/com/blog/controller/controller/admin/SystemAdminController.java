package com.blog.controller.controller.admin;

import com.blog.entity.Blog;
import com.blog.entity.BlogType;
import com.blog.entity.Blogger;
import com.blog.entity.Link;
import com.blog.service.BlogService;
import com.blog.service.BlogTypeService;
import com.blog.service.BloggerService;
import com.blog.service.LinkService;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin/system/")
public class SystemAdminController {
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    BlogService blogService;
    @Resource
    private LinkService linkService;
    @Resource
    private BloggerService bloggerService;
    @RequestMapping("/refreshSystem")

    public String refreshSystem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletContext application= RequestContextUtils.findWebApplicationContext(request).getServletContext();
        //获取最新博客类名
        List<BlogType> blogTypes = blogTypeService.countlist();
        application.setAttribute("blogTypeCountList", blogTypes);
        //获取最新的博客发布时间
        List<Blog> blogs = blogService.countList();
        application.setAttribute("blogCountList", blogs);
        //获取最新的友情链接信息
        List<Link> linkList = linkService.list(null);
        application.setAttribute("linkList", linkList);
         //获取更新的博主信息
        Blogger blogger = bloggerService.find();
        application.setAttribute("blogger", blogger);
        JSONObject result =new JSONObject();
        if (blogTypes.size()>0){
            result.put("success", true);
        }else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
}

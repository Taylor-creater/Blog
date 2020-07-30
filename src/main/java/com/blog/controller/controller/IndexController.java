package com.blog.controller.controller;

import com.blog.entity.Blog;
import com.blog.entity.PageBean;
import com.blog.service.BlogService;
import com.blog.util.PageUtil;
import com.blog.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Resource
    private BlogService blogService;

    @RequestMapping("index.ac")
    @ResponseBody
    public ModelAndView index(String page, String typeid, String releasedatestr,HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (StringUtil.isEmpty(page)) {
            page = "1";
        }
        PageBean pagebean = new PageBean(Integer.parseInt(page), 3);
        Map<String, Object> map = new HashMap<>();
        map.put("start", pagebean.getStart());
        map.put("size", pagebean.getPageSize());
        map.put("typeid", typeid);
        map.put("releasedatestr", releasedatestr);
        List<Blog> blogList = blogService.list(map);
        mv.addObject("blogList", blogList);
        StringBuffer param = new StringBuffer();
        if (StringUtil.isNotEmpty(typeid)) {
            param.append("typeid=" + typeid + "&");
        }
        if (StringUtil.isNotEmpty(releasedatestr)) {
            param.append("releasedatestr=" + releasedatestr + "&");
        }
        mv.addObject("pageCode", PageUtil.genPagination(request.getContextPath() + "/index.ac", blogService.getTotal(map).longValue(), Integer.parseInt(page), 3, param.toString()));
        mv.addObject("mainPage", "foreground/blog/list.jsp");
        mv.addObject("pageTitle", "本站源码下载页面_Java开源博客系统");
        mv.setViewName("mainTemp");
        return mv;
    }
}

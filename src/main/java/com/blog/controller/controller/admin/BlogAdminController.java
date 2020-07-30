package com.blog.controller.controller.admin;

import com.blog.entity.Blog;
import com.blog.entity.PageBean;
import com.blog.lucene.BlogIndex;
import com.blog.service.BlogService;
import com.blog.util.DateJsonValueProcessor;
import com.blog.util.ResponseUtil;
import com.blog.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/blog/")
public class BlogAdminController {
    @Resource
    private BlogService blogService;
    private BlogIndex blogIndex=new BlogIndex();
    @RequestMapping("/save")
    public String sava(Blog blog, HttpServletResponse response) throws Exception {
        Integer resultCount=0;
        if (blog.getId()==null){
            resultCount=blogService.add(blog);
        }else {
            resultCount=blogService.update(blog);
        }
        JSONObject result=new JSONObject();

        if (resultCount>0){
        result.put("success", true);
        }else {
            result.put("false", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("/list")
    public String list( String page,String rows,HttpServletResponse response,String title) throws Exception {
        PageBean pageBean=new PageBean(Integer.valueOf(page), Integer.valueOf(rows));
         JSONObject result=new JSONObject();
        Map<String,Object> map=new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("title", StringUtil.formatLike(title));
        List<Blog> blogList = blogService.list(map);
        Long blogtotal=blogService.getTotal(map);

        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));

        result.put("rows", JSONArray.fromObject(blogList,jsonConfig));
        result.put("total", blogtotal);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("/findbyid")
    @ResponseBody //该注解将返回的值转成json格式 放入response中
    public Blog findbyid( String id ,HttpServletResponse response) throws Exception {
        Blog blog = blogService.findById(Integer.valueOf(id));
        return blog;
    }

    @RequestMapping("delete")
    public String delete(String ids,HttpServletResponse response) throws Exception {
        Integer count=0;
        String [] strids=ids.split(",");
         for (String id: strids){
             blogService.delete(Integer.valueOf(id));
             count++;
         }
         JSONObject result=new JSONObject();

         if (count>0){
             result.put("success", true);
        }else {
             result.put("success", false);
        }
         ResponseUtil.write(response, result);
        return null;
    }
}

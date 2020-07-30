package com.blog.controller.controller.admin;

import com.blog.entity.BlogType;
import com.blog.entity.PageBean;
import com.blog.service.BlogService;
import com.blog.service.BlogTypeService;
import com.blog.service.BloggerService;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/blogType/")
public class BlogTypeAdminController {
    @Resource
    BlogTypeService blogTypeService;
    @Resource
    BlogService blogService;
    @RequestMapping({"/list"})
      public String list( String page,  String rows, HttpServletResponse response)
            throws Exception {
        PageBean pageBean = new PageBean(Integer.valueOf(page), Integer.valueOf(rows));
        Map<String, Object> map = new HashMap();
        map.put("start", Integer.valueOf(pageBean.getStart()));
        map.put("size", Integer.valueOf(pageBean.getPageSize()));
        List<BlogType> blogTypeList = this.blogTypeService.list(map);
        Long total = this.blogTypeService.gettotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping({"/save"})
    public String save(BlogType blogType,HttpServletResponse response) throws Exception {
      int resultCount=0;
      if (blogType.getId()==null){
          resultCount=blogTypeService.add(blogType).intValue();
      }else {
          resultCount=blogTypeService.update(blogType).intValue();
      }
        JSONObject result = new JSONObject();
      if (resultCount>0){
          result.put("success", true);
      }else {
          result.put("success", false);
      }

        ResponseUtil.write(response, result);
     return  null;
    }


    @RequestMapping({"/delete"})
    public String delete(String ids,HttpServletResponse response) throws Exception {
        String[] idsStr = ids.split(",");
        JSONObject result=new JSONObject();
         int a=0;
        for (int i = 0; i <idsStr.length ; i++) {
           Integer count=blogService.getBlogCountByTypeId(Integer.valueOf(idsStr[i]));
            if (count>0){
                a++;
            }else {
                 blogTypeService.delete(Integer.valueOf(idsStr[i]));
            }
        }
        if(a>0){
            result.put("exist", true);
        }else {
            result.put("exist", false);
        }
       result.put("success", true);
        ResponseUtil.write(response, result);
        return  null;
    }



}

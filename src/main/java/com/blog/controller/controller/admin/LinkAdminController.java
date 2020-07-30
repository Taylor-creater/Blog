package com.blog.controller.controller.admin;

import com.blog.entity.BlogType;
import com.blog.entity.Link;
import com.blog.entity.PageBean;
import com.blog.service.LinkService;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {
    @Resource
    private LinkService linkService;
    @RequestMapping({"/list"})
    public String list( String page,  String rows, HttpServletResponse response)
            throws Exception {
        PageBean pageBean = new PageBean(Integer.valueOf(page), Integer.valueOf(rows));
        Map<String, Object> map = new HashMap();
        map.put("start", Integer.valueOf(pageBean.getStart()));
        map.put("size", Integer.valueOf(pageBean.getPageSize()));
        List<Link> linkList = linkService.list(map);
        Long total = linkService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(linkList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping({"/save"})
    public String save(Link link,HttpServletResponse response) throws Exception {
        int resultCount=0;
        if (link.getId()==null){
            resultCount=linkService.add(link);
        }else {
            resultCount=linkService.update(link);
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
        int count=0;
        for (int i = 0; i <idsStr.length ; i++) {
            count=linkService.delete(Integer.valueOf(idsStr[i]));
        }
        if (count>0){
            result.put("success", true);
        }else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return  null;
    }

}

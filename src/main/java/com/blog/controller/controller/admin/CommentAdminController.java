package com.blog.controller.controller.admin;

import com.blog.entity.Comment;
import com.blog.entity.PageBean;
import com.blog.service.CommentService;
import com.blog.util.DateJsonValueProcessor;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/comment/")
public class CommentAdminController {
    @Resource
    private CommentService commentService;

    @RequestMapping("list")
    public String list(String page, String rows, String state, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.valueOf(page), Integer.valueOf(rows));
        Map<String,Object> map=new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("state", state);
        List<Comment> commentList = commentService.list(map);

        Long total = commentService.getTotal(map);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONObject result=new JSONObject();
        result.put("rows", JSONArray.fromObject(commentList,jsonConfig));
        result.put("total",total);
        ResponseUtil.write( response, result);
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(result.toString());
        return null;
    }


    @RequestMapping("delete")
    public String delete(String ids, HttpServletResponse response) throws Exception {
       String [] strid=ids.split(",");
       for(String id:strid){
           commentService.delete(Integer.valueOf(id));
       }
       JSONObject result=new JSONObject();
       result.put("success", true);
       ResponseUtil.write(response, result);
        return null;
    }


    @RequestMapping("examine")
    public String examine(String ids, String state,HttpServletResponse response) throws Exception {
        String [] strid=ids.split(",");
        for(String id:strid){
            Comment comment=new Comment();
            comment.setId(Integer.valueOf(id));
            comment.setState(Integer.valueOf(state));
            commentService.update(comment);
        }
        JSONObject result=new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}

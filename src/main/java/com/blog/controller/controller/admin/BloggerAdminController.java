package com.blog.controller.controller.admin;


import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import com.blog.util.CryptographyUtil;
import com.blog.util.DateUtil;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.security.Security;

@Controller
@RequestMapping("/admin/blogger/")
public class BloggerAdminController {
    @Resource
    private BloggerService bloggerService;

    @RequestMapping("save")
    public String save(MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response) throws Exception {

            if (!imageFile.isEmpty()) {
                String filePath = request.getServletContext().getRealPath("/");
                System.out.println(filePath);
                String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
                imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
                blogger.setImagename(imageName);
            }
            int resultTotal = bloggerService.update(blogger);
            StringBuffer result = new StringBuffer();
            if (resultTotal > 0) {
                result.append("<script language='javascript'>alert('修改成功！');</script>");
            } else {
                result.append("<script language='javascript'>alert('修改失败！');</script>");
            }
            ResponseUtil.write(response, result);
            return null;

    }

    @RequestMapping("find")
    public String find(HttpServletResponse response) throws Exception {
        Blogger blogger = bloggerService.find();
        ResponseUtil.write(response, JSONObject.fromObject(blogger));
        return null;
    }

    @RequestMapping("modifyPassword")
    public String modifyPassword(String id,String newpassword,HttpServletResponse response) throws Exception {
        Blogger blogger=new Blogger();
        blogger.setId(Integer.valueOf(id));
        blogger.setPassword(CryptographyUtil.md5(newpassword, "java123"));
        Integer count = bloggerService.update(blogger);
        JSONObject result=new JSONObject();
        if (count >0){
            result.put("success", true);
        }else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
       return "forward:/login.jsp";
    }
}

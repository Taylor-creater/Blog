import com.blog.dao.BloggerDao;
import com.blog.service.BloggerService;
import com.blog.service.impl.BloggerServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Test01 {
    @Autowired
    BloggerDao bloggerDao;
    @Test
    public void test01(){
        bloggerDao.getbyusername("admin");
        BloggerService service=new BloggerServiceImpl();
        //System.out.println(service.getbyusername("admin"));
    }
}

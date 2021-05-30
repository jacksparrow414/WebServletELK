package elk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author jacksparrow414
 * @date 2021/5/30
 */
public class SimpleServlet extends HttpServlet {
    
    protected static final Logger LOGGER = LogManager.getLogger();
    
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("进入SimpleServlet");
        resp.setContentType("application/json;charset=utf8");
        String json = "{\"name\":\"hello world\"}";
        resp.getWriter().write(json);
//        try {
//            int a = 1/0;
//        }catch (ArithmeticException exception) {
//            LOGGER.error("报错", exception);
//        }
        LOGGER.info("输出响应,响应字符串为{}", json);
        LOGGER.debug("这是debug信息");
        LOGGER.warn("这是warn信息");
    }
}

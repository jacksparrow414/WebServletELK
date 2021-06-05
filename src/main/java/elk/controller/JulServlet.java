package elk.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/logging/overview.html#a1.0">JD8 JUL文档</a>
 */
public class JulServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger("my.jul.logger");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.fine("this is debug log");
        LOGGER.info("this is info log");
        LOGGER.warning("this is warn log");
        LOGGER.severe("this is error log");
        try {
            int a = 1/0;
        }catch (ArithmeticException exception) {
            LOGGER.log(Level.SEVERE, "这是完整打印错误堆栈日志", exception);
        }
        resp.getWriter().write("{\"msg\":\"ok\"}");
    }
}

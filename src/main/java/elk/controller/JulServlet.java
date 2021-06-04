package elk.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JulServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(JulServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogManager.getLogManager().readConfiguration(new FileInputStream("classpath:/logging.properties"));
        LOGGER.fine("this is debug log");
        LOGGER.info("this is info log");
        LOGGER.warning("this is warn log");
        LOGGER.severe("this is error log");
    }
}

package elk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import elk.entity.ArticleEntity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jacksparrow414
 * @date 2021/7/2
 */
public class ArticleServlet extends HttpServlet {
    
    private static  final Logger LOGGER = Logger.getLogger(ArticleServlet.class.getName());
    
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String json;
        // read json
        while ((json = bufferedReader.readLine()) != null) {
            builder.append(json);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleEntity articleEntity = objectMapper.readValue(builder.toString(), ArticleEntity.class);
        LOGGER.info(builder.toString());
        resp.getWriter().write("{\"msg\":\"ok\"}");
    }
}

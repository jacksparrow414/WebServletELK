package elk.config;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.logging.log4j.ThreadContext;

/**
 * <a href="https://logging.apache.org/log4j/2.x/manual/thread-context.html">MDC文档</a>
 * @author jacksparrow414
 * @date 2021/5/30
 */
public class MdcFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        ThreadContext.put("id", UUID.randomUUID().toString());
        ThreadContext.put("clientIp", "216.165.95.2");
        filterChain.doFilter(servletRequest, servletResponse);
        ThreadContext.clearAll();
    }
}

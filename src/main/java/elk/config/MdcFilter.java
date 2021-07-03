package elk.config;

import org.apache.logging.log4j.ThreadContext;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * <a href="https://logging.apache.org/log4j/2.x/manual/thread-context.html">MDC文档</a>
 * @author jacksparrow414
 * @date 2021/5/30
 */
public class MdcFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        ThreadContext.put("userId", UUID.randomUUID().toString());
        ThreadContext.put("clientIp", "216.165.95.2");
        filterChain.doFilter(servletRequest, servletResponse);
        ThreadContext.clearAll();
    }
}

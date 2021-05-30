package elk.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author jacksparrow414
 * @date 2021/5/30
 */
public class SimpleServletTest {
    
    Logger logger = LogManager.getLogger();
    
    @Test
    public void assertLog4j2() {
        logger.info("这是info信息");
    }
}
package elk.controller;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JulServletTest {

    private static final Logger LOGGER = Logger.getLogger(JulServletTest.class.getName());

    private JulServlet julServlet;

    @Before
    public void setUp() {
        julServlet = new JulServlet();
    }

    @Test
    public void assertJul() throws ServletException, IOException {
        Logger.getGlobal().setLevel(Level.FINE);
        julServlet.doGet(null,null);
    }
}
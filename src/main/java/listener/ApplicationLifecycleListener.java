package listener;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Properties;

/**
 * @author Anton Lopatin on 28.05.2021
 */
@WebListener
public class ApplicationLifecycleListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger();
    private final Properties props = new Properties();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            logger.log(Level.ALL, "These all right!");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.log(Level.ERROR, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

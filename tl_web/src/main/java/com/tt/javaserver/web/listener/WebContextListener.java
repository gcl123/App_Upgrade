package com.tt.javaserver.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by feng on 8/7/15.
 */
public class WebContextListener implements ServletContextListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("context initialized...");
        sce.getServletContext().setAttribute("staticPath", "");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.error("context destroyed...");
    }
}

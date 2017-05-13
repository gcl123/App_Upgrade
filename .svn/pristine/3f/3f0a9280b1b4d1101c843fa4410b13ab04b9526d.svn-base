package com.tt.javaserver.web.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class Log4jConfigListener implements ServletContextListener {
    /**
     * 配置文件位置
     */
    public final String CONFIG_LOCATION_PARAM = "log4jConfigLocation";
    /**
     * 日志文件存放位置
     */
    public final String LOG_DIR = "logDir";
    /**
     * root log 记录级别
     */
    public final String ROOT_LOG_LEVEL = "rootLogLevel";

    public final String CONSOLE_LOGGIN_LEVEL = "consoleLogginLevel";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext context = sce.getServletContext();
        initProperty(context);
        String location = context.getInitParameter(CONFIG_LOCATION_PARAM);
        location = getRealPath(context, location);
        initLogging(location);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LogManager.shutdown();
    }

    public String getRealPath(ServletContext servletContext, String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        String realPath = servletContext.getRealPath(path);
        if (realPath == null) {
            throw new RuntimeException(
                    "ServletContext resource [" + path + "] cannot be resolved to absolute file path - " +
                            "web application archive not expanded?");
        }
        return realPath;
    }

    public void initProperty(ServletContext context) {
        String logDir = context.getInitParameter(LOG_DIR);
        String rootLogLevel = context.getInitParameter(ROOT_LOG_LEVEL);
        String consoleLogginLevel = context.getInitParameter(CONSOLE_LOGGIN_LEVEL);
        if (logDir == null || logDir.startsWith("${") || (System.getProperty("os.name").startsWith("Windows") && logDir.startsWith("/")))
            logDir = System.getProperty("user.home") + "/logs/";
        System.setProperty("LOG_DIR", logDir);
        if (rootLogLevel == null || rootLogLevel.startsWith("${")) {
            rootLogLevel = "INFO";
        }
        System.setProperty("ROOT_LOG_LEVEL", rootLogLevel);
        if (consoleLogginLevel == null || consoleLogginLevel.startsWith("${")) {
            consoleLogginLevel = "INFO";
        }
        System.setProperty("CONSOLE_LOGGIN_LEVEL", consoleLogginLevel);
    }

    public void initLogging(String location) {
        if (location.toLowerCase().endsWith(".xml")) {
            DOMConfigurator.configure(location);
        } else {
            PropertyConfigurator.configure(location);
        }
    }
}

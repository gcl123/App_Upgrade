package com.tt.javaserver.web.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;


/**
 * Created by feng on 16/7/15.
 */
public class InitApp implements ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitApp.class);

    private ServletContext servletContext;

    public void init() {
//        try {
//            String confPath = servletContext.getInitParameter("cfgPropertiesPath");
//            confPath = "/tmp/zzserver/web/";
//            ZZConfigManager.initializeConfig(confPath, "com.zz.javaserver" +
//                    ".web.conf");
//            LOGGER.info("init conf path:{}", confPath);
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("init conf failed.", e);
//        }
        try {
//


        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("init service failed.", e);
        }
        LOGGER.info("init app success.");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}

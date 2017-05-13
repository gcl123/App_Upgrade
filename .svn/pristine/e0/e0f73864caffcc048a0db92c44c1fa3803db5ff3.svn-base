package com.tt.javaserver.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by feng on 12/25/15.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger
            (ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object handler, Exception e) {
        try {
            if (null != e) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                handlerMethod.getMethodAnnotation(RequestMapping.class);
                String method = handlerMethod.getMethod().getName();
                LOGGER.error("method[{}] error:  {}", method, e.getMessage());
//                AlarmServiceClient.getInstance().alarm(AlarmLevel.ERROR,
//                        method + ":" + e.getMessage(), AlarmStrategy.ALL);
            }
        } catch (Exception e1) {
            LOGGER.error("", e1);
        }
        return null;
    }
}

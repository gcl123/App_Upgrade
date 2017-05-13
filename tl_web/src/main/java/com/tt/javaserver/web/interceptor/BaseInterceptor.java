package com.tt.javaserver.web.interceptor;

import com.tt.javaserver.web.service.TlRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseInterceptor.class);

    private final static Logger requestLogger = LoggerFactory.getLogger("request");


    @Autowired
    private TaskExecutor taskExecutor;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws
            Exception {
        TlRequestContext.init();
    }


    Pattern incluedeUrl = Pattern.compile("^\\-((index)|(insurance)|(order)|" +
            "(my))\\S*$", Pattern.CASE_INSENSITIVE);

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        try {
//            long current = System.currentTimeMillis();
//            final long costMs = current - TlRequestContext
//                    .getStartTime();
//            final String requestUrl = request.getRequestURL().toString();
//            String m = request.getRequestURI().replaceAll("/", "-");
//            requestLogger.info
//                    ("Request:\t{}\t{}\t{}\t{}\t{}\t{}\tCost" +
//                                    ":{}ms",
//                            new String[]{String.valueOf(current),
//                                    request.getRequestURI()
//                                    , String.valueOf(0)
//                                    , request.getSession().getId()
//                                    , URIs.getIp(request)
//                                    , request.getHeader("User-Agent")
//                                    , String.valueOf(costMs)});


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}

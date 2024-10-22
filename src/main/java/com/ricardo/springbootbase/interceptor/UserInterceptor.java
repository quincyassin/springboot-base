package com.ricardo.springbootbase.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ricardo.springbootbase.threadlocal.User;
import com.ricardo.springbootbase.threadlocal.UserContent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        User user = JSONObject.parseObject(token, User.class);
        UserContent.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContent.remove();
    }
}

package com.online.taix.filter;

import com.online.taix.utils.OnlineThreadLocal;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@WebFilter(urlPatterns = "/*",filterName = "first-filter")
public class BeforeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        final String version = httpServletRequest.getHeader("version");
        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("version",version);
        OnlineThreadLocal.set(hashMap);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

package com.online.taix.filter;

import com.netflix.loadbalancer.LoadBalancerContext;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.online.taix.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerContext;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class TaixFilterFirst extends ZuulFilter {

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        final RequestContext currentContext = RequestContext.getCurrentContext();
        final HttpServletRequest request = currentContext.getRequest();

        /*灰度发布*/
//        final String userId = request.getHeader("userId");
//        if(userId != null && userId.equals("1")){
//            currentContext.set("version","v1");
//            System.out.println(currentContext.get("version"));
//        }else if(userId != null && userId.equals("2")){
//            currentContext.set("version","v2");
//            System.out.println(currentContext.get("version"));
//        };

        /*白名单过滤*/
        final StringBuffer requestURL = request.getRequestURL();
        if( requestURL.toString().endsWith("/admin/get-varify-code") ||
                requestURL.toString().endsWith("/admin/login") ||
                    requestURL.toString().endsWith("/admin/test")){
            return null;
        }

        final String token = request.getHeader("Authorization");

        /*验证token*/
        System.out.println(token);
        if (token != null && tokenUtil.validateToken(token)){
            return null;
        }
        /*token鉴权 待开发*/
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        currentContext.setResponseBody("token confirm failure");
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}

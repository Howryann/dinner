package cs.study.dinner.filter;

import com.alibaba.fastjson.JSON;
import cs.study.dinner.common.R;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //进行路径匹配的
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //没登录是静态资源，放行
        //为什么可以这么设置呢？ 因为前端页面中有可能钩子函数，调用了后端api
        //如果调用了后端就会被拦截
        String[] uris = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"};
        String requestURI = request.getRequestURI();
        for (String uri : uris){
            if(PATH_MATCHER.match(uri, requestURI)){
                filterChain.doFilter(request, response);
                return;
            }
        }
        //登录了就放行
        Object employee = request.getSession().getAttribute("employee");
        if (employee != null){
            filterChain.doFilter(request, response);
            return;
        }
        //没登录拦截
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }
}

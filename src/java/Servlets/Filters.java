package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Filters implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext sc = filterConfig.getServletContext();
        
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        
        sc.log(filterName + " | " + servletPath);
        chain.doFilter(request, response);
        sc.log(filterName + " | " + servletPath);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}

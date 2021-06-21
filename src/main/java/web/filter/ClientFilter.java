package web.filter;

import model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static constant.Constants.USER;

/**
 * @author Anton Lopatin on 21.06.2021
 */
public class ClientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Account account = (Account) request.getSession().getAttribute(USER);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

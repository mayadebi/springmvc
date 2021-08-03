import javax.servlet.*;
import java.io.IOException;

public class GuolvFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
//        System.out.println("过滤器转编码");
        // 不执行这句话就被拦截了
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}

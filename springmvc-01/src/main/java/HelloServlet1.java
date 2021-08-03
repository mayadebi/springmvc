import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        返回html页面
        resp.setContentType("text/html");
//        设置编码
        resp.setCharacterEncoding("utf-8");
        ServletContext servletContext = this.getServletContext();
        PrintWriter writer = resp.getWriter();
//        取出
        writer.print("<h1>"+servletContext.getAttribute("fzy")+"<h1/>");
//        这个就是application   应用程序级别的

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

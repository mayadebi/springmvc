import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从客户的获取cookid
        Cookie[] cookies = req.getCookies();
//        新建一个cookid
        Cookie cookie = new Cookie("name", "付志远");
//        存入
        resp.addCookie(cookie);
        for (Cookie cookie1 : cookies) {
            System.out.println(cookie1.getName());
            System.out.println(cookie1.getValue());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

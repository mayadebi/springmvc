import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1,获取下载文件路径
        String realPath = this.getServletContext().getRealPath("/img/黑芝香苗.png");
        System.out.println("下载文件的路径"+realPath);
//        2.下载文件名是什么
//        获取最后一个/后面的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
//        3,设置方法让浏览器支持下载文件
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
//        4, 获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
//        5,创建缓冲区
        int len = 0;
        byte[] bytes = new byte[1024];
//        6, 获取 outputstream  输入流
        ServletOutputStream out = resp.getOutputStream();
//        7.把FileInputStream写入缓冲区
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
//        8,关闭流
        in.close();
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

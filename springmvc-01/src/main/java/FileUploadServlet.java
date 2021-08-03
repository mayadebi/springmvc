import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class FileUploadServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断上传的文件的带文件的还是普通的
//        这里需要把用的的commons的俩个包加到tomcat里
        try {
            if (!ServletFileUpload.isMultipartContent(req)) {
                System.out.println("不带文件的表单");
                return;
            }
            System.out.println("带文件的表单");
            // 创建上传文件保存路径
            String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
//        判断文件夹不存在就创建
            File uplodaFile = new File(uploadPath);
            if (!uplodaFile.exists()) {
                uplodaFile.mkdir();
            }
            // 先创建一个磁盘的工厂对象，处理上传路径和文件大小
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 可以设置缓冲区大小
            diskFileItemFactory.setSizeThreshold(1024 * 1024);
            // 获取servletUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 监听文件上传进度
            servletFileUpload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long l, long l1, int i) {
                    System.out.println("总大小:" + l1 + "  已上传:" + l);
                }
            });
            // 处理乱码问题
            servletFileUpload.setHeaderEncoding("UTF-8");


            // 封装成fileItem对象
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if(fileItem.isFormField()){ // 判断上传的表单是普通还是文件
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name+";"+value);
                }else{
                    // 判断是文件上传
                    // 拿到文件名字
                    String uploadFileName = fileItem.getName();
                    System.out.println("上传的文件名:"+uploadFileName);

                    if("".equals(uploadFileName.trim())||uploadFileName==null){
                        continue;
                    }
                    // 获取上传的文件名
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf(("/"))+1);
                    // 获取文件后缀名
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(("."))+1);
                    // 使用uuid创建文件夹
                    String uuid = UUID.randomUUID().toString();
                    // 每隔文件创建一个文件夹
                    String realPath = uploadPath+"/"+uuid;
                    File realFile = new File(realPath);
                    if(!realFile.exists()){
                        realFile.mkdir();
                    }
                    // 获取文件上传的流
                    InputStream inputStream = fileItem.getInputStream();
                    // 创建文件输出流
                    FileOutputStream fileOutputStream = new FileOutputStream((realPath + "/" + fileName));
                    // 创建缓冲区
                    byte[] bytes = new byte[1024 * 1024];

                    int len = 0;

                    while ((len = inputStream.read(bytes))>0){
                        fileOutputStream.write(bytes,0,len);
                    }
                    //关闭
                    fileOutputStream.close();
                    inputStream.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
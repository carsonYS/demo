package com.my.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class TestFileUpload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
        //1������һ��DiskFileItemFactory����  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //2������һ���ļ��ϴ�������  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        //����ϴ��ļ�������������  
        upload.setHeaderEncoding("UTF-8");   
        factory.setSizeThreshold(1024 * 500);//�����ڴ���ٽ�ֵΪ500K  
        File linshi = new File("E:\\linshi");//������500K��ʱ�򣬴浽һ����ʱ�ļ�����  
        factory.setRepository(linshi);  
        upload.setSizeMax(1024 * 1024 * 5);//�����ϴ����ļ��ܵĴ�С���ܳ���5M  
        try {  
            // 1. �õ� FileItem �ļ��� items  
            List<FileItem> /* FileItem */items = upload.parseRequest(request);  
  
            // 2. ���� items:  
            for (FileItem item : items) {  
                // ����һ��һ��ı���, ��ӡ��Ϣ  
                if (item.isFormField()) {  
                    String name = item.getFieldName();  
                    String value = item.getString("utf-8");  
  
                    System.out.println(name + ": " + value);  
                }  
                // �����ļ�������ļ����浽 e:\\files Ŀ¼��.  
                else {  
                	System.out.println(item.getContentType());
                    String fileName = item.getName();  
                    String _fileName = item.getName(); 
                    long sizeInBytes = item.getSize();  
                    System.out.println(fileName);  
                    System.out.println(sizeInBytes);  
  
                    InputStream in = item.getInputStream(); 
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
                    fileName = "e:\\files\\" + fileName;//�ļ������ϴ���λ��  
                    _fileName = "e:\\files\\_" + _fileName;
                    System.out.println(fileName);  
                    OutputStream out = new FileOutputStream(fileName);  
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }
                    OutputStream _out = new FileOutputStream(_fileName);
                    // ѹ��ͼƬ
                    // http://blog.csdn.net/simonchi/article/details/55098709
                    in = item.getInputStream(); 
                    File waterPic = new File("e:\\files\\waterPic.png");
                    Thumbnails.of(in).scale(0.5).rotate(90).toOutputStream(_out);
                    
                    
                    while ((len = in.read(buffer)) != -1) {  
                        _out.write(buffer, 0, len);  
                    }  
                    _out.close();  
                    out.close();  
                    in.close();  
                }  
            }  
  
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }  
		
	}

}

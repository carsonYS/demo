package com.my.test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestImageIO extends HttpServlet {

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
		HttpSession session = request.getSession();
		int b = 0;
		try {
			b = (Integer) session.getAttribute("b");
		} catch (Exception e) {
			b = 0;
		}
		
		
		BufferedImage bi = new BufferedImage(255, 255, 1);
		int r = 0;
		int g = 0;
		// int b = Integer.parseInt(_b);
		
		for (int i = 0; i < bi.getWidth(); i++) {
			for (int j = 0; j < bi.getHeight(); j++) {
				r = i;
				g = j;
				int rgb =((r * 256 + g) * 256 + Math.abs(255 - b));
				bi.setRGB(i, j, rgb);
			}
		}
		
		b+=5;
		if (b > 255 * 2) {
			b = 0;
		} 
		// System.out.println(b);
		session.setAttribute("b", b);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
		response.setContentType("image/png");
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "png", out);
	}

}

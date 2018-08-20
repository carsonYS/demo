package com.my.test.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.sun.mail.util.BASE64DecoderStream;

public class TestImageIO {
	
	private static String BASE64_IMAGE = /*data:image/png;base64,*/"iVBORw0KGgoAAAANSUhEUgAAAJAAAACQBAMAAAAVaP+LAAAAGFBMVEUAAABTU1NNTU1TU1NPT09SUlJSUlJTU1O8B7DEAAAAB3RSTlMAoArVKvVgBuEdKgAAAJ1JREFUeF7t1TEOwyAMQNG0Q6/UE+RMXD9d/tC6womIFSL9P+MnAYOXeTIzMzMzMzMzaz8J9Ri6HoITmuHXhISE8nEh9yxDh55aCEUoTGbbQwjqHwIkRAEiIaG0+0AA9VBMaE89Rogeoww936MQrWdBr4GN/z0IAdQ6nQ/FIpRXDwHcA+JIJcQowQAlFUA0MfQpXLlVQfkzR4igS6ENjknm/wiaGhsAAAAASUVORK5CYII=";
	
	public static void main(String[] args) throws IOException {
		byte[] imageByteArray = Base64.getDecoder().decode(BASE64_IMAGE);
		InputStream input = new ByteArrayInputStream(imageByteArray);
		BufferedImage bufferedImage = ImageIO.read(input);
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		BufferedImage bufferedImage2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//		Graphics2D g2D = (Graphics2D) bufferedImage2.getGraphics();
//		bufferedImage2 = g2D.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//		g2D.dispose();
//		g2D = bufferedImage2.createGraphics();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int r = 0;
				int g = 0;
				int b = 0;
				int rgb = bufferedImage.getRGB(i, j);
				if (rgb != 0) {
					r = 255;
					g = 255;
					b = 255;
					
				} else {
					r = 36;
					g = 41;
					b = 46;
//					g2D.setColor(new Color(36, 41, 46));
//					g2D.setStroke(new BasicStroke(1f));
//					g2D.fillRect(i, j, 1, 1);
				}
				rgb = (256 * r + g) * 256 + b;
				bufferedImage2.setRGB(i, j, rgb);
			}
		}
		
		OutputStream output = new FileOutputStream(new File("D:\\data\\image\\test.png"));
		ImageIO.write(bufferedImage2, "png", output);
	}

}

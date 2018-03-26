package com.my.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestImage {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedImage bi = new BufferedImage(255, 255, 1);
		int r = 0;
		int g = 0;
		int b = 255;
		
		for (int i = 0; i < bi.getWidth(); i++) {
			for (int j = 0; j < bi.getHeight(); j++) {
				r = i;
				g = j;
				int rgb =((r * 256 + g) * 256 + b);
				bi.setRGB(i, j, rgb);
			}
		}
		
		ImageIO.write(bi, "png", new File("1.png"));

	}

}

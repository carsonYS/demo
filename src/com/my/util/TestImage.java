package com.my.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

public class TestImage {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String imgBase64 = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAIAAAAlC+aJAAAAuElEQVR42u3YURKAIAhFUfe/adtAw4BPRfTyXQOnSLHWi0cDAAAAAAAAAFgJggEgr/QxxiZAlASAFgIAAMDtgAKz0BEAJdnqKQhAdvO8BHBmXdoqzwOM3Hs2LAB/WZWiAQgAMTI/YgAAxsZpAEtKDx9oAGQD9M0LwLxD/Qml3wJQmsEe1DzXJ6/NUcBBLeQpFIDrXN6iZflLLPMGygPsFrL/BkxeRqPPWwTMuaUXDwAAAAAAAABAZnwvQFe/m37a7QAAAABJRU5ErkJggg==";
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buffer = decoder.decodeBuffer(imgBase64);
		InputStream input = new ByteArrayInputStream(buffer);
		
		BufferedImage bi = ImageIO.read(input);
		int width = bi.getWidth();
		int height = bi.getHeight();
		int[][] rgbArry = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				rgbArry[i][j] = bi.getRGB(i, j);
			}
		}
		int n = 1;
		width = width * n;
		height = height * n;
		BufferedImage bi_ = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int r = 255;
				int g = 255;
				int b = 255;
				if (rgbArry[i][j] == -1) {
					r = 0;
					g = 0;
					b = 0;
				}
				int rgb =((r * 256 + g) * 256 + b);
				bi_.setRGB(i, j, rgb);
			}
		}
		
		ImageIO.write(bi_, "png", new File("1.png"));

	}

}

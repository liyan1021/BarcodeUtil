/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */

package com.winner.utils;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class BarcodeTest {

	public static void main(String[] paramArrayOfString) {
		
		try {
			JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());

			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0 ; i< 10 ; i++){
				String str = BarcodeGenerator.getBarcode();
				list.add(""+str+".png");
				BufferedImage localBufferedImage = localJBarcode.createBarcode(str.substring(0, str.length()-1));
				saveToPNG(localBufferedImage, str + ".png");
			}
			//localJBarcode.setEncoder(Code39Encoder.getInstance());
			//localJBarcode.setPainter(WideRatioCodedPainter.getInstance());
			//localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
			//localJBarcode.setShowCheckDigit(false);
			//xx
			//str = "JBARCODE-39";
			//localBufferedImage = localJBarcode.createBarcode(str);
			//saveToPNG(localBufferedImage, "Code39.png");

		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "jpeg");
	}

	static void saveToPNG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "png");
	}

	static void saveToGIF(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "gif");
	}

	static void saveToFile(BufferedImage paramBufferedImage,
			String paramString1, String paramString2) {
		try {
			FileOutputStream localFileOutputStream = new FileOutputStream("d:/" + paramString1);
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);
			localFileOutputStream.close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	
}
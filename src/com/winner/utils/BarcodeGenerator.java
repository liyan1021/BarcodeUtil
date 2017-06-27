package com.winner.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BarcodeGenerator {
	
	public static final int BARCODE_LENGTH = 12; 
	
	public static synchronized String getBarcode() {
		
		int c1=0,c2=0,cc=0;   
		
		char[] pool={'0','1','2','3','4','5','6','7','8','9'};
		
		Random random=new Random();   
		char[] ean=new char[12];   
		
		for(int i=0; i <ean.length; i++){    
			int index = random.nextInt(10);    
			ean[i] = pool[index];   
		}   
		for(int i=0;i < ean.length; i+=2){    
			int ch1 = ean[i] - '0';    
			c1 +=ch1;    
			int ch2 = ean[i+1] - '0';    
			c2 += ch2;     
		}   
		cc = c1 + 3 * c2;   
		int check = (10 - cc % 10) % 10;   
		ean = Arrays.copyOf(ean, ean.length + 1);   
		ean[ean.length - 1]=(char)(check + '0'); 
		return new String(ean);
	}
	
	public static List<String> getBarcodes(int count) {
		
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			result.add(getBarcode());
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(BarcodeGenerator.getBarcode());
		
	}
}

package com.cc.util;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class ImgUtil {
	 public boolean GenerateImage(String imgStr,String path)  
	    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
	        if (imgStr == null) //ͼ������Ϊ��  
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try   
	        {  
	            //Base64����  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	      /*      for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {//�����쳣����  
	                    b[i]+=256;  
	                }  
	            }  */
	            //����jpegͼƬ  
	          /*  String imgFilePath = "D:\\123456.jpg";//�����ɵ�ͼƬ  
*/	            OutputStream out = new FileOutputStream(path);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        }   
	        catch (Exception e)   
	        {  
	            return false;  
	        }  
	    }  
}

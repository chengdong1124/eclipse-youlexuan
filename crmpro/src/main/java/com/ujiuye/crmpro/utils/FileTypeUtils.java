package com.ujiuye.crmpro.utils;
/*
 * 
 * 通过后缀名判断文件类型
 */
public class FileTypeUtils {
	public static int getType(String fileName) {
		
		String suffixName= fileName.substring(fileName.lastIndexOf(".")+1);
		// 图片 1  
        String[] pics = {"JPEG","PNG","GIF","TIFF","BMP","DWG","PSD","JPG" };  
        //文档 2
        String[] docs = {"RTF","XML","HTML","CSS","JS","EML","DBX","PST","XLS","DOC","XLSX","DOCX","VSD","MDB","WPS","WPD","EPS","PDF","QDF","PWL","ZIP","RAR","JSP","JAVA","CLASS","JAR","MF","EXE","CHM" };  
        //视频  3
        String[] videos = {"AVI","RAM","RM","MPG","MOV","ASF","MP4","FLV"};  
        //种子  4
        String[] tottents = {"TORRENT"};  
        //音频  5
        String[] audios = {"WAV","MP3","MID"};  

        for(String string:audios) {
        	if(string.equalsIgnoreCase(suffixName)) {
        		return 5;
        	}
        }
        for(String string:tottents) {
        	if(string.equalsIgnoreCase(suffixName)) {
        		return 4;
        	}
        }
        for(String string:videos) {
        	if(string.equalsIgnoreCase(suffixName)) {
        		return 3;
        	}
        }
        for(String string:docs) {
        	if(string.equalsIgnoreCase(suffixName)) {
        		return 2;
        	}
        }
        for(String string:pics) {
        	if(string.equalsIgnoreCase(suffixName)) {
        		return 1;
        	}
        }
		return 6;
		
	} 
}

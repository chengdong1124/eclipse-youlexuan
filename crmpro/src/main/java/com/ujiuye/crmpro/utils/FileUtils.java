package com.ujiuye.crmpro.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static List<File> upload(MultipartFile[] myfiles, String path) {
		if(path==null) {
			//默认上传地址
			path = "E:\\upload\\";
		}
		
		List<File> fileList = new ArrayList();
		
		//length属性是针对Java中的数组来说的，要求数组的长度可以用其length属性；
		//length()方法是针对字符串来说的，要求一个字符串的长度就要用到它的length()方法；
		//java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!
		
		if (myfiles.length > 0) {	//属性
			for (MultipartFile myfile : myfiles) {
				if (myfile.getSize() > 0) {
					// 获取上传文件的名字
					String fileName = myfile.getOriginalFilename();
					//获取后缀名
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					//创建一个新名字
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String dateString = format.format(date);
					//生成六位随机数
					String random = String.valueOf(Math.random()).substring(3, 9);
					
					//上传地址
//					String path = "E:\\upload\\";
					//真实路径
					String truepath = path + dateString + random + suffix;
					//创建文件对象
					File file = new File(truepath);
					try {
						//实现上传
						myfile.transferTo(file);
						fileList.add(file);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			// 如果沒有上传文件，在这里处理
			System.out.println("没有上传上件");
		}
		return fileList;
	}
	
	
	public static ResponseEntity<byte[]> download(String filename, String path) {
		if(path==null) {
			//默认下载地址,从哪里下载
			path = "E:\\upload\\";
		}
		try {
			// 文件名乱码问题
			String newName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
			//System.out.println(filename + "\t" + newName);
			// 被下载的文件存放路径
			//String path = "E:\\photo\\";
			String downpath = path + filename;
			File file = new File(downpath);
			// 文件头
			HttpHeaders header = new HttpHeaders();
			// 设置下载文件的文件名字
			header.setContentDispositionFormData("attachment", newName);
			// MIME类型 response.setContentType(text/xml);
			// 设置application/json image/jpeg text/html
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// springmvc 提供的下载文件的工具类
			ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(file), 
					header, HttpStatus.OK);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

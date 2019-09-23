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
			//Ĭ���ϴ���ַ
			path = "E:\\upload\\";
		}
		
		List<File> fileList = new ArrayList();
		
		//length���������Java�е�������˵�ģ�Ҫ������ĳ��ȿ�������length���ԣ�
		//length()����������ַ�����˵�ģ�Ҫ��һ���ַ����ĳ��Ⱦ�Ҫ�õ�����length()������
		//java�е�size()��������Է��ͼ���˵��,����뿴��������ж��ٸ�Ԫ��,�͵��ô˷������鿴!
		
		if (myfiles.length > 0) {	//����
			for (MultipartFile myfile : myfiles) {
				if (myfile.getSize() > 0) {
					// ��ȡ�ϴ��ļ�������
					String fileName = myfile.getOriginalFilename();
					//��ȡ��׺��
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					//����һ��������
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String dateString = format.format(date);
					//������λ�����
					String random = String.valueOf(Math.random()).substring(3, 9);
					
					//�ϴ���ַ
//					String path = "E:\\upload\\";
					//��ʵ·��
					String truepath = path + dateString + random + suffix;
					//�����ļ�����
					File file = new File(truepath);
					try {
						//ʵ���ϴ�
						myfile.transferTo(file);
						fileList.add(file);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			// ����]���ϴ��ļ��������ﴦ��
			System.out.println("û���ϴ��ϼ�");
		}
		return fileList;
	}
	
	
	public static ResponseEntity<byte[]> download(String filename, String path) {
		if(path==null) {
			//Ĭ�����ص�ַ,����������
			path = "E:\\upload\\";
		}
		try {
			// �ļ�����������
			String newName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
			//System.out.println(filename + "\t" + newName);
			// �����ص��ļ����·��
			//String path = "E:\\photo\\";
			String downpath = path + filename;
			File file = new File(downpath);
			// �ļ�ͷ
			HttpHeaders header = new HttpHeaders();
			// ���������ļ����ļ�����
			header.setContentDispositionFormData("attachment", newName);
			// MIME���� response.setContentType(text/xml);
			// ����application/json image/jpeg text/html
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// springmvc �ṩ�������ļ��Ĺ�����
			ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(file), 
					header, HttpStatus.OK);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

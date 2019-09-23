package com.offcn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.offcn.common.Result;
import com.offcn.fastdfs.FastDFSClient;

@RequestMapping("/file")
@RestController
public class FileUploadController {
	
	@Value("http://192.168.59.132/")
	private String FiLE_UPLOAD_URL;
	
	@RequestMapping("/upload")
	public Result fileUpLoad(MultipartFile file) {
		
		try {
			String fileName = file.getOriginalFilename();
			String extName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			System.out.println(fileName+"---"+extName);
			//28818893223026739882&fm=26&gp=0.jpg --- jpg
					
			FastDFSClient client = new FastDFSClient("aa.conf");
			String path = client.uploadFile(file.getBytes(), extName);
			String url = FiLE_UPLOAD_URL+path;
			System.out.println(url);
			return new Result(true,url);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"上传失败");
		}
	
		
		
		
		
		
	}

}











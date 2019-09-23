package com.ujiuye.crmpro.utils.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UEditorController {
	private Logger logger = Logger.getLogger(UEditorController.class);

	/**
	 * ��ʼ���ٶȱ༭�����ɴ��������������ɲ�ͬ�ı༭��,�����
	 * 
	 * @param response
	 * @param request
	 */
	@RequestMapping("/ueditor/init")
	public void initUeditor(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("application/json");

		// ����·�������Ȼ�ȡstatic��Ŀ¼����·��
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		// ��config.json�ŵ���ueditor.config.jsͬһ����Ŀ¼�¡���ueditor�����ļ����뵽wapapp-ueditor��
		// ���û�ȡ����������ļ���ַ����·������·��ͬʱ�������ļ��ϴ�
		PrintWriter writer = null;
		try {
			String exec = new ActionEnter(request, rootPath).exec();
			writer = response.getWriter();
			writer.write(exec);
			writer.flush();
		} catch (IOException e) {
			logger.error("�ٶȱ༭����ʼ������", e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

}
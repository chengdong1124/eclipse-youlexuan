package com.ujiuye.crmpro.filter;

import java.io.IOException;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//localhost:8080/crmpro/login.jsp
		String currentURL = request.getRequestURI();
		//localhost:8080/crmpro/
		String ctxPath = request.getContextPath();
		
		// ������Ŀ����ʱ����ҳ�浱ǰ·��
		String targetURL = currentURL.substring(ctxPath.length());
		HttpSession session = request.getSession(false);
		// �Ե�ǰҳ������жϣ������ǰҳ�治Ϊ��¼ҳ��
		if (!("/login.jsp".equals(targetURL))) {
	
			// �ڲ�Ϊ��½ҳ��ʱ���ٽ����жϣ�������ǵ�½ҳ��Ҳû��session����ת����¼ҳ�棬
			if (session == null || session.getAttribute("LOGIN") == null) {
				response.sendRedirect("/crmpro/login.jsp");
				return;
			} else {
				// �����ʾ��ȷ������
				filterChain.doFilter(request, response);
				return;
			}
		} else {
			// �����ʾ�����ǰҳ���ǵ�½ҳ�棬����
			filterChain.doFilter(request, response);
			return;
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}

package org.o7planning.tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnotationExampleServlet
 */
//Bạn có thể cấu hình một hoặc nhiều 'mẫu của URL' (URL pattern)
//có thể truy cập vào Servlet này.
@WebServlet(
		urlPatterns = { "/AnnotationExampleServlet","/annotationExample", "/annExample" },
		initParams = {
				@WebInitParam(name = "emailSupport1", value = "abc@example.com"),
				@WebInitParam(name = "emailSupport2", value = "tom@example.com") 
				}
		)
public class AnnotationExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String emailSupport1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnotationExampleServlet() {
        // TODO Auto-generated constructor stub
    }
    
    // Phương thức này được gọi trước lần phục vụ đầu tiên của Servlet này.
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
 
        this.emailSupport1 = config.getInitParameter("emailSupport1");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		 
        ServletOutputStream out = response.getOutputStream();
 
        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");
 
        out.println("<body>");
        out.println("<h3>Servlet with Annotation configuration</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

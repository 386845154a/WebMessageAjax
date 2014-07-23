package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��½��Servlet
 * @author Admin
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4003175649047885489L;

	/**
	 * ��½������
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String user = request.getParameter("user");
		if(user !=null && user !=""){		//�ǿ���֤
			request.getSession().setAttribute("user", user);
			response.sendRedirect("talk.jsp?type="+request.getParameter("type"));
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">alert('��¼ʧ��');window.location.href='login.html';</script>");
			out.flush();
			out.close();
		}	
	}

}

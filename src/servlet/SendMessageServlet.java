package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Message;

/**
 * ������Ϣ��Servlet
 * @author Admin
 *
 */
public class SendMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 2668770472840115221L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("msg");
		String reader =request.getParameter("reader");

		Object obj = request.getSession().getAttribute("user");		//��Session�л�ȡ����������
		if(obj == null || str == null || str == ""){	//�ǿ���֤
			out.print("false");
		}else{
			Map<String,ConcurrentLinkedQueue<Message>> msglist =(Map<String,ConcurrentLinkedQueue<Message>>)(request.getServletContext().getAttribute("totalmsglist"));
			
			//�������Ϣ���� ����ӵ�Application��
			Message msg = new Message();
			msg.setMessage(str);
			msg.setSender(obj.toString());
			msg.setSendtime(new Date());
			if(reader==null || reader.equals("")){
				Iterator<String> mlist = msglist.keySet().iterator();
				while(mlist.hasNext()){
					String key = mlist.next();
					if(!key.equals(obj.toString())){
						msglist.get(key).add(msg);
					}
				}
			}else {
				msg.setReader(reader);
				ConcurrentLinkedQueue<Message> mlist = msglist.get("reader");
				if(mlist !=null){
					mlist.add(msg);
				}
			}
			out.print("true");
		}
		out.flush();
		out.close();
	}
}
package gao_client_server_data_exchange.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;


@WebServlet("/login.do")
public class LoginServlet4AndroidClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---get---");
		this.doPost(request, response);
	}

	/**
	 * http://localhost:8080/Client_Server_Data_Exchange/login.do?LoginName=tom&LoginPassword=123
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---post---");
		
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("LoginName");
		String loginPassword = request.getParameter("LoginPassword");
		System.out.println(loginName);
		System.out.println(loginPassword);
		
		response.setCharacterEncoding("UTF-8");
		//text/html
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			//登陆的业务判断
			if (loginName.equals("tom") && loginPassword.equals("123")) {
				printWriter.print("success");
			} else {
				printWriter.print("failed");
			}
		} finally {
			if (null != printWriter) {
				printWriter.close();
			}
		}
		
		
	}

}

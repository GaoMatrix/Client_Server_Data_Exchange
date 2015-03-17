package gao_client_server_data_exchange.servlet;

import gao_client_server_data_exchange.servlet.entity.Student;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@WebServlet("/getStudent.do")
public class GetStudentServlet4AndroidClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(100L, "Tom", 20));
		studentList.add(new Student(101L, "Jack", 21));
		studentList.add(new Student(102L, "Jim", 23));

		JSONArray array = JSONArray.fromObject(studentList);
		System.out.println(array.toString());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html:charset=UTF-8");

		PrintWriter out = null;
		try {
			out = response.getWriter();

			out.print(array.toString());
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}

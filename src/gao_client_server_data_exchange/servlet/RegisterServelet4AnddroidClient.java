package gao_client_server_data_exchange.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/register.do")
public class RegisterServelet4AnddroidClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---get---");
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---post---");
		request.setCharacterEncoding("UTF-8");
		/**
		 * Data={"LoginName":"Tom", "Interesting":["game","music","sports"]}
		 */
		String data = request.getParameter("Data");
		System.out.println(data);

		// json-lib 解析JSON数据的核心代码
		JSONObject object = JSONObject.fromObject(data);
		String loginName = object.getString("LoginName");
		System.out.println("register name: " + loginName);
		JSONArray interesting = object.getJSONArray("Interesting");
		System.out.println("register interesting : ");
		if (null != interesting) {
			for (Object obj : interesting) {
				System.err.println(obj.toString() + "\t");
			}
		}

		// 做你的业务处理
		
		/*响应：封装JSON结果
		 * {
		 * 		"result":"success",
		 * 		"errorMsg":""
		 * }
		 * {
		 * 		"result":"failed",
		 * 		"errorMsg":"服务器处理错误，注册失败"
		 * }
		 */
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			//JSON的数据封装
			/*ResultJSONBean jsonBean = new ResultJSONBean();
			jsonBean.setResult("failed");
			jsonBean.setError("服务器处理错误，注册失败");
			JSONObject obj = JSONObject.fromObject(jsonBean);
			System.out.println(obj.toString());
			printWriter.print(obj.toString());*/
			JSONObject jsonObject = new JSONObject();
			/*jsonObject.put("result", "failed");
			jsonObject.put("errorMsg", "服务器处理错误，注册失败");*/
			jsonObject.put("result", "success");
			jsonObject.put("errorMsg", "");
			System.out.println(jsonObject.toString());
			printWriter.print(jsonObject.toString());
		} finally {
			if (null != printWriter) {
				printWriter.close();
			}
		}
	}

}

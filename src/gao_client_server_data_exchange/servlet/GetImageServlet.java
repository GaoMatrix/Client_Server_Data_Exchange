package gao_client_server_data_exchange.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getImage.jpeg")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-----post-----");
		this.doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----get-----");

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			String id = request.getParameter("id");
			inputStream = new FileInputStream(new File("E://Picture//" + id +  ".png"));
			//设置响应头，设置响应内容的长度 ----客户端需要知道响应内容的长度
			response.setContentLength(inputStream.available());
			//设置响应头，告诉客户端这次响应返回数据的类型
			response.setContentType("image/jpeg");
			outputStream = response.getOutputStream();
			//不是好代码
			/*byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			outputStream.write(buffer);*/
			
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
			if (null != outputStream) {
				outputStream.close();
			}
		}

	}

}

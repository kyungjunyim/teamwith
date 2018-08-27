package com.teamwith.restcontroller;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/memberImage")
@RestController
public class ImageController {
	@Inject
	private ServletContext servletContext;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, String> file(HttpServletRequest req) {
		try {
			System.out.println(req.getInputStream().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * try {
		 * 
		 * String dir = req.getRealPath("/profile"); int max = 5 * 1024 * 1024; // 5MB
		 * MultipartRequest m = new MultipartRequest(req, dir, max); // 클라이언트에서 보낸 사진을
		 * 받는 부분입니다.
		 * 
		 * Connection con = DriverManager.getConnection(url, "xxxx", "xxxx");
		 * 
		 * String files = m.getFilesystemName("fileName"); String phone =
		 * m.getParameter("phone");
		 * 
		 * String sql = "insert into xxxxxx (filename, phone, photo)" + "values(?,?,?)";
		 * PreparedStatement st = con.prepareStatement(sql);
		 * 
		 * if (files != null) { files = URLEncoder.encode(files); } st.setString(1,
		 * files); st.setString(2, phone); st.setString(3, "2");
		 * 
		 * st.executeUpdate(); st.close(); con.close();
		 * 
		 * } catch (
		 * 
		 * Exception e) { out.print(dir); }
		 * 
		 */

		return null;
	}
}

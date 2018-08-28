package com.teamwith.restcontroller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teamwith.vo.MemberSimpleVO;

@RequestMapping("/api/memberImage")
@RestController
public class ImageController {
	@Inject
	private ServletContext servletContext;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String file(HttpSession session, HttpServletRequest req) {
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId;
		if (msVO == null) {
			memberId = "test";
		} else {
			memberId = msVO.getMemberId();
		}

		String name = null;
		String fileName = null;
		String folderTypePath = "c:/data";
		int sizeLimit = 1000 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, folderTypePath, sizeLimit, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Enumeration files = multi.getFileNames();

		// 파일 정보가 있다면
		if (files.hasMoreElements()) {
			name = (String) files.nextElement();
			fileName = multi.getFilesystemName(name);
		}

		File file = multi.getFile(name);
		String newFilename = null;
		System.out.println("★★★★★★★★★★★★★★★★★ 이미지 업로드 완료 파일명은? : " + fileName);

		if (file != null) {
			String rootPath = session.getServletContext().getRealPath("/");
			String attachPath = "resources\\image\\member\\" + memberId;
			String filename = fileName;
			try {
				newFilename = uploadFile(rootPath, attachPath, filename, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(newFilename);
		return "ok";
	}

	private String uploadFile(String uploadPath, String attachPath, String originalName, File fileData)
			throws Exception {
		String newFilename = attachPath + ".png";

		String[] str = attachPath.split("\\\\");
		String memId = str[str.length - 1];
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return "/resources/image/member/" + memId + ".png";
	}

	private String getNewFilename(String filename) {
		if (filename.contains(".")) {
			return filename.substring(filename.indexOf('.'));
		}
		return null;
	}
}

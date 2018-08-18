package com.teamwith.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {
	public static String uploadFile(String uploadPath, String fileName, Part file) throws Exception {
		String contentType = file.getContentType().split("/")[0];
		System.out.println(contentType);
		
		File filePath = new File(uploadPath);
		filePath.mkdirs();
		
		String saveName = uploadPath + "/" + fileName + "." + file.getContentType().split("/")[1];
		file.write(saveName);
		
		if(isImage(contentType)) {
			System.out.println("image");
			makeThumbnail(saveName, file);
		}
		
		return saveName;
	}
	
	private static boolean isImage(String contentType) {
		if(contentType.equals("image")) {
			return true;
		}
		return false;
	}

	private static void makeThumbnail(String saveName, Part file) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(saveName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,150);
		
		File originFile = new File(saveName);
		originFile.delete();
		File newFile = new File(saveName);
		
		ImageIO.write(destImg, file.getContentType().split("/")[1], newFile);
	}
	
}

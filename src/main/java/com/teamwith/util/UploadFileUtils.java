package com.teamwith.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class UploadFileUtils {
	public static String uploadPDF(String filePath,String fileName) throws Exception{
		System.out.println("filePath = "+filePath);
		System.out.println("fileName = "+fileName);
		File file=new File(filePath+fileName);
		FileInputStream fis=new FileInputStream(file);
		XMLSlideShow ppt=new XMLSlideShow(fis);
		fis.close();
		Dimension pgsize=ppt.getPageSize();
		
		XSLFSlide[] slide=ppt.getSlides();
		BufferedImage images=null;
		for(int i=0;i<slide.length;i++) {
			images=new BufferedImage(pgsize.width,pgsize.height,BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic=images.createGraphics();
			
			graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			graphic.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphic.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			
			
			graphic.setPaint(Color.white);
			graphic.fill(new Rectangle2D.Float(0,0,pgsize.width,pgsize.height));
			slide[i].draw(graphic);
			
			File newFile=new File(filePath+"\\tempImage\\");
			if(!newFile.isDirectory()) {
				newFile.mkdirs();
			}
			FileOutputStream out=new FileOutputStream(newFile+"\\tempImage-"+i+".png");
			ImageIO.write(images, "png", out);
		}
		File pptFile=new File(filePath+fileName+".ppt");
		pptFile.delete();
		Document document=new Document();
		File dir=new File(filePath);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		String pdfFileName=fileName+"-PDF.pdf";
		PdfWriter.getInstance(document, new FileOutputStream(dir+"\\"+pdfFileName));
		document.open();
		for(int i=0;i<slide.length;i++) {
			document.newPage();
			String imagePath=filePath+"\\tempImage\\tempImage-"+i+".png";
			Image image=Image.getInstance(imagePath);
			image.setAbsolutePosition(i, i);
			image.scaleAbsoluteHeight(PageSize.A4.getHeight());
			image.scaleAbsoluteWidth(PageSize.A4.getWidth());
			document.add(image);
			
			File deleteFile=new File(imagePath);
			deleteFile.delete();
		}
		document.close();
		return pdfFileName;
	}
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
	public static String uploadFile2(String uploadPath, String fileName, byte[] fileData) throws Exception {
		File dir=new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		System.out.println(uploadPath+fileName);
		File target=new File(uploadPath,fileName);
		FileCopyUtils.copy(fileData, target);
		
		return fileName;
	}
	
	private static boolean isImage(String contentType) {
		if(contentType.equals("image")) {
			return true;
		}
		return false;
	}
	private static String getNewFilename(String filename) {
//	      if (filename.contains(".")) {
//	         String ext = filename.substring(filename.indexOf('.'));
	         return UUID.randomUUID().toString() +filename;

//	      }
//	      return null;
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

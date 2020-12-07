package com.lbx.mall.order;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;
import com.aspose.cells.License;

public class File2PdfUtil {
	
	/**
	* Word或Excel 转Pdf 帮助类
	* @author 
	* 备注:需要引入 aspose-words-15.8.0-jdk16.jar / aspose-cells-8.5.2.jar
	*/
	 private static boolean getLicense() {
	        boolean result = false;
	       try {
	           InputStream is = File2PdfUtil.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
	           License aposeLic = new License();
	          aposeLic.setLicense(is);
	          result = true;
	       } catch (Exception e) {
	         e.printStackTrace();
	      }
	     return result;
	   }

	   /**
	  * @param wordPath 需要被转换的word全路径带文件名
	  * @param pdfPath 转换之后pdf的全路径带文件名
	  */
	  public static void doc2pdf(String wordPath, String pdfPath) {
	     if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
	        return;
	     }
	    try {
	        long old = System.currentTimeMillis();
	        File file = new File(pdfPath); //新建一个pdf文档
	        FileOutputStream os = new FileOutputStream(file);
	        Document doc = new Document(wordPath); //Address是将要被转化的word文档
	        doc.save(os, com.aspose.words.SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
	        long now = System.currentTimeMillis();
	        os.close();
	        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	     }

	   /**
	   * @param excelPath 需要被转换的excel全路径带文件名
	   * @param pdfPath 转换之后pdf的全路径带文件名
	   */
	    public static void excel2pdf(String excelPath, String pdfPath) {
	        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
	        return;
	       }
	      try {
	         long old = System.currentTimeMillis();
	        Workbook wb = new Workbook(excelPath);// 原始excel路径
	        FileOutputStream fileOS = new FileOutputStream(new File(pdfPath));
	        wb.save(fileOS, com.aspose.cells.SaveFormat.PDF);
	        fileOS.close();
	        long now = System.currentTimeMillis();
	           System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
	        } catch (Exception e) {
	          e.printStackTrace();
	       }
	     }
     public static void main(String[] args) {
       //word 和excel 转为pdf
       String wordPdfPath = "D:/mypri/java/word2pdf/ACS5.0核算系统_港股通业务_测试报告.pdf";
       String word2pdf = "D:/mypri/java/word2pdf/ACS5.0核算系统_港股通业务_测试报告.doc" ;
        doc2pdf(word2pdf, wordPdfPath );


        String  excelPdfPath = "D:/mypri/java/word2pdf/20套账债券业务（1026新）.pdf";
        String  excel2pdf = "D:/mypri/java/word2pdf/20套账债券业务（1026新）.xlsx";
        excel2pdf(excel2pdf, excelPdfPath);
    }

}

package com.trungtamjava.helloSpringboot.Controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;

@Controller
public class ExportController {

	@Autowired
	private SpringTemplateEngine springTemplateEngine;
	
	@GetMapping("/test-template")
	String testTemplate()  {
		return "testPdf";
	}
	
	// template => processHTML => Generate PDF
	@GetMapping("/export-pdf")
	public String exportPdf() {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\my laptop\\Desktop\\avatarEmp\\ava.jpg");
	        String base64 = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(input.readAllBytes());
			
			Context context = new Context();
			context.setVariable("test", base64);
			String template = springTemplateEngine.process("testPdf", context);
			PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
			
			DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, true, false);
			
			
			ConverterProperties converterProperties = new ConverterProperties();
			converterProperties.setFontProvider(defaultFontProvider);
			
			HtmlConverter.convertToPdf(template, pdfWriter, converterProperties);
			
			FileOutputStream fileOutputStream = 
					new FileOutputStream("C:\\Users\\my laptop\\Desktop\\avatarEmp\\test.pdf");
			
			byteArrayOutputStream.writeTo(fileOutputStream);
			byteArrayOutputStream.flush();
			fileOutputStream.close();
			input.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/admin/jj";
	}
	
}

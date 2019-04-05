package it.contrader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

public class GenerateWordDocument {

	public static void generateDocx() {
		DocxStamper stamper = new DocxStamper(new DocxStamperConfiguration());
		DocxContext context = new DocxContext();
		context.setName("John");
		InputStream template;
		try {
			template = new FileInputStream(new File("template.docx"));
			OutputStream out;
			out = new FileOutputStream("output_template.docx");
			stamper.stamp(template, context, out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

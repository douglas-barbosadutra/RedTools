package it.contrader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

import it.contrader.dto.AziendaClienteDTO;
import it.contrader.dto.DossierDTO;

public class GenerateWordDocument {

	public static void generateDocx(AziendaClienteDTO aziendaClienteDTO, DossierDTO dossierDTO) {
		DocxStamper stamper = new DocxStamper(new DocxStamperConfiguration());
		InputStream template;
		InputStream tmp2;
		OutputStream tmp1;
		OutputStream out;
		try {
			template = new FileInputStream(new File("Esempio.docx"));
			tmp1 = new FileOutputStream("tmp.docx");
			stamper.stamp(template, aziendaClienteDTO, tmp1);
			tmp1.close();
			tmp2= new FileInputStream(new File("tmp.docx"));
			out = new FileOutputStream("export.docx");
			tmp1.close();
			stamper.stamp(tmp2, dossierDTO, out);
			out.close();
		} catch (IOException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}
}

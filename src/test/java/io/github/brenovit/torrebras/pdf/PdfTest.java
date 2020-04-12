package io.github.brenovit.torrebras.pdf;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfTest {
	
	@Test
	public void test() throws FileNotFoundException {
	PdfWriter writer = new PdfWriter("hello.pdf");
	PdfDocument pdf = new PdfDocument(writer);
	Document document = new Document(pdf);
	document.add(new Paragraph("Hello World!"));
	document.close();
	}
}

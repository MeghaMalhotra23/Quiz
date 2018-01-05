package com.mm.question.view;

import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mm.question.operations.QuestionOperations;
import com.mm.question.operations.Questions;


public class FirstPdf {
    private static String FILE = "c:/temp/FirstPdf.pdf";
    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private Font title= new Font(Font.FontFamily.TIMES_ROMAN,22,Font.BOLD);
   
 
    public FirstPdf() {
    	 try {
    		 Document document= new Document();
             PdfWriter.getInstance(document, new FileOutputStream(FILE));
             document.open();
             addPage(document);
             document.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    private void addPage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        Paragraph title=new Paragraph("     JAVA Certification Quiz", this.title); 
        preface.add(title);
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Report generated by: " + "Megha , " + new Date(),smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Q1 "+getQues(0).getQuestion(),catFont));
        preface.add(new Paragraph("   YOUR ANSWER:  "+getQues(0).getRans(),smallBold));
        preface.add(new Paragraph("   RIGHT ANSWER:  "+getQues(0).getUrans(), smallBold));
        preface.add(new Paragraph("SCORE:  "+getQues(0).getScore(),subFont));
        
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Q2 "+getQues(1).getQuestion(),catFont));
        preface.add(new Paragraph("   YOUR ANSWER:  "+getQues(1).getRans(),smallBold));
        preface.add(new Paragraph("   RIGHT ANSWER:  "+getQues(1).getUrans(), smallBold));
        preface.add(new Paragraph("SCORE:  "+getQues(1).getScore(),subFont));
        
        addEmptyLine(preface, 2);
        preface.add(new Paragraph("Q3 "+getQues(2).getQuestion(),catFont));
        preface.add(new Paragraph("   YOUR ANSWER:  "+getQues(2).getRans(),smallBold));
        preface.add(new Paragraph("   RIGHT ANSWER:  "+getQues(2).getUrans(), smallBold));
        preface.add(new Paragraph("SCORE:  "+getQues(2).getScore(),subFont));

        addEmptyLine(preface, 8);
        document.add(preface);
    }
    
    public  Questions getQues(int i) {
    	return QuestionOperations.getInstance().getQuestion(i);
    }
   
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
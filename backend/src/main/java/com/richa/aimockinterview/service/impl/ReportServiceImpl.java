package com.richa.aimockinterview.service.impl;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.richa.aimockinterview.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public byte[] generateInterviewReport(Long sessionId) {

        try {

            Document document = new Document();

            ByteArrayOutputStream outputStream =
                    new ByteArrayOutputStream();

            PdfWriter.getInstance(document, outputStream);

            document.open();

            Font titleFont =
                    new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

            Font normalFont =
                    new Font(Font.FontFamily.HELVETICA, 12);

            document.add(new Paragraph(
                    "AI Mock Interview Report",
                    titleFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Session ID : " + sessionId,
                    normalFont));

            document.add(new Paragraph(
                    "Candidate : Demo User",
                    normalFont));

            document.add(new Paragraph(
                    "Role : Backend Developer",
                    normalFont));

            document.add(new Paragraph(
                    "Technology : Java + Spring Boot",
                    normalFont));

            document.add(new Paragraph(
                    "Score : 90 / 100",
                    normalFont));

            document.add(new Paragraph(
                    "Status : COMPLETED",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "AI Feedback",
                    titleFont));

            document.add(new Paragraph(
                    "Excellent understanding of Java and Spring Boot. Keep improving communication and system design.",
                    normalFont));

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
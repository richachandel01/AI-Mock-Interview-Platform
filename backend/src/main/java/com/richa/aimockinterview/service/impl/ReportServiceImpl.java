package com.richa.aimockinterview.service.impl;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.richa.aimockinterview.entity.InterviewSession;
import com.richa.aimockinterview.repository.InterviewSessionRepository;
import com.richa.aimockinterview.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final InterviewSessionRepository interviewSessionRepository;

    @Override
    public byte[] generateInterviewReport(Long sessionId) {

        try {

            InterviewSession session =
                    interviewSessionRepository.findById(sessionId)
                            .orElseThrow(() ->
                                    new RuntimeException("Interview Session not found"));

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
                    "Session ID : " + session.getId(),
                    normalFont));

            document.add(new Paragraph(
                    "Candidate : " + session.getUser().getName(),
                    normalFont));

            document.add(new Paragraph(
                    "Role : " + session.getInterview().getRole(),
                    normalFont));

            document.add(new Paragraph(
                    "Technology : " + session.getInterview().getTechnology(),
                    normalFont));

            document.add(new Paragraph(
                    "Score : " + session.getScore() + " / 100",
                    normalFont));

            document.add(new Paragraph(
                    "Status : " + session.getStatus(),
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "AI Feedback",
                    titleFont));

            document.add(new Paragraph(
                    "Feedback will be added after EvaluationResult integration.",
                    normalFont));

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }
}
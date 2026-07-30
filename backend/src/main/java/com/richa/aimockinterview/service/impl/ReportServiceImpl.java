package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public byte[] generateInterviewReport(Long sessionId) {

        return new byte[0];

    }
}
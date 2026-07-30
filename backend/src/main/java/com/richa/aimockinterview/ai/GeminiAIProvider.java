package com.richa.aimockinterview.ai;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

@Primary
@Component
public class GeminiAIProvider implements AIProvider {
    private final Client client = new Client();

    @Override
public AIFeedbackResponseDto generateFeedback(
        AIFeedbackRequestDto request) {

        String prompt = """
You are an expert technical interviewer.

Evaluate the following interview answer.

Question:
%s

Expected Answer:
%s

Candidate Answer:
%s

Return ONLY in this format:

Score: <number out of 100>
Feedback: <2-3 lines>

Do not return markdown.
Do not explain anything else.
"""
.formatted(
                request.getQuestion(),
                request.getExpectedAnswer(),
                request.getUserAnswer());

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.5-flash",
                        prompt,
                        null);

        String output = response.text();

        int score = 70;
        String feedback = output;

        try {

            String[] lines = output.split("\n");

            for (String line : lines) {

                if (line.startsWith("Score:")) {

                    score = Integer.parseInt(
                            line.replace("Score:", "").trim());

                }

                if (line.startsWith("Feedback:")) {

                    feedback = line.replace(
                            "Feedback:",
                            "").trim();

                }
            }

        } catch (Exception ignored) {

        }

        return AIFeedbackResponseDto.builder()
                .score(score)
                .feedback(feedback)
                .build();
    }
}
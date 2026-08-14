import api from "./api";

export const getQuestionsByInterview = async (interviewId) => {
    const response = await api.get(
        `/questions/interview/${interviewId}`
    );

    return response.data;
};

export const getAllQuestions = async () => {
    const response = await api.get("/questions");

    return response.data;
};

export const submitAnswer = async (answerData) => {
    const response = await api.post("/answers", answerData);

    return response.data;
};
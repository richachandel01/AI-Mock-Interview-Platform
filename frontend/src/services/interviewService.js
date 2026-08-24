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
    const response = await api.post(
        "/answers",
        answerData
    );

    return response.data;
};

export const getAnswersBySession = async (sessionId) => {
    const response = await api.get(
        `/answers/session/${sessionId}`
    );

    return response.data;
};

export const getAIFeedback = async (answerId) => {
    const response = await api.get(
        `/ai-feedback/answer/${answerId}`
    );

    return response.data;
};


export const getInterviewSummary = async (sessionId) => {
    const response = await api.get(
        `/answers/session/${sessionId}/summary`
    );

    return response.data;
};


export const getInterviewHistory = async () => {
    const response = await api.get("/sessions/history");

    return response.data;
};
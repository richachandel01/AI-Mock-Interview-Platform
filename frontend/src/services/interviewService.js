import api from "./api";

// Interview APIs
export const createInterview = async (interviewData) => {
    const response = await api.post("/interviews", interviewData);
    return response.data;
};

export const getInterviews = async () => {
    const response = await api.get("/interviews");
    return response.data;
};

// Interview Session APIs
export const startInterviewSession = async (sessionData) => {
    const response = await api.post("/sessions", sessionData);
    return response.data;
};

export const getInterviewSessions = async () => {
    const response = await api.get("/sessions");
    return response.data;
};

export const getInterviewHistory = async () => {
    const response = await api.get("/sessions/history");
    return response.data;
};

// Question APIs
export const getQuestions = async () => {
    const response = await api.get("/questions");
    return response.data;
};

export const createQuestion = async (questionData) => {
    const response = await api.post("/questions", questionData);
    return response.data;
};

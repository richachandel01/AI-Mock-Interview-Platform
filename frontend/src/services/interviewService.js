import api from "./api";

// Create a new interview
const createInterview = async (interviewData) => {
    const response = await api.post("/interviews", interviewData);
    return response.data;
};

// Get all interviews
const getAllInterviews = async () => {
    const response = await api.get("/interviews");
    return response.data;
};

// Start an interview session
const createSession = async (sessionData) => {
    const response = await api.post("/sessions", sessionData);
    return response.data;
};

// Get all interview sessions
const getAllSessions = async () => {
    const response = await api.get("/sessions");
    return response.data;
};

// Get interview history
const getInterviewHistory = async () => {
    const response = await api.get("/sessions/history");
    return response.data;
};

// Get all questions
const getAllQuestions = async () => {
    const response = await api.get("/questions");
    return response.data;
};

const interviewService = {
    createInterview,
    getAllInterviews,
    createSession,
    getAllSessions,
    getInterviewHistory,
    getAllQuestions,
};

export default interviewService;
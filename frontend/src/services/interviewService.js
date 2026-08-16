export const submitAnswer = async (answerData) => {

    const response = await api.post(
        "/answers",
        answerData
    );

    return response.data;
};

export const completeInterviewSession = async (sessionId) => {

    const response = await api.post(
        `/sessions/${sessionId}/complete`
    );

    return response.data;
};
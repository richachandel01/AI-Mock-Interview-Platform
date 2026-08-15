export const submitAnswer = async (answerData) => {

    const response = await api.post(
        "/answers",
        answerData
    );

    return response.data;
};
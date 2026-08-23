import { useEffect, useState } from "react";
import {
    getAnswersBySession,
    getAIFeedback
} from "../../services/interviewService";

function InterviewResults() {

    const [answers, setAnswers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    const sessionId = 1;

    useEffect(() => {

        const loadResults = async () => {

            try {

                setLoading(true);
                setError("");

                const answerData =
                    await getAnswersBySession(sessionId);

                const results = await Promise.all(
                    answerData.map(async (answer) => {

                        try {

                            const aiFeedback =
                                await getAIFeedback(answer.id);

                            return {
                                ...answer,
                                aiScore: aiFeedback.score,
                                aiFeedback: aiFeedback.feedback
                            };

                        } catch (err) {

                            console.error(
                                `Failed to load AI feedback for answer ${answer.id}:`,
                                err
                            );

                            return {
                                ...answer,
                                aiScore: null,
                                aiFeedback:
                                    "AI feedback could not be generated."
                            };
                        }
                    })
                );

                setAnswers(results);

            } catch (err) {

                console.error(
                    "Failed to load interview results:",
                    err
                );

                setError(
                    "Unable to load interview results."
                );

            } finally {

                setLoading(false);

            }
        };

        loadResults();

    }, []);

    const scoredAnswers = answers.filter(
        (answer) =>
            typeof answer.aiScore === "number"
    );

    const overallScore =
        scoredAnswers.length > 0
            ? Math.round(
                scoredAnswers.reduce(
                    (total, answer) =>
                        total + answer.aiScore,
                    0
                ) / scoredAnswers.length
            )
            : 0;

    if (loading) {
        return (
            <div className="min-h-screen bg-slate-100 flex items-center justify-center">
                <div className="text-center">
                    <h2 className="text-xl font-semibold">
                        Analyzing your interview...
                    </h2>

                    <p className="text-gray-500 mt-2">
                        Generating AI feedback for your answers.
                    </p>
                </div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="min-h-screen bg-slate-100 flex items-center justify-center px-6">
                <div className="bg-white rounded-xl shadow p-8 text-center">
                    <h2 className="text-red-600 text-xl font-semibold">
                        {error}
                    </h2>

                    <p className="text-gray-500 mt-2">
                        Please try again later.
                    </p>
                </div>
            </div>
        );
    }

    return (
        <div className="min-h-screen bg-slate-100 px-6 py-8">

            <div className="max-w-4xl mx-auto">

                <div className="mb-8">

                    <h1 className="text-3xl font-bold">
                        Interview Results
                    </h1>

                    <p className="text-gray-500 mt-2">
                        Review your answers and AI-generated feedback.
                    </p>

                </div>

                {answers.length === 0 ? (

                    <div className="bg-white rounded-xl shadow p-8 text-center">

                        <h2 className="text-xl font-semibold">
                            No interview answers found.
                        </h2>

                        <p className="text-gray-500 mt-2">
                            Complete an interview to see your results.
                        </p>

                    </div>

                ) : (

                    <>

                        {/* Overall Score */}

                        <div className="bg-white rounded-xl shadow p-8 mb-8">

                            <p className="text-gray-500 text-sm uppercase tracking-wide">
                                Overall Score
                            </p>

                            <div className="mt-3 flex items-end gap-2">

                                <span className="text-5xl font-bold">
                                    {overallScore}
                                </span>

                                <span className="text-gray-500 text-xl mb-1">
                                    / 100
                                </span>

                            </div>

                            <p className="text-gray-500 mt-3">
                                Based on {scoredAnswers.length} evaluated answer
                                {scoredAnswers.length === 1 ? "" : "s"}.
                            </p>

                        </div>

                        {/* Individual Answers */}

                        <div className="space-y-6">

                            {answers.map((answer, index) => (

                                <div
                                    key={answer.id}
                                    className="bg-white rounded-xl shadow p-6"
                                >

                                    <h2 className="text-lg font-semibold">
                                        Question {index + 1}
                                    </h2>

                                    {answer.questionText && (
                                        <p className="mt-3 text-gray-800">
                                            {answer.questionText}
                                        </p>
                                    )}

                                    <div className="mt-5">

                                        <p className="text-gray-500 text-sm">
                                            Your Answer
                                        </p>

                                        <p className="mt-2 text-gray-800">
                                            {answer.userAnswer}
                                        </p>

                                    </div>

                                    <div className="mt-6 border-t pt-5">

                                        <p className="text-gray-500 text-sm">
                                            AI Score
                                        </p>

                                        {answer.aiScore !== null ? (

                                            <div className="mt-2">

                                                <span className="text-3xl font-bold">
                                                    {answer.aiScore}
                                                </span>

                                                <span className="text-gray-500">
                                                    / 100
                                                </span>

                                            </div>

                                        ) : (

                                            <p className="mt-2 text-gray-500">
                                                Score unavailable
                                            </p>

                                        )}

                                    </div>

                                    <div className="mt-5">

                                        <p className="text-gray-500 text-sm">
                                            AI Feedback
                                        </p>

                                        <p className="mt-2 text-gray-800 leading-relaxed">
                                            {answer.aiFeedback}
                                        </p>

                                    </div>

                                </div>

                            ))}

                        </div>

                    </>

                )}

            </div>

        </div>
    );
}

export default InterviewResults;
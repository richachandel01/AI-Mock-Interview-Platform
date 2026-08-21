import { useEffect, useState } from "react";
import { getAnswersBySession } from "../../services/interviewService";

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

                const data =
                    await getAnswersBySession(sessionId);

                setAnswers(data);

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

    if (loading) {
        return (
            <div className="min-h-screen flex items-center justify-center">
                <h2 className="text-xl font-semibold">
                    Loading results...
                </h2>
            </div>
        );
    }

    if (error) {
        return (
            <div className="min-h-screen flex items-center justify-center">
                <h2 className="text-red-600 text-xl">
                    {error}
                </h2>
            </div>
        );
    }

    return (
        <div className="min-h-screen bg-slate-100 px-6 py-8">

            <div className="max-w-4xl mx-auto">

                <h1 className="text-3xl font-bold mb-8">
                    Interview Results
                </h1>

                {answers.length === 0 ? (
                    <div className="bg-white rounded-xl shadow p-6">
                        <p>No answers found for this interview.</p>
                    </div>
                ) : (
                    <div className="space-y-6">

                        {answers.map((answer, index) => (

                            <div
                                key={answer.id}
                                className="bg-white rounded-xl shadow p-6"
                            >

                                <h2 className="text-lg font-semibold">
                                    Question {index + 1}
                                </h2>

                                <div className="mt-4">

                                    <p className="text-gray-500 text-sm">
                                        Your Answer
                                    </p>

                                    <p className="mt-2 text-gray-800">
                                        {answer.userAnswer}
                                    </p>

                                </div>

                            </div>

                        ))}

                    </div>
                )}

            </div>

        </div>
    );
}

export default InterviewResults;
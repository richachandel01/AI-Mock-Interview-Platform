import { useEffect, useState } from "react";
import { getAnswersBySession } from "../../services/interviewService";

function Results() {

    const [answers, setAnswers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    const sessionId = 1;

    useEffect(() => {

        const loadResults = async () => {

            try {

                setLoading(true);
                setError("");

                const data = await getAnswersBySession(sessionId);

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
        <div className="min-h-screen bg-slate-100">

            <main className="max-w-5xl mx-auto px-6 py-8">

                <h1 className="text-3xl font-bold mb-2">
                    Interview Results
                </h1>

                <p className="text-gray-600 mb-8">
                    Review your submitted answers.
                </p>

                {answers.length === 0 ? (

                    <div className="bg-white rounded-xl shadow p-6">
                        <p>
                            No answers found for this interview.
                        </p>
                    </div>

                ) : (

                    <div className="space-y-6">

                        {answers.map((answer, index) => (

                            <div
                                key={answer.id}
                                className="bg-white rounded-xl shadow p-6"
                            >

                                <div className="flex justify-between mb-4">

                                    <h2 className="text-lg font-semibold">
                                        Question {index + 1}
                                    </h2>

                                    <span className="text-sm text-gray-500">
                                        {answer.submittedAt}
                                    </span>

                                </div>

                                <div className="mb-4">

                                    <h3 className="font-medium text-gray-700">
                                        Your Answer
                                    </h3>

                                    <p className="mt-2 bg-gray-50 rounded-lg p-4">
                                        {answer.userAnswer}
                                    </p>

                                </div>

                                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">

                                    <div className="border rounded-lg p-4">

                                        <h3 className="font-medium">
                                            Score
                                        </h3>

                                        <p className="mt-2 text-gray-500">
                                            Pending AI evaluation
                                        </p>

                                    </div>

                                    <div className="border rounded-lg p-4">

                                        <h3 className="font-medium">
                                            Feedback
                                        </h3>

                                        <p className="mt-2 text-gray-500">
                                            AI feedback will appear here.
                                        </p>

                                    </div>

                                </div>

                            </div>

                        ))}

                    </div>

                )}

            </main>

        </div>
    );
}

export default Results;
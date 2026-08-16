import { useEffect, useState } from "react";

import InterviewHeader from "./InterviewHeader";
import QuestionCard from "./QuestionCard";
import Timer from "./Timer";
import ProgressBar from "./ProgressBar";
import AnswerBox from "./AnswerBox";
import InterviewFooter from "./InterviewFooter";

import {
    getQuestionsByInterview,
    submitAnswer
} from "../../services/interviewService";

function Interview() {

    const [questions, setQuestions] = useState([]);
    const [currentQuestion, setCurrentQuestion] = useState(0);

    const [answer, setAnswer] = useState("");

    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    const [submitting, setSubmitting] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [submitError, setSubmitError] = useState("");

    const [interviewCompleted, setInterviewCompleted] =
        useState(false);

    const interviewId = 1;

    // Temporary session ID.
    // Will be replaced with the real session ID
    // when session creation is implemented.
    const sessionId = 1;

    useEffect(() => {

        const loadQuestions = async () => {

            try {

                setLoading(true);
                setError("");

                const data =
                    await getQuestionsByInterview(interviewId);

                setQuestions(data);

            } catch (err) {

                console.error(
                    "Failed to load questions:",
                    err
                );

                setError(
                    "Unable to load interview questions."
                );

            } finally {

                setLoading(false);

            }
        };

        loadQuestions();

    }, []);

    const handleSubmitAnswer = async () => {

        if (!answer.trim()) {

            setSubmitError(
                "Please enter your answer before submitting."
            );

            return;
        }

        try {

            setSubmitting(true);
            setSubmitError("");

            const data = await submitAnswer({

                userAnswer: answer,

                questionId:
                    questions[currentQuestion].id,

                sessionId: sessionId

            });

            console.log(
                "Answer submitted successfully:",
                data
            );

            setSubmitted(true);

            // If this was the final question,
            // complete the interview.
            if (
                currentQuestion ===
                questions.length - 1
            ) {
                setInterviewCompleted(true);
            }

        } catch (err) {

            console.error(
                "Failed to submit answer:",
                err
            );

            setSubmitError(
                "Unable to submit answer. Please try again."
            );

        } finally {

            setSubmitting(false);

        }
    };

    const handleNextQuestion = () => {

        if (
            submitted &&
            currentQuestion < questions.length - 1
        ) {

            setCurrentQuestion(
                currentQuestion + 1
            );

            setAnswer("");
            setSubmitted(false);
            setSubmitError("");

        }

    };

    if (loading) {

        return (
            <div className="min-h-screen flex items-center justify-center">

                <h2 className="text-xl font-semibold">
                    Loading interview...
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

    if (questions.length === 0) {

        return (
            <div className="min-h-screen flex items-center justify-center">

                <h2 className="text-xl">
                    No interview questions available.
                </h2>

            </div>
        );

    }

    /*
     * Show completion screen after
     * final answer is successfully submitted.
     */
    if (interviewCompleted) {

        return (
            <div className="min-h-screen flex items-center justify-center bg-slate-100">

                <div className="bg-white shadow-lg rounded-xl p-10 text-center">

                    <h1 className="text-3xl font-bold text-green-600">
                        Interview Completed!
                    </h1>

                    <p className="mt-4 text-gray-600">
                        Your answers have been successfully submitted.
                    </p>

                    <p className="mt-2 text-gray-500">
                        Your interview is now ready for evaluation.
                    </p>

                </div>

            </div>
        );
    }

    const question =
        questions[currentQuestion];

    return (

        <div className="min-h-screen bg-slate-100">

            <InterviewHeader />

            <main className="max-w-4xl mx-auto px-6 py-6">

                <ProgressBar
                    currentQuestion={
                        currentQuestion + 1
                    }
                    totalQuestions={
                        questions.length
                    }
                />

                <QuestionCard
                    question={question}
                    questionNumber={
                        currentQuestion + 1
                    }
                />

                <Timer />

                <AnswerBox
                    answer={answer}
                    setAnswer={setAnswer}
                    onSubmit={handleSubmitAnswer}
                    submitting={submitting}
                    submitted={submitted}
                    submitError={submitError}
                />

                <InterviewFooter
                    onNext={handleNextQuestion}
                    disabled={
                        !submitted ||
                        currentQuestion ===
                        questions.length - 1
                    }
                />

            </main>

        </div>
    );
}

export default Interview;
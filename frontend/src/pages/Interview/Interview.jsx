import { useEffect, useState } from "react";

import InterviewHeader from "./InterviewHeader";
import QuestionCard from "./QuestionCard";
import Timer from "./Timer";
import ProgressBar from "./ProgressBar";
import AnswerBox from "./AnswerBox";
import InterviewFooter from "./InterviewFooter";

import { getQuestionsByInterview } from "../../services/interviewService";

const interviewId = 1;

useEffect(() => {
    const loadQuestions = async () => {
        try {
            setLoading(true);

            const data = await getQuestionsByInterview(interviewId);

            setQuestions(data);
        } catch (err) {
            console.error("Failed to load questions:", err);
            setError("Unable to load interview questions.");
        } finally {
            setLoading(false);
        }
    };

    loadQuestions();
}, []);
    const handleNextQuestion = () => {

        if (currentQuestion < questions.length - 1) {

            setCurrentQuestion(currentQuestion + 1);

            setAnswer("");

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

    const question = questions[currentQuestion];

    return (
        <div className="min-h-screen bg-slate-100">

            <InterviewHeader />

            <main className="max-w-4xl mx-auto px-6 py-6">

                <ProgressBar />

                <QuestionCard
                    question={question}
                    questionNumber={currentQuestion + 1}
                />

                <Timer />

                <AnswerBox
                    answer={answer}
                    setAnswer={setAnswer}
                />
                <ProgressBar
    currentQuestion={currentQuestion + 1}
    totalQuestions={questions.length}
/>
                <InterviewFooter
                    onNext={handleNextQuestion}
                    disabled={currentQuestion === questions.length - 1}
                />

            </main>

        </div>
    );
}

export default Interview;

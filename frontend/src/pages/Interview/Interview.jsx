import InterviewHeader from "./InterviewHeader";
import QuestionCard from "./QuestionCard";
import AnswerBox from "./AnswerBox";
import ProgressBar from "./ProgressBar";
import Timer from "./Timer";
import InterviewFooter from "./InterviewFooter";

function Interview() {
    return (
        <div className="min-h-screen bg-gray-100">

            <InterviewHeader />

            <div className="max-w-5xl mx-auto py-8 px-6">

                <ProgressBar />

                <QuestionCard />

                <AnswerBox />

                <InterviewFooter />

            </div>

            <Timer />

        </div>
    );
}

export default Interview;
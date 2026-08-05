import InterviewHeader from "./InterviewHeader";
import QuestionCard from "./QuestionCard";
import Timer from "./Timer";
import ProgressBar from "./ProgressBar";
import AnswerBox from "./AnswerBox";
import InterviewFooter from "./InterviewFooter";

function Interview() {
  return (
    <div className="min-h-screen bg-slate-100">

      <InterviewHeader />

      <ProgressBar />

      <QuestionCard />

      <Timer />

      <AnswerBox />

      <InterviewFooter />

    </div>
  );
}

export default Interview;
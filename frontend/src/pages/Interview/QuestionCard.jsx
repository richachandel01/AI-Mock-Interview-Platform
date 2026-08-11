function QuestionCard({ question, questionNumber }) {
    return (
        <div className="bg-white rounded-xl shadow p-6 mt-6">

            <h2 className="text-xl font-bold mb-4">
                Question {questionNumber}
            </h2>

            <p className="text-gray-700 text-lg">
                {question?.questionText || "Loading question..."}
            </p>

        </div>
    );
}

export default QuestionCard;

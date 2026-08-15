function AnswerBox({
    answer,
    setAnswer,
    onSubmit,
    submitting,
    submitted,
    submitError
}) {

    return (
        <div className="mt-6">

            <textarea
                rows="8"
                className="w-full border rounded-lg p-4"
                placeholder="Write your answer..."
                value={answer}
                onChange={(e) =>
                    setAnswer(e.target.value)
                }
                disabled={
                    submitting || submitted
                }
            />

            {submitError && (
                <p className="mt-2 text-red-600">
                    {submitError}
                </p>
            )}

            <button
                onClick={onSubmit}
                disabled={
                    submitting ||
                    submitted ||
                    !answer.trim()
                }
                className="mt-4 bg-green-600 text-white px-6 py-3 rounded-lg hover:bg-green-700 transition disabled:bg-gray-400"
            >
                {submitting
                    ? "Submitting..."
                    : submitted
                    ? "Answer Submitted"
                    : "Submit Answer"}
            </button>

        </div>
    );
}

export default AnswerBox;
function ProgressBar({
    currentQuestion,
    totalQuestions
}) {

    const percentage =
        totalQuestions > 0
            ? Math.round(
                (currentQuestion /
                    totalQuestions) *
                    100
            )
            : 0;

    return (

        <div className="mt-6">

            <div className="flex justify-between mb-2">

                <span>
                    Question {currentQuestion} /{" "}
                    {totalQuestions}
                </span>

                <span>
                    {percentage}%
                </span>

            </div>

            <div className="w-full bg-gray-300 rounded-full h-3">

                <div
                    className="bg-blue-600 h-3 rounded-full"
                    style={{
                        width: `${percentage}%`
                    }}
                />

            </div>

        </div>
    );
}

export default ProgressBar;
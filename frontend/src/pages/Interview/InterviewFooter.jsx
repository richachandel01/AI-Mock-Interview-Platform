function InterviewFooter({
    onNext,
    disabled
}) {

    return (
        <div className="flex justify-end mt-6">

            <button
                onClick={onNext}
                disabled={disabled}
                className="bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition disabled:bg-gray-400"
            >
                {disabled
                    ? "Interview Complete"
                    : "Next Question"}
            </button>

        </div>
    );
}

export default InterviewFooter;
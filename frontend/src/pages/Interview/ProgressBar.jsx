function ProgressBar() {

    return (

        <div className="mt-6">

            <div className="flex justify-between mb-2">

                <span>Question 1 / 10</span>

                <span>10%</span>

            </div>

            <div className="w-full bg-gray-300 rounded-full h-3">

                <div
                    className="bg-blue-600 h-3 rounded-full"
                    style={{ width: "10%" }}
                />

            </div>

        </div>

    );

}

export default ProgressBar;
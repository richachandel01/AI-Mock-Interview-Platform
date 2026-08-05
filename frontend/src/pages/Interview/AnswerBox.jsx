import { useState } from "react";

function AnswerBox() {

    const [answer, setAnswer] = useState("");

    return (

        <div className="mt-6">

            <textarea
                rows="8"
                className="w-full border rounded-lg p-4"
                placeholder="Write your answer..."
                value={answer}
                onChange={(e)=>setAnswer(e.target.value)}
            />

        </div>

    );
}

export default AnswerBox;
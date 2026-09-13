import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getInterviewHistory } from "../../services/interviewService";

function History() {
    const navigate = useNavigate();

    const [history, setHistory] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    useEffect(() => {
        const loadHistory = async () => {
            try {
                setLoading(true);
                setError("");

                const data = await getInterviewHistory();
                setHistory(data);
            } catch (err) {
                console.error("Failed to load interview history:", err);
                setError("Unable to load interview history.");
            } finally {
                setLoading(false);
            }
        };

        loadHistory();
    }, []);

    const formatDate = (dateString) => {
        if (!dateString) return "N/A";

        return new Date(dateString).toLocaleString();
    };

    if (loading) {
        return (
            <div className="container mt-4">
                <h2>Interview History</h2>
                <p>Loading interview history...</p>
            </div>
        );
    }

    if (error) {
        return (
            <div className="container mt-4">
                <h2>Interview History</h2>

                <div className="alert alert-danger">
                    {error}
                </div>
            </div>
        );
    }

    return (
        <div className="container mt-4 mb-5">

            <div className="d-flex justify-content-between align-items-center mb-4">
                <div>
                    <h2 className="mb-1">Interview History</h2>

                    <p className="text-muted mb-0">
                        Review your previous mock interview sessions.
                    </p>
                </div>

                <span className="badge bg-primary">
                    {history.length} Session
                    {history.length !== 1 ? "s" : ""}
                </span>
            </div>

            {history.length === 0 ? (

                <div className="card shadow-sm">
                    <div className="card-body text-center py-5">

                        <h5>No Interview History</h5>

                        <p className="text-muted mb-0">
                            You have not completed any interview sessions yet.
                        </p>

                    </div>
                </div>

            ) : (

                <div className="row g-4">

                    {history.map((session) => (

                        <div
                            className="col-12 col-md-6 col-lg-4"
                            key={session.sessionId}
                        >

                            <div className="card h-100 shadow-sm">

                                <div className="card-body">

                                    <div className="d-flex justify-content-between align-items-start mb-3">

                                        <div>

                                            <h5 className="card-title mb-1">
                                                {session.role || "Interview"}
                                            </h5>

                                            <small className="text-muted">
                                                Session #{session.sessionId}
                                            </small>

                                        </div>

                                        <span
                                            className={`badge ${
                                                session.status === "COMPLETED"
                                                    ? "bg-success"
                                                    : "bg-secondary"
                                            }`}
                                        >
                                            {session.status}
                                        </span>

                                    </div>

                                    <hr />

                                    <div className="row text-center">

                                        <div className="col-6">

                                            <h4 className="mb-1">
                                                {session.totalQuestions ?? 0}
                                            </h4>

                                            <small className="text-muted">
                                                Questions
                                            </small>

                                        </div>

                                        <div className="col-6">

                                            <h4 className="mb-1">
                                                {session.score ?? 0}
                                            </h4>

                                            <small className="text-muted">
                                                Score
                                            </small>

                                        </div>

                                    </div>

                                    <hr />

                                    <small className="text-muted">
                                        Started: {formatDate(session.createdAt)}
                                    </small>

                                    {session.status === "COMPLETED" && (
                                        <button
                                            type="button"
                                            className="btn btn-primary w-100 mt-3"
                                            onClick={() =>
                                                navigate(
                                                    `/results/${session.sessionId}`
                                                )
                                            }
                                        >
                                            View Results
                                        </button>
                                    )}

                                </div>

                            </div>

                        </div>

                    ))}

                </div>

            )}

        </div>
    );
}

export default History;
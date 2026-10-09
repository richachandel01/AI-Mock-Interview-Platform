import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

function Login() {
    const navigate = useNavigate();
    const { login } = useAuth();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();
        setError("");
        setLoading(true);

        try {
            await login({ email, password });
            navigate("/dashboard");
        } catch (err) {
            setError(
                err.response?.data?.message ||
                "Login failed. Please check your credentials and try again."
            );
        } finally {
            setLoading(false);
        }
    };

    return (
        <main style={{
            maxWidth: "420px",
            margin: "70px auto",
            padding: "32px",
            border: "1px solid #ddd",
            borderRadius: "12px",
            fontFamily: "Arial, sans-serif"
        }}>
            <h1 style={{ textAlign: "center" }}>Welcome Back</h1>
            <p style={{ textAlign: "center", color: "#666" }}>
                Login to your AI Mock Interview account
            </p>

            <form onSubmit={handleLogin}>
                <label htmlFor="email">Email</label>
                <input
                    id="email"
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    placeholder="Enter your email"
                    autoComplete="email"
                    required
                    style={{
                        display: "block",
                        width: "100%",
                        boxSizing: "border-box",
                        padding: "12px",
                        margin: "8px 0 18px",
                        border: "1px solid #ccc",
                        borderRadius: "6px"
                    }}
                />

                <label htmlFor="password">Password</label>
                <input
                    id="password"
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    placeholder="Enter your password"
                    autoComplete="current-password"
                    required
                    style={{
                        display: "block",
                        width: "100%",
                        boxSizing: "border-box",
                        padding: "12px",
                        margin: "8px 0 18px",
                        border: "1px solid #ccc",
                        borderRadius: "6px"
                    }}
                />

                {error && (
                    <p role="alert" style={{ color: "red" }}>
                        {error}
                    </p>
                )}

                <button
                    type="submit"
                    disabled={loading}
                    style={{
                        width: "100%",
                        padding: "12px",
                        background: "#2563eb",
                        color: "white",
                        border: "none",
                        borderRadius: "6px",
                        cursor: loading ? "wait" : "pointer"
                    }}
                >
                    {loading ? "Logging in..." : "Login"}
                </button>
            </form>

            <p style={{ textAlign: "center", marginTop: "22px" }}>
                Don't have an account? <Link to="/signup">Sign up</Link>
            </p>
        </main>
    );
}

export default Login;

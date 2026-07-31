import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";

function Signup() {

    const navigate = useNavigate();

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSignup = async (e) => {

        e.preventDefault();

        try {

            await api.post("/auth/register", {
                name,
                email,
                password
            });

            alert("Registration Successful!");

            navigate("/login");

        } catch (error) {

            console.error(error);

            alert(
                error.response?.data?.message ||
                "Registration Failed"
            );
        }
    };

    return (
        <div style={{ padding: "40px" }}>

            <h2>Signup</h2>

            <form onSubmit={handleSignup}>

                <input
                    type="text"
                    placeholder="Full Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />

                <br /><br />

                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <br /><br />

                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <br /><br />

                <button type="submit">
                    Register
                </button>

            </form>

        </div>
    );
}

export default Signup;
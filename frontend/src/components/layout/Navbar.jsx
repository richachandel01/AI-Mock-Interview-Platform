import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

function Navbar() {

    const { authenticated, logout } = useAuth();

    const navigate = useNavigate();

    const handleLogout = () => {

        logout();

        navigate("/login");
    };

    return (

        <nav className="bg-slate-900 text-white px-8 py-4 flex justify-between">

            <h1 className="text-2xl font-bold">
                AI Mock Interview
            </h1>

            <div className="flex gap-6">

                <Link to="/">Home</Link>

                {

                    authenticated ? (

                        <>

                            <Link to="/dashboard">
                                Dashboard
                            </Link>

                            <button onClick={handleLogout}>
                                Logout
                            </button>

                        </>

                    ) : (

                        <>

                            <Link to="/login">
                                Login
                            </Link>

                            <Link to="/signup">
                                Signup
                            </Link>

                        </>

                    )

                }

            </div>

        </nav>

    );
}

export default Navbar;
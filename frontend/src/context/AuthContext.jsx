import { createContext, useContext, useEffect, useState } from "react";
import AuthService from "../services/AuthService";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {

    const [authenticated, setAuthenticated] = useState(false);

    useEffect(() => {
        setAuthenticated(AuthService.isAuthenticated());
    }, []);

    const login = async (credentials) => {
        await AuthService.login(credentials);
        setAuthenticated(true);
    };

    const logout = () => {
        AuthService.logout();
        setAuthenticated(false);
    };

    return (
        <AuthContext.Provider
            value={{
                authenticated,
                login,
                logout
            }}
        >
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
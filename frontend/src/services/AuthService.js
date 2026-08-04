import api from "./api";

const AuthService = {

    async login(credentials) {

        const response = await api.post("/auth/login", credentials);

        localStorage.setItem("token", response.data.token);

        return response.data;
    },

    async register(userData) {

        const response = await api.post("/auth/register", userData);

        return response.data;
    },

    logout() {

        localStorage.removeItem("token");
    },

    isAuthenticated() {

        return !!localStorage.getItem("token");
    }

};

export default AuthService;
import axios from "axios";

const API_BASE_URL = import.meta.env.PROD
    ? "https://ai-mock-interview-backend-jzdw.onrender.com/api"
    : (import.meta.env.VITE_API_BASE_URL || "http://localhost:8080/api");

const api = axios.create({
    baseURL: API_BASE_URL,
});

api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token");
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error)
);

export default api;

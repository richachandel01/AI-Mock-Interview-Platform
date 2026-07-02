# 🎯 AI Mock Interview Platform

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green)
![React](https://img.shields.io/badge/React-19-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Google Gemini](https://img.shields.io/badge/AI-Google_Gemini-purple)
![JWT](https://img.shields.io/badge/Security-JWT-success)
![License](https://img.shields.io/badge/License-MIT-brightgreen)

---

# 📖 About

AI Mock Interview Platform is a production-ready full-stack web application that helps students and job seekers prepare for technical and HR interviews using Google Gemini AI.

The platform allows users to:

- Practice mock interviews
- Receive AI-generated interview feedback
- Track interview history
- Analyze performance
- Securely authenticate using JWT
- Manage interview sessions

---

# ✨ Features

- 🤖 Google Gemini AI Integration
- 🔐 JWT Authentication
- 👤 Role-Based Authorization
- 💬 AI Interview Feedback
- 📋 Interview Management
- 🎯 Interview Session Tracking
- 📊 Performance Analytics
- 🗄 PostgreSQL Database
- ⚡ RESTful APIs
- 🏗 Layered Spring Boot Architecture

---

# 🛠 Tech Stack

## Frontend

- React.js
- Vite
- Tailwind CSS
- Axios
- React Router DOM

## Backend

- Java 21
- Spring Boot 3.5
- Spring Security
- Spring Data JPA
- Maven

## Database

- PostgreSQL

## AI

- Google Gemini API
- Google GenAI SDK

## Authentication

- JWT

---

# 📂 Project Structure

```text
AI-Mock-Interview-Platform
│
├── frontend
│
├── backend
│
├── database
│
├── docs
│
└── README.md
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/richachandel01/AI-Mock-Interview-Platform.git
```

---

## Backend Setup

```bash
cd backend
```

Install dependencies

```bash
./mvnw clean install
```

Run backend

```bash
./mvnw spring-boot:run
```

Backend will run on

```
http://localhost:8080
```

---

## Frontend Setup

```bash
cd frontend
```

Install packages

```bash
npm install
```

Run frontend

```bash
npm run dev
```

Frontend will run on

```
http://localhost:5173
```

---

# ⚙ Environment Variables

Backend

```
GEMINI_API_KEY=your_api_key

JWT_SECRET=your_secret_key

SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/aimockinterview

SPRING_DATASOURCE_USERNAME=postgres

SPRING_DATASOURCE_PASSWORD=password
```

---

# 📡 API Documentation

## Authentication

### Login

```
POST /api/auth/login
```

---

## Users

### Create User

```
POST /api/users
```

### Get Users

```
GET /api/users
```

---

## Interview

### Create Interview

```
POST /api/interviews
```

### Get Interviews

```
GET /api/interviews
```

---

## Interview Session

### Start Session

```
POST /api/sessions
```

### Get Sessions

```
GET /api/sessions
```

---

## AI Feedback

### Generate Feedback

```
POST /api/ai-feedback
```

Example Request

```json
{
    "question":"What is Spring Boot?",
    "expectedAnswer":"Spring Boot is a Java framework.",
    "userAnswer":"Spring Boot simplifies Java application development by reducing configuration and providing embedded servers."
}
```

Example Response

```json
{
    "score":98,
    "feedback":"The candidate provides an excellent explanation with practical understanding."
}
```

---

# 🏗 Architecture

```
React Frontend
       │
       ▼
Spring Boot REST APIs
       │
       ▼
Spring Security + JWT
       │
       ▼
PostgreSQL
       │
       ▼
Google Gemini AI
```

---

# 📸 Screenshots

Coming Soon

- Landing Page
- Dashboard
- Interview Session
- AI Feedback

---

# 🗺 Roadmap

- Voice-based Interview
- Resume Analyzer
- Coding Interview Module
- AI Follow-up Questions
- Admin Dashboard
- Leaderboard
- Docker Deployment

---

# 📚 Development Log

Complete development history from **Day 1 to Day 17** is available in

```
docs/development-log.md
```

---

# 👩‍💻 Author

**Richa Chandel**

B.Tech Computer Science Graduate

Java Full Stack Developer

Open to Software Development Opportunities

---

# 📄 License

This project is licensed under the MIT License.
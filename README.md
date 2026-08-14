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

# Day 18 - Answer Submission Module

## Features Implemented

### Answer Submission API

Users can submit answers for interview questions.

### APIs

#### Submit Answer

```http
POST /api/answers
```

Request

```json
{
  "userAnswer": "Spring Boot simplifies Java development.",
  "questionId": 1,
  "sessionId": 1
}
```

Response

```json
{
  "id": 3,
  "userAnswer": "Spring Boot simplifies Java development.",
  "submittedAt": "2026-07-19T13:30:22"
}
```

---

#### Get All Answers

```http
GET /api/answers
```

Returns all submitted answers.

---

## Backend Components

### Entity

- Answer

### DTO

- AnswerRequestDto
- AnswerResponseDto

### Repository

- AnswerRepository

### Service

- AnswerService
- AnswerServiceImpl

### Controller

- AnswerController

---

## Features

- Answer submission
- Store answers in PostgreSQL
- Fetch submitted answers
- Bean Validation added
- Layered Architecture

---

## Learning Outcomes

- Bean Validation
- REST API Design
- Spring Data JPA
- DTO Pattern
- Service Layer
- PostgreSQL Integration

---

## Status

✅ Day 18 Completed Successfully


---

# Day 19 – AI Evaluation Engine

## Features

- Implemented EvaluationResult module
- Automatic answer scoring
- Feedback generation
- EvaluationResult persistence in PostgreSQL
- Evaluation History API

## APIs

### Evaluate Answer

POST /api/evaluations

### Get Evaluation History

GET /api/evaluations

## Learning Outcomes

- Service Layer business logic
- Entity relationships
- Repository pattern
- DTO mapping
- PostgreSQL persistence
- AI evaluation workflow

## Status

✅ Day 19 Completed Successfully



## Day 20 - Dashboard Analytics API

### Features Implemented

- Dashboard Summary API
- Total Interview Count
- Total Answers Count
- Average Score
- Highest Score

### Endpoint

#### Dashboard Summary

```http
GET /api/dashboard/summary
```

### Sample Response

```json
{
  "totalInterviews":2,
  "totalAnswers":3,
  "averageScore":70.0,
  "highestScore":70
}



# Day 21 – Interview History Module

## Features Added

- Implemented Interview History API
- Created InterviewHistoryResponseDto
- Added history retrieval service
- Added repository methods for session history
- Added REST endpoint:
  GET /api/sessions/history
- Configured Spring Security access
- Successfully tested using curl

## API

GET /api/sessions/history

Response

[
  {
    "sessionId":1,
    "role":"Backend Developer",
    "totalQuestions":0,
    "score":0,
    "status":"STARTED",
    "createdAt":"2026-06-26T00:45:27"
  }
]



## Day 22 – AI Feedback Engine (Google Gemini)

Implemented an AI-powered interview evaluation system.

### Features
- Google Gemini API integration
- AI evaluates candidate answers
- Generates interview score
- Generates detailed feedback
- Modular AI Provider architecture
- Easily replaceable AI models
- REST API for evaluation

### Endpoint

POST /api/ai-feedback

Request

{
  "question": "...",
  "expectedAnswer": "...",
  "userAnswer": "..."
}

Response

{
  "score": 100,
  "feedback": "..."
}



## Day 23 – PDF Interview Report

### Features
- Added PDF report generation using iTextPDF
- Created ReportService
- Implemented ReportServiceImpl
- Added ReportController
- Download interview report using

GET /api/reports/{sessionId}

### Report contains
- Candidate Name
- Interview Role
- Technology
- Score
- Status
- AI Feedback



## Day 24 – Analytics Dashboard API

### Features
- Total Interviews
- Completed Interviews
- Average Score
- Highest Score
- Success Rate

### Endpoint

GET /api/analytics

### Example Response

```json
{
  "totalInterviews": 2,
  "completedInterviews": 0,
  "averageScore": 70,
  "highestScore": 70,
  "successRate": 0.0
}
```



# Day 25 - Frontend Authentication Setup

## Features

- Axios API configuration
- Authentication service
- React Context API
- User session management
- LocalStorage integration

## Learning Outcomes

- Axios
- Context API
- Authentication architecture
- React state management
```




## Day 26
- Added complete Authentication Module
- JWT Login
- User Registration
- Auth Context
- Axios Authentication
- Local Storage Token Handling




## Day 27 Completed

### Authentication & Route Protection

#### Frontend
- ProtectedRoute component
- JWT Axios interceptor
- AuthContext persistence
- Logout functionality
- Protected Dashboard, Profile, History, Interview routes

#### Backend
- Spring Security configuration
- JWT Authentication Filter
- JWT Service
- Role-based authorization
- Stateless authentication
```

### Learning Outcomes

- Spring Data JPA Aggregate Queries
- Dashboard Analytics
- Repository @Query
- Service Layer Aggregation
- REST API Design




## Day 29 – Interview Session

### Features Completed

- Interactive Interview Screen
- Question Navigation
- Progress Tracking
- Countdown Timer
- Speech-to-Text Integration
- Save Answers API
- Submit Interview Flow
- Backend Integration




# Day 31 — Interview Session & Question Flow

## Objective

Build the first functional interview-session experience.

## Completed

- Interview page structure
- Interview header
- Question display
- Answer input
- Question navigation
- Progress tracking
- Interview timer
- Backend API integration
- Frontend/backend verification

## Architecture

React
 ↓
interviewService.js
 ↓
api.js
 ↓
Spring Boot
 ↓
InterviewController
 ↓
InterviewService
 ↓
QuestionRepository

## Testing

Frontend:
npm run dev

Backend:
./mvnw spring-boot:run

Production build:
npm run build

## Git Commits

- Day 31: Build interview page foundation
- Day 31: Add interview question display
- Day 31: Add interview answer input
- Day 31: Add interview progress and timer
- Day 31: Connect interview flow to backend APIs
- docs(day31): add interview session documentation





## 📅 Day 32 — Interview Session & Question Loading

### Completed

- Implemented interview session flow
- Connected frontend interview page with backend APIs
- Added interview question loading
- Added current question state
- Added question navigation
- Added question progress tracking
- Added loading and error states
- Integrated interview components
- Verified frontend production build

### Interview Flow

Login
↓
Interview Page
↓
Create/Load Session
↓
Load Questions
↓
Display Current Question
↓
Navigate Questions
↓
Prepare Answer

### Verification

Frontend:
`npm run build` ✅

Backend:
Spring Boot application running on port 8080 ✅






## 📅 Day 32 — Backend Interview API Integration

### Completed

- Created centralized `interviewService.js`
- Connected React interview page with backend APIs
- Added interview question fetching
- Added loading state
- Added API error handling
- Added empty-question handling
- Connected dynamic question display
- Connected answer state to the answer textarea
- Added Next Question functionality
- Added question progression
- Added interview completion state

### API Integration

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/questions` | Fetch interview questions |
| POST | `/api/questions` | Create interview question |
| GET | `/api/interviews` | Fetch interviews |
| POST | `/api/interviews` | Create interview |
| GET | `/api/sessions` | Fetch sessions |
| POST | `/api/sessions` | Start interview session |
| GET | `/api/sessions/history` | Fetch interview history |

### Frontend Files

```text
frontend/
└── src/
    ├── pages/
    │   └── Interview/
    │       ├── Interview.jsx
    │       ├── QuestionCard.jsx
    │       ├── AnswerBox.jsx
    │       ├── ProgressBar.jsx
    │       ├── Timer.jsx
    │       ├── InterviewHeader.jsx
    │       └── InterviewFooter.jsx
    │
    └── services/
        └── interviewService.js







        ## Day 34 — Dynamic Interview Question Flow

### Completed
- Dynamic question loading
- Interview question state management
- Current question tracking
- Answer state management
- Next-question navigation
- Dynamic progress tracking
- Loading state
- Error handling
- Interview flow integration

### Frontend
- Interview.jsx
- QuestionCard.jsx
- AnswerBox.jsx
- ProgressBar.jsx
- InterviewFooter.jsx
- interviewService.js

### API
GET /api/questions/interview/{interviewId}

### Validation
- Frontend production build
- Backend Maven compilation
- Interview question retrieval
- Question navigation
- Answer input






## Day 35 — Interview Answer Submission

### Completed

- Answer state management
- Answer input UI
- Answer validation
- Answer submission API
- Answer persistence
- Question-to-answer association
- Interview-session-to-answer association
- Submission loading state
- Submission error handling
- Submitted state
- Next-question navigation after submission
- Dynamic interview progress

### Frontend

- `Interview.jsx`
- `AnswerBox.jsx`
- `ProgressBar.jsx`
- `interviewService.js`

### Backend

- `Answer.java`
- `AnswerRequestDto.java`
- `AnswerResponseDto.java`
- `AnswerRepository.java`
- `AnswerService.java`
- `AnswerServiceImpl.java`
- `AnswerController.java`
- `SecurityConfig.java`

### API

POST `/api/answers`

GET `/api/answers`

### Validation

- Backend Maven compilation
- Frontend production build
- Answer validation
- Answer submission
- Answer persistence
- Question association
- Session association
- Interview UI submission flow
---

# 👩‍💻 Author

**Richa Chandel**

B.Tech Computer Science Graduate

Java Full Stack Developer

Open to Software Development Opportunities

---

# 📄 License

This project is licensed under the MIT License.
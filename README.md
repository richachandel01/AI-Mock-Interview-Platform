# AI Mock Interview Platform

## Project Overview

AI Mock Interview Platform is a full-stack SaaS application designed to help students and job seekers prepare for technical and HR interviews using AI-generated interview sessions, answer evaluation, analytics, and downloadable reports.

---

## Tech Stack

### Frontend

* React.js
* Vite
* Tailwind CSS
* React Router DOM
* Axios

### Backend

* Java 22
* Spring Boot 3.5.15
* Spring Security
* Maven

### Database

* PostgreSQL (Upcoming)

### AI Integration

* Gemini API (Planned)
* OpenAI API (Fallback)

### Deployment

* Vercel (Frontend)
* Render (Backend)
* Supabase PostgreSQL (Database)

---

# Project Structure

```text
AI-Mock-Interview-Platform/
│
├── frontend/
├── backend/
├── database/
├── docs/
├── docker/
├── scripts/
│
└── README.md
```

---

# Development Progress

## Day 1 - Project Initialization

### Completed

* Created GitHub Repository
* Initialized Git Project
* Designed Project Architecture
* Created Monorepo Structure

### Folder Structure

```text
AI-Mock-Interview-Platform/
│
├── frontend
├── backend
├── database
├── docs
├── docker
├── scripts
└── README.md
```

### Git Commit

```bash
Initial project setup and architecture
```

---

## Day 2 - Frontend Setup

### Completed

* Created React Project using Vite
* Installed Dependencies
* Configured Frontend Environment
* Created Frontend Folder Structure

### Installed Packages

```bash
npm install react-router-dom axios
```

### Frontend Structure

```text
src/
│
├── assets
├── components
│   ├── common
│   └── layout
│
├── pages
│   ├── Landing
│   ├── Login
│   ├── Signup
│   ├── Dashboard
│   ├── Interview
│   ├── History
│   ├── Profile
│   └── Admin
│
├── routes
├── services
├── context
├── hooks
├── utils
│
├── App.jsx
└── main.jsx
```

### Git Commit

```bash
Day 2: Frontend setup and architecture
```

---

## Day 3 - Routing and Pages Setup

### Completed

* Configured React Router
* Created Page Components
* Implemented Navigation Structure
* Setup Basic Routing

### Pages Created

* Landing
* Login
* Signup
* Dashboard
* Interview
* History
* Profile
* Admin

### Learning Outcome

* React Router DOM
* Component Structure
* Route Management
* Project Navigation Flow

### Git Commit

```bash
Day 3: Routing and page structure setup
```

---

## Day 4 - Backend Foundation Setup

### Completed

* Generated Spring Boot Project
* Configured Maven Wrapper
* Verified Maven Build Success
* Created Layered Backend Architecture
* Added Health Controller
* Configured Spring Security Base Setup
* Successfully Started Spring Boot Server
* Verified Backend Running on Port 8080

### Backend Structure

```text
backend/
│
└── src/main/java/com/richa/aimockinterview
    │
    ├── config
    ├── controller
    ├── dto
    ├── entity
    ├── exception
    ├── mapper
    ├── repository
    ├── security
    ├── service
    ├── util
    │
    └── AimockinterviewApplication.java
```

### APIs Created

#### Health Check API

```http
GET /
```

Response:

```text
AI Mock Interview Backend Running
```

### Spring Boot Status

* Spring Boot Version: 3.5.15
* Java Version: 22
* Embedded Tomcat: Running
* Backend Port: 8080

### Learning Outcome

* Spring Boot Project Structure
* Maven Wrapper Usage
* Controller Creation
* REST API Basics
* Embedded Tomcat
* Spring Security Basics

### Git Commit

```bash
Day 4: Backend foundation and Spring Boot setup
```

---

# Current Project Status

## Frontend

* Project Initialized
* Routing Configured
* Pages Created
* Ready for UI Development

## Backend

* Spring Boot Running
* Layered Architecture Ready
* Health API Working
* Ready for Database Integration

---

## Day 5 - PostgreSQL Integration and JPA Setup

### Completed

* Installed PostgreSQL 17
* Created Database: `aimockinterview`
* Configured PostgreSQL Connection
* Configured Spring Data JPA
* Configured Hibernate
* Created User Entity
* Created User Repository
* Connected Spring Boot with PostgreSQL
* Verified Maven Build Success
* Verified Backend Startup with Database Configuration

### Database Configuration

Configured `application.yml`

```yaml
spring:
  application:
    name: ai-mock-interview

  datasource:
    url: jdbc:postgresql://localhost:5432/aimockinterview
    username: postgres
    password: ********

  jpa:
    hibernate:
      ddl-auto: update

    show-sql: true

    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
```

### User Entity Created

Fields:

* id
* name
* email
* password
* role

### Repository Layer Created

```java
public interface UserRepository extends JpaRepository<User, Long> {
}
```

### Learning Outcome

* PostgreSQL Installation
* Database Creation
* Spring Boot Database Configuration
* Hibernate ORM Basics
* JPA Entity Mapping
* Repository Pattern
* Spring Data JPA

### Git Commit

```bash
Day 5: PostgreSQL integration and User entity setup
```

---

# Current Project Status

## Frontend

* Project Initialized
* Routing Configured
* Pages Created
* Ready for UI Development

## Backend

* Spring Boot Running
* Layered Architecture Ready
* Health API Working
* PostgreSQL Connected
* Hibernate JPA Configured
* User Entity Created
* User Repository Created
* Ready for Authentication Development

---

# Upcoming Milestones

## Day 6

* User Registration API
* DTO Layer
* Service Layer
* Validation
* Password Encoding
* Save User into PostgreSQL

## Day 7

* Authentication APIs
* JWT Configuration
* Signup API
* Login API
* Token Generation

## Day 8

* Role Based Authorization
* Student Module
* Admin Module
* Protected APIs

```
```
---

# Author

Richa Chandel

B.Tech Graduate | Software Developer Aspirant

Building a Production-Ready AI Mock Interview Platform from Scratch.

---

# License

MIT License

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
# Day 6 - User Management API with PostgreSQL

## Completed Features

### Database Integration

* PostgreSQL connected successfully
* Spring Data JPA configured
* Hibernate auto table creation enabled

### User Entity

Created User entity with:

* id
* name
* email
* password
* role

### Repository Layer

Created:

```java
UserRepository extends JpaRepository<User, Long>
```

### Service Layer

Implemented:

* createUser()
* getAllUsers()

### Controller Layer

Endpoints:

#### Create User

```http
POST /api/users
```

Request:

```json
{
  "name":"Richa",
  "email":"richa@test.com",
  "password":"123456"
}
```

Response:

```json
{
  "id":1,
  "name":"Richa",
  "email":"richa@test.com",
  "role":"USER"
}
```

#### Get All Users

```http
GET /api/users
```

Response:

```json
[
  {
    "id":1,
    "name":"Richa",
    "email":"richa@test.com",
    "role":"USER"
  }
]
```

### Security

Configured Spring Security to allow all requests during development.

### Tech Stack

* Java 21+
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok

## Learning Outcomes

* REST API creation
* Layered Architecture
* DTO Pattern
* Entity Mapping
* Dependency Injection
* PostgreSQL Integration
* Spring Security Basics

## Status

✅ Day 6 Completed Successfully


---



# Day 7 - JWT Authentication System

## Completed Features

### JWT Dependencies Added

Added JWT libraries:

```xml
jjwt-api
jjwt-impl
jjwt-jackson
```

### Authentication DTOs

Created:

#### LoginRequestDto

```java
email
password
```

#### LoginResponseDto

```java
token
```

---

### JWT Service

Created:

```java
JwtService
```

Implemented:

```java
generateToken()
extractEmail()
```

Features:

* JWT Token Generation
* JWT Token Validation
* Email Extraction from Token
* Token Expiration Support

---

### Authentication API

Created:

```java
AuthController
```

Endpoint:

```http
POST /api/auth/login
```

Request:

```json
{
  "email":"richa@test.com",
  "password":"123456"
}
```

Response:

```json
{
  "token":"JWT_TOKEN"
}
```

---

### Database User Authentication

Implemented:

```java
findByEmail()
```

inside:

```java
UserRepository
```

Authentication Flow:

```text
User Login
      ↓
Database Validation
      ↓
JWT Generation
      ↓
Token Returned
```

---

### JWT Authentication Filter

Created:

```java
JwtAuthenticationFilter
```

Responsibilities:

* Read Authorization Header
* Extract JWT Token
* Validate Token
* Allow Request Forwarding

Header Format:

```http
Authorization: Bearer <token>
```

---

### Spring Security Integration

Updated:

```java
SecurityConfig
```

Configuration:

```java
/api/auth/**
```

Public Routes

Protected Routes:

```java
anyRequest().authenticated()
```

Added:

```java
JwtAuthenticationFilter
```

Before:

```java
UsernamePasswordAuthenticationFilter
```

---

## Authentication Architecture

```text
Client
  │
  │ Login Request
  ▼
AuthController
  │
  ▼
UserRepository
  │
  ▼
JwtService
  │
  ▼
JWT Token
  │
  ▼
Client Stores Token
  │
  ▼
Authorization Header
  │
  ▼
JwtAuthenticationFilter
  │
  ▼
Protected APIs
```

---

## APIs Available

### Login

```http
POST /api/auth/login
```

### Create User

```http
POST /api/users
```

### Get Users

```http
GET /api/users
```

### Protected Profile API

```http
GET /api/users/profile
```

Requires:

```http
Authorization: Bearer <token>
```

---

## Learning Outcomes

* JWT Authentication
* Stateless Security
* Spring Security Filters
* Request Interception
* Token Based Authentication
* Authentication Architecture
* Secure API Design

---

## Status

✅ Day 7 Completed Successfully

 # Upcoming Milestones

## Day 8 - Role Based Authorization

### Goals

* Implement USER and ADMIN roles
* Role-based endpoint protection
* Spring Security authorization rules
* Admin-only APIs
* User-only APIs
* Access Denied handling

### Deliverables

* Role-based SecurityConfig
* Custom authorization rules
* Protected admin routes
* Protected user routes

---

## Day 9 - Interview Domain Module

### Goals

* Create Interview Entity
* Create Interview Repository
* Create Interview Service
* Create Interview Controller
* Interview CRUD APIs

### Deliverables

* Interview creation API
* Get Interview API
* Delete Interview API
* Interview database integration

---

## Day 10 - Question Management Module

### Goals

* Question Entity
* Question Repository
* Question Service
* Question APIs

### Deliverables

* Add Questions API
* Get Questions API
* Question Mapping with Interview

---

## Day 11 - AI Integration Preparation

### Goals

* Gemini API setup
* API key configuration
* AI Service layer
* Prompt Engineering structure

### Deliverables

* AI configuration module
* Gemini service integration

---

## Day 12 - AI Question Generation

### Goals

* Generate interview questions dynamically
* Generate HR questions
* Generate Technical questions

### Deliverables

* AI Question Generation API
* Dynamic interview creation

---

## Day 13 - Answer Evaluation Engine

### Goals

* AI Answer Evaluation
* Feedback Generation
* Scoring System

### Deliverables

* Answer Evaluation API
* Score Calculation API

---

## Day 14 - Dashboard Analytics

### Goals

* Interview History
* Performance Analytics
* Score Tracking

### Deliverables

* Dashboard APIs
* Analytics APIs

---

## Day 15 - Project Stabilization

### Goals

* Testing
* Bug Fixing
* Documentation Update
* Code Refactoring

### Deliverables

* Stable Backend v1
* Production-ready API structure

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

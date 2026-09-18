# Day 1 — AI Student Management System

## 🚀 Project Overview

Today I started building an **AI-powered Student Management System** using **Spring Boot, Spring AI, Ollama, and MySQL**.

The goal is to allow users to interact with the student database using natural-language prompts, while **Spring AI Tool Calling** connects the AI to actual backend operations.

## 🛠️ Technologies Used

- Java 17
- Spring Boot 4.1.1
- Spring AI 2.0.1
- Ollama
- Llama 3.2
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Postman

## 📚 Day 1 Progress

### 1. Student Entity

Created a `StudentEntity` containing:

- Student ID
- First Name
- Last Name
- Standard

The ID is automatically generated using `@GeneratedValue(strategy = GenerationType.IDENTITY)`.

Also added the required no-argument constructor for JPA.

### 2. Database Integration

Connected the application to MySQL using Spring Data JPA.

### 3. Student Repository

Created a repository by extending `JpaRepository<StudentEntity, Long>` and used the built-in `findById()` method.

### 4. Spring AI Tool Calling

Created `StudentService` and exposed backend operations to the AI using the `@Tool` annotation.

Implemented tools for:

- Adding students
- Finding students

### 5. ChatClient Integration

Integrated `ChatClient` with the student service using `.tools(studentService)`.

This allows the AI to decide when to call the backend tools based on the user's natural-language request.

### 6. Ollama Integration

Configured Ollama locally with the **Llama 3.2** model.

## ✅ Day 1 Result

Successfully implemented the following flow:

User Prompt → Spring AI ChatClient → Ollama/Llama 3.2 → Tool Calling → StudentService → Spring Data JPA → MySQL

The AI successfully performed **student insertion through a real database tool call**.

## 🎯 Next

**Day 2:** Add student marks and establish the student-to-marks relationship, then allow the AI to work with the real database records.

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
## Day 2 – Spring AI + LLM Integration

### What I built

On Day 2, I integrated **Spring AI** into the Student Management System and connected it to an LLM.

The application can use natural-language prompts to interact with the student management functionality through Spring AI tools.

### Features implemented

* Integrated Spring AI with the Spring Boot application.
* Added LLM-based interaction with the Student Management System.
* Used `ChatClient` to communicate with the LLM.
* Added Spring AI tool calling using `@Tool`.
* Connected AI operations with the existing `StudentService`.
* Added student percentage management using a separate `PercentageEntity`.
* Implemented a `@OneToOne` relationship between `StudentEntity` and `PercentageEntity`.
* Allowed the AI to call backend methods based on the user's request.
* Tested adding students and retrieving students based on percentage.

### Why I switched from Ollama to Google Gemini

Initially, I used **Ollama** to run a local LLM.

Ollama was useful for understanding how Spring AI communicates with a locally running model, but I encountered limitations with tool calling and structured JSON generation for my `StudentEntity`.

For example, when the AI needed to create a `StudentEntity`, Ollama sometimes generated incomplete JSON or omitted fields such as `standard`. Spring AI then failed while converting the generated JSON into the Java entity.

Because this project depends on reliable **tool calling and structured responses**, I switched to **Google Gemini API**.

Gemini provided more reliable structured responses and tool-calling behavior for this project, making it easier for the LLM to interact with my Spring services.

> Ollama was not removed because it is bad. It is still useful for local and offline LLM experimentation. I switched to Gemini specifically because it worked more reliably for the tool-calling requirements of this project.

### Getting a Gemini API Key

You can create a Google Gemini API key from **Google AI Studio**:

https://aistudio.google.com/app/apikey

### ⚠️ Important – API Key Security

**Never commit your Gemini API key to GitHub.**

Do NOT write:

```properties
spring.ai.google.genai.api-key=YOUR_ACTUAL_API_KEY
```

with your real key in the repository.

Instead, use an environment variable:

```properties
spring.ai.google.genai.api-key=${GOOGLE_API_KEY}
```

Then configure `GOOGLE_API_KEY` as an environment variable on your computer.

For anyone cloning this project:

1. Get your own Gemini API key from Google AI Studio.
2. Set the `GOOGLE_API_KEY` environment variable.
3. Run the application.
4. Never add the actual key to `application.properties`.
5. Never commit API keys, passwords, or other secrets to GitHub.

### Day 2 Result

The application now has an LLM-powered layer that can understand natural-language requests and use Spring AI tools to interact with the Student Management System.

**Next:** Spring AI RAG (Retrieval-Augmented Generation).


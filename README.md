# Cliente CRUD Application 🚀

This project is a full-stack web application designed to manage client information through a CRUD (Create, Read, Update, Delete) interface. The application is developed using Angular for the front-end and Java Spring Boot for the back-end.

## Features 🌟

- **Client Management**: Create, view, update, and delete client records.
- **Data Storage**: Utilizes JPA with an H2 database to store client data.
- **RESTful APIs**: The front-end connects to the back-end through RESTful APIs over HTTP.

## Project Structure 🏗️

### Backend

- **Framework**: Java Spring Boot
- **Database**: JPA with H2 (in-memory database)
- **Entities**: The application manages the following client attributes:
  - `id` (Long): The unique identifier for each client.
  - `name` (String): The name of the client.
  - `gender` (Integer): The gender of the client (e.g., Male, Female).
  - `salary` (Double): The salary of the client.
  - `bonus` (Double): The bonus percentage allocated to the client.

### Frontend

- **Framework**: Angular
- **Styling**: Bootstrap for responsive design.
- **HTTP Requests**: The front-end communicates with the back-end via HTTP, using the APIs provided by the Java Spring Boot application.

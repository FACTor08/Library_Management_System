# 📚 Local Library API
 
A RESTful Library Management API built with Spring Boot, featuring JWT authentication, role-based access control, and full book loan management.
 
🔗 **Live API:** https://local-library-production-9e67.up.railway.app
 
---
 
## 🛠️ Tech Stack
 
- **Java 21** + **Spring Boot 4**
- **Spring Security** + **JWT** (JSON Web Tokens)
- **MySQL** (hosted on Railway)
- **Hibernate / JPA**
- **Maven**
- **Deployed on Railway**
---
 
## ✨ Features
 
- 🔐 JWT-based stateless authentication
- 👥 Role-based access control (USER / ADMIN)
- 📖 Full book catalog management
- 👤 Author and category management
- 🔄 Book loan and return system with timestamps
- 🔍 Search for books, authors and categories
---
 
## 🚀 Getting Started
 
### Prerequisites
- Java 21
- Maven
- MySQL
### Clone & Run Locally
 
```bash
git clone https://github.com/FACTor08/Local-Library.git
cd Local-Library
```
 
Configure your `application.properties`:
 
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb
spring.datasource.username=your_username
spring.datasource.password=your_password
```
 
```bash
./mvnw spring-boot:run
```
 
---
 
## 📡 API Endpoints
 
### 🔓 Auth (Public)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/login` | Login and receive JWT token |
| `POST` | `/user-signup` | Register a new library member |
| `POST` | `/administrator/admin-signup` | Register a new admin |
 
**Login Request:**
```json
{
  "libraryId": "LIB-0023",
  "password": "password123"
}
```
 
**Login Response:**
```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJMSUItMDAyMyJ9...
```
 
---
 
### 📖 Books (Authenticated)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/local-lib/home` | Get all books |
| `GET` | `/local-lib/home/search?name=` | Search books by title |
| `POST` | `/local-lib/administrator/home/new-book` | Add a new book *(Admin only)* |
 
**Add Book Request:**
```json
{
  "title": "Dune",
  "author": "Frank Herbert",
  "category": "Science Fiction",
  "isbn": "978-3-16-148410-0"
}
```
 
---
 
### ✍️ Authors (Authenticated)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/local-lib/home/authors` | Get all authors |
| `GET` | `/local-lib/home/authors/search?name=` | Search authors by name |
| `POST` | `/local-lib/administrator/home/new-author` | Add a new author *(Admin only)* |
 
**Add Author Request:**
```json
{
  "name": "George Orwell"
}
```
 
---
 
### 🗂️ Categories (Authenticated)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/local-lib/home/category` | Get all categories |
| `GET` | `/local-lib/home/category/search?name=` | Search categories |
| `POST` | `/local-lib/administrator/home/new-category` | Add a new category *(Admin only)* |
| `DELETE` | `/local-lib/administrator/home/delete-category?category=` | Delete a category *(Admin only)* |
 
**Add Category Request:**
```json
{
  "category": "Science Fiction"
}
```
 
---
 
### 🔄 Loans (Authenticated)
 
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/local-lib/home/loan/borrow` | Borrow a book |
| `POST` | `/local-lib/home/loan/return` | Return a book |
| `GET` | `/local-lib/administrator/home/loan-status` | View all loans *(Admin only)* |
 
**Borrow/Return Request:**
```json
{
  "libraryId": "LIB-0023",
  "bookTitle": "Dune"
}
```
 
**Response:**
```
Borrow Request
User: LIB-0023 borrowed Dune at 2026-05-01T12:00:00,

Return Request
Dune has been returned by User: LIB-0023 at 2026-05-01T12:00:00
```
 
---
 
## 🔐 Authentication
 
All protected endpoints require a JWT token in the request header:
 
```
Authorization: Bearer <your_token>
```
 
Get your token by logging in via `POST /login`.
 
---
 
## 👥 Roles & Access
 
| Role | Access |
|------|--------|
| **USER** | Browse books, authors, categories, borrow/return books |
| **ADMIN** | Everything above + add books/authors/categories, view all loans |
 
---
 
## 📁 Project Structure
 
```
src/main/java/com/FACTor/Library/API/
├── component/        # JWT Filter, Transfer components
├── config/           # Spring Security configuration
├── controller/       # REST Controllers
├── dto/              # Data Transfer Objects
├── entity/           # JPA Entities
├── repository/       # Spring Data JPA Repositories
└── service/          # Business Logic
```
 
---
 
## 👨‍💻 Author
 
**FACTor** — [GitHub](https://github.com/FACTor08)

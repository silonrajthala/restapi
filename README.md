# 📘 Java Spring Boot API with Basic Auth (PostgreSQL)

This REST API uses **Spring Boot** and **PostgreSQL**, with:
- Basic Authentication using usernames and hashed passwords stored in the DB
- Get all users
- Add a new user
- Search users by email

---

## 🔐 Authentication

The API uses **Basic Authentication** against records in the PostgreSQL `users` table.

Use the `Authorization` header:

# Student Management System

A Spring Boot-based RESTful API for managing student admissions, profiles, courses, and enrollments — built following layered architecture, DTOs, JPA, and Spring Security.


## Tech Stack

-   Java 17
-   Spring Boot 3
-   Spring Data JPA
-   Spring Security
-   MySQL
-   Maven
-   Lombok

## Functional Highlights

**Admin Features**
-   Add students with multiple addresses
-   Add/manage courses with topics
-   Assign courses to students
-   Search students by name or course

**Student Features**
-   Login using `studentCode` and `dateOfBirth`
-   Update profile: email, mobile, parent names, addresses
-   View assigned courses and topics
-   Leave a course

**Security**
-   Admin login via HTTP Basic Auth
-   Student login via custom endpoint

## Run instructions

### 🔧 Prerequisites
-   Java 17+
-   Maven 3+
-   MySQL server running

## 1. Clone the Repository

You can rename the current file by clicking the file name in the navigation bar or by clicking the **Rename** button in the file explorer.

## 2. Configure `application.properties`
Edit `src/main/resources/application.properties` and replace :
- <mysql_username>
- <mysql_password>
  with your database username and password respectively.


## 3. Build & Run

- mvn clean install
- mvn spring-boot:run

Application will start at:
#### **`http://localhost:8080/`**

### **Admin APIs (Protected with Basic Auth)**

#### Admin Login
-   **Auth Type:** Basic Auth
-   **Username:** `admin`
-   **Password:** `admin123`

All Admin endpoints are under `/api/admin`

| Action | HTTP Method | Endpoint | Description |
|--------|-------------|----------|-------------|
| Add Student | `POST` | `/api/admin/students` | Add a new student with addresses |
| Add Course | `POST` | `/api/admin/courses` | Create a new course |
| Assign Course to Student | `POST` | `/api/admin/students/{studentId}/assign-course/{courseId}` | Assign a course to a student |
| Get All Students | `GET` | `/api/admin/students` | Retrieve all students |
| Search Students by Name | `GET` | `/api/admin/students/search?name={name}` | Search students by name |
| Get Students by Course Name | `GET` | `/api/admin/students/course?name={courseName}` | Get students enrolled in a course |

**Authentication Required**: Basic Auth (e.g., username: `admin`, password: `admin123`)

### **Student APIs**

All Student endpoints are under `/api/students`

| Action | HTTP Method | Endpoint | Description |
|--------|-------------|----------|-------------|
| Student Login | `POST` | `/api/students/login` | Validate student identity using student_code and DOB, **Note:** It is not handling tokens and hence all the other student APIs are open. |
| Update Profile | `PUT` | `/api/students/{studentId}/profile` | Update email, phone, parents’ names, and address |
| View My Courses | `GET` | `/api/students/{studentId}/courses` | List of all assigned courses |
| Leave a Course | `DELETE` | `/api/students/{studentId}/courses/{courseId}` | Remove a course from student's list |


All admin routes require authentication:
/api/admin/**

## Pending enhancements:
- Student login can be handled properly with tokens.
- Swagger Integration for API documentation
- DTO Layer with mappings between DTO and Entity
- Unit Tests



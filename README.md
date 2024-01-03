# Employee Manager



## Overview

The **Employee Manager** is a modern and intuitive web application designed to streamline the management of employee information. This project combines a sleek Angular frontend with a robust Spring Boot backend to provide a seamless user experience.

## Features

- **View Employees**: Explore a dynamic list of employees with individualized cards.
- **Add Employee**: Easily input new employee details, including name, email, job title, phone, and image URL.
- **Edit Employee**: Update existing employee information effortlessly.
- **Delete Employee**: Remove employees from the system with a simple click.
- **Search Employees**: Find employees quickly based on name, email, phone, or job title.

## Technologies Used

### Frontend

- **Angular**: A powerful and scalable frontend framework.
- **Bootstrap**: The world's most popular CSS framework for building responsive and mobile-first websites.
- **HttpClientModule**: Angular's module for handling HTTP requests.

### Backend

- **Spring Boot**: A sophisticated Java-based framework for developing robust and scalable backend applications.
- **Spring Data JPA**: A powerful tool that simplifies data access in the Java application.
- **H2 Database**: An in-memory database used for efficient data storage.

## Project Structure

- **frontend**: Contains Angular application files.
- **backend**: Includes Spring Boot application files.
- **database**: Placeholder for the H2 database file.

## Setup

1. **Clone the Repository**: `git clone <repository-url>`
2. **Backend Setup**: Navigate to the `backend` folder and run the Spring Boot application.
3. **Frontend Setup**: Navigate to the `frontend` folder and run the Angular application.

## Usage

1. Access the application in your web browser.
2. Utilize the navigation bar to add, edit, delete, or search for employees.
3. View detailed employee information presented in individual cards on the main page.

## API Endpoints

- **GET /employee**: Retrieve a list of all employees.
- **GET /employee/find/{id}**: Retrieve details of a specific employee by ID.
- **POST /employee/add**: Add a new employee.
- **PUT /employee/update**: Update an existing employee.
- **DELETE /employee/delete/{id}**: Delete an employee by ID.

## Dependencies

- Angular CLI
- Node.js
- Java Development Kit (JDK)
- Maven

## Contributions

Contributions are welcomed! If you'd like to contribute to this project, please fork the repository and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

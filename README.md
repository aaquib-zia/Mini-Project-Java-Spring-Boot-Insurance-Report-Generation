# Insurance Report Generator Application

A web-based reporting **Insurance Report Generator System** that allows users to search, filter and export insurance/benefit plan records.
The application provides users to browse dynamic filtering options and supports exporting reports in both Excel and PDF formats.

---

## Features

- Search records using multiple filters
  - Plan Name
  - Plan Status
  - Gender
  - Start Date
  - End Date

- Display filtered results in tabular format

- Export reports to:
  - Excel
  - PDF

- Reset search filters

- Responsive and clean UI

---

## Technologies Used

### Backend

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend

- HTML
- CSS
- Bootstrap
- Thymeleaf

### Database

- MySQL

### Reporting

- Apache POI (Excel Export)
- iText / OpenPDF (PDF Export)

---

## Project Structure

```text
src/
 ├── controller/
 ├── entity/
 ├── repo/
 ├── request/
 ├── runner/
 ├── service/
 └── util/
```

---

## Screenshots

### Reports Dashboard

Add your screenshot here:

```markdown

```

---

## How It Works

1. User selects filter criteria
2. Application fetches matching records from the database
3. Results are displayed in a table
4. User can export reports as Excel or PDF

---

## Setup Instructions

### Clone Repository

```bash
git clone [https://github.com/aaquib-zia/Mini-Project-Java-Spring-Boot-Insurance-Report-Generation.git]
```

### Configure Database

Update `application.properties`

```properties
server.port=8081

spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.url=jdbc:mysql://localhost:3306/your_db

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create

server.servlet.context-path=/miniproject
```

### Run Application

```bash
mvn spring-boot:run
```

Open in browser:

```text
http://localhost:8081/miniproject/
```

---

## Future Enhancements

- Pagination
- Sorting
- Authentication & Authorization
- Dashboard Analytics
- REST API Integration
- Email Report Sharing
- Responsive Mobile Support

---

## Learning Outcomes

This project helped in understanding:

- Spring Boot MVC architecture
- Dynamic search functionality
- JPA/Hibernate integration
- Report generation
- Exporting data to Excel/PDF
- Frontend and backend integration

---

## Author

Aaquib Zia  
GitHub: [https://github.com/aaquib-zia/]

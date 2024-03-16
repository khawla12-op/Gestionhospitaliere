# Hospital Management Application (Learning ORM)

This educational project is designed to delve into Object-Relational Mapping (ORM) concepts using JPA, Hibernate, and Spring Data. It provides a platform to manage hospital entities and their relationships effectively.

## Entities

### Patient
Represents a patient of the hospital.

### Medecin
Represents a doctor working at the hospital.

### Consultation
Represents a medical consultation between a patient and a doctor.

### Rendez-Vous (Appointment)
Represents a scheduled appointment between a patient and a doctor.

### StatusRDV (Appointment Status)
Represents the current status of an appointment.

## Relationships

### One-to-Many
- A doctor can have many consultations (Medecin -> Consultation).
- A patient can have many appointments (Patient -> Rendez-Vous).

### Many-to-One
- A consultation is associated with one patient (Consultation -> Patient).
- A consultation is associated with one doctor (Consultation -> Medecin).
- An appointment is associated with one patient (Rendez-Vous -> Patient).
- An appointment is associated with one doctor (Rendez-Vous -> Medecin).

## Technologies Used
- Java Persistence API (JPA)
- Hibernate
- Spring Data

## Getting Started
To run the application locally, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd hospital-management`
3. Install dependencies: `mvn install`
4. Run the application: `mvn spring-boot:run`




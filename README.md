# Hospital Management System

## Overview

The Hospital Management System is a Java-based application designed to manage and streamline the various operations of a hospital. This application provides functionalities for managing departments, employees, ambulance services, and other critical hospital functions.

## Features

- **Department Management**: View and manage departments within the hospital.
- **Employee Management**: Keep track of employee details including name, contact information, job title, and more.
- **Ambulance Services**: Manage ambulance details, including driver information, status, and service history.
- **User-Friendly Interface**: The application features an intuitive GUI built with Swing for seamless user experience.
- **Database Connectivity**: Utilizes SQL for data management and retrieval, ensuring reliable storage and accessibility.

## Technologies Used

- Java
- Swing (for GUI)
- SQL (for database management)
- DbUtils (for populating JTable from ResultSet)

## Requirements

- JDK 8 or higher
- MySQL Database
- Required libraries: 
  - `net.proteanit.sql`

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Hospital-Management-System.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Hospital-Management-System
   ```

3. Set up the database:
   - Create a MySQL database and run the SQL scripts provided in the `/sql` directory to create the necessary tables.

4. Configure the database connection:
   - Update the `Conn` class in your project to include your database credentials.

5. Compile and run the application:
   - Use your favorite IDE or command line to compile and run the project.

## Usage

- Launch the application to view the main menu.
- Select options to view and manage departments, employees, or ambulance services.
- Use the BACK button to navigate between screens.

## Contributing

Contributions are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your branch and create a pull request.

## Contact

For any inquiries or suggestions, feel free to contact me at [sourishdey40@gmail.com](mailto:sourishdey40@gmail.com).

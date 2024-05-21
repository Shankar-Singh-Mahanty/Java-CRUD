# Java CRUD, RowSet, and Transaction Programs

This repository contains simple Java programs that demonstrate CRUD (Create, Read, Update, Delete) operations, row set handling, and transaction management (withdraw and deposit) using JDBC. These programs are intended to provide a basic understanding of database interactions in Java.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Built With](#built-with)
- [Contributing](#contributing)
- [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will help you set up and run the Java CRUD, RowSet, and Transaction programs on your local machine for educational and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or later
- A relational database (e.g., ORACLE)
- JDBC driver for your database

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Shankar-Singh-Mahanty/Java-CRUD.git
    cd Java-CRUD
    ```

2. **Configure the database connection:**

    Update the database connection details in the Java programs to match your local database setup. Typically, you'll find these details in the `getConnection` method or a configuration file.

## Usage

Each program in this repository demonstrates a specific functionality:

- **CRUD Operations:** Basic Create, Read, Update, and Delete operations on a database table.
- **RowSet Handling:** Using `CachedRowSet` for managing data in a disconnected mode.
- **Transaction Management:** Handling database transactions such as withdrawals and deposits to ensure data consistency.

### Running the Programs

1. **Compile the Java files:**

    ```bash
    javac -cp .:path/to/jdbc/driver.jar *.java
    ```

2. **Run the desired program:**

    ```bash
    java -cp .:path/to/jdbc/driver.jar ProgramName
    ```

## Built With

- [Java](https://www.oracle.com/java/) - Programming language
- [JDBC](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/) - Java Database Connectivity
- [MySQL](https://www.mysql.com/) - Relational database management system (or your preferred database)

## Contributing

Please explore the repo for details on the code of conduct and the process for submitting pull requests.

## Acknowledgments

- Inspired by various online tutorials and documentation.
- Thanks to the open-source community for providing valuable resources and examples.

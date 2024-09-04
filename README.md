
# Client Database - CRUD Operations

Simple SpringBoot application using Maven, Hibernate, Rest, and H2 in-memory database. The purpose was to create a simple relational database table to perform CRUD operations on a client class using best practices for this type of operation.

## Operations:

- Client insertion with data validation using the Jakarta Validation API library.
- Paginated search of all clients in the database.
- Search by ID with global exception handling using the `ControllerExceptionHandler` class.
- Updating clients with global exception handling using the `ControllerExceptionHandler` class.
- Customer deletion by ID with global exception handling using the `ControllerExceptionHandler` class.
- Response body for unsuccessful requests when invalid data is entered for attributes, including a list of error messages for each attribute.


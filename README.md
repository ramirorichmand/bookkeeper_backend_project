# Bookkeeper Backend Project

## Description

This project is a Bookkeeper API containing books within a 'booklist.' Each book contains the title, author, description and genre.

The program allows the user to have a book stored in their 'booklist' as well as allowing them to categorise them into "Currently reading," "To-read" and "Read" to add further personalisation. 

The user is able to filter books based on author, genre and rating.

Below is a description of all models available, along with the Class Diagram and Entity Relationship Diagram.

### Users:
A user object contains an id, full name, an email address and their own booklist. 

### Books:
Books contains an id, title, author, description and genre

### OwnedBook:
OwnedBook contains the status, user and book

### Class Diagram (update later)

<img src ="./Backend Class Diagram.png" alt="class diagram" width="80%"/>


### Entity Relationship Diagram (update later)

<img src="./Entity Relationship Diagram Backend.png" alt="entity relationship diagram" width="80%"/>

---------

## Tech Stack

The technologies used for this project are:
- Intellij IDEA, running JDK 17
- Spring Boot
- PostgreSQL 
- Postman
-------------

## How to use the API 

### RESTful route endpoints

#### To access the program, use `https://localhost:{port}/{endpoint}` - the default port is 8080

Each model - User, Book and OwnedBook - have REST controllers that provide basic CRUD functionality, specifically Index, Show, Create, Update and Delete routes. The User and Book models also have additional functionality, described below: 

- INDEX: 
  - `GET http://localhost:8080/books` returns all books in JSON format and can be accessed via web browser
  - This method is available for all other models

- SHOW:
  - `GET http://localhost:8080/books/{bookId}` returns books with unique id = {id} and can be accessed via web browser

- CREATE:
  - POST [local host] creates a book with a unique id, and returns the created book. Attributes of this new book must be sent within the request body in Postman

- UPDATE:
  - PUT [local host] updates books with unique id = {id} and returns the updated book. All attributes, changed or not, must be included in the request body in Postman

- DELETE:
  - DELETE [local host] updates book with unique id = {id}. This must be done in Postman. If delete request is successful, Http status 202 - no content - is returned
  
### Filters and Sort (Update later)
  
The book model contains filters and a sort that allow the user to narrow their search.

---------
## Dependencies
- Spring Web
- SpringBoot Devtools
- Spring Data JPA
--------

## Collaborators
- Aya
- Leah
- Ramiro 



# My Personal Project, a simplified library management application

## What will the application do?

This application keeps the digitalized record of library activity, including add new book to a list of book records including information like author name, publisher, year published and book name. It also keeps a record on book when it is borrowed, including who borrowed the book, date when book is borrowed and expected date of return.

## Who will use it?

The librarian

## Why is this project of interest to you

I am taking WRDS 150 this term, and I am amazed how the UBC library have different library branches to store millions printed documents and DVDs all according the discipline related, while work through the library skill tutorial. A complicated method was introduced in the video tutorial but it is beyond my comprehension. I was deeply impressed on how they keep things in library organized and decide to do something related to this topic.

## User Stories
- As a user, I want to add a new book to the library
- As a user, I want to remove a book from the library
- As a user, I want to list a book's full info include author name, publisher, year published and book name.
- As a user, I want to add a record when a book is borrowed from library
- As a user, I want to list all book belongs to the library
- As a user, I want to list all borrowed book with it's expected return date
- As a user, I want to list all book that is currently in stock
- As a user, I want to remove a borrow record when borrower returns the book
- As a user, I want to have option to save any change I made to the library in a file
- As a user, I want to have option to load data from the file I saved before

## Instruction for the grader
- you can add a new book to library by click add new book to library and enter 4 fields to add a new book to library then click confirm
- you can remove a book from library by click remove book and select the book you want to remove via drop-down list then click confirm
- you can add a new borrow record by click add borrow record, select book via drop-down list, enter the name of borrower and then click confirm
- you can list all book belongs to the library by click list information and then click list all collection button
- you can list all borrow record by click list information and then click list borrow record button
- you can list all book that is currently in stock by click list information and then click list available book button
- you can remove a borrow record from library by click remove borrow record option and then select the book to return via a drop-down menu list and then click confirm
- you can save changes to a file by click save changes button
- you can load changes to a file by click load from file button
- Visual component can be found inside add record and add new book to library

## Phase 4: Task 3

- If I have more time, I will apply Singleton design pattern to Library class, since I only need one instance of Library for this program, and I have passing this instance everywhere when implementing my GUI 
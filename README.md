

<div align=center>
    <img src="https://serverdo.in/wp-content/uploads/2019/06/1GCu4cNWIU1ElDbY7d4ycZw.jpg">
    <h1>Java Mastery Journey with ❸ Projects</h1>
</div>

<div align="center">
    📚 <a href="#">Course Link</a> |
    🚀 <a href="#">Projects</a> |
    📝 <a href="#">Course Notes</a> |
</div><br> 



Welcome to my Java Learning & Practice journey! Over the course of one year, I have dedicated myself to mastering the core knowledge of Java programming through meticulous note-taking and hands-on projects.

<div align="center"></div><br>

## 📒 Table of Content




| Section   | Topic             | Problem Sets                                              |
| --------- | ----------------- | --------------------------------------------------------- |
| Section 1 | Getting Started   | Introduction to Java, Setting up Development Environment, Writing First Java Program |
| Section 2 | Computer Basics   | Computer Architecture, Operating Systems, Basics of Data Representation |
| Section 3 | Java Basic Syntax | Variables and Data Types, Operators and Expressions, Control Flow Statements, Arrays and Strings |
| Section 4 | Object-Oriented Programming (OOP) | Classes and Objects, JVM memory, Class Members: Fields & Methods, How to Declare Member Variables, Member Variables vs. Local Variables, Understanding Instance method, [Stack Memory and Heap Space ](https://www.baeldung.com/java-stack-heap),Method Overload , Variable-Length Parameter(Varargs), Method Parameter Passing Mechanism, Recursion, |
|Section 5 | Object-Oriented Programming (OOP) | Encapsulation, Constructor,JavaBean, UML, *keyword:* this, *keyword*: Super,Inheritance, Override,Access Modifiers, Polymorphism (Compile-time and Runtime Polymorphism), Virtual Method Invocation, Upcasting vs. Downcasting |
| Section 6 | Object-Oriented Programming (OOP) | *keyword*: static, final, abstract, Singleton, Code Blocks, Interfaces, Inner Classes (Nested Classes), Enum,Annotation, Wrapper Class |
| Section 7 | Exception handling | Understanding Exceptions, try-catch Blocks, Multiple Catch Blocks, Throwing Exceptions, Custom Exceptions |
| Section 8 | Thread | Multithreading Concepts, Creating Threads: Thread vs Runnable, Thread Synchronization, Daemon Threads, Thread Lifecycle, Thread Communication, Producer-Consumer Problem, Locks and Lock Release |
| Section 9 | Common class and API                                       | String, StringBuffer,StringBUilder, DateAPI, java.lang.Comaprable, Java.util.Comparator, System, Runtime, Math, Random    |
| Section 10 |          Collection                              | Introduction to Collections, List Interface and ArrayList, Set Interface and HashSet, Map Interface and HashMap, Iterator and Iterable, Generics in Collections, Synchronized Collections |
| Section 11 | Generics | Generic Classes, Type Parameters, Generic Methods |
| Section 12 | File and Stream I/O:                  | File Handling with File Class, Byte Streams and Character Streams, File I/O with NIO (New I/O) Package, Handling File and Stream Exceptions, Best Practices for File and Stream I/O |
| Section 13 | Network Programming and Communication | Overview of Networking, TCP and UDP Protocols, Three-Way Handshake and Four-Way Handshake, Network Programming APIs: InetAddress and Socket Classes, Socket-related Class APIs, URL Programming with URL and URLConnection Classes |
| Section 14 | Reflection |Understanding Reflection Mechanism, Getting Class Instances, Class Loading, Basic Applications of Reflection, Reading Annotation Information, Exploring the Dynamics of Reflection|
|Section 11	  |Java 8|Lambda Expressions, Functional Interfaces, Stream API for Collection Processing, Introduction to JShell|
| Section 15 | Advanced Java Concepts | Serialization and Deserialization, JavaFX Basics, Java 9 and Beyond Features |



##  Project 1: 💰 Family Budgeting Software

> This project involves simulating the development of a family budget software using a text interface. The goal is to become proficient in basic Java syntax, including local variables, data types, loops, branching, method invocation, return values, and simple screen output formatting.

🪴 It mainly involves the following knowledge points: 

1.  Local variables and basic data types
2.  Loop statements
3.  Branch statement
4.  Method invocation and receipt of return values
5.  Simple screen output format control



##  Project 2:  📚  Library Information Management Software

> Simulate the realization of a "Library Information Management Software" based on a text interface, familiar with object-oriented programming and debugging skills, and master the use of classes, objects, arrays, and MVC design pattern.

🪴The project will cover the following key concepts:

1. Using the Class Structure: Properties, Methods, and Constructors
Object creation and usage
2. Class encapsulation
3. Declaring and using arrays
4. Insertion, deletion, and replacement of array elements
5. Understanding and utilizing the keyword: this

The structure of the project is as follows:

```
BookView
|--> Book: An entity object used to encapsulate book information.
|--> BookList: A management module for Book objects. It internally manages an array of Book objects and provides corresponding methods for adding, modifying, deleting, and traversing the objects, which are called by BookView.
|--> BookView: A user interface display module responsible for handling interface logic. It displays menus, receives user input, and calls the relevant methods of BookList.
|--> BookTest: The main class of the program, which is responsible for starting the program and creating the BookView object.

```




##  **Project 3:  👩🏻‍💻 Development team personnel scheduling system**

Description:

The Development Team Personnel Scheduling System is a Java-based application that provides comprehensive functionalities for managing a development team. Users can efficiently handle team member assignments, equipment management, and view team member details. The system is designed to accommodate various types of team members, including Programmers, Designers, and Architects, along with their specific equipment requirements.

🪴 Key Concepts Covered:

1. Class Inheritance: Understand and implement inheritance to create a hierarchical structure for team members.
2. Polymorphism: Utilize polymorphism to enable flexible handling of different team member types.
3. Abstract Class: Learn to design and use abstract classes for common attributes and behaviors among team members.
4. Interface: Implement interfaces to define common actions across different team member roles.
5. Exception Handling: Implement robust exception handling to enhance the application's reliability.
6. File Read and Write: Develop file read and write operations for data storage and retrieval.
7. MVC Design Pattern: Apply the Model-View-Controller design pattern to create a modular and maintainable system.

Domain: 

> The Domain module defines the core entities and their properties in the team management system. It includes the following classes:

``` 
Domain:
  |--> **Employee**: Represents the basic information of a team member, including their ID, name, age, and salary.
  |--> **Programmer**: Extends Employee and adds additional properties specific to programmers, such as a member ID, status, and equipment.
  |--> **Designer**: Extends Programmer and adds an additional bonus field specific to designers.
  |--> **Architect**: Extends Designer and includes a stock field specific to architects.
  |-->**Equipment**: Represents the equipment used by team members and includes subclasses like PC, MAC, and Printer.
  |--> **PC**: Extends Equipment and adds additional properties specific to PCs, such as model and display.
  |--> **MAC**: Extends Equipment and adds additional properties specific to MACs, such as model and color.
  |--> **Printer**: Extends Equipment and adds additional properties specific to printers, such as type and name.
```

Service:

> The Service module provides the core business logic of the team management system. It includes the following classes:

```
Service:
  |--> **TeamData**: A management module for Employee objects. It internally manages an array of Employee objects and provides corresponding methods for adding, modifying, deleting, and traversing the objects, which are called by TeamView.
  |--> **TeamListService**: A user interface display module responsible for handling interface logic. It displays menus, receives user input, and calls the relevant methods of TeamData.
  |--> **TeamService**: The main class of the program, which is responsible for starting the program and creating the TeamView object.
  |--> **TeamStatus**: An enumeration class that defines the status of a team member.
  |--> **TeamException**: A custom exception class that defines exceptions that may occur in the team management system.
```

View:

> The View module provides the user interface for the team management system. It includes the following classes:

```
View:
  |--> **TeamView**: A user interface display module responsible for handling interface logic. It displays menus, receives user input, and calls the relevant methods of TeamListService.
  |--> **TSUtility**: A utility class that provides methods for reading user input and displaying menus.
```

JUnit Test:

> The JUnit Test module provides unit tests for the team management system. It includes the following classes:

```
Junit:
  |--> **TeamServiceTest**: A unit test class for the TeamService class.
  |--> **TeamViewTest**: A unit test class for the TeamView class.
  |--> **TeamDataTest**: A unit test class for the TeamData class.
  |--> **TeamListServiceTest**: A unit test class for the TeamListService class.
  |--> **TeamExceptionTest**: A unit test class for the TeamException class.
```


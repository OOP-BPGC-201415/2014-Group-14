This project is a Mess Management System written in Java keeping
in mind the principles we have learned from our course "Object
Oriented Programming" (CS F213).

All UML diagrams are in uml/.
All code is in src/ (tests are in src/tests).
The SQL Queries of the databases created can be found in database/MessManagement.sql file

To compile all source files in one go run the exec.sh in src/ directory

The are 3 packages :
	- actors 
	- backend
	- swd

Project Special Requirments :

1. We require Apache Tomcat Server For Running The Web-App Part (JSP files)
2. We require a MySql Database Server for interacting with the Databases

Classes That Are Complete :

1. MessConvener
2. DatabaseManager
3. Inventory
4. Menu
5. Problem
6. Complaint
7. Session
8. SessionWrapper
9. Hygiene


Classes That Are Incomplete :

1. FacultyCoordinator
2. MessManager
3. Student
4. Worker
5. SwipeIdCard
6. Swd

This project is a Mess Management System written in Java keeping
in mind the principles we have learned from our course "Object
Oriented Programming" (CS F213).

Contribution of Team Members
============================

| Name          | ID            | Roles          | Role-based Cont. (%) | Overall Cont. (%) 
| ------------- | ------------- | -------------- | -------------------- |------------------
| Vipul Singh	| 2012B3A7511G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |                                                    
| Ayush Pandey	| 2012B4A7714G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |
| Bhargav S	| 2013A7PS053G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |
| Rohith R	| 2013A7PS124G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |
| Nihanth	| 2012A3PS151G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |
| Avidipto	| 2012B3A7506G  | Code Dev	 | 16.66                | 16.66
|	   	|	        | Testing    	 | 16.66                |
|  		|               | CRC Cards    	 | 16.66	        |
|       	|	        | UML  		 | 16.66                |
|       	|	        | Proj Req    	 | 16.66                |
|  		|	        | Use Cases    	 | 16.66                |





| Topic         | Number in Stage-2 | Code          | Number added after Stage-2 |
| ------------- | ----------------- | --------------| ---------------------------|
| Use cases	| 13	            | Incomplete    | Removed 1                  |
| Classes       | 15                | Incomplete    | 5			 	 |
| Packages      | 3	            | Incomplete    | 1	                	 |
| Sequence Diag | 4	            | Complete      |	                 	 |
| Unit Tests    | 2	            | Complete      |		               	 |                                           


All UML diagrams are in uml/.

All code is in src/ (JUnit Tests are in src/tests).

The SQL Queries of the databases created can be found in database/MessManagement.sql file

Eclipse Deployment Instructions:
1. Install Tomcat 8.x and add to Eclipse servers
2. Install MySQL and source the MessManagement.sql file.
2. Import the project root from Git (File->Import->Projects From Git)
3. Start Tomcat, open index.jsp in your browser.

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

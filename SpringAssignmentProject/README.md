This Eclipse project contains 3 part Assignment for SPRING.

Database details:
database type: mySQL
database name : mydb
table name: student

Server Used:
Jetty (port configured to 8095)

Parts:
1. Spring MVC --> POST method --> implemented through a form for getting details for a POST request. JDBC inserts the new Student data into mydb.student table.
2. Factory Method --> implemented in FactoryMethod class --> corresponding bean is specified --> run main() method in ApplicationMain class to see results.
3. Spring JDBC --> ResultSet and RowMapper used for handling data retrieved from database for Spring MVC --> provided in JDBCTemplateDao Class

For input form to test POST request --> http://localhost:8095/SpringAssignmentProject/index.jsp
To retreive all student details --> http://localhost:8095/SpringAssignmentProject/getStudents
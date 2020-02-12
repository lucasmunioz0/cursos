# rest-startup-teacher-02

## Description

This is a API rest that was built using Jersey framework. The idea of this project is to 
publish a service that allow execute CRUD operations over the employee resource. This
service produce and consume JSON.

### Features

The project is composite by the following items

> 1.	script folder: This place has the script for create the table for employee information.
> 2.	src/main/java folder: java classes.
>       *	com.educacionit.java.web.ConnectionHelper: Create connections to database.
>       *	com.educacionit.java.web.Employee: Employee POJO class.
>       *	com.educacionit.java.web.EmployeeDAO: Employee DAO.
>       *	com.educacionit.java.web.EmployeeResource: Employee rest service.
> 3.	src/main/resource: files setup.
>       *	jdbc.properties: Database configuration.
>       *	log4j.properties: logger configuration.


### Build artifact (Compile)

> 1.	From shell or command window: mvn clean package
> 2.	From IDE: check the IDE's information about run maven projects.
>       *	Intellij: [IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html)
>       *	Intellij: [Netbeans](https://platform.netbeans.org/tutorials/nbm-maven-quickstart.html)
>       *	Intellij: [Eclipse](http://maven.apache.org/plugins/maven-eclipse-plugin/usage.html)

## Deploy artifact
> 1. Go to target folder.
> 2. Copy war file.
> 3. Paste war file into webapps folder inside $TOMCAT_HOME or use the Tomcat Deploy tool.

## Run artifact

Go to the favourite browser and enter the following url: **http://localhost:8080//employee-service/api/employees**

## Tips

Use Postman client for test this application. it is a rest api.
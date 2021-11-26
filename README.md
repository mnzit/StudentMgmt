# StudentMgmt

1. Use any Application Server

Tested using payara micro

1. Download payara micro
2. Setup the db using student.sql
3. Run it
command to deploy the project
```
java -jar ~/payara-micro-5.2021.8.jar --deploy target/*.war --nocluster
```
Kill Port Mac & Linux
```
lsof -nP -iTCP -sTCP:LISTEN | grep 8080                                
kill -9 84847   
```

Kill Port Windows
```
netstat -ano | findstr :8080
taskkill /PID 84847 /F
```

## Phases

1. Exposed a simple rest api with using servlets, using custom jdbc template
2. Deployed the code based to Payara Micro
3. Added connection pooling
4. Introducted hibernate to reduce complexity
5. Using Full blowned payara server and used its internal connection pooling
6. Added a generic hibernate dao layer
7. Introduced JAX-RS using Jersey
8. Introduced JSP
9. Converted Servlet to Spring application
10. Manually configured Dispatcher Servlet, View Resolvers, Beans using XML config
11. Manually configured Dispatcher Servlet, View Resolvers, Beans using XML java
12. Add Spring JPA
13. Added thymeleaf to replace JSP

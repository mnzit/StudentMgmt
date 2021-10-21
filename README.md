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

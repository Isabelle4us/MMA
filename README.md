# MMA
MMA procjet for cs631

# SETUP

For database:

Run following commands to create the database mma in mysql, username and password have to be exactly the same

`mysql> create database mma;` -- Creates the new database

`mysql> create user 'springuser'@'%' identified by 'password';` -- Creates the user

`mysql> grant all on mma.* to 'springuser'@'%';` -- Gives all privileges to the new user on the newly created database

For backend:

start MySQL

start the backend by running
`./mvnw spring-boot:run`

under the project root folder. and check MySQL it will automatically generate all the tables for the java class I put in the project.

For Test payload:

create illness:
```
curl --request POST \
  --url http://localhost:8080/illness \
  --header 'Content-Type: application/json' \
  --data '{
	"illnessCode": 1,
	"description": "cough"
}'
```

create physician:
```
curl --request POST \
  --url http://localhost:8080/physician \
  --header 'Content-Type: application/json' \
  --data '{
	"empNo": 10001,
	"name": "doctor wang",
	"tel": "1231415142",
	"gender": "MALE",
	"address": "Address A",
	"ssn": "234-512-5123",
	"birthday": "1991-10-08",
	"annualSalary": 800000,
  "specialty": "specialtyA",
  "percentOwnership": 5
}'
```

create patient:
```
curl --request POST \
  --url http://localhost:8080/patient \
  --header 'Content-Type: application/json' \
  --data '{
	"patientNo": 10001,
	"name": "li si",
	"tel": "1231415145",
	"gender": "MALE",
	"bloodType": "A",
	"ssn": "234-512-5123",
	"birthday": "1990-10-08"
}'
```

create consultation:
```
curl --request POST \
  --url http://localhost:8080/consultation \
  --header 'Content-Type: application/json' \
  --data '{
	"patientId": 3,
	"physicianId": 2,
	"illnessId": 1,
	"date": "2022-11-08",
	"start": "11:30",
	"end": "13:30"
}'
```

get appointments:
```
curl --request POST \
  --url http://localhost:8080/patient/3/schedule \
  --header 'Content-Type: application/json' \
  --data '{
	"physicianId": 2,
	"date": "2022-11-08"
}'
```

get previous consultations:
```
curl --request GET \
  --url http://localhost:8080/patient/3/consultation
```

get previous illness:
```
curl --request GET \
  --url http://localhost:8080/patient/3/illness
```

try update the diagnose result and get consultations and illness again
```
case1: update consultation set diagnosed=false;
case2: update consultation set diagnosed=true;
```
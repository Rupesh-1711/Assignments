#  Java8-Spring Boot Assignment  

## Technologies Used:
 - Java 8
 - Spring Boot
 - Maven
 - MySql

## Assignment

create a project to calculate analytics from the call data saved for a callcenter.
Each call that is received by the callcenter is saved in a database table

## API's
- Add Call Data 
- Post:- http://localhost:8089/kapture/
```
{
    "from_number": 9999999999,
    "start_time": "13-01-2021 07:02:49",
    "end_time": "13-01-2021 07:14:44"
}
```
- 1> Hour of the day when the call volume is highest.
- GET :- http://localhost:8089/kapture/hourVolume

- 2> Hour of the day when the calls are longest.
- GET :- http://localhost:8089/kapture/hourLongest

- 3> Day of the week when the call volume is highest.
- GET :- http://localhost:8089/kapture/dayVolume

- 4> Day of the week when the calls are longest.
- GET :- http://localhost:8089/kapture/dayLongest

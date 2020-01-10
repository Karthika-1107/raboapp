# Raboapp
Raboapp transaction statement processor

1. The raboapp application used technologies are java8, springboot, spring rest service, spring aop, junit with springbootstartertest
2. The allowed mime type of uploaded record is configured in property file so that we can add or remove anytype of document here
3. To extract data from uploaded document, I used strategy pattern. Now it is having algorithm for XML and CSV file we can extend this to other type also.
4. Using java 8 stream api to validate the record
5. Spring AOP is used for commons logging

Steps to Test the application:
1. Directly hit the rest url "/raboapp/stmtprocessor/validateStatement" in postman with uploaded document as input
2. Possibleto test through junit test case 


#
RaboBank app - transaction statement processor

1. The raboapp application used technologies are java8, springboot, spring rest service, spring aop, junit with springbootstartertest
2. The allowed mime types  configured in property file so that we can configure for including any other file here
3. To extract data from uploaded document, I used strategy pattern. Now it is having algorithm for XML and CSV file we can extend this to other type also.
4. Using java 8 stream api to validate the record
5. Spring AOP is used for commons logging

I used React js for FE. Since it is not mentioned for me I did not commit it here. Please let us know if it required i will commit it.

Steps to Test the application:
1. Run RaboApp.java . The springboot root configuration class
2. Directly hit the rest url "/raboapp/stmtprocessor/validateStatement" in postman with uploaded document as input
3. It is also Possible to test through junit test cases also.

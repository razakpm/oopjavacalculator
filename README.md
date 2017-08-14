# java-calculator
Working repository 
Heavily object-oriented calculator in Java to train OOP skills and master Java.

## Roadmap

1. Implement basic math operations as classes and write unit tests for them. Get familiar with Gradle and Idea.
2. Implement RPN to parse string input to convert "2 + (3 / 4)" into Operation objects.
3. Implement expressions and solvers for solving systems like "2 + x = 10".
4. Wrap existing code into REST-API service.
5. Implement optical character recognition (OCR) feature. With OCR we are going to convert image with numeric expression into text, and from there - to domain model objects.
6. Implement automatic expression detection using line and objects detection. 

## Contribution

0. Use Slack to coordinate work.
1. All task-related work should be done in separate branch and reviewed before commit. 
2. Please create branch, make your work there and make a pull-request using website. 
3. Write tests and ensure they are passing before making pull request.
4. Follow code-style and do code-reformatting before making a commit.
 
## New functional
Webserver for our calculator.  
To run server locally, do following in terminal:  
% gradle build  
% gradle wrapper  
% ./gradlew build  
% java -jar build/libs/gs-handling-form-submission-0.1.0.jar  

In your browser open:  
http://localhost:8080/calculator  
or  
http://localhost:8080/calculate?value=...  
for examle:  
http://localhost:8080/calculate?value=sin(pi/2)  

rerrrdfgd
Jira test
Jira test 2 
Jira commit Roni

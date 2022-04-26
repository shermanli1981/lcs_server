# LCS Server

This repo is an application for a Longest Common Substring Server. 

The app is built with Spring Boot. 

The following functionality are exposed via RESTful APIs:

Solve the Longest Common Substring problem via HTTP POST: http://localhost:8080/lcs

Tests are included with the code.

## Setup
### Requirements
* Should use Java 11 or higher. Previous versions of Java are un-tested.
* Use Maven 3.6.0 or higher
* IntelliJ 2018 or Higher

### Steps:
1) On the command line
    ```
    git clone https://github.com/shermanli1981/lcs_server.git
    ```
 2) Inside Intellij
     ```
    File -> New -> Project from Exsiting Source..
    ```
    run the application by right clicking on the PetstoreApplication main class and choosing Run 'PetstoreApplication'.
    
3) Navigate to Swagger UI, then you can perform the operation

    Visit http://localhost:8080/swagger-ui.html in your browser.

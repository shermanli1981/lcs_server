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
    run the application by right clicking on the LongestCommonSubstringApplication main class and choosing Run 'LongestCommonSubstringApplication'.
    
3) Navigate to Swagger UI, then you can perform the operation

    Visit http://localhost:8080/swagger-ui.html in your browser.
![image](https://user-images.githubusercontent.com/104450517/165347258-611cedc3-3ffa-4868-8801-3ebdc9459831.png)

4) Call the API with below body, return one result:
{
  "setOfStrings": [
    {"value": "comcast"},
    {"value": "comcastic"},
    {"value": "broadcaster"}
  ]
}


![image](https://user-images.githubusercontent.com/104450517/165348114-ab6e11d3-4c16-4471-bd48-7a32238d496b.png)

Result as below:
![image](https://user-images.githubusercontent.com/104450517/165348437-88944c1b-1f03-42b3-b7ac-282c146db442.png)

5) Call the API with below body, return two results:
{
  "setOfStrings": [
    {"value": "abcdfg"},
    {"value": "abfg"},
    {"value": "abfgcd"}
  ]
}
![image](https://user-images.githubusercontent.com/104450517/165348667-cb49002b-0159-421f-9330-5328cb5df950.png)

6) Call the API with below body, return three results:

{
  "setOfStrings": [
    {"value": "abcdefxyz"},
    {"value": "xyzabcdef"},
    {"value": "defxyzabc"}
  ]
}

![image](https://user-images.githubusercontent.com/104450517/165348980-e561a9a5-b6e5-44c7-9605-1d19fd0d25e6.png)


7) Test are included under the test folder:

![image](https://user-images.githubusercontent.com/104450517/165357120-546f83c6-8cfb-4545-8486-f63eb954c5e2.png)

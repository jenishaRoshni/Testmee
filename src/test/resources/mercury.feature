Feature: Login

  In order to login to the http://newtours.demoaut.com/ website
  As a user
  I have to register first and login successful with multiple test data

  Rules:
  - Only registered users can do the login
  - Test the login functionality with multiple test data with parameterization in Data Table
 

  To Do:
  - is the password field masked?

 Background:
    Given user is on the login page
@Sanity
  Scenario: Successful login - positive case
     When Given user is on the login pagen  user enters correct credentials
   Then  user can do the successful login

@smoke
 Scenario: Testing with multiple test data using data table - positive case
     When user enters below credentails and clicks sing in
      |username |password |
      |invalidUN|invalidPW|
      |validUN  |validPW  |
      |selenium |selenium |
	Then the expected behavior could be
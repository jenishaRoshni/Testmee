Feature: Login

Scenario Outline: Login in a testme app
Given login to the homepage
When user enter with valid "<username>" and "<password>"
Then  successfully user login

 
    Examples: 
      |username  | password | 
      | AlexUser |  Alex@123 | 
     
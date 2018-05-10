
Feature: Acceptance Testing is check Login and Logout functionality is working fine
  In Order to check that
  the Login Functionality is working fine
  we will do the acceptance testing

  @LoginwithValidUser
  Scenario: As a Registered User I want to able to Login into the application so that i can check valid user details

  Given Click on Login link on Get Started Screen
  Then Click on EmailAddress button on Welcome Screen
  When Enter Email and Password and click on Sign In button
  And Click on Profile link from Latest Quickees Screen
  And Click on Settings icon from profile Screen
  And Click on LogOut tab
  Then User should be successfully LogOut
  
  @LoginwithInValidUser
  Scenario: As a UnRegistered User i want to enter user credentials and tap on SignIn button so that app will prompt a validation message
  
  Given Click on Login link on Get Started Screen
  When Click on EmailAddress button on Welcome Screen
  Then Enter Invalid Email and Password and click on Sign In button

  Then Switch to alert pop up and get the text of the alert
  Then Tap on Ok button to accept and close the alert pop up
  
  
  
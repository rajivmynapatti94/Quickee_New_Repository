@ProfilePicture
Feature: Acceptance Testing is check upload profile picture functioanlity is working fine
  In Order to check that
  the Upload profile picture Functionality is working fine
  we will do the acceptance testing

	@ProfilePicture-Gallery
  Scenario: As a User, I want to able to upload profile picture with use of Gallery section

  Given Click on Login link on Get Started Screen
  Then Click on EmailAddress button on Welcome Screen
  When Enter Email and Password and click on Sign In button
  And Click on Profile link from Latest Quickees Screen
  And Click on Settings icon from profile Screen
  And Upload Profile picture with the help of gallery section 
  And Click on LogOut tab
  Then User should be successfully LogOut
  
  
  
  
  
  
  
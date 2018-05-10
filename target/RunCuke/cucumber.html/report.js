$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Acceptance Testing is check Login and Logout functionality is working fine",
  "description": "In Order to check that\nthe Login Functionality is working fine\nwe will do the acceptance testing",
  "id": "acceptance-testing-is-check-login-and-logout-functionality-is-working-fine",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 19,
  "name": "As a UnRegistered User i want to enter user credentials and tap on SignIn button so that app will prompt a validation message",
  "description": "",
  "id": "acceptance-testing-is-check-login-and-logout-functionality-is-working-fine;as-a-unregistered-user-i-want-to-enter-user-credentials-and-tap-on-signin-button-so-that-app-will-prompt-a-validation-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@LoginwithInValidUser"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "Click on Login link on Get Started Screen",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Click on EmailAddress button on Welcome Screen",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Enter Invalid Email and Password and click on Sign In button",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "Switch to alert pop up and get the text of the alert",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "Tap on Ok button to accept and close the alert pop up",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.goToLoginScreen()"
});
formatter.result({
  "duration": 345755685945,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.tapOnEmailbutton()"
});
formatter.result({
  "duration": 3046683269,
  "status": "passed"
});
formatter.match({
  "location": "InvalidLoginStep.enterInvalidEmailAndPassword()"
});
formatter.result({
  "duration": 16779030182,
  "status": "passed"
});
formatter.match({
  "location": "InvalidLoginStep.getalerttext()"
});
formatter.result({
  "duration": 2525739054,
  "status": "passed"
});
formatter.match({
  "location": "InvalidLoginStep.acceptalert()"
});
formatter.result({
  "duration": 5049346966,
  "status": "passed"
});
formatter.after({
  "duration": 512253,
  "status": "passed"
});
});
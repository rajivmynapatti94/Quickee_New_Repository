$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Acceptance Testing is check Login and Logout functionality is working fine",
  "description": "In Order to check that\nthe Login Functionality is working fine\nwe will do the acceptance testing",
  "id": "acceptance-testing-is-check-login-and-logout-functionality-is-working-fine",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@LoginFunctionality"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "As a Logged-out User I want to able to Login into the application so that i can check valid user details",
  "description": "",
  "id": "acceptance-testing-is-check-login-and-logout-functionality-is-working-fine;as-a-logged-out-user-i-want-to-able-to-login-into-the-application-so-that-i-can-check-valid-user-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@LoginwithValidUser"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "Click on Login link on Get Started Screen",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Click on EmailAddress button on Welcome Screen",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Enter Email and Password and click on Sign In button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Click on Profile link from Latest Quickees Screen",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Settings icon from profile Screen",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Click on LogOut tab",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User should be successfully LogOut",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.goToLoginScreen()"
});
formatter.result({
  "duration": 33698207725,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.tapOnEmailbutton()"
});
formatter.result({
  "duration": 2764613019,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.enterEmailAndPassword()"
});
formatter.result({
  "duration": 14843786493,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.goToProfile()"
});
formatter.result({
  "duration": 44219701536,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: Locator map: \n- native content: \"By.xpath: (//XCUIElementTypeOther[@name\u003d\"TabBarItem_AccessibilityLabel\"])[4]\" \n- html content: \"by id or name \"profile\"\"\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027ind351.local\u0027, ip: \u002710.2.4.157\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.6\u0027, java.version: \u002710.0.1\u0027\nDriver info: driver.version: SharedDriver\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:110)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:57)\n\tat io.appium.java_client.ios.IOSElement$$EnhancerByCGLIB$$184e91dc.toString(\u003cgenerated\u003e)\n\tat java.base/java.lang.String.valueOf(String.java:2788)\n\tat java.base/java.lang.StringBuilder.append(StringBuilder.java:135)\n\tat com.quickee.driver.SharedDriver.waitUntilClickable(SharedDriver.java:162)\n\tat com.quickee.driver.SharedDriver.click(SharedDriver.java:78)\n\tat com.quickee.screens.LatestQuickeesScreen.clickProfileTab(LatestQuickeesScreen.java:55)\n\tat com.quickee.steps.LoginSteps.goToProfile(LoginSteps.java:57)\n\tat ✽.And Click on Profile link from Latest Quickees Screen(Login.feature:13)\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.goToSettings()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.clickOnlogoutTab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.verifyLogout()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1075283469,
  "status": "passed"
});
formatter.uri("SelectProfilePicture.feature");
formatter.feature({
  "line": 2,
  "name": "Acceptance Testing is check upload profile picture functioanlity is working fine",
  "description": "In Order to check that\nthe Upload profile picture Functionality is working fine\nwe will do the acceptance testing",
  "id": "acceptance-testing-is-check-upload-profile-picture-functioanlity-is-working-fine",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ProfilePicture"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "As a User, I want to able to upload profile picture with use of Gallery section",
  "description": "",
  "id": "acceptance-testing-is-check-upload-profile-picture-functioanlity-is-working-fine;as-a-user,-i-want-to-able-to-upload-profile-picture-with-use-of-gallery-section",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@ProfilePicture-Gallery"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "Click on Login link on Get Started Screen",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Click on EmailAddress button on Welcome Screen",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Enter Email and Password and click on Sign In button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Click on Profile link from Latest Quickees Screen",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Settings icon from profile Screen",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Upload Profile picture with the help of gallery section",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Click on LogOut tab",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User should be successfully LogOut",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.goToLoginScreen()"
});
formatter.result({
  "duration": 21888822274,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: Locator map: \n- native content: \"By.id: Login\" \n- html content: \"by id or name \"login\"\"\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027ind351.local\u0027, ip: \u002710.2.4.157\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.12.6\u0027, java.version: \u002710.0.1\u0027\nDriver info: driver.version: SharedDriver\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:110)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:57)\n\tat io.appium.java_client.ios.IOSElement$$EnhancerByCGLIB$$184e91dc.toString(\u003cgenerated\u003e)\n\tat java.base/java.lang.String.valueOf(String.java:2788)\n\tat java.base/java.lang.StringBuilder.append(StringBuilder.java:135)\n\tat com.quickee.driver.SharedDriver.waitUntilClickable(SharedDriver.java:162)\n\tat com.quickee.driver.SharedDriver.click(SharedDriver.java:78)\n\tat com.quickee.screens.GetStartedScreen.goToLoginScreen(GetStartedScreen.java:50)\n\tat com.quickee.steps.LoginSteps.goToLoginScreen(LoginSteps.java:35)\n\tat ✽.Given Click on Login link on Get Started Screen(SelectProfilePicture.feature:10)\n",
  "status": "failed"
});
formatter.match({
  "location": "LoginSteps.tapOnEmailbutton()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.enterEmailAndPassword()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.goToProfile()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.goToSettings()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "UploadProfilePicture.selectProfilePictureWithGallery()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.clickOnlogoutTab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginSteps.verifyLogout()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1133994951,
  "status": "passed"
});
});
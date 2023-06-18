Feature: Verify the Login and Log Off Functionality  

@Login2
Scenario: Verify the user is able to "Login" in application and click on "search i-con"
	Given The User has logged in to portal as "Participant".
	Then  The User waits till the page gets loaded.
	When  The User Clicks on "publish" option.
	Then  The User waits till the page gets loaded.
	Then  The User waits more extra time to page gets loaded.
	Then  The User Clicks on "search i-con" link of "search" section. 

@Logoff1
Scenario: Verify the functionality of "log off from Portal & Close the Browser".
  Then  The User may click on "close" link of "search" section.
  Given Close The Parent Browser Object. 
 

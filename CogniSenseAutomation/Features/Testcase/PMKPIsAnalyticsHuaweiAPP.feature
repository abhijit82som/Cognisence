Feature: Verify the Functionalities of PM KPIs Analytics Huawei App 

Background: Precondition Steps
  Given The User has logged in to portal as "Participant".
	When  The User may click on "publish" button.
	Then  The User waits till the page gets loaded.
	Then  The User waits more extra time to page gets loaded.
	Then  The User may click on "search i-con" link of "search" section.
	Then  The User waits till the page gets loaded.
	Then  The User may click on "close" link of "search" section.
	Then  The User enters "PM KPIs Analytics Huawei" in "search box" field.  
	Given The User waits till the page gets loaded.
	Then  User expects the text for "PM KPIs Analytics Huawei".
	When The User Clicks on "PM KPIs Analytics Huawei" option.
	Given The User waits till the page gets loaded.
	Then  The user will be redirected to "PM KPIs Analytics Huawei" page.
	Then The User Clicks on "PM KPIs Analysis Sheet" image link from "sheet" section.
	Given The User waits till the page gets loaded. 
	#Then The User waits more extra time to page gets loaded.
    #Then The user will be redirected to "PM KPIs Analytics Huawei - PM KPIs Analysis" page.
	
@Regression
@PMKPIsAnalyticsHuawei

Scenario: Verify the "PM KPIs Analysis Sheet" exists under a "PM KPIs Analytics Huawei App"

 	Then  User expects the text for "PM KPIs Analysis".
	Given The User waits till the page gets loaded.
			
@Regression
@PMKPIsAnalyticsHuawei

Scenario: Verify the list of different components exist in a Analysis tab of "PM KPIs Analysis Sheet"

	Then  The User Clicks on "PM KPIs Analysis Sheet" image link from "sheet" section.
	Then  The User waits till the page gets loaded.
	Then  The User waits more extra time to page gets loaded.
	Then  User verifies the "Tech Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "Vendor Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "RNC TAC Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "Site Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "Cell Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "Date Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  User verifies the "Hour Drop Down of PM KPIs Analytics Huawei APP" exists in the "Analysis tab" page.
	Then  The User waits till the page gets loaded.
		
@Regression
@PMKPIsAnalyticsHuawei

  Scenario: Verify the Dropdown Value of "KPI Group" Tab in "PM KPIs Analysis" Sheet.
  	Then  The User waits till the page gets loaded.
  	Then The User waits more extra time to page gets loaded.
  	Given The User waits till the page gets loaded.
    Then User verifies the "KPI Group" exists in the "Analysis tab" page.
    Then The User verifies Selected "KPI Group" values from differents dropdown list for "PM KPIs Analytics Huawei" app and "PM KPIs Analysis" sheet.
    #Then The User verifies Selected "Component" values from differents dropdown list for "PM KPIs Analytics" app and "PM KPIs Analysis" sheet.
    Given The User waits till the page gets loaded.
 
	
Feature: Verify the Functionalities of PM KPIs Analytics App

  Background: Precondition Steps
    Given The User has logged in to portal as "Participant".
    When The User may click on "publish" button.
    Then The User waits more extra time to page gets loaded.
    Then The User may click on "search i-con" link of "search" section.
    Then The User waits till the page gets loaded.
    Then The User may click on "close" link of "search" section.
    Then The User enters "PM KPIs Analytics" in "search box" field.
    Then The User waits till the page gets loaded.
    Then User expects the text for "PM KPIs Analytics".
    When The User Clicks on "PM KPIs Analytics" option.
    Then The User waits more extra time to page gets loaded.
    Then The user will be redirected to "PM KPIs Analytics" page.
    Then The User Clicks on "PM KPIs Analysis Sheet" image link from "sheet" section.
    Then The User waits till the page gets loaded.
    Then The User waits more extra time to page gets loaded.
    

  @Regression @PMKPIsAnalytics 
  Scenario: Verify the list of different components exist in a Analysis tab of "PM KPIs Analysis Sheet"
    Then User verifies the "Tech Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Vendor Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "RNC TAC Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Site Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Cell Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Date Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Hour Drop Down of PM KPIs Analytics APP" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.

  @Sanity @Regression @PMKPIsAnalytics  
  Scenario: Verify the Count of different "Component's" values of "PM KPIs Analytics" app and "PM KPIs Analysis" sheet.
    #Then The User verifies All the "Component" values from differents dropdown list for "PM KPIs Analytics" app and "PM KPIs Analysis" sheet.
    Then The User verifies Selected "Component" values from differents dropdown list for "PM KPIs Analytics" app and "PM KPIs Analysis" sheet.
    Given The User waits till the page gets loaded.

  @Sanity @Regression @PMKPIsAnalytics 
  Scenario: Compare and validate all the data from Ranked RNC/TAC Table with baseline sheet.
    When The User Right Clicks on "KPI Group dropdown of Ranked RAC for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Accessibility dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "KPI dropdown of Ranked RAC for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Combined Nokia Tech setup attempts dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "more link of Ranked RNCTAC for PM KPI" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Click here to download your data file." option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button of download popup" option.
    Then The User renames the downloaded excel file as "exportRankedRNCTACForCombined Nokia Tech setup attempts" and copy the file in "PM KPIs Analytics" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedRankedRNCTACForCombined Nokia Tech setup attempts" file and actual "exportRankedRNCTACForCombined Nokia Tech setup attempts" file for the "PM KPIs Analytics" App.

  @Sanity @Regression @PMKPIsAnalytics 
  Scenario: Compare and validate all the data from Ranked Sites Table with baseline sheet.
    When The User Right Clicks on "KPI Group dropdown of Ranked Sites for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Accessibility dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "KPI dropdown of Ranked Sites for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Combined Nokia Tech setup attempts dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "more link of Ranked Sites for PM KPI" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Click here to download your data file." option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button of download popup" option.
    Then The User renames the downloaded excel file as "exportRankedSitesForCombined Nokia Tech setup attempts" and copy the file in "PM KPIs Analytics" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedRankedSitesForCombined Nokia Tech setup attempts" file and actual "exportRankedSitesForCombined Nokia Tech setup attempts" file for the "PM KPIs Analytics" App.

  @Sanity @Regression @PMKPIsAnalytics 
  Scenario: Compare and validate all the data from Ranked Cell Table with baseline sheet.
    When The User Right Clicks on "KPI Group dropdown of Ranked Cell for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Accessibility dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "KPI dropdown of Ranked Cell for PM KPI" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Full screen" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Combined Nokia Tech setup attempts dropdown value for PM KPI" option.
    When The User Clicks on "Confirm selection" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Exit full screen" option.
    Then The User waits till the page gets loaded.
    When The User Right Clicks on "more link of Ranked Cells for PM KPI" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Click here to download your data file." option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button of download popup" option.
    Then The User renames the downloaded excel file as "exportRankedCellsForCombined Nokia Tech setup attempts" and copy the file in "PM KPIs Analytics" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedRankedCellsForCombined Nokia Tech setup attempts" file and actual "exportRankedCellsForCombined Nokia Tech setup attempts" file for the "PM KPIs Analytics" App.

Feature: Verify the Functionalities of Subscriber Analytics App

  Background: Precondition Steps
    Given The User has logged in to portal as "Participant".
    When The User may click on "publish" button.
    Then The User waits more extra time to page gets loaded.
    Then The User may click on "search i-con" link of "search" section.
    Then The User waits till the page gets loaded.
    Then The User may click on "close" link of "search" section.
    Then The User enters "Subscriber Analytics_Automation_2" in "search box" field.
    Then The User waits till the page gets loaded.
    Then User expects the text for "Subscriber Analytics_Automation_2".
    When The User Clicks on "Subscriber Analytics_Automation_2" option.
    Then The user will be redirected to "Subscriber Analytics_Automation" page.
    Then The User Clicks on "Select Subscribers" image link from "sheet" section.
    Then The User waits more extra time to page gets loaded.
    Then The user will be redirected to "Subscriber Analytics_Automation_2" page.
    
    @Regression @SubscriberAnalytics  
    Scenario: Verify the Dropdown Value of "Date filter" Tab in "Subscriber Analytics_Automation_2" Sheet. 
     Then User verifies the "Date filter" exists in the "Subscriber Analytics_Automation_2" page.
    Then The User verifies Selected "Date filter" values from differents dropdown list for "Subscriber Analytics_Automation_2" app and "Subscriber Analytics" sheet.
    
    @Regression @SubscriberAnalytics 
    Scenario: Verify the Dropdown Value of "IMSI filter" Tab in "Subscriber Analytics_Automation" Sheet. 
     Then User verifies the "IMSI filter" exists in the "Subscriber Analytics_Automation" page.
    #Then The User verifies Selected "Date" values from differents dropdown list for "Subscriber Analytics_Automation" app and "Subscriber Analytics" sheet.
    
    @Regression @SubscriberAnalytics 
  Scenario: Compare and validate IMSIs from subscriber artifacts.
    #When The User Right Clicks on "KPI Group dropdown of Ranked RAC for PM KPI" option.
    Then The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "More of IMSI dropdown" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Export data" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits till the page gets loaded.
    #When The User Right Clicks on "KPI dropdown of Ranked RAC for PM KPI" option.
    Then The User waits till the page gets loaded.
    #When The User Clicks on "Close" option.
    #Then The User waits till the page gets loaded.
    Then The User renames the downloaded excel file as "ExportedIMSInoforSubscriberApp" and copy the file in "Subscriber Analytics_Automation_2" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedIMSInoforSubscriberApp" file and actual "ExportedIMSInoforSubscriberApp" file for the "Subscriber Analytics_Automation_2" App.
    
    
     @Regression @SubscriberAnalytics     
  Scenario: Verify the list of different components exist in a Analysis tab of "Subscriber Analytics"
    Then User verifies the "No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "IMSI of No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "MSISDN of No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "No. of Calls of No. of Calls per IMSI" exists in the "Analysis tab" page.
    
    @Regression @SubscriberAnalytics     
  Scenario: Verify the list of different components exist in a Analysis tab of "Subscriber Analytics"
    Then User verifies the "No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "IMSI of No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "MSISDN of No. of Calls per IMSI" exists in the "Analysis tab" page.
    Then User verifies the "No. of Calls of No. of Calls per IMSI" exists in the "Analysis tab" page.
    
    @Regression @SubscriberAnalytics     
  Scenario: Verify the list of different components exist in a Analysis tab of "Subscriber Analytics"
  When The User Clicks on "IMSI no. 724117209292012" option.
  Then The User waits till the page gets loaded.
  When The User Clicks on "Confirm selection of IMSI table" option.
    
            
            
            @Regression @SubscriberAnalytics    
  Scenario: Verify the list of different components exist in a Analysis tab of "Subscriber Analytics"
  Then The User waits till the page gets loaded.
  When The User Clicks on "Search box of IMSI" option.
  Then The User waits till the page gets loaded.
  Then The User enters "268032205327392" in "Search section" field.
  Then The User waits till the page gets loaded.
    Then User expects the text for "268032205327392".
    When The User Clicks on "268032205327392" option.
  When The User Clicks on "Confirm selection of IMSI table" option.
   Then The User waits till the page gets loaded. 
   When The User Clicks on "Explore button of subscriber app" option.
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   When The User Clicks on "Generate new app" option.
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   Then The User waits more extra time to page gets loaded.
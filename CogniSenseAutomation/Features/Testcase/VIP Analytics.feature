Feature: Verify the Functionalities of VIP Analytics App

  Background: Precondition Steps
  
    Given The User has logged in to portal as "Participant".
    When The User may click on "publish" button.
    Then The User waits more extra time to page gets loaded.
    Then The User may click on "search i-con" link of "search" section.
    Then The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    Then The User may click on "close" link of "search" section.
    Then The User enters "VIP Analytics_Automation" in "search box" field.
    Then The User waits till the page gets loaded.
    Then User expects the text for "VIP Analytics_Automation".
    Then The User waits till the page gets loaded.
    When The User Clicks on "VIP Analytics_Automation" option.
    Then The User waits more extra time to page gets loaded.
    Then The User Clicks on "VIP Analysis" image link from "sheet" section.
    Then The User may click on "VIP Analysis" link of "sheet" section.
    Then The User waits till the page gets loaded.
    Then The User waits more extra time to page gets loaded.
    Then The user will be redirected to "VIP Analytics" page.

  @Regression @VIPAnalytics      
  Scenario: Verify the list of different components exist in a Analysis tab of "VIP Analysis"
    Then User verifies the "Tech Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Vendor Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "RAB Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Rel. Cause Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Cell Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Date Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Hour Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "IMSI Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "IMEI Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "UE Model Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "UE Vendor Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Name Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Group Drop Down of VIP Analytics APP" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    @Regression @VIPAnalytics1  
  Scenario: Verify the Dropdown Value of "Analysis of" Tab in "VIP Analysis" Sheet.
    Then User verifies the "Analysis of" exists in the "Analysis tab" page.
    Then The User verifies Selected "Analysis of" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.
    
@Regression @VIPAnalytics  
  Scenario: Verify the Dropdown Value of "Quality KPI" Tab in "VIP Analysis" Sheet.
     Then The User verifies Selected "Quality KPI/Quality KPI of VIP Analytics" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.    
    
 @Regression @VIPAnalytics 
  Scenario: Verify the Dropdown Value of "Quantity KPI" Tab in "VIP Analysis" Sheet.
      Then The User verifies Selected "Quantity KPI/Quantity KPI of VIP Analytics" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
    
 @Regression @VIPAnalytics
  Scenario: Verify the Dropdown Value of "Time Resolution for Quality KPI " Tab in "VIP Analysis" Sheet.
      Then The User verifies Selected "Time Resolution for Quality KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.    
  
  @Regression @VIPAnalytics  
  Scenario: Verify the Dropdown Value of "Time Resolution for Quantity KPI " Tab in "VIP Analysis" Sheet.
      Then The User verifies Selected "Time Resolution for Quantity KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
    
 @Regression @VIPAnalytics
  Scenario: Verify the Dropdown Value of "Dimension for Quality KPI" Tab in "VIP Analysis" Sheet.
      Then The User verifies Selected "Dimension for Quality KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.       
    
@Regression @VIPAnalytics  
  Scenario: Verify the Dropdown Value of "Dimension for Quantity KPI" Tab in "VIP Analysis" Sheet.
      Then The User verifies Selected "Dimension for Quantity KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.           
 
 @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Quality KPI" Tab in "VIP History" Sheet.
     When The User Clicks on "Next sheet link of VIP History" option.
     Then The User waits till the page gets loaded.
     Then The User verifies Selected "Quality KPI/Quality KPI of VIP History" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.    
     
  @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Quantity KPI" Tab in "VIP History" Sheet.
     When The User Clicks on "Next sheet link of VIP History" option.
     Then The User waits till the page gets loaded. 
     Then The User verifies Selected "Quantity KPI/Quantity KPI of VIP History" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
     
  @Regression @VIPAnalytics 
  Scenario: Verify the Dropdown Value of "Time Resolution of VIP History" Tab in "VIP History" Sheet.
      When The User Clicks on "Next sheet link of VIP History" option.
      Then The User waits till the page gets loaded.
      Then The User verifies Selected "Time Resolution of VIP History" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.
  
  @Regression @VIPAnalytics 
  Scenario: Verify the Dropdown Value of "Quality KPI" Tab in "VIP Explore" Sheet. 
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Quality KPI/Quality KPI of VIP Explore" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.
      Given Close The child Browser Object. 
  
  @Regression @VIPAnalytics
  Scenario: Verify the Dropdown Value of "Quantity KPI" Tab in "VIP Explore" Sheet. 
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Quantity KPI/Quantity KPI of VIP Explore" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
      Given Close The child Browser Object. 
      
   @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Time Resolution for Quality KPI" Tab in "VIP Explore" Sheet. 
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Time Resolution for Quality KPI of VIP Explore" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
      Given Close The child Browser Object.
                      
      @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Time Resolution for Quantity KPI" Tab in "VIP Explore" Sheet. 
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Time Resolution for Quantity KPI of VIP Explore" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet. 
      Given Close The child Browser Object.   
      
       @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Dimension for Quality KPI" Tab in "VIP Explore" Sheet. 
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Dimension for Quality KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.           
  		Given Close The child Browser Object. 
       
      @Regression @VIPAnalytics
    Scenario: Verify the Dropdown Value of "Dimension for Quantity KPI" Tab in "VIP Explore" Sheet.  
      When The User Clicks on "Explore Icon" option. 
      Then The User waits till the page gets loaded.
      When The User Clicks on "Explore App" option. 
      Then The User waits till the page gets loaded. 
      Then The User verifies Selected "Dimension for Quantity KPI" values from differents dropdown list for "VIP Analytics_Automation" app and "VIP Analytics" sheet.           
  		Given Close The child Browser Object.   
      
      
      @Regression @VIPAnalytics
     Scenario: Run Hourly Aggregation for Engineering, Minimized Engineering, VIP 
      Then Verify the columns of "Hourly Aggregation of output_minimized_engineering" files from "VIP Analytics" sheet.
      Then Verify the columns of "Hourly Aggregation of output_engineering" files from "VIP Analytics" sheet.
      Then Verify the columns of "Hourly Aggregation of output_output_vip" files from "VIP Analytics" sheet.
      
      @Regression @VIPAnalytics
     Scenario: Run Hourly Aggregation for Business 
      Then Verify the columns of "Hourly Aggregation of Business" files from "VIP Analytics" sheet.
      
       @Regression @VIPAnalytics
     Scenario: Run Hourly Aggregation for Subscriber 
      Then Verify the columns of "Hourly Aggregation of Subscriber" files from "VIP Analytics" sheet.
      
            @Regression @VIPAnalytics 
     Scenario: Run Daily Aggregation for Engineering, Minimized Engineering, VIP 
      Then Verify the columns of "Daily Aggregation of output_minimized_engineering" files from "VIP Analytics" sheet.
      Then Verify the columns of "Daily Aggregation of output_engineering" files from "VIP Analytics" sheet.
      Then Verify the columns of "Daily Aggregation of output_output_vip" files from "VIP Analytics" sheet.
      Then Verify the columns of "Daily Aggregation of output_VIP history" files from "VIP Analytics" sheet.
      
       @Regression @VIPAnalytics
     Scenario: Run Daily Aggregation for Business 
      Then Verify the columns of "Hourly Aggregation of Business" files from "VIP Analytics" sheet.
      
       @Regression @VIPAnalytics
     Scenario: Run Daily Aggregation for Subscriber 
      Then Verify the columns of "Hourly Aggregation of Subscriber" files from "VIP Analytics" sheet.
      
      
                                
Feature: Verify the Functionalities of FM Analytics App

  Background: Precondition Steps
    Given The User has logged in to portal as "Participant".
    When The User may click on "publish" button.
    Then The User waits more extra time to page gets loaded.
    Then The User may click on "search i-con" link of "search" section.
    Then The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    Then The User may click on "close" link of "search" section.
    Then The User enters "FM Analytics - FMA - fm_lte_Automation" in "search box" field.
    Then The User waits till the page gets loaded.
    Then User expects the text for "FM Analytics - FMA - fm_lte_Automation".
    Then The User waits till the page gets loaded.
    When The User Clicks on "FM Analytics - FMA - fm_lte_Automation" option.
    Then The User waits more extra time to page gets loaded.
    #Then The User Clicks on "Alarms Status sheet" image link from "sheet" section.
    #Then The User may click on "Alarms Status" link of "sheet" section.
    #Then The User waits till the page gets loaded.
    Then The User waits more extra time to page gets loaded.
    Then The user will be redirected to "FM Analytics - FMA - fm_lte_Automation" page.
    
    @Regression @FMAnalytics 
  Scenario: Verify the list of different Sheets exist in a Analysis tab of "FM Analytics - FMA - fm_lte_Automation" 
    When The User Clicks on "Sheets Button" option.
    Then The User waits more extra time to page gets loaded.
    Then The User waits till the page gets loaded.
    Then User verifies the "Alarms Status sheet" exists in the "FM Analytics - FMA - fm_lte_Automation" page.
    Then User verifies the "Alarms Analysis sheet" exists in the "FM Analytics - FMA - fm_lte_Automation" page.
    
    @Regression @FMAnalytics 
  Scenario: Verify the information label exist in Alarms Status sheet of "FM Analytics"
    Then User verifies the "Alarms Status in the last 24 hours  ( 11.17.2022 03 - 11.18.2022 02)" exists in the "Analysis tab" page.

  @Regression @FMAnalytics 
  Scenario: Verify the list of different filters exist in a Analysis tab of "Alarms Status"
    Then User verifies the "Tech Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Vendor Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "NE/RNC/BSC Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Site Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Cell Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "NE Level Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Severity Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Alarm type Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Date and Hour Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
  Scenario: Verify the list of different No. of alarms according to the artifacts in a Analysis tab of "Alarms Status"
    Then The User waits till the page gets loaded.
    Then User verifies the "No. of critical alarms from artifacts" exists in the "Analysis tab" page.
    Then User verifies the "No. of major alarms from artifacts" exists in the "Analysis tab" page.
    Then User verifies the "No. of minor alarms from artifacts" exists in the "Analysis tab" page.
    Then User verifies the "No. of warning alarms from artifacts" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
  Scenario: Verify the Zoom-in button and verify the map name in  "Alarms Status" sheet.
    When The User Clicks on "Zoom-in" option.
    Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
    Then User verifies the "Alarms Map" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
    
    @Regression @FMAnalytics 
  Scenario: Verify the Zoom-out button and verify the map name in  "Alarms Status" sheet.
    When The User Clicks on "Zoom-out" option.
    Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
    Then User verifies the "Alarms Map" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
   
    
    @Regression @FMAnalytics 
  Scenario: Verify the Severity Hourly Time Trend stacked bar exist in a Analysis tab of "Alarms Status"
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
    Then User verifies the "Severity Hourly Time Trend stacked Bar" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
  Scenario: Verify the Severity Hourly Time Trend according to artifacts of "Alarms Status" sheet.
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded. 
    When The User Right Clicks on "Severity Hourly Time Trend stacked Bar" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportSeverityHourlyTimeTrendfromArtifacts" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedSeverityHourlyTimeTrendfromArtifacts" file and actual "exportSeverityHourlyTimeTrendfromArtifacts" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    
    @Regression @FMAnalytics  
  Scenario: Apply some filter and verify the Severity Hourly Time Trend stacked bar according to artifacts of "Alarms Status" sheet.
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded. 
    When The User Clicks on "Site of top level filter" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Site:DPT047B2" option.
    When The User Clicks on "Site:DPT048B2" option.
    When The User Clicks on "Site:MAV038B2" option.
    When The User Clicks on "Site:DPT067B2" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Confirm selection of fm app" option.
    Then The User waits till the page gets loaded. 
    When The User Right Clicks on "Severity Hourly Time Trend stacked Bar" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportStackedBar_after_apply_filter" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedStackedBar_after_apply_filter" file and actual "exportStackedBar_after_apply_filter" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    
    
    @Regression @FMAnalytics 
    Scenario: Verify the list of different filters exist in a Analysis tab of "Alarms Analysis"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Tech Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Vendor Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "NE/RNC/BSC Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Site Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Cell Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "NE Level Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Severity Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Alarm type Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Hour Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Then User verifies the "Date Drop Down of FM Analytics APP" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Time Resolution" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Time Resolution" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet.    
   
   
       @Regression @FMAnalytics 
    Scenario: Verify the X-axis and Y-axis of Time Trend of "Alarms Analysis"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Analyze By Dropdown list item" option.
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Cell of Analyze By" option.
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Y axis of Time trend stacked bar" exists in the "Analysis tab" page.
    Then User verifies the "X axis of Time trend stacked bar" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
   
   
   
   @Regression @FMAnalytics 
    Scenario: Verify the Time trend title according to selected resolution in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Time Resolution Dropdown list item" option.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Hourly of Time Resolution" option.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Severity Distribution Time Trend Hourly" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
    
    
       
       @Regression @FMAnalytics 
    Scenario: Verify the Time trend title according to selected resolution in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Time Resolution Dropdown list item" option.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Daily of Time Resolution" option.
      Then The User waits more extra time to page gets loaded.
       Then User verifies the "Severity Distribution Time Trend Daily" exists in the "Analysis tab" page.
       Then The User waits more extra time to page gets loaded.
    
   
   
   @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Analyze By" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Analyze By" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet. 
      
      
      @Regression @FMAnalytics 
    Scenario: Select property as "Cell" from time trend and varify with artifacts of "Alarms Analysis"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Analyze By Dropdown list item" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Cell of Analyze By" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Confirm selection of fm app" option.
     Then The User waits till the page gets loaded.
     Then User verifies the "Cell Distribution Time Trend Hourly" exists in the "Analysis tab" page.
     When The User Right Clicks on "Cell Distribution Time Trend Hourly" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "export_Cell_Value_from_time_trend" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "Expected_Cell_Value_from_time_trend" file and actual "export_Cell_Value_from_time_trend" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded. 
    
    
    @Regression @FMAnalytics 
    Scenario: Select property as "Alarm Type" from time trend and varify with artifacts of "Alarms Analysis"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Analyze By Dropdown list item" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Alarm Type of Analyze By" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Confirm selection of fm app" option.
     Then The User waits till the page gets loaded.
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Time Resolution Dropdown list item" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Daily of Time Resolution" option.
     Then The User waits till the page gets loaded. 
     When The User Clicks on "Confirm selection of fm app" option.
     Then User verifies the "Alarm Type Distribution Time Trend Daily" exists in the "Analysis tab" page.
     When The User Right Clicks on "Alarm Type Distribution Time Trend Daily" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
     #Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "export_AlarmsType_from_TimeTrendDaily" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "Expected_AlarmsType_from_TimeTrendDaily" file and actual "export_AlarmsType_from_TimeTrendDaily" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.  
   
   @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Property" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Property" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet.   
      
      
      
   
   @Regression @FMAnalytics 
    Scenario: Verify two tab "Cell" and "Site" of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Alarms Properties Table" exists in the "Analysis tab" page.
      Then User verifies the "Cells of Alarms Properties Table" exists in the "Analysis tab" page. 
      Then User verifies the "Sites of Alarms Properties Table" exists in the "Analysis tab" page.   
      
      @Regression @FMAnalytics 
    Scenario: Verify the map title according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Severity of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		#Then The User waits till the page gets loaded.
   		When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Alarms Severity Map" exists in the "Analysis tab" page.
   
   @Regression @FMAnalytics 
    Scenario: Verify the map title according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Alarm Type of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Alarms Alarm Type Map" exists in the "Analysis tab" page.
      Then The User waits more extra time to page gets loaded.
      
      
      
      @Regression @FMAnalytics 
    Scenario: Verify the "Cell" tab according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Severity of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then User verifies the "Alarms Properties Table" exists in the "Analysis tab" page.
      #When The User Clicks on "Cells of Alarms Properties Table" option. 
      Then User verifies the "Cell Name of Alarms Properties Table" exists in the "Analysis tab" page.
      Then User verifies the "Cell Alarms (Severity)" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
      
      @Regression @FMAnalytics 
    Scenario: Verify the "Cell" tab according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Alarm Type of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		Then The User waits more extra time to page gets loaded.
   		#Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then User verifies the "Alarms Properties Table" exists in the "Analysis tab" page.
      #When The User Clicks on "Cells of Alarms Properties Table" option. 
      Then User verifies the "Cell Name of Alarms Properties Table" exists in the "Analysis tab" page.
      Then User verifies the "Cell Alarms (Alarm Type)" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
       
       
       @Regression @FMAnalytics 
    Scenario: Verify the "Site" tab according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Severity of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		#Then The User waits till the page gets loaded.
   		When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then User verifies the "Alarms Properties Table" exists in the "Analysis tab" page.
      #When The User Clicks on "Full Screen ofAlarms Properties Table" option.
      #Then The User waits till the page gets loaded.
      When The User Clicks on "Sites of Alarms Properties Table" option. 
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Site Name of Alarms Properties Table" exists in the "Analysis tab" page.
      Then User verifies the "Site Alarms (Severity)" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
      
      
       @Regression @FMAnalytics 
    Scenario: Verify the "Site" tab according to selected property of "Alarms Properties Table"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Property Dropdown list item" option. 
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
   		When The User Clicks on "Alarm Type of Property Dropdown" option.
   		Then The User waits till the page gets loaded.
   		#Then The User waits till the page gets loaded.
   		When The User Clicks on "Confirm selection of fm app" option.
   		When The User Clicks on "Exit full screen of Property dropdown" option.
   		Then The User waits till the page gets loaded.
      Then User verifies the "Alarms Properties Table" exists in the "Analysis tab" page.
      #When The User Clicks on "Full Screen ofAlarms Properties Table" option.
      #Then The User waits till the page gets loaded.
      When The User Clicks on "Sites of Alarms Properties Table" option. 
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Site Name of Alarms Properties Table" exists in the "Analysis tab" page.
      Then User verifies the "Site Alarms (Alarm Type)" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
      
      
      @Regression @FMAnalytics 
  Scenario: Verify by default all the severities should be selected and it should be multi selected dropdown of "No. of Alarms map"
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
       When The User Clicks on "Selected severity" option.
       Then The User waits till the page gets loaded.
       Then User verifies the "Selected Critical alarm" exists in the "Analysis tab" page.
       Then User verifies the "Selected warning alarm" exists in the "Analysis tab" page.
       Then User verifies the "Selected major alarm" exists in the "Analysis tab" page.
       Then User verifies the "Selected minor alarm" exists in the "Analysis tab" page.
       Then The User waits till the page gets loaded.
       When The User Clicks on "Unselect Severity" option.
       Then The User waits till the page gets loaded.
       When The User Clicks on "select major filter from no. of alarms map" option.
       Then The User waits till the page gets loaded.
       When The User Clicks on "select critical filter from no. of alarms map" option.
       Then The User waits till the page gets loaded.
       Then The User waits till the page gets loaded.
       
      
      @Regression @FMAnalytics 
    Scenario: Verify two tab "Cell" and "Site" of "No. of Alarms map"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "No. of Alarms Map" exists in the "Analysis tab" page.
      Then User verifies the "No. of Alarms Table" exists in the "Analysis tab" page.
      Then User verifies the "Cells of No. of Alarms Table" exists in the "Analysis tab" page. 
      Then User verifies the "Sites of No. of Alarms Table" exists in the "Analysis tab" page.
      
      
            
      @Regression @FMAnalytics 
    Scenario: Verify the list of different columns exist in "Cell" tab of "No. of Alarms map"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "No. of Alarms Table" exists in the "Analysis tab" page.
      Then User verifies the "Cells of No. of Alarms Table" exists in the "Analysis tab" page.
      When The User Clicks on "Cells of No. of Alarms Table" option.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Full Screen of No. of Alarms Map" option.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Cell Name of No. of Alarms Table" exists in the "Analysis tab" page.
      Then User verifies the "No. of Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Critical Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Major Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Minor Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Warning Alarms" exists in the "Analysis tab" page. 
      When The User Clicks on "Exit full screen of No. of Alarms Map" option.
    Then The User waits till the page gets loaded.
      
      @Regression @FMAnalytics 
    Scenario: Verify the list of different columns exist in "Site" tab of "No. of Alarms map"
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "No. of Alarms Table" exists in the "Analysis tab" page.
      Then User verifies the "Sites of No. of Alarms Table" exists in the "Analysis tab" page.
      When The User Clicks on "Sites of No. of Alarms Table" option.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Full Screen of No. of Alarms Map" option.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Site Name of No. of Alarms Table" exists in the "Analysis tab" page.
      Then User verifies the "No. of Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Critical Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Major Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Minor Alarms" exists in the "Analysis tab" page.
      Then User verifies the "No. of Warning Alarms" exists in the "Analysis tab" page. 
      When The User Clicks on "Exit full screen of No. of Alarms Map" option.
      Then The User waits more extra time to page gets loaded.
      
      
      @Regression @FMAnalytics  
    Scenario: Verify the list of different columns exist in "Alarm detailed table" 
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Alarm ID of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Date of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Hour of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Site of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Cell of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Severity of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Raised Time of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Dropped Time of Detailed Table" exists in the "Analysis tab" page.
    Then User verifies the "Alarm Type of Detailed Table" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    @Regression @FMAnalytics 
  Scenario: Verify the table should be sorted according to "Alarm ID" in "Alarm detailed table" 
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
       When The User Right Clicks on "Detailed Table" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportSortedAlarmIDfromAlarmDetailedTable" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedSortedAlarmIDfromAlarmDetailedTable" file and actual "exportSortedAlarmIDfromAlarmDetailedTable" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
    Scenario: Verify the corresponding column list exist in "Alarm detailed table"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Column List" exists in the "Analysis tab" page.
    Then User verifies the "Tech. of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Vendor of Column List" exists in the "Analysis tab" page.
    Then User verifies the "NE/RNC/BSC of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Site of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Cell of Column List" exists in the "Analysis tab" page.
    Then User verifies the "NE Level of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Severity of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Raised Time of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Dropped Time of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Alarm Type of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Specific Problem of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Alarm Object Name of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Alarm Object Type of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Location Name of Column List" exists in the "Analysis tab" page.
    Then User verifies the "Probable Cause of Column List" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.
    
    
     @Regression @FMAnalytics 
     Scenario: Verify the selected and unselected columns in "Alarm detailed table"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then The User does Scroll down to "Tech. of Column List" element.
     When The User Clicks on "Tech. of Column List" option.                                                                                                                                                                                                                                                                                                   
     When The User Clicks on "Vendor of Column List" option.
     When The User Clicks on "NE/RNC/BSC of Column List" option.
     When The User Clicks on "NE Level of Column List" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Confirm selection for detailed table" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Technology of Detailed Table" exists in the "Analysis tab" page.
     Then User verifies the "Vendor of Detailed Table" exists in the "Analysis tab" page.
     Then User verifies the "NE/RNC/BSC of Detailed Table" exists in the "Analysis tab" page.
     Then User verifies the "NE Level of Detailed Table" exists in the "Analysis tab" page.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     When The User Clicks on "Tech. of Column List" option.
     When The User Clicks on "Confirm selection for detailed table" option.
     #Then The User waits till the page gets loaded.
     When The User Clicks on "Selected vendor" option.
     When The User Clicks on "Confirm selection for detailed table" option.
     #Then The User waits till the page gets loaded. 
     When The User Clicks on "Selected NE/RNC/BSC" option.
     When The User Clicks on "Confirm selection for detailed table" option.
     When The User Clicks on "Selected NE Level" option.
     When The User Clicks on "Confirm selection for detailed table" option.
     Then The User waits more extra time to page gets loaded.
     #When The User Clicks on "Confirm selection for detailed table" option.
     Then The User waits till the page gets loaded. 
     #Then The User waits more extra time to page gets loaded.
     Then User verifies the "Technology of Detailed Table" does not exists in the "Analysis tab" page.
     Then User verifies the "Vendor of Detailed Table" does not exists in the "Analysis tab" page.
     Then User verifies the "NE/RNC/BSC of Detailed Table" does not exists in the "Analysis tab" page.
     Then User verifies the "NE Level of Detailed Table" does not exists in the "Analysis tab" page.
     Then The User waits till the page gets loaded. 
     
     
      @Regression @FMAnalytics 
  Scenario: Apply date filter and verify raised and dropped time according to artifacts from "Alarm detailed table"
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Date filter of detailed table" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "11.18.2022:detailed table" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Confirm selection of fm app" option.
    Then The User waits more extra time to page gets loaded.
    When The User Right Clicks on "Detailed Table" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "export18novDateDetailsfromDetailsTable" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "Expected18novDateDetailsfromDetailsTable" file and actual "export18novDateDetailsfromDetailsTable" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    
    @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Stack by" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Stack By 1" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet. 
      
      
      @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Analyze By" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Analyze By Stacked bar Dropdown 1" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet. 
      
      
      @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Stack by" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Stack By 2" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet. 
      
      
      @Regression @FMAnalytics 
    Scenario: Verify the Dropdown Value of "Analyze By" Tab in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then The User verifies Selected "Analyze By Stacked bar Dropdown 2" values from differents dropdown list for "FM Analytics - FMA - fm_lte_Automation" app and "Alarms Analysis" sheet. 
      
      
      
      @Regression @FMAnalytics 
    Scenario: Verify two  "Analyze By & Stacked by" Stacked bar present in "Alarms Analysis" Sheet.
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      Then User verifies the "Analyze By Stacked bar 1" exists in the "Analysis tab" page.
      Then User verifies the "Analyze By Stacked bar 2" exists in the "Analysis tab" page.
     Then The User waits till the page gets loaded.
     
     
     @Regression @FMAnalytics 
    Scenario: Verify the X-axis and Y-axis according to selected dropdown value from "Analyze by" and "Stack by" and Verify the no. of alarms with artifacts in "Analyze By Stacked bar 1".
      When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Analyze By Stacked bar Dropdown list item 1" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Technology of Analyze By Dropdown 1" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection for detailed table" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Stack By Dropdown list item 1" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "NE Level of Stack By Dropdown 1" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection for detailed table" option.
      Then User verifies the "Title of Analyze By Stacked bar 1" exists in the "Analysis tab" page.
      Then User verifies the "Y axis for stacked by" exists in the "Analysis tab" page.
      Then User verifies the "Y axis for analyze by" exists in the "Analysis tab" page.
      Then User verifies the "X axis for stack by and analyze by" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
      When The User Right Clicks on "Title of Analyze By Stacked bar 1" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "export_AnalyzeBy_StackBy" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "Expected_AnalyzeBy_StackBy" file and actual "export_AnalyzeBy_StackBy" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
     
      
      
           @Regression @FMAnalytics 
    Scenario: Verify the X-axis and Y-axis according to selected dropdown value from "Analyze by" and "Stack by" and Verify the no. of alarms with artifacts in "Analyze By Stacked bar 2".
			When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Analyze By Stacked bar Dropdown list item 2" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "NE Level of Analyze By Dropdown 2" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection for detailed table" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Stack By Dropdown list item 2" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Alarm Type of Stack By Dropdown 2" option.
      Then The User waits till the page gets loaded.
      When The User Clicks on "Confirm selection for detailed table" option.
      Then User verifies the "Title of Analyze By Stacked bar 2" exists in the "Analysis tab" page.
      Then User verifies the "Y axis for stacked by 2" exists in the "Analysis tab" page.
      Then User verifies the "Y axis for analyze by 2" exists in the "Analysis tab" page.
      Then User verifies the "X axis for stack by and analyze by 2" exists in the "Analysis tab" page.
      Then The User waits till the page gets loaded.
      When The User Right Clicks on "Title of Analyze By Stacked bar 2" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "export_AnalyzeBy_StackBy_2" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "Expected_AnalyzeBy_StackBy_2" file and actual "export_AnalyzeBy_StackBy_2" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
     
      
      
      
      @Regression @FMAnalytics  
    Scenario: Verify the different name of dimensions and measure of "Statistics Pivot Table"
     When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded. 
     Then The User waits more extra time to page gets loaded.
     Then User verifies the "Statistics Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Date of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Hour of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Technology of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Vendor of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "NE/RNC/BSC of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Site of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Cell of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Alarm Type of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "Severity of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "No. of Alarms of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "No. of Critical Alarms of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "No. of Major Alarms of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "No. of Minor Alarms of Pivot Table" exists in the "Analysis tab" page.
    Then User verifies the "No. of Warning Alarms of Pivot Table" exists in the "Analysis tab" page.
    Given The User waits till the page gets loaded.   
  
     
     
     @Regression @FMAnalytics 
  Scenario: Verify the Time trend according to selected resolution in "Alarms Analysis" Sheet.
  When The User Clicks on "Next sheet link of Alarms Analysis" option.
     Then The User waits till the page gets loaded.
    When The User Right Clicks on "Severity Distribution Time Trend Hourly" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportSeverityDistributionTimeTrendhourly" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedSeverityDistributionTimeTrendhourly" file and actual "exportSeverityDistributionTimeTrendhourly" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    @Regression @FMAnalytics 
  Scenario: Verify the Time trend according to selected resolution in "Alarms Analysis" Sheet.
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Time Resolution Dropdown list item" option.
      Then The User waits more extra time to page gets loaded.
      When The User Clicks on "Daily of Time Resolution" option.
      Then The User waits more extra time to page gets loaded.
       #Then User verifies the "Severity Distribution Time Trend Daily" exists in the "Analysis tab" page.
    When The User Clicks on "Confirm selection of fm app" option.
    Then The User waits more extra time to page gets loaded.
    When The User Right Clicks on "Severity Distribution Time Trend Daily" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportSeverityDistributionTimeTrendDaily" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedSeverityDistributionTimeTrendDaily" file and actual "exportSeverityDistributionTimeTrendDaily" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
     
      @Regression @FMAnalytics 
  Scenario: Verify the No. of alarms should be matched with artifacts of "Statistics Pivot Table"
    Given The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Next sheet link of Alarms Analysis" option.
      Then The User waits till the page gets loaded.
    When The User Right Clicks on "Statistics Pivot Table" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Download as of severity time trend" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "Data of Download as" option.
    Then The User waits till the page gets loaded.
    When The User Clicks on "export-url" option.
    Then The User waits more extra time to page gets loaded.
    When The User Clicks on "close button" option.
    Then The User renames the downloaded excel file as "exportStatisticsPivotTable" and copy the file in "FM Analytics - FMA - fm_lte_Automation" folder.
    Then The User waits till the page gets loaded.
    Then User compares the two excel file between expected "ExpectedStatisticsPivotTable" file and actual "exportStatisticsPivotTable" file for the "FM Analytics - FMA - fm_lte_Automation" App.
    Given The User waits till the page gets loaded.
    
    
    
                       
     
    
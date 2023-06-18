Feature: Verify the Functionalities of VDT Layer3 Engnieering App

Background: Precondition Steps
   
   Given The User has logged in to portal as "Participant".
	 When  The User may click on "publish" button.
	 Then  The User waits till the page gets loaded.
	 Then  The User waits more extra time to page gets loaded.
	 Then  The User may click on "search i-con" link of "search" section.
	 Then  The User waits till the page gets loaded.
	 Then  The User may click on "close" link of "search" section.
	 Then  The User enters "VDT Layer 3 - QA" in "search box" field.  
	 Given The User waits till the page gets loaded.
	 Then  User expects the text for "VDT Layer 3 - QA".
	 When  The User Clicks on "VDT Layer 3 - QA" option.
	 Given The User waits till the page gets loaded.
	 Then  The User waits more extra time to page gets loaded.
	 #Then  The user will be redirected to "VDT Layer 3 - QA Sheet" page.
	 #Then  The User Clicks on "VDT L3 - QA Sheet" image link from "sheet" section.
	 #Then  The User waits till the page gets loaded.
	 #Then  The User waits more extra time to page gets loaded.
	 Then  The user will be redirected to "VDT Layer 3 - QA" page.
	
@Regression
@VDTLayer3QA
Scenario: Verify the "VDT Layer 3 - IMSI" exists under a "VDT Layer 3 - QA"

	 Then  User expects the text for "VDT Layer 3 - IMSI: 268032106419051".
	 Given The User waits till the page gets loaded.
	
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default Value of "Select KPI Drop Down" from "VDT Time Trend".

   When  The User Clicks on "Select KPI Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   Then  User expects the text "RSRP/RSCP (dBm)" from "Select KPI Drop Down".	
	
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default Value of "Color By Propertey Drop Down" from "VDT Time Trend".

   When  The User Clicks on "Color By Property Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   Then  User expects the text "Call ID" from "Color By Property Drop Down".	

@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default Value of "Color By KPI Drop Down" from "Color By KPI Map".

   When  The User Clicks on "Color By KPI Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   Then  User expects the text "RSRP/RSCP (dBm)" from "Color By KPI Drop Down".	

@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default Value of "Color By Property Drop Down" from "Color By Property Map".

   When  The User Clicks on "Color By Property Map Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   Then  User expects the text "Call ID" from "Color By Property Map Drop Down".	

@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default Value of "Aggr Method Drop Down" from "Aggregation Method Value".

   When  The User Clicks on "Aggregation Method Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   Then  User expects the text "Avg. Value" from "Aggr Method Drop Down".	
                    			
@Regression
@VDTLayer3QA
Scenario: Verify the list of different components exist in a Analysis tab of "VDT Layer 3 - QA"

	 Then  User verifies the "Call ID Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	 Then  User verifies the "Vendor Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	 Then  User verifies the "Tech Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	 Then  User verifies the "Primary Cell Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	 Then  User verifies the "Date Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	 Then  User verifies the "Hour Drop Down of VDT Layer 3 - QA APP" exists in the "Analysis tab" page.
	
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of different KPIs exist in "Select KPI for VDT Time Trend" drop down of "VDT Layer 3 - QA"
 
   Then  The User verifies Selected "Select KPI" values from differents dropdown list for "VDT Layer 3 - QA" app and "VDT Layer 3 - IMSI: 268032106419051" sheet.

@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of different Values exist in "Color By Property for VDT Time Trend" drop down of "VDT Layer 3 - QA"
 
   Then  The User verifies Selected "Color By Property" values from differents dropdown list for "VDT Layer 3 - QA" app and "VDT Layer 3 - IMSI: 268032106419051" sheet.
     
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of different Values exist in "Color By KPI MAP" drop down of "VDT Layer 3 - QA"
 
   Then  The User verifies Selected "Color By KPI Map" values from differents dropdown list for "VDT Layer 3 - QA" app and "VDT Layer 3 - IMSI: 268032106419051" sheet.
 
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of different Values exist in "Color By Property MAP" drop down of "VDT Layer 3 - QA"
 
   Then  The User verifies Selected "Color By Property Map" values from differents dropdown list for "VDT Layer 3 - QA" app and "VDT Layer 3 - IMSI: 268032106419051" sheet.
 
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of different Values exist in "Aggr Method for Map" drop down of "VDT Layer 3 - QA"
 
   Then  The User verifies Selected "Aggr Method" values from differents dropdown list for "VDT Layer 3 - QA" app and "VDT Layer 3 - IMSI: 268032106419051" sheet.
                    
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the selected "KPI" name and selected "Color By Property" name "Y-axis" and "X-axis" wise.
       
   When  The User Clicks on "Select KPI Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded. 
   When  The User Clicks on "DL Throughput (Mbps)" option.
   When  The User Clicks on "selectLink" option.
   When  The User Clicks on "Color By Property Drop Down of VDT Layer 3 - QA APP" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Technology" option.
   When  The User Clicks on "selectLink" option.
   Then  User expects the text "DL Throughput (Mbps)" from "Y-axis".
   Then  User expects the text "Timestamp,Technology" from "X-axis".
   
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Compare and validate all the data from event Table with baseline sheet.
   
   When  The User Right Clicks on "More link from Event Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportEventTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares the two excel file between expected "expectedEventTable" file and actual "exportEventTable" file for the "VDT Layer 3 - QA" App.
   
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the default selection of list of columns for Event Table.  
   
   When  The User Right Clicks on "More link of column list section from Event Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Export data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportdefaultColumnsListofEventTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares the two excel file between expected "expecteddefaultColumnsListofEventTable" file and actual "exportdefaultColumnsListofEventTable" file for the "VDT Layer 3 - QA" App.
     
@Sanity	
@Regression
@VDTLayer3QA
Scenario: Verify the list of column of event table is showing according to the selected column of column list section.
        
   When  The User Right Clicks on "More link from Event Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportEventTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares only those rows present in the expected "expectedColumnsListofEventTable" file with actual "exportEventTable" file for the "VDT Layer 3 - QA" App.
                       
@Sanity	
@Regression
@VDTLayer3QA 
Scenario: Compare and validate all the data from event Table with baseline sheet.
   
   When  The User Right Clicks on "More link from Flow Diagram Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportFlowDiagramTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares the two excel file between expected "expectedFlowDiagramTable" file and actual "exportFlowDiagramTable" file for the "VDT Layer 3 - QA" App.

@Sanity	
@Regression
@VDTLayer3QA   
Scenario: Verify the default selection of list of columns for Flow Diagram Table.  
   
   When  The User Right Clicks on "More link of column list section from flow diagram Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Export data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportdefaultColumnsListofFlowdiagramTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares the two excel file between expected "expecteddefaultColumnsListofFlowDiagramTable" file and actual "exportdefaultColumnsListofFlowdiagramTable" file for the "VDT Layer 3 - QA" App.
   
@Sanity	
@Regression
@VDTLayer3QA 
Scenario: Verify the list of column of flow diagram table is showing according to the selected column of column list section.
        
   When  The User Right Clicks on "More link from Flow Diagram Table" option.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "Download as" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Data" option.
   Then  The User waits till the page gets loaded.
   When  The User Clicks on "Click here to download your data file." option.
   #Then  The User waits till the page gets loaded.
   Then  The User waits more extra time to page gets loaded.
   When  The User Clicks on "close button of download popup" option.
   Then  The User renames the downloaded excel file as "exportFlowDiagramTable" and copy the file in "VDT Layer 3 - QA" folder.
   Then  The User waits till the page gets loaded.
   Then  User compares only those rows present in the expected "expectedColumnsListofFlowDiagramTable" file with actual "exportFlowDiagramTable" file for the "VDT Layer 3 - QA" App.                            
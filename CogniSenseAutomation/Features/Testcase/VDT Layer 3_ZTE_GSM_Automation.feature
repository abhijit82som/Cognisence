Feature: Verify the Functionalities of VDT Layer3 Engnieering App

Background: Precondition Steps
    Given The User has logged in to portal as "Participant".
    When The User may click on "publish" button.
    Then The User waits more extra time to page gets loaded.
    Then The User may click on "search i-con" link of "search" section.
    Then The User waits till the page gets loaded.
    Then The User waits till the page gets loaded.
    Then The User may click on "close" link of "search" section.
    Then The User enters "VDT Layer 3_ZTE_GSM_Automation" in "search box" field.
    Then The User waits till the page gets loaded.
    #Then User expects the text for "VDT Layer 3_ZTE_GSM_Automation".
    #Then The User waits till the page gets loaded.
    When The User Clicks on "VDT Layer 3_ZTE_GSM_Automation" option.
    Then The User waits more extra time to page gets loaded.
    #Then The User Clicks on "Alarms Status sheet" image link from "sheet" section.
    #Then The User may click on "Alarms Status" link of "sheet" section.
    #Then The User waits till the page gets loaded.
    Then The User waits more extra time to page gets loaded.
    Then The user will be redirected to "VDT Layer 3_ZTE_GSM_Automation" page.
	
@Regression

Scenario: Verify the "VDT Layer 3 - IMSI" exists under a "VDT Layer 3 - QA"

	 Then User verifies the "VDT Layer 3 - IMSI: 410060006810202" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
	 Given The User waits till the page gets loaded.
	 
	 
	@Regression

Scenario: Verify the "VDT Layer 3 - IMSI" exists under a "VDT Layer 3 - QA"
		When The User Clicks on "Vendor of VDT L3" option.
    Then The User waits more extra time to page gets loaded. 
	  Then User verifies the "Vendor name (ZTE)" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
	  Given The User waits till the page gets loaded.
	  When The User Clicks on "Tech. of VDT L3" option.
    Then The User waits more extra time to page gets loaded. 
	  Then User verifies the "Tech. name (GSM)" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
	  Given The User waits till the page gets loaded.
	
	@Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   Then User verifies the "Event Time of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "Call ID of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "No. of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
    Then User verifies the "Event Name of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
    Then User verifies the "Direction of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
    Then User verifies the "UE of Flow Diagram Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
    Given The User waits till the page gets loaded.
    
  
  @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   Then User verifies the "Candidate PCI/SC/BSIC 1" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "Candidate RSRP/RSCP/DL RxLevel 1" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   
   
   @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   When The User Right Clicks on "RSRP/RSCP (dBm) of VDT L3" option.
   Then The User waits till the page gets loaded.
   When The User Clicks on "Full Screen VDT L3" option. 
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   Then User verifies the "DL RxLevel (dBm) of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page. 
   Then User verifies the "DL RxQual of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "UL RxLevel (dBm) of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "UL RxQual of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "RSRP S-CELL (dBm) of VDT L3" does not exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "RSRQ S-CELL (dB) of VDT L3" does not exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   
   
   @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   When The User Right Clicks on "RSRP/RSCP (dBm) of KPI map" option.
   Then The User waits till the page gets loaded.
   When The User Clicks on "Full Screen VDT L3" option. 
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   Then User verifies the "DL RxLevel (dBm) of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page. 
   Then User verifies the "DL RxQual of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "UL RxLevel (dBm) of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "UL RxQual of VDT L3" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "RSRP S-CELL (dBm) of VDT L3" does not exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "RSRQ S-CELL (dB) of VDT L3" does not exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   
   
   @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   When The User Clicks on "Search of Event table" option. 
   Then The User waits till the page gets loaded.
   When The User Clicks on "Selection menu of Event table" option. 
   Then The User waits till the page gets loaded.
   When The User Clicks on "Clear Selection of Event table" option. 
   Then The User waits till the page gets loaded.
   When The User Clicks on "Confirm selection of VDT L3" option. 
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   Then User verifies the "Call ID of Event Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page. 
   Then User verifies the "Event Time of Event Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   Then User verifies the "No. of Event Table" exists in the "VDT Layer 3 - IMSI: 410060006810202" page.
   
   
   @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   Then User verifies the "Active UL RxLevel 1" exists in the "Event table of VDT Layer 3" page. 
   Then User verifies the "Active UL RxQual 1" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Timing Advance (meters)" exists in the "Event table of VDT Layer 3" page.
   
   
    @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   When The User Clicks on "Timing Advance (meters)" option. 
   When The User Clicks on "Active UL RxLevel 1" option.
   When The User Clicks on "Active UL RxQual 1" option.
   Then The User waits till the page gets loaded.
   Then The User waits till the page gets loaded.
   Then User verifies the "Timing Advance (meters) in Event table" exists in the "Event table of VDT Layer 3" page. 
   Then User verifies the "Active UL RxLevel 1 in Event table" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Active UL RxQual 1 in Event table" exists in the "Event table of VDT Layer 3" page.
   
   
   @Regression      
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   Then User verifies the "Active RNC/BSC 1" exists in the "Event table of VDT Layer 3" page. 
   Then User verifies the "Active PCI/SC/BSIC 1" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Active RSRP/RSCP/DL RxLevel 1" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Active RSRQ/ECIO/DL RxQual 1" exists in the "Event table of VDT Layer 3" page.
   Then The User does Scroll down to "Active RSRQ/ECIO/DL RxQual 1" element. 
   Then User verifies the "Candidate RNC/BSC 1" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Candidate PCI/SC/BSIC 1" exists in the "Event table of VDT Layer 3" page.
   Then User verifies the "Candidate RSRP/RSCP/RxLevel 1" exists in the "Event table of VDT Layer 3" page.
   
   
   @Regression @Test     
  Scenario: Verify the list of different column exist in Flow Diagram table of "VDT Layer 3 - IMSI: 410060006810202"
   Then The User waits till the page gets loaded.
   Then User verifies the "BTS" exists in the "Flow diagram table of VDT Layer 3" page. 
   Then User verifies the "MSC" exists in the "Flow diagram table of VDT Layer 3" page.
   Then User verifies the "BSC" exists in the "Flow diagram table of VDT Layer 3" page.
Feature: Check working of APP

@scenarioTestApp
Scenario Outline: Validation of APP
	Given User executes "<Abbreviation Sheet name>" Different APPSheets for Different APP - "<APPName>", APPSheet - "<APPSheet>" with DML "<DML is Allowed>".
	Examples:
	|APPName | APPSheet | Abbreviation Sheet name | DML is Allowed |
| FM Analytics - FMA - fm_lte_Automation | Alarms Status | FMAnalytics | No | 

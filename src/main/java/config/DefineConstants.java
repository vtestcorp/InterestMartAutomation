package config;

public class DefineConstants {
	// Test data file Path
	public static final String Path_TestData = "";

	// Application URL
	public static final String URL = "http://p5app.p5email.com/";

	// Explicit Wait Time
	public static final int explicitWait_30 = 30;

	public static final int explicitWait_60 = 60;

	public static final String PROJECT_PATH = System.getProperty("user.dir");

	public static final String PROJECT_OS = System.getProperty("os.name");

	public static final String TestData_Folder = "Test_Data";
	public static final String TestDataJson_Folder = "TestDataJson";

	public static final String Mail_TestData_Folder = "Mail";

	public static final String Contacts_TestData_Folder = "Contacts";

	public static final String There_is_no_data_for_this_view = "There is no data for this view";
		
	// Contacts Module Json file
	public static final String Login = TestData_Folder + "//" + Contacts_TestData_Folder + "//" + "Login.json";
	public static final String Create_Contact = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Create_Contact.json";
	public static final String Add_Remove_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Add_Remove_Group.json";
	public static final String Invalidate_Contact = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Invalidate_Contact.json";
	public static final String Unsubcribe_Contact = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Unsubcribe_Contact.json";
	public static final String Export_Report = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Export_Report.json";
	public static final String Search_Contact = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Search_Contact.json";
	public static final String Contact_Details = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Contact_Details.json";
	public static final String Create_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Create_Group.json";
	public static final String Custom_Fields = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Custom_Fields.json";
	public static final String Email_Verification = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Email_Verification.json";
	public static final String Verify_Custom_Field_Presence = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Verify_Custom_Field_Presence.json";
	public static final String Delete_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Delete_Group.json";
	public static final String Download_Sample_File = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Download_Sample_File.json";
	public static final String Duplicate_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Duplicate_Group.json";
	public static final String Edit_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Edit_Group.json";
	public static final String Exclusive_Contact_List = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Exclusive_Contact_List.json";
	public static final String Export_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Export_Group.json";
	public static final String Validate_Group = TestData_Folder + "//" + Contacts_TestData_Folder + "//"
			+ "Validate_Group.json";

	// Mail Module Json file
	public static final String TC_01_Create_Draft_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_01_Create_Draft_Campaign.json";
	public static final String TC_02_Search_Draft_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_02_Search_Draft_Campaign.json";
	public static final String TC_03_Edit_Draft_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_03_Edit_Draft_Campaign.json";
	public static final String TC_04_Duplicate_Draft_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_04_Duplicate_Draft_Campaign.json";
	public static final String TC_05_Delete_Draft_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_05_Delete_Draft_Campaign.json";
	public static final String TC_06_Create_Scheduled_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_06_Create_Scheduled_Campaign.json";
	public static final String TC_07_Search_Scheduled_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_07_Search_Scheduled_Campaign.json";
	public static final String TC_08_Delete_Scheduled_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_08_Delete_Scheduled_Campaign.json";
	public static final String TC_09_Edit_Scheduled_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_09_Edit_Scheduled_Campaign.json";
	public static final String TC_10_Duplicate_Scheduled_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_10_Duplicate_Scheduled_Campaign.json";
	public static final String TC_11_Create_Triggers_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_11_Create_Triggers_Campaign.json";
	public static final String TC_12_Search_Triggers_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_12_Search_Triggers_Campaign.json";
	public static final String TC_13_Edit_Triggers_Campaign = TestData_Folder + "//" + Mail_TestData_Folder + "//" + "TC_13_Edit_Triggers_Campaign.json";
}
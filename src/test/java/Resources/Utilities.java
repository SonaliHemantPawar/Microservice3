package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Automation.Microservice.RetrialPojo;
import junit.framework.Assert;

public class Utilities {
	
	public Connection connection;
	public static Statement statement;
	public static ResultSet rs;
	public static Properties prop;
	public static String code;
	
	
	

	@BeforeClass
	public void setUp() throws IOException {
		//Load Properties file
		FileInputStream input = new FileInputStream("src\\test\\java\\Resources\\config.properties");
		prop = new Properties();
		prop.load(input);
		
		//Setup DB connection
		String databaseURL = "jdbc:oracle:thin:@vgditf1-scan:1527/MCOM_GL_ONLINE_SERV";
		String user = "mcomload";
		String password = "mcy4mot";
		connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the Database...");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	@AfterClass
	public void tearDown() {
		if (connection != null) {
			try {
				System.out.println("\nClosing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	//Retrieves data from db where event_id taken from config.properties
	public ResultSet getDataFromDB(String event_id) throws SQLException {
		String query = "SELECT * FROM SNGL_MSG_LGCY_DOC_EVENT where event_id = '"+event_id+"' order by crte_dttm desc";
		System.out.println("Query is : " +query);
		statement = connection.createStatement();
		rs = statement.executeQuery(query);
		return rs;
		}
	
	//Prints records from DB
	public void printDBrecords(ResultSet rs) throws SQLException {
		String line = new String(new char[280]).replace('\0', '-');		
		System.out.println(line);

		System.out.println(rs.getString("EVENT_ID") + "\t" + rs.getString("EVENT_TYPE") + "\t"
				+ rs.getString("CRTE_DTTM") + "\t" +rs.getString("LST_UPDT_DTTM") + "\t"+ rs.getString("STAT") + "\t" + rs.getString("RETRIAL_CRTE_DTTM")
				+ "\t"+ rs.getString("FAIL_RSN")
				+ "\t" + rs.getInt("RETRIAL_CNT") + "\t" + rs.getString("RETRIAL_TM") + "\t"
				+ rs.getString("CUT_OFF_TM"));
	}
	
	public void validateRecordsFromDB(ResultSet rs) throws Exception {
		try {
		// 1. Perform "Event ID" Validation
		Assert.assertEquals(rs.getString("EVENT_ID"), prop.getProperty("event_id"));
		
		// 2. Perform "Event type" validation
		if (rs.getString("EVENT_TYPE").equalsIgnoreCase("FIRST_CHARGEBACK"))
			Assert.assertEquals("FIRST_CHARGEBACK",rs.getString("EVENT_TYPE"));
		else
			Assert.assertEquals("SECOND_PRESENTMENT",rs.getString("EVENT_TYPE"));
					
		// 3. Perform "Event_Payload" validation
			//constructMsgCode(rs);
			validateJSONPayload(rs.getString("EVENT_TYPE"), prop.getProperty("error_code"));

		// 4.Perform "CRTE_DTTM" validation
			Assert.assertEquals(prop.getProperty("creation_date"),rs.getString("CRTE_DTTM"));
		
		//5. Perform "LST_UPDT_DTTM","STAT","RETRIAL_CRTE_DTTM","FAIL_RSN","RETRIAL_CNT","RETRIAL_TM","CUT_OFF_TM" columns validations
			RetrialColumns(rs);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Function to validate JSON payload
	public void validateJSONPayload(String event_type,String errorCode) throws SQLException {
		Clob payload_details = rs.getClob("EVENT_PYLD_JSON");
		String json_payload_db = payload_details.getSubString(1, (int) payload_details.length());
		String js = "";	
		//System.out.println("ErrorCode : " +errorCode );
		if (event_type.equalsIgnoreCase("FIRST_CHARGEBACK")) {	
			switch(errorCode){
			case "GET_400": js = payload.FC_Payload("LEGACY", "400");break;
			case "GET_401": js = payload.FC_Payload("LEGACY", "401");break;
			case "GET_403":	js = payload.FC_Payload("LEGACY", "403");break;
			case "GET_404":	js = payload.FC_Payload("LEGACY", "404");break;
			case "GET_500": js = payload.FC_Payload("LEGACY", "500");break;
			//UPDATE_CLAIM					
			case "UPDATE_400": js = payload.FC_Payload("400", "123324343");break;
			case "UPDATE_401": js = payload.FC_Payload("401", "123324343");break;
			case "UPDATE_403": js = payload.FC_Payload("403", "123324343");break;
			case "UPDATE_404": js = payload.FC_Payload("404", "123324343");break;
			case "UPDATE_500": js = payload.FC_Payload("500", "123324343");break;
			default: js = payload.FC_Payload("LEGACY", "123324343");					
		}} else { // SECOND_PRESENTMENT
			switch(errorCode){
			case "GET_400": js = payload.SP_Payload("LEGACY", "400");break;
			case "GET_401": js = payload.SP_Payload("LEGACY", "401");break;
			case "GET_403":	js = payload.SP_Payload("LEGACY", "403");break;
			case "GET_404":	js = payload.SP_Payload("LEGACY", "404");break;
			case "GET_500": js = payload.SP_Payload("LEGACY", "500");break;
			//UPDATE_CLAIM					
			case "UPDATE_400": js = payload.SP_Payload("400", "123324343");break;
			case "UPDATE_401": js = payload.SP_Payload("401", "123324343");break;
			case "UPDATE_403": js = payload.SP_Payload("403", "123324343");break;
			case "UPDATE_404": js = payload.SP_Payload("404", "123324343");break;
			case "UPDATE_500": js = payload.SP_Payload("500", "123324343");break;
			default: js = payload.SP_Payload("LEGACY", "123324343");					
		}
			}
		//validate Json payload from db
		Assert.assertEquals(js,json_payload_db);
		
	}
	
	//function to validate "LST_UPDT_DTTM","STAT","RETRIAL_CRTE_DTTM","FAIL_RSN","RETRIAL_CNT","RETRIAL_TM","CUT_OFF_TM" columns from db
	public void RetrialColumns(ResultSet rs) throws Exception 
	{	SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
		RetrialPojo rm = new RetrialPojo();
		String msgCode="";
		try{
			//set the last_updt_time from db
			rm.setLast_Updated_dt(rs.getString("LST_UPDT_DTTM"));
			if(rs.getString("RETRIAL_CRTE_DTTM")==null) { 
				//processed status	
				//Assert.assertEquals(DateFormat.format(DateFormat.parse(prop.getProperty("creation_date"))),DateFormat.format(DateFormat.parse(rs.getString("LST_UPDT_DTTM"))));
				Assert.assertEquals(rm.getLast_Updated_dt(), rs.getString("LST_UPDT_DTTM"));
				Assert.assertEquals("PROCESSED", rs.getString("STAT"));
				Assert.assertEquals(null, rs.getString("RETRIAL_CRTE_DTTM"));
				Assert.assertEquals(null, rs.getString("FAIL_RSN"));
				Assert.assertEquals(0, rs.getInt("RETRIAL_CNT"));
				Assert.assertEquals(null, rs.getString("RETRIAL_TM"));
				Assert.assertEquals(null, rs.getString("CUT_OFF_TM"));
			}
			else {
						//Pending and Failed status
				rm.setCutoff_dt(dateFormatting(rs.getString("RETRIAL_CRTE_DTTM"), "AddSevenDays",0)); //added 7 days 23:59:59
				rm.setRetrial_Crte_dt(DateFormat.format(DateFormat.parse(prop.getProperty("creation_date"))));
						rm.setStatus("PENDING");
						rm.setRetrial_cnt(rs.getString("RETRIAL_CNT"));	
						
						if(rs.getString("RETRIAL_CNT").equals("0"))	{
							//All 7 tries of that day is completed.. so setting the retrial time to next day and time = 8:00 am 
							rm.setRetrial_tm(dateFormatting(rm.getLast_Updated_dt(), "AddOneDay",0)); 
							System.out.println("\nRetry count is 0 and retrial tm is " +rm.getRetrial_tm());
						}else if(rs.getString("RETRIAL_CNT").matches("[1-7]")){
							//Setting retrial time according to retrial count
							rm.setRetrial_tm(dateFormatting(rm.getLast_Updated_dt(),"AddRetrialMinutes" ,rs.getInt("RETRIAL_CNT")*2)); //retrial_tm
							System.out.println("\nRetry count is "+rs.getInt("RETRIAL_CNT")+" and retrial tm is " +rm.getRetrial_tm());
						}
						else{//validating scenario where retrial time = cut-off date and all 7 retries completed
							rm.setStatus("FAILED");
							rm.setRetrial_tm(rs.getString("RETRIAL_TM")); // retrial time does not change when record gets failed
							rm.setRetrial_cnt("8"); //retrial count					
						}
					
					//Validating Fail Rsn message  
					code = prop.getProperty("error_code").split("_")[1];
					if((code.equalsIgnoreCase("400"))||(code.equalsIgnoreCase("401"))||(code.equalsIgnoreCase("403"))||(code.equalsIgnoreCase("404"))) 
						msgCode = "400";
					else msgCode = "500";
					
					if((prop.getProperty("error_code").contains("GET"))) 
						rm.setFailMsg("{\"Error\":[{\"Description\":\"MC_GET_CLAIM_API Failed !!!!\",\"Details\":null,\"ReasonCode\":\""+msgCode+"\",\"Recoverable\":null,\"RequestId\":null,\"Source\":\"MC_GET_CLAIM_API\"}]}");
					else 
						rm.setFailMsg("{\"Error\":[{\"Description\":\"MC_UPDATE_CLAIM_API Failed!!!\",\"Details\":null,\"ReasonCode\":\""+msgCode+"\",\"Recoverable\":null,\"RequestId\":null,\"Source\":\"MC_UPDATE_CLAIM_API\"}]}");

					
				Assert.assertEquals(rm.getLast_Updated_dt(),rs.getString("LST_UPDT_DTTM"));
				Assert.assertEquals(rm.getStatus(),rs.getString("STAT") );
				Assert.assertEquals(rm.getRetrial_Crte_dt(),DateFormat.format(DateFormat.parse(rs.getString("RETRIAL_CRTE_DTTM"))));
				Assert.assertEquals(rm.getFailMsg(), rs.getString("FAIL_RSN"));
				Assert.assertEquals(rm.getRetrial_cnt(), rs.getString("RETRIAL_CNT"));
				Assert.assertEquals(rm.getRetrial_tm(), rs.getString("RETRIAL_TM"));
				//Assert.assertEquals(rm.getCutoff_dt(), rs.getString("CUT_OFF_TM")); 
				
				}
		}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public String dateFormatting(String strDate, String str, int min) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		Date date1 = formatter.parse(strDate);
	     c.setTime(date1);
		if(str.equalsIgnoreCase("AddSevenDays")) {
		c.add(Calendar.DATE, 7); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND, 59);
		}else if (str.equalsIgnoreCase("AddOneDay")){
	        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
	        c.set(Calendar.HOUR, 8);
	        c.set(Calendar.MINUTE,00);
	        c.set(Calendar.SECOND, 00);
		}else {
			c.add(Calendar.MINUTE, min);
		}
	        // convert calendar to date
	        Date modifiedDate = c.getTime();
	       // System.out.println("Modified date is ::  " +formatter.format(modifiedDate));
			return formatter.format(modifiedDate);
	}
}


package Automation.Microservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Resources.Utilities;
import junit.framework.Assert;

public class TestCaseClass extends Utilities {
	
	
	//TC1916897 :S1373110 : Verify singleMsgLegacyDocSync service does not reads the message other than 1st Chgbk and 2nd presentment
	//TC1917356 : S1373110 : Verify when document detail is successfully updated then Status of the record is updated to PROCESSED
	//TC1917392 : S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when GET_CLAIM API call to MC_CLAIM service fails with HTTP error 500
	//TC1920366: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when GET_CLAIM API call to MC_CLAIM service fails with HTTP error 400
	//TC1920367: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when GET_CLAIM API call to MC_CLAIM service fails with HTTP error 401
	//TC1920369: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when GET_CLAIM API call to MC_CLAIM service fails with HTTP error 403
	//TC1920370: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when GET_CLAIM API call to MC_CLAIM service fails with HTTP error 404
	//TC1920406: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when UPDATE_CLAIM API call to MC_CLAIM service fails with HTTP error 500
	//TC1920414: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when UPDATE_CLAIM API call to MC_CLAIM service fails with HTTP error 400
	//TC1920417: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when UPDATE_CLAIM API call to MC_CLAIM service fails with HTTP error 401
	//TC1920418: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when UPDATE_CLAIM API call to MC_CLAIM service fails with HTTP error 403
	//TC1920421: S1373110 : Verify the retrial mechanism of singleMsgLegacyDocSync service when UPDATE_CLAIM API call to MC_CLAIM service fails with HTTP error 404
	
	@Test
	public void MainTest() throws Exception{
		int counter = 0;
		try {
			// Retrieve Data from DB 
			ResultSet rs = getDataFromDB(prop.getProperty("event_id"));
			System.out.println("\nEVENT_ID\tEVENT_TYPE\tCRTE_DTTM\tLST_UPDT_DTTM\tSTAT\tRETRIAL_CRTE_DTTM\tFAIL_RSN\tRETRIAL_CNT\tRETRIAL_TMCUT_OFF_TM");
				while (rs.next()) {					
					printDBrecords(rs);
					validateRecordsFromDB(rs);
					counter++;
				}
				if(counter==0) System.out.println("\nDB is not updated or Events other than First Chargeback and Second Presentment is not updated in DB");
				else System.out.println("\nValidation of " +counter + " rows completed");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	

}

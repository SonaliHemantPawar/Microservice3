package Resources;

public class payload {
	
	public static String FC_Payload(String InputChannel , String OrigSwitchNo) {
		
		return "{\r\n" + 
				"    \"service\": \"MC_LEGACY_SYNCHRONIZER\",\r\n" + 
				"    \"event\": \"LEGACY_FIRST_CHARGBK_DOC_SYNC\",\r\n" + 
				"	\"eventTag\": [\"SINGLE_DOC\",\"DUAL_DOC\"],\r\n" + 
				"    \"eventId\": \"2412213\",\r\n" + 
				"    \"dateTime\": \"yyyy-MM-dd HH:mm:ss.SSS\",\r\n" + 
				"    \"payloadDTO\": \"com.mastercard.mastercom.model.Model@1.0.0\",\r\n" + 
				"	\"InputChannel\":\""+InputChannel+"\", \r\n" + 
				"    \"inputFootprint\":\"Central\",\r\n" + 
				"	\"inputRegion\": null,\r\n" + 
				"    \"payload\":{\r\n" + 
				"      \"chargeback\":{\r\n" + 
				"            \"chargeback_id\":\"CBK_b8787946-f611-4f66-aeaf-f466cd965a19\",\r\n" + 
				"	        \"MCC_Userid\":\"\",\r\n" + 
				"            \"DOC_PRCSS_STAT_DTTM\": \"\",\r\n" + 
				"            \"Doc_upld_set_id \": \"\", \r\n" + 
				"			\"User_type\":\"\",\r\n" + 
				"			\"MEMO_TXT\":\"\" ,\r\n" + 
				"            \"files\": [\r\n" + 
				"				{\r\n" + 
				"				  \"id\": \"string\",\r\n" + 
				"				  \"fileType\": \"ORGINAL\",\r\n" + 
				"				  \"date\": \"2017-10-20T16:15:56.957-0200\"\r\n" + 
				"				}\r\n" + 
				"			  ]\r\n" + 
				"             },\r\n" + 
				"      \"Debit_chargebacks\":{\r\n" + 
				"            \"DB_CHGBK_ID\":\"\",\r\n" + 
				"			\"DB_CHGBK_LOAD_DTTM\":\"\",\r\n" + 
				"			\"ACQ_INST_NUM\":\"\",	\r\n" + 
				"			\"ACQ_NUMERIC_CURR_CD\":\"\",	\r\n" + 
				"			\"ACQ_PROCESSOR_NUM\":\"\",	\r\n" + 
				"			\"ADJ_CR_AMT\":\"\",	\r\n" + 
				"			\"ADJ_DR_AMT\":\"\",	\r\n" + 
				"			\"ADJ_LOCAL_AMT\":\"\",\r\n" + 
				"			\"ADJ_LOCAL_AMT_CD\":\"\",	\r\n" + 
				"			\"ISS_INST_NUM\":\"\",	\r\n" + 
				"			\"ISS_NUMERIC_CURR_CD\":\"\",	\r\n" + 
				"			\"ISS_PROCESSOR_NUM\":\"\",	\r\n" + 
				"			\"NEW_AMT\":\"\",	\r\n" + 
				"			\"ORIG_SWITCH_PROCESS_DT\":\"\",	\r\n" + 
				"			\"ORIG_SWITCH_SERIAL_NUM\":\""+OrigSwitchNo+"\",	\r\n" + 
				"			\"PRIMARY_ACCT_NUM\":\"\",	\r\n" + 
				"			\"PROCESSOR_CD\":\"GLOBAL\",\r\n" + 
				"			\"PRODUCT_TYPE_CD\":\"\",	\r\n" + 
				"			\"REASON_CODE\":\"\",	\r\n" + 
				"			\"SETTLEMENT_DT\":\"30-OCT-19 06.09.13.224000000 AM\",	\r\n" + 
				"			\"SWITCH_PROCESS_DT\":\"\",	\r\n" + 
				"			\"SWITCH_SERIAL_NUM\":\"\",	\r\n" + 
				"			\"TRACE_NUM\":\"\",	\r\n" + 
				"			\"INTER_TERMIN_ID\":\"\",	\r\n" + 
				"			\"REF_NUM\":\"\",\r\n" + 
				"			\"TRANS_CURR_EXP_NUM\":\"\",	\r\n" + 
				"			\"ORIG_REQ_LOC_AMT\":\"\",	\r\n" + 
				"			\"ISO_PROC_CODE\":\"\",\r\n" + 
				"			\"ADVICE_REASON_CODE\":\"\",\r\n" + 
				"			\"AUTH_DW_PRCSS_DT\":\"\",	\r\n" + 
				"			\"AUTH_DW_SEQ_NUM\":\"\",	\r\n" + 
				"			\"CLR_DW_PRCSS_DT\":\"\",\r\n" + 
				"			\"CLR_DW_PRCSS_NUM\":\"\",\r\n" + 
				"			\"FRAUD_SW\":\"\",	\r\n" + 
				"			\"ACCT_DATA_CMPRMS_SW\":\"\",	\r\n" + 
				"			\"STOPLIST_CRTE_DTTM\":\"\",\r\n" + 
				"			\"EMS_TRNSLT_SCR\":\"\",\r\n" + 
				"			\"DW_PRCSS_DT\":\"\",\r\n" + 
				"			\"DW_SEQ_NUM\":\"\",\r\n" + 
				"			\"FRAUD_NOTIF_DT\":\"\",	\r\n" + 
				"			\"FRAUD_CTR_TXT\":\"\",	\r\n" + 
				"			\"ATM_POS_CD\":\"\",	\r\n" + 
				"			\"DW_CHGBK_REV_PRCSS_DT\":\"\",	\r\n" + 
				"			\"DW_CHGBK_REV_SEQ_NUM\":\"\",	\r\n" + 
				"			\"DW_REPRESENT_REVERSAL_PRCSS_DT\":\"\",\r\n" + 
				"			\"DW_REPRESENT_REVERSAL_SEQ_NUM\":\"\",	\r\n" + 
				"			\"CASE_ID\":\"\",	\r\n" + 
				"			\"SETL_ORIG_DT\":\"\",\r\n" + 
				"			\"SERV_CD\":\"\",	\r\n" + 
				"			\"ACQ_NAM\":\"\",	\r\n" + 
				"			\"POS_ENTRY_CD\":\"\",\r\n" + 
				"			\"POS_DATA\":\"\",	\r\n" + 
				"			\"ACQ_ADDR\":\"\",	\r\n" + 
				"			\"ACQ_LOCATION\":\"\",	\r\n" + 
				"			\"ACQ_DT\":\"\",	\r\n" + 
				"			\"ACQ_TM\":\"\",	\r\n" + 
				"			\"ICHG_RATE_IND\":\"\",	\r\n" + 
				"			\"ISSR_ORIG_SETL_AMT\":\"\"	,\r\n" + 
				"			\"ISSR_ORIG_SETL_CURR_CD\":\"\",\r\n" + 
				"			\"ISSR_ORIG_SETL_EXPNT_NUM\":\"\",	\r\n" + 
				"			\"ACQ_CNTCT_NAM\":\"\",	\r\n" + 
				"			\"ACQ_PHN_NUM\":\"\",	\r\n" + 
				"			\"ACQ_FAX_NUM\":\"\",	\r\n" + 
				"			\"DOC_RQRD_SW\":\"\",	\r\n" + 
				"			\"RCVR_PROC_ID\":\"\",\r\n" + 
				"			\"SEND_PROC_ID\":\"\",	\r\n" + 
				"			\"PROCESSING_ENV_NAME\":\"\"\r\n" + 
				"             },\r\n" + 
				"      \"Claim\":{\r\n" + 
				"          \"CLAIM_ID\":\"\",\r\n" + 
				"		  \"DISPUTE_ID\":\"\",\r\n" + 
				"		  \"MCC_USER_ID\":\"\",\r\n" + 
				"		  \"DISPUTE_TYPE\":\"\",\r\n" + 
				"		  \"INSERT_DTTM\":\"\",\r\n" + 
				"		  \"UPDT_DTTM\":\"\",\r\n" + 
				"	  \"Request\":{\r\n" + 
				"		  \"primaryAccountNumber\":\"5120000000000000001\",\r\n" + 
				"		  \"settlementDate\":\"121818\",\r\n" + 
				"		  \"reversalReasonCode\":\"53\",\r\n" + 
				"		  \"replacementAmount\":\"2\",\r\n" + 
				"	  	  \"controlNumber\":\"99999\",\r\n" + 
				"		  \"adjustmentContactName\":\"MASTERCOM HUBSITE\",\r\n" + 
				"		  \"adjustmentContactPhone\":\"6367223646\",\r\n" + 
				"		  \"adjustmentContactFax\":\"6363299864\",\r\n" + 
				"		  \"usageCode\":\"1\",\r\n" + 
				"		  \"documentIndicator\":\"1\",\r\n" + 
				"		  \"localAdjustmentAmount\":\"2,199\"\r\n" + 
				"            }\r\n" + 
				"		}\r\n" + 
				"         \r\n" + 
				"      }\r\n" + 
				"   }";
	}	
	 public static String SP_Payload(String InputChannel , String OrigSwitchNo) {
			return "{\r\n" + 
					"   \"service\":\"MC_LEGACY_SYNCHRONIZER\",\r\n" + 
					"   \"event\":\"LEGACY_SECOND_PRESNTMNT_DOC_SYNC\",\r\n" + 
					"   \"eventTag\":[\r\n" + 
					"      \"SINGLE_DOC\",\r\n" + 
					"      \"DUAL_DOC\"\r\n" + 
					"   ],\r\n" + 
					"   \"eventId\":\"MCCHG1545825308000\",\r\n" + 
					"   \"dateTime\":\"yyyy-MM-dd HH:mm:ss.SSS\",\r\n" + 
					"   \"payloadDTO\":\"com.mastercard.mastercom.model.docSysn\",\r\n" + 
					"   \"InputChannel\":\""+InputChannel+"\",\r\n" + 
					"   \"inputFootprint\":\"Central\",\r\n" + 
					"   \"inputRegion\":null,\r\n" + 
					"   \"payload\":{\r\n" + 
					"      \"chargeback\":{\r\n" + 
					"         \"chargeback_id\":\"CBK_b8787946-f611-4f66-aeaf-f466cd965a19\",\r\n" + 
					"         \"MCC_Userid\":\"\",\r\n" + 
					"         \"DOC_PRCSS_STAT_DTTM\":\"\",\r\n" + 
					"         \"Doc_upld_set_id \":\"\",\r\n" + 
					"         \"User_type\":\"\",\r\n" + 
					"         \"MEMO_TXT\":\"\",\r\n" + 
					"         \"files\":[\r\n" + 
					"            {\r\n" + 
					"               \"id\":\"string\",\r\n" + 
					"               \"fileType\":\"ORGINAL\",\r\n" + 
					"               \"date\":\"2017-10-20T16:15:56.957-0200\"\r\n" + 
					"            }\r\n" + 
					"         ]\r\n" + 
					"      },\r\n" + 
					"      \"Debit_chargebacks\":{\r\n" + 
					"         \"DB_CHGBK_ID\":\"\",\r\n" + 
					"         \"DB_CHGBK_LOAD_DTTM\":\"\",\r\n" + 
					"         \"ACQ_INST_NUM\":\"\",\r\n" + 
					"         \"ACQ_NUMERIC_CURR_CD\":\"\",\r\n" + 
					"         \"ACQ_PROCESSOR_NUM\":\"\",\r\n" + 
					"         \"ADJ_CR_AMT\":\"\",\r\n" + 
					"         \"ADJ_DR_AMT\":\"\",\r\n" + 
					"         \"ADJ_LOCAL_AMT\":\"\",\r\n" + 
					"         \"ADJ_LOCAL_AMT_CD\":\"\",\r\n" + 
					"         \"ISS_INST_NUM\":\"\",\r\n" + 
					"         \"ISS_NUMERIC_CURR_CD\":\"\",\r\n" + 
					"         \"ISS_PROCESSOR_NUM\":\"\",\r\n" + 
					"         \"NEW_AMT\":\"\",\r\n" + 
					"         \"ORIG_SWITCH_PROCESS_DT\":\"\",\r\n" + 
					"         \"ORIG_SWITCH_SERIAL_NUM\":\""+OrigSwitchNo+"\",\r\n" + 
					"         \"PRIMARY_ACCT_NUM\":\"\",\r\n" + 
					"         \"PROCESSOR_CD\":\"GLOBAL\",\r\n" + 
					"         \"PRODUCT_TYPE_CD\":\"\",\r\n" + 
					"         \"REASON_CODE\":\"\",\r\n" + 
					"         \"SETTLEMENT_DT\":\"30-OCT-19 06.09.13.224000000 AM\",\r\n" + 
					"         \"SWITCH_PROCESS_DT\":\"\",\r\n" + 
					"         \"SWITCH_SERIAL_NUM\":\"\",\r\n" + 
					"         \"TRACE_NUM\":\"\",\r\n" + 
					"         \"INTER_TERMIN_ID\":\"\",\r\n" + 
					"         \"REF_NUM\":\"\",\r\n" + 
					"         \"TRANS_CURR_EXP_NUM\":\"\",\r\n" + 
					"         \"ORIG_REQ_LOC_AMT\":\"\",\r\n" + 
					"         \"ISO_PROC_CODE\":\"\",\r\n" + 
					"         \"ADVICE_REASON_CODE\":\"\",\r\n" + 
					"         \"AUTH_DW_PRCSS_DT\":\"\",\r\n" + 
					"         \"AUTH_DW_SEQ_NUM\":\"\",\r\n" + 
					"         \"CLR_DW_PRCSS_DT\":\"\",\r\n" + 
					"         \"CLR_DW_PRCSS_NUM\":\"\",\r\n" + 
					"         \"FRAUD_SW\":\"\",\r\n" + 
					"         \"ACCT_DATA_CMPRMS_SW\":\"\",\r\n" + 
					"         \"STOPLIST_CRTE_DTTM\":\"\",\r\n" + 
					"         \"EMS_TRNSLT_SCR\":\"\",\r\n" + 
					"         \"DW_PRCSS_DT\":\"\",\r\n" + 
					"         \"DW_SEQ_NUM\":\"\",\r\n" + 
					"         \"FRAUD_NOTIF_DT\":\"\",\r\n" + 
					"         \"FRAUD_CTR_TXT\":\"\",\r\n" + 
					"         \"ATM_POS_CD\":\"\",\r\n" + 
					"         \"DW_CHGBK_REV_PRCSS_DT\":\"\",\r\n" + 
					"         \"DW_CHGBK_REV_SEQ_NUM\":\"\",\r\n" + 
					"         \"DW_REPRESENT_REVERSAL_PRCSS_DT\":\"\",\r\n" + 
					"         \"DW_REPRESENT_REVERSAL_SEQ_NUM\":\"\",\r\n" + 
					"         \"CASE_ID\":\"\",\r\n" + 
					"         \"SETL_ORIG_DT\":\"\",\r\n" + 
					"         \"SERV_CD\":\"\",\r\n" + 
					"         \"ACQ_NAM\":\"\",\r\n" + 
					"         \"POS_ENTRY_CD\":\"\",\r\n" + 
					"         \"POS_DATA\":\"\",\r\n" + 
					"         \"ACQ_ADDR\":\"\",\r\n" + 
					"         \"ACQ_LOCATION\":\"\",\r\n" + 
					"         \"ACQ_DT\":\"\",\r\n" + 
					"         \"ACQ_TM\":\"\",\r\n" + 
					"         \"ICHG_RATE_IND\":\"\",\r\n" + 
					"         \"ISSR_ORIG_SETL_AMT\":\"\",\r\n" + 
					"         \"ISSR_ORIG_SETL_CURR_CD\":\"\",\r\n" + 
					"         \"ISSR_ORIG_SETL_EXPNT_NUM\":\"\",\r\n" + 
					"         \"ACQ_CNTCT_NAM\":\"\",\r\n" + 
					"         \"ACQ_PHN_NUM\":\"\",\r\n" + 
					"         \"ACQ_FAX_NUM\":\"\",\r\n" + 
					"         \"DOC_RQRD_SW\":\"\",\r\n" + 
					"         \"RCVR_PROC_ID\":\"\",\r\n" + 
					"         \"SEND_PROC_ID\":\"\",\r\n" + 
					"         \"PROCESSING_ENV_NAME\":\"\"\r\n" + 
					"      },\r\n" + 
					"      \"Claim\":{\r\n" + 
					"         \"CLAIM_ID\":\"\",\r\n" + 
					"         \"DISPUTE_ID\":\"\",\r\n" + 
					"         \"MCC_USER_ID\":\"\",\r\n" + 
					"         \"DISPUTE_TYPE\":\"\",\r\n" + 
					"         \"INSERT_DTTM\":\"\",\r\n" + 
					"         \"UPDT_DTTM\":\"\",\r\n" + 
					"         \"Request\":{\r\n" + 
					"            \"primaryAccountNumber\":\"5120000000000000001\",\r\n" + 
					"            \"settlementDate\":\"121818\",\r\n" + 
					"            \"reversalReasonCode\":\"53\",\r\n" + 
					"            \"replacementAmount\":\"2\",\r\n" + 
					"            \"controlNumber\":\"99999\",\r\n" + 
					"            \"adjustmentContactName\":\"MASTERCOM HUBSITE\",\r\n" + 
					"            \"adjustmentContactPhone\":\"6367223646\",\r\n" + 
					"            \"adjustmentContactFax\":\"6363299864\",\r\n" + 
					"            \"usageCode\":\"1\",\r\n" + 
					"            \"documentIndicator\":\"1\",\r\n" + 
					"            \"localAdjustmentAmount\":\"2,199\"\r\n" + 
					"         }\r\n" + 
					"      }\r\n" + 
					"   }\r\n" + 
					"}";
		}
}

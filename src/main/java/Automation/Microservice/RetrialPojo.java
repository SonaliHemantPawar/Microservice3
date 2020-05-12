package Automation.Microservice;


import java.util.ArrayList;
import java.util.Date;

public class RetrialPojo {
	String Retrial_tm;
	String Cutoff_dt;
	String Last_Updated_dt;
	String Retrial_Crte_dt;
	String Retrial_cnt;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String failMsg;
	public String getFailMsg() {
		return failMsg;
	}
	public void setFailMsg(String failMsg) {
		this.failMsg = failMsg;
	}
	public String getRetrial_tm() {
		return Retrial_tm;
	}
	public void setRetrial_tm(String retrial_tm) {
		Retrial_tm = retrial_tm;
	}
	public String getCutoff_dt() {
		return Cutoff_dt;
	}
	public void setCutoff_dt(String cutoff_dt) {
		Cutoff_dt = cutoff_dt;
	}
	public String getLast_Updated_dt() {
		return Last_Updated_dt;
	}
	public void setLast_Updated_dt(String last_Updated_dt) {
		Last_Updated_dt = last_Updated_dt;
	}
	public String getRetrial_Crte_dt() {
		return Retrial_Crte_dt;
	}
	public void setRetrial_Crte_dt(String string) {
		Retrial_Crte_dt = string;
	}
	public String getRetrial_cnt() {
		return Retrial_cnt;
	}
	public void setRetrial_cnt(String string) {
		Retrial_cnt = string;
	}
	

}

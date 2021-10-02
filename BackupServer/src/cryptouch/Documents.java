package cryptouch;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 

public class Documents {
	Connection con;
    CallableStatement csmt;
    ResultSet rs;
private String title,desc,userid,path,dt,tm,docId,otherUserid,inFile,outFile,otp,uotp,msgid,key,ext;
public String getMsgid() {
	return msgid;
}



public void setMsgid(String msgid) {
	this.msgid = msgid;
}



public String getKey() {
	return key;
}



public void setKey(String key) {
	this.key = key;
}
 
private int mxid;
private String file;
public String getOtp() {
	return otp;
}


 
public void setOtp(String otp) {
	this.otp = otp;
}



public String getUotp() {
	return uotp;
}



public void setUotp(String uotp) {
	this.uotp = uotp;
}

public String getTitle() {
	return title;
}



public String getInFile() {
	return inFile;
}



public void setInFile(String inFile) {
	this.inFile = inFile;
}



public String getOutFile() {
	return outFile;
}



public void setOutFile(String outFile) {
	this.outFile = outFile;
}



public String getOtherUserid() {
	return otherUserid;
}



public void setOtherUserid(String otherUserid) {
	this.otherUserid = otherUserid;
}


 


public String getDocId() {
	return docId;
}



public void setDocId(String docId) {
	this.docId = docId;
}



public void setTitle(String title) {
	this.title = title;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
 

public String getDt() {
	return dt;
}
public void setDt(String dt) {
	this.dt = dt;
}
public String getTm() {
	return tm;
}
public void setTm(String tm) {
	this.tm = tm;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public int getMxid() {
	return mxid;
}
public void setMxid(int mxid) {
	this.mxid = mxid;
}
 
public Documents()
{
	
}

   
public boolean registration()
{
    try
    { 
    	byte[] b=new Base64Decoder().decode(inFile);
    	final File f1 = new File(Documents.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		 path=GetWebPath.getPath(f1.getPath());
    	File f=new File(path+"/Uploads/"+outFile);
    	FileOutputStream fos=new FileOutputStream(f);
    	fos.write(b);
          
       return true;
       
    }
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
        return false;
    }
}
}

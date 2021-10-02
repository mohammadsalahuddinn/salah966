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
public void getId()
{
    try
    {
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getMaxIdDocs()}");
       
         csmt.execute();
         rs=csmt.getResultSet();
                    
        boolean auth=false;
        while(rs.next())
        { System.out.println("true");
            auth=true;
            
            mxid=rs.getInt("mxid");
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err in ipfs="+ex.getMessage());
         
    }
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
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        java.util.Date d=new java.util.Date();
        String dt1=(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
        String tm1=d.getHours()+":"+d.getMinutes();
        csmt=con.prepareCall("{call insertDoc(?,?,?,?,?,?,?)}");
        csmt.setString(1, userid);
        csmt.setString(2, desc);
        csmt.setString(3, dt1);
        csmt.setString(4, tm1);
        csmt.setString(5, title);  
        csmt.setString(6, key);  
        csmt.setString(7, outFile);  
         int n=csmt.executeUpdate(); 
        
        if(n>0)
        {
            try{con.close();}catch(Exception ex){}
            System.out.println("true");
            return true;
        }
        else
            return false;

        }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
        return false;
    }
}
}

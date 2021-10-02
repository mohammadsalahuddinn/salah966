package cryptouch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

public class MsgDetails {
private String userid,msg,group,subject,dt,tm,msgid,username;
 
public String getMsgid() {
	return msgid;
}



public void setMsgid(String msgid) {
	this.msgid = msgid;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



Connection con;
CallableStatement csmt;
ResultSet rs;
 

 


public String getSubject() {
	return subject;
}



public void setSubject(String subject) {
	this.subject = subject;
}



public String getUserid() {
	return userid;
}



public void setUserid(String userid) {
	this.userid = userid;
}



public String getMsg() {
	return msg;
}



public void setMsg(String msg) {
	this.msg = msg;
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



public String getGroup() {
	return group;
}



public void setGroup(String group) {
	this.group = group;
}



public boolean InsertMsg()
{
	boolean flag=false;
    try
    {
    	Date d=new Date();
    	String dt=d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
    	String tm=d.getHours()+":"+d.getMinutes();
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        System.out.println("data="+userid+" "+group+" "+msg+" "+subject);
        csmt=con.prepareCall("{call insertMsg(?,?,?,?,?,?)}");
         
        csmt.setString(1, userid);
        csmt.setString(2, group);
        csmt.setString(3, msg);
        csmt.setString(4, dt);
        csmt.setString(5, tm);
        csmt.setString(6, subject);
        int n= csmt.executeUpdate();
         
           System.out.println("false");
        if(n>0)
        {   System.out.println("true");
        	flag=true;
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err in api="+ex.getMessage());
         
    }
    return flag;
}


public boolean InsertSingleMsg()
{
	boolean flag=false;
    try
    {
    	Date d=new Date();
    	String dt=d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
    	String tm=d.getHours()+":"+d.getMinutes();
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        System.out.println("data="+userid+" "+group+" "+msg+" "+subject);
        csmt=con.prepareCall("{call insertMsg(?,?,?,?,?,?)}");
         
        csmt.setString(1, userid);
        csmt.setString(2, "NA");
        csmt.setString(3, msg);
        csmt.setString(4, dt);
        csmt.setString(5, tm);
        csmt.setString(6, subject);
        int n= csmt.executeUpdate();
         
           System.out.println("false");
        if(n>0)
        {   System.out.println("true");
        	flag=true;
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err in api="+ex.getMessage());
         
    }
    return flag;
}
}

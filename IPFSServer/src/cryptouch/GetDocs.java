package cryptouch;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 

public class GetDocs {
	Connection con;
    CallableStatement csmt;
    ResultSet rs;
  
private List<Documents> lstdoc;
  
 
public List<Documents> getLstdoc() {
	return lstdoc;
}
public void setLstdoc(List<Documents> lstdoc) {
	this.lstdoc = lstdoc;
}
public void getDocumentList(String userid1)
{
    try
    { 
	final File f1 = new File(GetDocs.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	String path=GetWebPath.getPath(f1.getPath());
	
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        csmt=con.prepareCall("{call getDocuments1(?)}");
        lstdoc=new ArrayList<Documents>();
        csmt.setString(1, userid1);
         csmt.execute();
         rs=csmt.getResultSet();
                     
        while(rs.next())
        { System.out.println("true");
        Documents doc=new Documents();
        doc.setTitle(rs.getString("title").toString().trim());
        doc.setMsgid(rs.getString("msgid").toString().trim());
    	doc.setDesc(rs.getString("docdesc").toString().trim());
    	 
    	doc.setUserid(rs.getString("userid").toString().trim());
    	doc.setDt(rs.getString("dt").toString().trim());
    	doc.setTm(rs.getString("tm").toString().trim());
    	doc.setKey(rs.getString("skey").toString().trim());
    	doc.setOutFile(rs.getString("filepath").toString().trim());
    	File f=new File(path+"/Uploads/"+rs.getString("filepath").toString().trim());
    	byte[] b=Files.readAllBytes(Paths.get(path+"/Uploads/"+rs.getString("filepath").toString().trim()));
    	doc.setInFile(new Base64Encoder().encode(b));
        lstdoc.add(doc);
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}  
public void getDocumentList1(String docids)
{
    try
    { 
	final File f1 = new File(GetDocs.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	String path=GetWebPath.getPath(f1.getPath());
	
         DBConnector obj=new  DBConnector();
        con=obj.connect();
        PreparedStatement pst =con.prepareStatement("select * from getdocuments where msgid in ("+docids+")");
        lstdoc=new ArrayList<Documents>();
        System.out.println("docids="+docids);
      //  pst.setString(1, docids);
        
         rs=pst.executeQuery();
                     
        while(rs.next())
        { System.out.println("true");
        Documents doc=new Documents();
        doc.setTitle(rs.getString("title").toString().trim());
        doc.setMsgid(rs.getString("msgid").toString().trim());
    	doc.setDesc(rs.getString("docdesc").toString().trim());
    	 
    	doc.setUserid(rs.getString("userid").toString().trim());
    	doc.setDt(rs.getString("dt").toString().trim());
    	doc.setTm(rs.getString("tm").toString().trim());
    	doc.setKey(rs.getString("skey").toString().trim());
    	doc.setOutFile(rs.getString("filepath").toString().trim());
    	File f=new File(path+"/Uploads/"+rs.getString("filepath").toString().trim());
    	byte[] b=Files.readAllBytes(Paths.get(path+"/Uploads/"+rs.getString("filepath").toString().trim()));
    	doc.setInFile(new Base64Encoder().encode(b));
        lstdoc.add(doc);
              
        }
    }
       
     
    catch(Exception ex)
    {
        System.out.println("err="+ex.getMessage());
         
    }
}  
}

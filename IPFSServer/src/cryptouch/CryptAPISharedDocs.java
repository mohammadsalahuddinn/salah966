package cryptouch;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

 
 
 

@Path("/ipfs_getSharedDoc")
public class CryptAPISharedDocs {
	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Documents> getTrackInJSON(@PathParam("param") String param) {

		 
		GetDocs obj=new GetDocs();
		obj.getDocumentList1(param);
		return obj.getLstdoc();

	}
	@POST
	 @Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Documents msg) {

		String result = "false";
		if(msg.registration())
		{
			result="true";
		}
		return Response.status(201).entity(result).build();
		
	}
	
}

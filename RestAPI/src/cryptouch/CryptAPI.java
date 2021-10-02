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

import models.GetMessagesList;

 
 
 

@Path("/crypt")
public class CryptAPI {
	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MsgDetails> getTrackInJSON(@PathParam("param") String param) {

		 
		GetMessagesList obj=new GetMessagesList();
		Base64Decoder decoder=new Base64Decoder();
		 String param1=decoder.decodeBase64String(param);
		return obj.getMssages(param1);

	}
	@POST
	 @Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(MsgDetails msg) {

		String result = "false";
		if(msg.InsertMsg())
		{
			result="true";
		}
		return Response.status(201).entity(result).build();
		
	}
	
}

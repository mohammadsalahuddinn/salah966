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
  
@Path("/backup")
public class CryptAPI {
	 
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

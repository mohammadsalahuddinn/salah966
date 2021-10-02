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
import models.GetSingleMessagesList;

@Path("/single_crypt")
public class SingleMsgAPI {
	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MsgDetails> getTrackInJSON(@PathParam("param") String param) {

		 
		GetSingleMessagesList obj=new GetSingleMessagesList();
		 
		return obj.getMssages(param);

	}
	@POST
	 @Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(MsgDetails msg) {

		String result = "false";
		if(msg.InsertSingleMsg())
		{
			result="true";
		}
		return Response.status(201).entity(result).build();
		
	}
}

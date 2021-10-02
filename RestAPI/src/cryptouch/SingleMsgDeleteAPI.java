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

@Path("/single_cryptDelete")
public class SingleMsgDeleteAPI {
	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MsgDetails> getTrackInJSON(@PathParam("param") String param) {

		 
		GetSingleMessagesList obj=new GetSingleMessagesList();
		Base64Decoder decoder=new Base64Decoder();
		 String param1=decoder.decodeBase64String(param);
		return obj.getMssagesDel(param1.split("\\|")[0].trim(), param1.split("\\|")[1].trim());

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

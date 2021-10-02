package cryptouch;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/getdocId")
public class GetDocId {
	@GET
	@Path("/get/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON() {

		 
		Documents obj=new Documents();
		obj.getId(); 
		return String.valueOf(obj.getMxid());

	}
}

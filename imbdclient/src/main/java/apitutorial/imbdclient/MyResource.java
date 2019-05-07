package apitutorial.imbdclient;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("movieclient")
public class MyResource {

	@GET
	@Path("/getrating/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Datamodel sayHello(@PathParam(value="msg") String msg){
		
	try {	
		//System.out.println(msg);
	Datamodel d =Retrieval.getDetails(msg);
	return d;
	}
	catch(Exception e)
	
	{
		System.out.println(e);
		Datamodel d=new Datamodel((float)100.0,-1);
		 return d;
	}
		
	 
		
		
	}
}

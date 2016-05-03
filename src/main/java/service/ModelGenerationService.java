/**
 * 
 */
package service;

import handler.ModelHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import constants.StringConstants;

/**
 * @author Manthan
 *
 */
@Path("/modelService")
public class ModelGenerationService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/generateModel/{toolName}")
	public String generateModel(@PathParam("toolName") String toolName){
		String returnValue = ModelHandler.generateModel(toolName);
		if(returnValue.equals(StringConstants.SUCCESS_MODEL_CREATION))
			return StringConstants.SUCCESS_RETURN_MESSAGE;
		else
			return StringConstants.FAILURE_RETURN_MESSAGE;
	}
}

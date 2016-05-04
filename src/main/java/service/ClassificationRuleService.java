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
@Path("/classificationRuleService")
public class ClassificationRuleService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getRules/{toolName}")
	public String getRuleSet(@PathParam("toolName") String toolName){
		ModelHandler.getRuleSet(toolName);
		return ModelHandler.returnRuleSet(toolName);
		
	}
}

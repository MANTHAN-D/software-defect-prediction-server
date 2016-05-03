/**
 * 
 */
package service;

import handler.ModelHandler;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ArffModel;
import model.ClassificationInputDataModel;
import model.ClassificationRequestModel;

/**
 * @author Manthan
 *
 */
@Path("/classificationService")
public class ClassificationService {

	@POST
	@Path("/classify")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ArffModel> classifyFileRecords(ClassificationRequestModel requestData){
				
		String toolName = requestData.getSource();
		List<ClassificationInputDataModel> dataSet = requestData.getData();
				
		ModelHandler.classifyData(toolName, dataSet);		
		return ModelHandler.getResponseDataList();
	}
}

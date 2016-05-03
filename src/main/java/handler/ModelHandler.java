/**
 * 
 */
package handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.StringConstants;
import dao.ModellingDataDAO;
import exceptions.TempFileException;
import model.ArffModel;
import model.ClassificationInputDataModel;
import myra.Model;
import myra.rule.pittsburgh.unordered.UcAntMinerPB;
import myra.util.Logger;

/**
 * @author Manthan
 *
 */
public class ModelHandler {
	
	private static List<ArffModel> responseDataList = null;
	private static Map<String, Model> modelMap = new HashMap<>();;
	private static UcAntMinerPB algorithm = new UcAntMinerPB();	
	
	public static String generateModel(String toolName){
		if(!modelMap.containsKey(toolName) || modelMap.get(toolName) == null){
			try {
				/*modelMap.put(toolName,algorithm.generateModel(ModellingDataDAO.getModellingDataInput(toolName)));*/
				ModellingDataDAO.getModellingDataInput(toolName);
				algorithm.generateModel(toolName, ModellingDataDAO.getArgs());
			} catch (TempFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				modelMap.put(toolName, null);
			}
			if(modelMap.get(toolName) == null)
				return StringConstants.FAILURE_MODEL_CREATION;
		}
		System.out.println("Model generated " + modelMap.get(toolName));
		Logger.log("Model generated " + modelMap.get(toolName));
		return StringConstants.SUCCESS_MODEL_CREATION;
		
	}
	
	public static void classifyData(String toolName, List<ClassificationInputDataModel> dataSet){
		/**Check if model exists*/						
		if(!modelMap.containsKey(toolName) || modelMap.get(toolName) == null){			
			/*modelResult = generateModel(toolName);*/						
			try {
				ModellingDataDAO.getModellingDataInput(toolName);
				algorithm.generateModel(toolName, ModellingDataDAO.getArgs());
				ModellingDataDAO.getTestArffFilePath(toolName,dataSet);				
				algorithm.classifyData(ModellingDataDAO.getArgs(), modelMap.get(toolName));
			} catch (TempFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Logger.log("\nData classification falied at handler");
			}
			/*System.out.println("Generating model....." + modelResult);
			if(modelResult.equals(StringConstants.SUCCESS_MODEL_CREATION)){
				//Model exists for given tool
				
				String[] testFileArgs;
				try {
					testFileArgs = ModellingDataDAO.getTestArffFilePath(toolName,dataSet);
					System.out.println("Test file generated....." + testFileArgs);
					responseDataList = algorithm.classifyData(testFileArgs, modelMap.get(toolName));
				} catch (TempFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Data classification falied at handler");
				}				
			}*/
		}
		else{
			Logger.log("\nPrev model being used available" + modelMap.get(toolName));			
			try {
				ModellingDataDAO.getTestArffFilePath(toolName,dataSet);
				algorithm.classifyData(ModellingDataDAO.getArgs(), modelMap.get(toolName));
			} catch (TempFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Logger.log("\nData classification falied at handler");
			}
		}
			
		Logger.log("\nReturning from classification....." + responseDataList);		
	}
	
	public static void setModel(String toolName, Model model){
		modelMap.put(toolName, model);
	}

	/**
	 * @return the responseDataList
	 */
	public static List<ArffModel> getResponseDataList() {
		return responseDataList;
	}

	/**
	 * @param responseDataList the responseDataList to set
	 */
	public static void setResponseDataList(List<ArffModel> responseDataList) {
		ModelHandler.responseDataList = responseDataList;
	}
	
	

}

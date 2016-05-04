/**
 * 
 */
package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utilities.ArffGenerator;
import model.ArffModel;
import model.ClassificationInputDataModel;
import myra.util.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import exceptions.TempFileException;



/**
 * @author Manthan
 *
 */
public class ModellingDataDAO {

	private static String arffFilePath;
	private static String[] args; 
	/*private static final String RESOURCEBASEURL = "http://localhost:8080/software-defect-classification-service/rest/dummyService/dummyData";*/
	private static final String RESOURCEBASEURL = "http://localhost:3000/clusters/getData?source=";
	
	public static void getModellingDataInput(String toolName) throws TempFileException{
		String[] args = new String[2];
		args[0] = "-f";
		getDataFromMongo(toolName);
		String filePathAndName = getArffFilePath();
		if(filePathAndName != null)
			args[1] = filePathAndName;
		else
			throw new TempFileException("NULL temp-file path");
		setArgs(args);
	}
	
	private static void getDataFromMongo(String toolName){
		
		/*Make a request to service to get array of json objects */			
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);
		/*WebResource webResource = client.resource(ModellingDataDAO.RESOURCEBASEURL);//+toolName);
		 * 
*/		WebResource webResource = client.resource(ModellingDataDAO.RESOURCEBASEURL+toolName);
		GenericType<ArrayList<ArffModel>> list = new GenericType<ArrayList<ArffModel>>() {};
		/*ArrayList<ArffModel> response = webResource.accept("application/json").get(list);*/
		ArrayList<ArffModel> response = webResource.get(list);
		
		/*Create arff file*/
		generateArffFile(toolName,response);
		
	}
	
	public static void getTestArffFilePath(String toolName, List<ClassificationInputDataModel> dataList) throws TempFileException{
		
		String[] args = new String[2];
		args[0] = "-t";
		
		ClassificationInputDataModel inputDataObject = null;
		
		ArrayList<ArffModel> arffDataList = new ArrayList<>();
		Iterator<ClassificationInputDataModel> dataListIt = dataList.iterator();
		while(dataListIt.hasNext()){
			inputDataObject = dataListIt.next();
			arffDataList.add(new ArffModel(inputDataObject.getWmc(), inputDataObject.getDit(), 
					inputDataObject.getNoc(), inputDataObject.getCbo(), inputDataObject.getRfc(), 
					inputDataObject.getLcom()));
		}
		
		/**Create Arff file**/				
		generateArffFile(toolName,arffDataList);
		String filePathAndName = getArffFilePath();
		if(filePathAndName != null)
			args[1] = filePathAndName;
		else
			throw new TempFileException("NULL temp-file path");
		
		Logger.log("Returning test file creation : "+args);
		setArgs(args);
	}
	
	private static void generateArffFile(String toolName, ArrayList<ArffModel> arffDataList){
		/*Create arff file*/
		try {
			ArffGenerator arffGenerator = new ArffGenerator(toolName, arffDataList);
			arffGenerator.writeToFile();
			Logger.log(arffGenerator.getArffFilePath());
			setArffFilePath(arffGenerator.getArffFilePath());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Logger.log(""+arffDataList.size());		
	}
	
	
	/**
	 * @return the arffFilePath
	 */
	public static String getArffFilePath() {
		return arffFilePath;
	}

	/**
	 * @param arffFilePath the arffFilePath to set
	 */
	public static void setArffFilePath(String arffFilePath) {
		ModellingDataDAO.arffFilePath = arffFilePath;
	}

	
	/**
	 * @return the args
	 */
	public static String[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public static void setArgs(String[] args) {
		ModellingDataDAO.args = args;
	}

	/*public static void main(String[] args){
		ModellingDataDAO dao = new ModellingDataDAO();
		dao.getDataFromMongo("prop");
	}*/
}


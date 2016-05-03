/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Manthan
 *
 */
public class ClassificationRequestModel {

	private String source;
	private ArrayList<ClassificationInputDataModel> data;
	
	public ClassificationRequestModel(){
		this.source = null;
		this.data=null;
	}
	
	public ClassificationRequestModel(String source, ArrayList<ClassificationInputDataModel> data){
		this.source = source;
		this.data = data;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the data
	 */
	public ArrayList<ClassificationInputDataModel> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<ClassificationInputDataModel> data) {
		this.data = data;
	}
		
}

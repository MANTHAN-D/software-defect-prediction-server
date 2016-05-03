package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import model.ArffModel;

/**
 * @author Manthan
 *
 */
public class ArffGenerator {
	
	private File file;	
	private ArrayList<ArffModel> dataRecords;
	private String arffInitialContent;
	private String timeStamp;
	
	public ArffGenerator(String toolName, ArrayList<ArffModel> dataRecords) throws IOException{
		
		this.timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss",Locale.US).format(new Date(System.currentTimeMillis()));
		this.file = File.createTempFile(toolName+"_"+this.timeStamp, ".arff");		
		this.dataRecords = dataRecords;
		
		this.arffInitialContent = "@RELATION bugs\n"+
		"@ATTRIBUTE WMC NUMERIC\n"+
		"@ATTRIBUTE DIT NUMERIC\n"+
		"@ATTRIBUTE NOC NUMERIC\n"+
		"@ATTRIBUTE CBO NUMERIC\n"+
		"@ATTRIBUTE RFC NUMERIC\n"+
		"@ATTRIBUTE LCOM NUMERIC\n"+
		"@ATTRIBUTE bugFr {low,medium,high}\n\n"+
		"@DATA\n";
	}
	
	public void writeToFile(){
		writeDataToArff();
	}	
	
	private void writeDataToArff(){
		FileWriter fw=null;
		BufferedWriter bw=null;
		PrintWriter pw=null;
		try{
			fw = new FileWriter(file);			
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);			
			pw.println(arffInitialContent);
			
			for(ArffModel dataRecord : dataRecords){
				pw.println(dataRecord.getWmc()+","+
						dataRecord.getDit()+","+dataRecord.getNoc()+","+
						dataRecord.getCbo()+","+dataRecord.getRfc()+","+
						dataRecord.getLcom()+","+
						/*((dataRecord.getBugFrequency() <= 2)?"low":((dataRecord.getBugFrequency() <=7)?"medium":"high"))); // xerces-init, xerces-1.3, xerces-1.2  
*/						/*((dataRecord.getBugFrequency() <= 4)?"low":((dataRecord.getBugFrequency() <=11)?"medium":"high"))); //xerces-1.4
*/						dataRecord.getBugFreq()); // chirag's file format
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally{			
			try {
				if(pw!= null)pw.close();
				if(bw!=null)bw.close();
				if(fw!=null)fw.close();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getArffFilePath(){
		if(this.file!=null){
			return this.file.getAbsolutePath();
		}
		else{
			return null;
		}
	}
}


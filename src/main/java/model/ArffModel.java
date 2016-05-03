/**
 * 
 */
package model;

/**
 * @author Manthan
 *
 */

public class ArffModel {
	
	private double wmc;
	private double dit;
	private double noc;
	private double cbo;
	private double rfc;
	private double lcom;
	private double bugs;
	private String bugFreq;
	private String file;
	private String source;
	private String _id;
	
	public ArffModel(){
		this.wmc = -1;
		this.dit = -1;
		this.noc = -1;
		this.cbo = -1;
		this.rfc = -1;
		this.lcom = -1;
		this.bugs = -1;
		this.bugFreq = null;
		this.file = null;
		this.source = null;
	}
	
	public ArffModel(double wmc, double dit, double noc, double cbo, double rfc, double lcom, 
			double bugs, String bugFreq, String file, String source){
		this.wmc = wmc;
		this.dit = dit;
		this.noc = noc;
		this.cbo = cbo;
		this.rfc = rfc;
		this.lcom = lcom;
		this.bugs = bugs;
		this.bugFreq = bugFreq;
		this.file = file;
		this.source = source;
	}
	
	public ArffModel(double wmc, double dit, double noc, double cbo, double rfc, double lcom, String bugFreq){
		this.wmc = wmc;
		this.dit = dit;
		this.noc = noc;
		this.cbo = cbo;
		this.rfc = rfc;
		this.lcom = lcom;
		this.bugFreq = bugFreq;
		this.file = null;
		this.source = null;
	}
	
	public ArffModel(double wmc, double dit, double noc, double cbo, double rfc, double lcom){
		this.wmc = wmc;
		this.dit = dit;
		this.noc = noc;
		this.cbo = cbo;
		this.rfc = rfc;
		this.lcom = lcom;
		this.bugFreq = "low";
		this.file = null;
		this.source = null;
	}

	/**
	 * @return the wmc
	 */
	public double getWmc() {
		return wmc;
	}

	/**
	 * @param wmc the wmc to set
	 */
	
	public void setWmc(double wmc) {
		this.wmc = wmc;
	}

	/**
	 * @return the dit
	 */
	public double getDit() {
		return dit;
	}

	/**
	 * @param dit the dit to set
	 */
	
	public void setDit(double dit) {
		this.dit = dit;
	}

	/**
	 * @return the noc
	 */
	public double getNoc() {
		return noc;
	}

	/**
	 * @param noc the noc to set
	 */
	
	public void setNoc(double noc) {
		this.noc = noc;
	}

	/**
	 * @return the cbo
	 */
	public double getCbo() {
		return cbo;
	}

	/**
	 * @param cbo the cbo to set
	 */
	
	public void setCbo(double cbo) {
		this.cbo = cbo;
	}

	/**
	 * @return the rfc
	 */
	public double getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	
	public void setRfc(double rfc) {
		this.rfc = rfc;
	}
	
	/**
	 * @return the lcom
	 */
	public double getLcom() {
		return lcom;
	}

	/**
	 * @param lcom the lcom to set
	 */
	
	public void setLcom(double lcom) {
		this.lcom = lcom;
	}

	/**
	 * @return the bugs
	 */
	public double getBugs() {
		return bugs;
	}

	/**
	 * @param bugs the bugs to set
	 */
	
	public void setBugs(double bugs) {
		this.bugs = bugs;
	}

	/**
	 * @return the bugFreq
	 */
	public String getBugFreq() {
		return bugFreq;
	}

	/**
	 * @param bugFreq the bugFreq to set
	 */
	
	public void setBugFreq(String bugFreq) {
		this.bugFreq = bugFreq;
	}

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	
	public void setFile(String file) {
		this.file = file;
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
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}	
	
	
}

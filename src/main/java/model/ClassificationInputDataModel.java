/**
 * 
 */
package model;

/**
 * @author Manthan
 *
 */
public class ClassificationInputDataModel {

	private double wmc;
	private double dit;
	private double noc;
	private double cbo;
	private double rfc;
	private double lcom;
	
	public ClassificationInputDataModel(){
		this.wmc = -1;
		this.dit = -1;
		this.noc = -1;
		this.cbo = -1;
		this.rfc = -1;
		this.lcom = -1;
	}
	
	public ClassificationInputDataModel(double wmc, double dit, double noc, double cbo, double rfc, double lcom){
		this.wmc = wmc;
		this.dit = dit;
		this.noc = noc;
		this.cbo = cbo;
		this.rfc = rfc;
		this.lcom = lcom;
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
}

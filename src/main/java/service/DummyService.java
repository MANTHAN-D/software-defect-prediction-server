/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.ArffModel;

/**
 * @author Manthan
 *
 */
@Path("/dummyService")
public class DummyService {

	@GET
	/*@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})*/
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dummyData")
	public List<ArffModel> getDummyData(){
		List<ArffModel> dummyList = new ArrayList<ArffModel>();
		
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 3, "low", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 0, "low", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 13, "medium", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 31, "high", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 3, "low", "zuel", "zuzel"));
		System.out.println(dummyList.toString());
		return dummyList;
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})	
	public String testServer(){
		List<ArffModel> dummyList = new ArrayList<ArffModel>();
		
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 3, "low", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 0, "low", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 13, "medium", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 31, "high", "zuel", "zuzel"));
		dummyList.add(new ArffModel(23, 21, 56, 43, 89, 67, 3, "low", "zuel", "zuzel"));
		System.out.println(dummyList.toString());
		return dummyList.toString();
	}
	
	@GET
	/*@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})*/
	/*@Produces({MediaType.TEXT_XML})*/
	@Path("/oneDummyData")
	public Response getOneDummyData(){
		ArffModel m = new ArffModel(23, 21, 56, 43, 89, 67, 3, "low", "zuel", "zuzel"); 
		System.out.println("Hola "+m.toString());
		return Response.status(200).entity(m).build();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/twoDummyData")
	public ArffModel getTwoDummyData(){
		ArffModel m = new ArffModel();
		
		m.setWmc(23);
		m.setDit(21);
		m.setNoc(56);
		m.setRfc(43);
		m.setLcom(89);
		m.setCbo(67);
		m.setBugs(3);
		m.setBugFreq("low");
		m.setSource("zuzel");
		m.setFile("zuel");
		
		System.out.println("Hola2 "+m.toString());
		return m;
	}
}

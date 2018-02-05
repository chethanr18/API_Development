package com.java4s;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.java4s.CTP_Input;
import com.sun.jersey.spi.resource.Singleton;

/****** NOTE : Check the Others folder in this project to understand how the call is made********/

@Path("/customers")
public class HelloWorldService {
	static HashMap<String, String> inputDS = new HashMap<String, String>();
  @GET
  @Produces("text/html")
  public Response getLocalCust() {
	  
	  
           String output = "I am from 'getLocalCust' method"; 
      /**** Converting Hashmap to JSON  string and sending it as response using GSON package *****/
           Gson gson = new Gson();
           String json = gson.toJson(inputDS);
           output = json;
           
      /**** Converting Hasmap to JSON  string and sending it as response using ObjectMapper *****/
           ObjectMapper mapperObj = new ObjectMapper();
           
           String jsonResp = "";
           try{
        	   jsonResp = mapperObj.writeValueAsString(inputDS);
           }
           catch(Exception e) {
        	   e.printStackTrace();
           }
           //return Response.status(200).entity(output).build();
           return Response.status(200).entity(jsonResp).build();
  }
 
  @GET
  @Path("/nri")
  @Produces("text/html")
  public Response getNriCust() {
 
            String output = "I am from 'getNriCust' method";
            return Response.status(200).entity(output).build();
  }
  
  @POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
  	@Produces("text/html")
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(200).entity(result).build();
	}	
  
    @POST
	@Path("/upload")
	@Produces({"application/json"})
	@Consumes(MediaType.APPLICATION_JSON)
	public Response uploadInout(CTP_Input input) {

    	HashMap<String, String> inputDS = new HashMap<String, String>();
    	
		String requirementId = input.getRequirementId();
		String testPlanName = input.getTestPlanName();
		
		
		
		inputDS.put(requirementId, testPlanName);
		
		String result = "Input saved : " + input + " Total elements:"+ inputDS.size();
		
		return Response.status(200).entity(result).build();
	}
}
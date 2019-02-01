package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.TraineeBusiness;

@Path("/trainees")
public class TraineeEndPoints {

	@Inject
	private TraineeBusiness service;

	@GET
	@Path("/alltrainees")
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@POST
	@Path("/createtrainee")
	public String createtrainer(String trainer) {
		return service.createTrainee(trainer);
	}
	
	@GET
	@Path("/{traineeid}")
	public String findTraineeById(@PathParam("traineeid") long traineeid) {
		return service.findTraineeById(traineeid);
	}
	
	@DELETE
	@Path("/{traineeid}")
	public String deleteTraineeById(@PathParam("traineeid") long traineeid) {
		return service.deleteTrainee(traineeid);
	}
	
	@POST
	@Path("/{traineeid}")
	public String UpdateAccountById(@PathParam("traineeid") long traineeid, String trainee) {
		return service.updateTrainee(traineeid, trainee);
	}
}
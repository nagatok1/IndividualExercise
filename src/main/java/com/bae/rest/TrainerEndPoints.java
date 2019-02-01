package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bae.business.TrainerBusiness;

@Path("/trainers")
public class TrainerEndPoints {

	@Inject
	private TrainerBusiness service;

	@GET
	@Path("/alltrainers")
	public String getAllTrainers() {
		return service.getAllTrainers();
	}
	
	@POST
	@Path("/createtrainer")
	public String createtrainer(String trainer) {
		return service.createTrainer(trainer);
	}
	
	@GET
	@Path("/{trainerid}")
	public String findTrainerById(@PathParam("trainerid") long trainerid) {
		return service.findTrainerById(trainerid);
	}
	
	@DELETE
	@Path("/{trainerid}")
	public String deleteTrainerById(@PathParam("trainerid") long trainerid) {
		return service.deleteTrainer(trainerid);
	}
	
	@POST
	@Path("/{trainerid}")
	public String UpdateAccountById(@PathParam("trainerid") long trainerid, String trainer) {
		return service.updateTrainer(trainerid, trainer);
	}
}

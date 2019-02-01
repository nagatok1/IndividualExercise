package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.TrainerRepository;
import com.bae.util.JSONUtil;

public class TrainerBusiness implements TrainerInterface {

	@Inject
	private TrainerRepository myrepo;

	@Inject
	private JSONUtil jsonutil;

	@Override
	public String getAllTrainers() {
		return myrepo.getAllTrainers();
	}

	@Override
	public String createTrainer(String trainer) {
		return myrepo.createTrainer(trainer);
	}

	@Override
	public String deleteTrainer(Long trainerid) {
		return myrepo.deleteTrainer(trainerid);
	}

	@Override
	public String updateTrainer(Long trainerid, String trainer) {
		return myrepo.updateTrainer(trainerid, trainer);
	}

	@Override
	public String findTrainerById(Long trainerid) {
		return myrepo.findTrainerById(trainerid);
	}

	@Override
	public String findTrainerByClassroomId(Long classroomid) {
		return myrepo.findTrainerByClassroomId(classroomid);
	}

}

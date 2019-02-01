package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeBusiness implements TraineeInterface {

	@Inject
	private TraineeRepository myrepo;

	@Override
	public String getAllTrainees() {
		return myrepo.getAllTrainees();
	}

	@Override
	public String createTrainee(String trainee) {
		return myrepo.createTrainee(trainee);
	}

	@Override
	public String deleteTrainee(Long traineeid) {
		return myrepo.deleteTrainee(traineeid);
	}

	@Override
	public String updateTrainee(Long traineeid, String trainee) {
		return myrepo.updateTrainee(traineeid, trainee);
	}

	@Override
	public String findTraineeById(Long traineeid) {
		return myrepo.findTraineeById(traineeid);
	}

	@Override
	public String findTraineeByClassroomId(Long classroomid) {
		return myrepo.findTraineeByClassroomId(classroomid);
	}

}

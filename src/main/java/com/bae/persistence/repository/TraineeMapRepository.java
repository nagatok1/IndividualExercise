package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Trainee;
import com.bae.persistence.domain.Trainer;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	Map<Long, Trainee> trainee = new HashMap<>();

	@Inject
	private JSONUtil jsonutil;

	private String success = "Success";
	private String failure = "Failure";

	public String getAllTrainees() {
		return jsonutil.getJSONForObject(trainee.values());

	}

	@Override
	public String createTrainee(String trainee) {
		Trainee newTrainee;
		newTrainee = jsonutil.getObjectForJSON(trainee, Trainee.class);
		this.trainee.put(newTrainee.getTraineeid(), newTrainee);
		return success;
	}

	@Override
	public String deleteTrainee(Long traineeid) {
		if (trainee.containsKey(traineeid)) {
			trainee.remove(traineeid);
			return success;
		} else {
			return failure;
		}
	}

	@Override
	public String updateTrainee(Long traineeid, String trainee) {
		if (this.trainee.containsKey(traineeid)) {
			Trainee newTrainee = null;
			newTrainee = jsonutil.getObjectForJSON(trainee, Trainee.class);
			this.trainee.put(newTrainee.getTraineeid(), newTrainee);
			return success;

		} else {
			return failure;
		}
	}

	@Override
	public String findTraineeById(Long traineeid) {
		return jsonutil.getJSONForObject(trainee.containsKey(traineeid));
	}

	@Override
	public String findTraineeByClassroomId(Long classroomid) {
		return jsonutil.getJSONForObject(trainee.containsKey(classroomid));
	}

}
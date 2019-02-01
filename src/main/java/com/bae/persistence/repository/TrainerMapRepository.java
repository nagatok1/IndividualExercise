package com.bae.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.bae.persistence.domain.Trainer;
import com.bae.util.JSONUtil;

@Alternative
public class TrainerMapRepository implements TrainerRepository {

	Map<Long, Trainer> trainer = new HashMap<>();

	@Inject
	private JSONUtil jsonutil;

	private String success = "Success";
	private String failure = "Failure";

	public String getAllTrainers() {
		return jsonutil.getJSONForObject(trainer.values());

	}

	@Override
	public String createTrainer(String trainer) {
		Trainer newTrainer;
		newTrainer = jsonutil.getObjectForJSON(trainer, Trainer.class);
		this.trainer.put(newTrainer.getTrainerid(), newTrainer);
		return success;
	}

	@Override
	public String deleteTrainer(Long trainerid) {
		if (trainer.containsKey(trainerid)) {
			trainer.remove(trainerid);
			return success;
		} else {
			return failure;
		}
	}

	@Override
	public String updateTrainer(Long trainerid, String trainer) {
		if (this.trainer.containsKey(trainerid)) {
			Trainer newTrainer = null;
			newTrainer = jsonutil.getObjectForJSON(trainer, Trainer.class);
			this.trainer.put(newTrainer.getTrainerid(), newTrainer);
			return success;

		} else {
			return failure;
		}
	}

	@Override
	public String findTrainerById(Long trainerid) {
		return jsonutil.getJSONForObject(trainer.containsKey(trainerid));
	}

	@Override
	public String findTrainerByClassroomId(Long classroomid) {
		return jsonutil.getJSONForObject(trainer.containsKey(classroomid));
	}

}
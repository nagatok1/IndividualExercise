package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.util.JSONUtil;
import com.bae.persistence.domain.Trainer;
import com.bae.persistence.repository.TrainerRepository;

@Transactional(SUPPORTS)
@Default
public class TrainerDBImp implements TrainerRepository {

	String success = "{\"message\": \"Success\"}";
	String failure = "{\"message\": \"Failure\"}";

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonutil;

	@Override
	public String getAllTrainers() {
		Query query = manager.createQuery("Select a FROM Trainer a");
		Collection<Trainer> trainers = (Collection<Trainer>) query.getResultList();
		return jsonutil.getJSONForObject(trainers);
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainer(String trainer) {
		Trainer newtrainer = jsonutil.getObjectForJSON(trainer, Trainer.class);
		manager.persist(newtrainer);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainer(Long trainerid) {
		Trainer TrainerInDB = findTrainer(trainerid);
		if (TrainerInDB != null) {
			manager.remove(TrainerInDB);
			return success;
		} else {
			return failure;
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainer(Long trainerid, String trainer) {
		if (deleteTrainer(trainerid).equals(success)) {
			createTrainer(trainer);
			return success;
		} else {
			return failure;
		}
	}

	private Trainer findTrainer(Long trainerid) {
		return manager.find(Trainer.class, trainerid);
	}

	@Override
	public String findTrainerById(Long trainerid) {
		return jsonutil.getJSONForObject(manager.find(Trainer.class, trainerid));
	}

	@Override
	public String findTrainerByClassroomId(Long classroomid) {
		return jsonutil.getJSONForObject(manager.find(Trainer.class, classroomid));
	}
}
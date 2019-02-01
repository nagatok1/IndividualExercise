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
import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.TraineeRepository;

@Transactional(SUPPORTS)
@Default
public class TraineeDBImp implements TraineeRepository {

	String success = "{\"message\": \"Success\"}";
	String failure = "{\"message\": \"Failure\"}";

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonutil;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return jsonutil.getJSONForObject(trainees);
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee newtrainee = jsonutil.getObjectForJSON(trainee, Trainee.class);
		manager.persist(newtrainee);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeid) {
		Trainee TraineeInDB = findTrainee(traineeid);
		if (TraineeInDB != null) {
			manager.remove(TraineeInDB);
			return success;
		} else {
			return failure;
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Long traineeid, String trainee) {
		if (deleteTrainee(traineeid).equals(success)) {
			createTrainee(trainee);
			return success;
		} else {
			return failure;
		}
	}

	private Trainee findTrainee(Long traineeid) {
		return manager.find(Trainee.class, traineeid);
	}

	@Override
	public String findTraineeById(Long traineeid) {
		return jsonutil.getJSONForObject(manager.find(Trainee.class, traineeid));
	}

	@Override
	public String findTraineeByClassroomId(Long classroomid) {
		return jsonutil.getJSONForObject(manager.find(Trainee.class, classroomid));
	}
}

package com.bae.persistence.repository;

public interface TrainerRepository {

	String getAllTrainers();
	String createTrainer(String account);
	String deleteTrainer(Long id);
	String updateTrainer(Long id, String account);
	String findTrainerById(Long id);
	String findTrainerByClassroomId(Long id);

	
}

package com.bae.persistence.repository;

public interface TraineeRepository {

	String getAllTrainees();
	String createTrainee(String account);
	String deleteTrainee(Long id);
	String updateTrainee(Long id, String account);
	String findTraineeById(Long id);
	String findTraineeByClassroomId(Long id);

	
}
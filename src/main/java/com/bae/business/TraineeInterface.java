package com.bae.business;

public interface TraineeInterface {

	String getAllTrainees();
	String createTrainee(String trainee);
	String deleteTrainee(Long traineeid);
	String updateTrainee(Long traineeid, String trainee);
	String findTraineeById(Long traineeid);
	String findTraineeByClassroomId(Long classroomid);
}

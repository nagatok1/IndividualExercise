package com.bae.business;

public interface TrainerInterface {

	String getAllTrainers();
	String createTrainer(String trainer);
	String deleteTrainer(Long trainerid);
	String updateTrainer(Long trainerid, String trainer);
	String findTrainerById(Long trainerid);
	String findTrainerByClassroomId(Long classroomid);
}

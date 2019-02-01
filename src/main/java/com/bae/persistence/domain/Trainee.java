package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long traineeid;
	
	private Long classroomid;

	private String trainee;

	public Trainee(Long classroomid, String trainee) {
		this.classroomid = classroomid;
		this.trainee = trainee;
	}

	public Trainee() {

	}

	public Long getTraineeid() {
		return traineeid;
	}

	public void setTraineeid(Long traineeid) {
		this.traineeid = traineeid;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public String getTrainee() {
		return trainee;
	}

	public void setTrainee(String trainee) {
		this.trainee = trainee;
	}
}